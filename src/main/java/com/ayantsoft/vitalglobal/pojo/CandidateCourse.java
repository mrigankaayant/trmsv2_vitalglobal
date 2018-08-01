package com.ayantsoft.vitalglobal.pojo;
// Generated 21 Dec, 2017 4:58:49 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CandidateCourse generated by hbm2java
 */
@Entity
@Table(name = "candidate_course", catalog = "ayant_trmsv2")
public class CandidateCourse implements java.io.Serializable {

	private Integer id;
	private String course;
	private String description;
	private Set<ProgrammeSchedule> programmeSchedules = new HashSet<ProgrammeSchedule>(0);
	private Set<Trainer> trainers = new HashSet<Trainer>(0);
	private Set<CandidatePayment> candidatePayments = new HashSet<CandidatePayment>(0);
	private Set<Candidate> candidates = new HashSet<Candidate>(0);
	private Set<TrainerInvoice> trainerInvoices = new HashSet<TrainerInvoice>(0);

	public CandidateCourse() {
	}

	public CandidateCourse(String course, String description, Set<ProgrammeSchedule> programmeSchedules,
			Set<Trainer> trainers, Set<CandidatePayment> candidatePayments, Set<Candidate> candidates,
			Set<TrainerInvoice> trainerInvoices) {
		this.course = course;
		this.description = description;
		this.programmeSchedules = programmeSchedules;
		this.trainers = trainers;
		this.candidatePayments = candidatePayments;
		this.candidates = candidates;
		this.trainerInvoices = trainerInvoices;
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

	@Column(name = "course", length = 45)
	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidateCourse")
	public Set<ProgrammeSchedule> getProgrammeSchedules() {
		return this.programmeSchedules;
	}

	public void setProgrammeSchedules(Set<ProgrammeSchedule> programmeSchedules) {
		this.programmeSchedules = programmeSchedules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidateCourse")
	public Set<Trainer> getTrainers() {
		return this.trainers;
	}

	public void setTrainers(Set<Trainer> trainers) {
		this.trainers = trainers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidateCourse")
	public Set<CandidatePayment> getCandidatePayments() {
		return this.candidatePayments;
	}

	public void setCandidatePayments(Set<CandidatePayment> candidatePayments) {
		this.candidatePayments = candidatePayments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidateCourse")
	public Set<Candidate> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidateCourse")
	public Set<TrainerInvoice> getTrainerInvoices() {
		return this.trainerInvoices;
	}

	public void setTrainerInvoices(Set<TrainerInvoice> trainerInvoices) {
		this.trainerInvoices = trainerInvoices;
	}

}