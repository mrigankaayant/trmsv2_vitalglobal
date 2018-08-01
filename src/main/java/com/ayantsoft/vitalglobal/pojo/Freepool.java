package com.ayantsoft.vitalglobal.pojo;
// Generated 21 Dec, 2017 4:58:49 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Freepool generated by hbm2java
 */
@Entity
@Table(name = "freepool", catalog = "ayant_trmsv2")
public class Freepool implements java.io.Serializable {

	private Integer id;
	private int candidateId;
	private String candidateName;
	private String candidateEmail;
	private String candidateMobile;
	private String curLocation;
	private String skill;
	private String status;
	private String visa;
	private String recruiterName;
	private Integer recruiterId;

	public Freepool() {
	}

	public Freepool(int candidateId) {
		this.candidateId = candidateId;
	}

	public Freepool(int candidateId, String candidateName, String candidateEmail, String candidateMobile,
			String curLocation, String skill, String status, String visa, String recruiterName, Integer recruiterId) {
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidateEmail = candidateEmail;
		this.candidateMobile = candidateMobile;
		this.curLocation = curLocation;
		this.skill = skill;
		this.status = status;
		this.visa = visa;
		this.recruiterName = recruiterName;
		this.recruiterId = recruiterId;
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

	@Column(name = "candidate_id", nullable = false)
	public int getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	@Column(name = "candidate_name", length = 100)
	public String getCandidateName() {
		return this.candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	@Column(name = "candidate_email", length = 100)
	public String getCandidateEmail() {
		return this.candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

	@Column(name = "candidate_mobile", length = 45)
	public String getCandidateMobile() {
		return this.candidateMobile;
	}

	public void setCandidateMobile(String candidateMobile) {
		this.candidateMobile = candidateMobile;
	}

	@Column(name = "cur_location", length = 200)
	public String getCurLocation() {
		return this.curLocation;
	}

	public void setCurLocation(String curLocation) {
		this.curLocation = curLocation;
	}

	@Column(name = "skill", length = 45)
	public String getSkill() {
		return this.skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Column(name = "status", length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "visa", length = 45)
	public String getVisa() {
		return this.visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	@Column(name = "recruiter_name", length = 100)
	public String getRecruiterName() {
		return this.recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	@Column(name = "recruiter_id")
	public Integer getRecruiterId() {
		return this.recruiterId;
	}

	public void setRecruiterId(Integer recruiterId) {
		this.recruiterId = recruiterId;
	}

}
