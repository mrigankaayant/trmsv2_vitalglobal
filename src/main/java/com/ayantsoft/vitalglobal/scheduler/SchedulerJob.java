package com.ayantsoft.vitalglobal.scheduler;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.transform.Transformers;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ayantsoft.vitalglobal.pojo.Callrecords;
import com.ayantsoft.vitalglobal.pojo.CandidateDto;
import com.ayantsoft.vitalglobal.pojo.Extension;
import com.ayantsoft.vitalglobal.pojo.PhoneRecording;
import com.ayantsoft.vitalglobal.pojo.Record;

public class SchedulerJob implements Job {

	@Override
	public void execute(JobExecutionContext context)      
			throws JobExecutionException {

		try{

			Calendar cal = Calendar.getInstance();
		    cal.add(Calendar.DATE, -1);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(cal.getTime());
			String startDate = date+" 00:00:00";
			String endDate = date+" 23:59:59";
			
			
			List<Extension> extensions = null;

			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			Session session = sessionFactory.openSession();
			String hql = "FROM Extension e ";
			Query query = session.createQuery(hql);
			extensions = query.list();


			for(Extension e:extensions){
				String endpoint = "https://billing.vitelglobal.com/globalit_callrecords.php?username=jeet&password=nPG%25j8dGlo@Yr$2L$v65459&"
						+ "line="+e.getExtension()+"&startdate="+URLEncoder.encode(startDate)+"&enddate="+URLEncoder.encode(endDate);

				URL url = new URL(endpoint);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/xml");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				JAXBContext jaxbContext = JAXBContext.newInstance(Callrecords.class);     
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
				Callrecords c= (Callrecords) jaxbUnmarshaller.unmarshal(conn.getInputStream());

				List<Record> rlist = c.getRecord();


				if(rlist != null && rlist.size() >0){
					for(Record r:rlist){

						PhoneRecording pr = new PhoneRecording();
						pr.setEmployeeName(e.getEmployeeName());
						if(e.getManagerName() != null){
							pr.setManagerName(e.getManagerName());
						}
						pr.setExtension(e.getExtension());
						pr.setDestNumber(r.getDst());
						pr.setSrcNumber(r.getSrc());
						pr.setCallDuration(r.getBillsec());
						pr.setCallStatus(r.getDisposition());
						pr.setCallingDate(r.getCalldate());

						if(r.getSrc().equals(e.getExtension())){
							pr.setInOut("OUTGOING");
						}else{
							pr.setInOut("INCOMMING");
						}


						if(r.getDst() != null){
							if(r.getDst().length() == 10 || r.getDst().length() == 11){
								pr.setCallingLocation("US");
							}
							if(r.getDst().length() >11){
								String indianEx = r.getDst().substring(0,5);
								if("01191".equals(indianEx)){
									pr.setCallingLocation("INDIA");
								}
							}
							if(r.getDst().length() == 3){
								if(r.getDst().equals(e.getExtension())){

									if(r.getSrc().length() == 10 || r.getSrc().length() == 11){
										pr.setCallingLocation("US");
									}

									if(r.getSrc().length() >11){
										String indianEx = r.getSrc().substring(0,5);
										if("01191".equals(indianEx)){
											pr.setCallingLocation("INDIA");
										}
									}

									if(r.getSrc().length() == 3){
										pr.setCallingLocation("INTERNAL");
									}
								}else{
									pr.setCallingLocation("INTERNAL");
								}
							}
						}

						// for candidate checking

						boolean indicator = false;

						if(r.getSrc().equals(e.getExtension())){

							if(r.getDst() != null && r.getDst().length() > 5){
								String indianEx = r.getDst().substring(0,5);
								if("01191".equals(indianEx)){
									indicator = true;
								}
							}

							if(r.getDst() != null && r.getDst().length() == 3){
								Pattern p = Pattern.compile("[^a-z0-9 ]",Pattern.CASE_INSENSITIVE);
								Matcher m = p.matcher(r.getDst());
								if(!m.find()){
									indicator = true;
								}
							}

							if(!indicator){

								String destNumber = null;

								if(r.getDst().length() >= 10){
									if(r.getDst().length() == 10){
										destNumber = r.getDst();
									}else{
										destNumber = r.getDst().substring(r.getDst().length()-10,r.getDst().length());
									}
								}


								if(destNumber != null && destNumber.matches("[0-9]+")){
									String checkCandidateHql = "SELECT c.candidateId as candidateId,c.firstName as candidateName,add.email as candidateEmail "
											+ "FROM Candidate c "
											+ "INNER JOIN c.contactAddress add "
											+ "WHERE add.workMobile = "+destNumber+"OR add.workPhone = "+destNumber;

									Query checkCandidateQuery = session.createQuery(checkCandidateHql).setResultTransformer(Transformers.aliasToBean(CandidateDto.class));
									List<CandidateDto> candidateDtos = checkCandidateQuery.list();

									CandidateDto candidateDto = null;

									if(candidateDtos != null && candidateDtos.size() >0){
										candidateDto = candidateDtos.get(0);
									}

									if(candidateDto != null){
										pr.setCandidateName(candidateDto.getCandidateName());
										pr.setCandidateEmail(candidateDto.getCandidateEmail());
										pr.setCandidateId(candidateDto.getCandidateId());
										System.out.println(candidateDto.getCandidateName()+"   "+candidateDto.getCandidateEmail()+"    "+candidateDto.getCandidateId());
									}
								}

							}

						}

						try{
							session.beginTransaction();
							session.save(pr);
							session.getTransaction().commit();
						}catch(Exception ex){
							ex.printStackTrace();
						}

					}
				}
			}	

		}catch(Exception e){
			e.printStackTrace();
		}
	}   

}
