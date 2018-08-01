package com.ayantsoft.vitalglobal.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement; 
import javax.xml.bind.annotation.XmlElement;  

@XmlRootElement 
public class Callrecords {
	
	private Integer totalnoofrecords;
	private List<Record> record;
	
	public Callrecords() {}  
	
	public Callrecords(Integer totalnoofrecords,List<Record> record) {  
	    super();  
	    this.totalnoofrecords = totalnoofrecords;  
	    this.record = record;   
	}  
	
	@XmlElement  
	public Integer getTotalnoofrecords() {
		return totalnoofrecords;
	}
	
	public void setTotalnoofrecords(Integer totalnoofrecords) {
		this.totalnoofrecords = totalnoofrecords;
	}

	@XmlElement
	public List<Record> getRecord() {
		return record;
	}

	public void setRecord(List<Record> record) {
		this.record = record;
	}
	
}
