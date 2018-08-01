package com.ayantsoft.vitalglobal.pojo;

public class Record {
	
	private String calldate;
	private String src;
	private String dst;
	private Integer billsec;
	private String disposition;
	
	
	public Record(){ }
	
	public Record(String calldate,String src,String dst,Integer billsec,String disposition){
		this.calldate = calldate;
		this.src = src;
		this.dst = dst;
		this.billsec = billsec;
		this.disposition = disposition;
	}
	
	
	
	public String getCalldate() {
		return calldate;
	}
	public void setCalldate(String calldate) {
		this.calldate = calldate;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	public Integer getBillsec() {
		return billsec;
	}
	public void setBillsec(Integer billsec) {
		this.billsec = billsec;
	}
	public String getDisposition() {
		return disposition;
	}
	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}
}
