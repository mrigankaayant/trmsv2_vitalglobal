package com.ayantsoft.vitalglobal.pojo;
// Generated 21 Dec, 2017 4:58:49 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PhoneRecording generated by hbm2java
 */
@Entity
@Table(name = "phone_recording", catalog = "ayant_trmsv2")
public class PhoneRecording implements java.io.Serializable {

	private Integer id;
	private String employeeName;
	private String managerName;
	private String extension;
	private String destNumber;
	private String candidateName;
	private Integer callDuration;
	private String callStatus;
	private String callingDate;
	private String inOut;
	private String callingLocation;
	private String candidateEmail;
	private Integer candidateId;
	private String srcNumber;

	public PhoneRecording() {
	}

	public PhoneRecording(String employeeName) {
		this.employeeName = employeeName;
	}

	public PhoneRecording(String employeeName, String managerName, String extension, String destNumber,
			String candidateName, Integer callDuration, String callStatus, String callingDate, String inOut,
			String callingLocation,String candidateEmail,Integer candidateId,String srcNumber) {
		this.employeeName = employeeName;
		this.managerName = managerName;
		this.extension = extension;
		this.destNumber = destNumber;
		this.candidateName = candidateName;
		this.callDuration = callDuration;
		this.callStatus = callStatus;
		this.callingDate = callingDate;
		this.inOut = inOut;
		this.callingLocation = callingLocation;
		this.candidateEmail = candidateEmail;
		this.candidateId = candidateId;
		this.srcNumber = srcNumber;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "employee_name", nullable = false, length = 100)
	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Column(name = "manager_name", length = 100)
	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Column(name = "extension", length = 45)
	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Column(name = "dest_number", length = 45)
	public String getDestNumber() {
		return this.destNumber;
	}

	public void setDestNumber(String destNumber) {
		this.destNumber = destNumber;
	}

	@Column(name = "candidate_name", length = 100)
	public String getCandidateName() {
		return this.candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	@Column(name = "call_duration")
	public Integer getCallDuration() {
		return this.callDuration;
	}

	public void setCallDuration(Integer callDuration) {
		this.callDuration = callDuration;
	}

	@Column(name = "call_status", length = 45)
	public String getCallStatus() {
		return this.callStatus;
	}

	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}

	@Column(name = "calling_date", length = 100)
	public String getCallingDate() {
		return this.callingDate;
	}

	public void setCallingDate(String callingDate) {
		this.callingDate = callingDate;
	}

	@Column(name = "in_out", length = 45)
	public String getInOut() {
		return this.inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut;
	}

	@Column(name = "calling_location", length = 100)
	public String getCallingLocation() {
		return this.callingLocation;
	}

	public void setCallingLocation(String callingLocation) {
		this.callingLocation = callingLocation;
	}
	
	@Column(name = "candidate_email", length = 100)
	public String getCandidateEmail() {
		return this.candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	
	
	@Column(name = "candidate_id")
	public Integer getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}
	
	@Column(name = "src_number", length = 45)
	public String getSrcNumber() {
		return this.srcNumber;
	}

	public void setSrcNumber(String srcNumber) {
		this.srcNumber = srcNumber;
	}
}
