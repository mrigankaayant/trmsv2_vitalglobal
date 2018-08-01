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
 * CheckListType generated by hbm2java
 */
@Entity
@Table(name = "check_list_type", catalog = "ayant_trmsv2")
public class CheckListType implements java.io.Serializable {

	private Integer id;
	private String checkListTypeName;
	private Boolean isActive;
	private Integer indexOrder;
	private Boolean isDocumentsMandatory;
	private String remarks;
	private Set<CandidateCheckList> candidateCheckLists = new HashSet<CandidateCheckList>(0);

	public CheckListType() {
	}

	public CheckListType(String checkListTypeName, Boolean isActive, Integer indexOrder, Boolean isDocumentsMandatory,
			String remarks, Set<CandidateCheckList> candidateCheckLists) {
		this.checkListTypeName = checkListTypeName;
		this.isActive = isActive;
		this.indexOrder = indexOrder;
		this.isDocumentsMandatory = isDocumentsMandatory;
		this.remarks = remarks;
		this.candidateCheckLists = candidateCheckLists;
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

	@Column(name = "check_list_type_name", length = 100)
	public String getCheckListTypeName() {
		return this.checkListTypeName;
	}

	public void setCheckListTypeName(String checkListTypeName) {
		this.checkListTypeName = checkListTypeName;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "index_order")
	public Integer getIndexOrder() {
		return this.indexOrder;
	}

	public void setIndexOrder(Integer indexOrder) {
		this.indexOrder = indexOrder;
	}

	@Column(name = "is_documents_mandatory")
	public Boolean getIsDocumentsMandatory() {
		return this.isDocumentsMandatory;
	}

	public void setIsDocumentsMandatory(Boolean isDocumentsMandatory) {
		this.isDocumentsMandatory = isDocumentsMandatory;
	}

	@Column(name = "remarks", length = 45)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "checkListType")
	public Set<CandidateCheckList> getCandidateCheckLists() {
		return this.candidateCheckLists;
	}

	public void setCandidateCheckLists(Set<CandidateCheckList> candidateCheckLists) {
		this.candidateCheckLists = candidateCheckLists;
	}

}
