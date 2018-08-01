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
 * Countries generated by hbm2java
 */
@Entity
@Table(name = "countries", catalog = "ayant_trmsv2")
public class Countries implements java.io.Serializable {

	private Integer id;
	private String sortname;
	private String name;
	private Set<States> stateses = new HashSet<States>(0);

	public Countries() {
	}

	public Countries(String sortname, String name) {
		this.sortname = sortname;
		this.name = name;
	}

	public Countries(String sortname, String name, Set<States> stateses) {
		this.sortname = sortname;
		this.name = name;
		this.stateses = stateses;
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

	@Column(name = "sortname", nullable = false, length = 3)
	public String getSortname() {
		return this.sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "countries")
	public Set<States> getStateses() {
		return this.stateses;
	}

	public void setStateses(Set<States> stateses) {
		this.stateses = stateses;
	}

}