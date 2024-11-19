package com.gowri.tech.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

/**
 * @author -NaveenWodeyar
 * @date -18-Nov-2024
 * @time - 2:55:59 pm
 * @location -
 */
@Entity
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stId;
	
	private String stName;
	
	private String stMail;
	
	private String stClass;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "TEACHER_STUDENT_TABLE",joinColumns = {
			@JoinColumn(referencedColumnName = "stId",name = "studentId")
	},
	inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "thId",name = "teacherID")
	})
	private List<Teachers> teachers;
	
	public Students() {}

	/**
	 * @param stId
	 * @param stName
	 * @param stMail
	 * @param stClass
	 */
	public Students(Integer stId, String stName, String stMail, String stClass) {
		super();
		this.stId = stId;
		this.stName = stName;
		this.stMail = stMail;
		this.stClass = stClass;
	}

	/**
	 * @return the stId
	 */
	public Integer getStId() {
		return stId;
	}

	/**
	 * @param stId the stId to set
	 */
	public void setStId(Integer stId) {
		this.stId = stId;
	}

	/**
	 * @return the stName
	 */
	public String getStName() {
		return stName;
	}

	/**
	 * @param stName the stName to set
	 */
	public void setStName(String stName) {
		this.stName = stName;
	}

	/**
	 * @return the stMail
	 */
	public String getStMail() {
		return stMail;
	}

	/**
	 * @param stMail the stMail to set
	 */
	public void setStMail(String stMail) {
		this.stMail = stMail;
	}

	/**
	 * @return the stClass
	 */
	public String getStClass() {
		return stClass;
	}

	/**
	 * @param stClass the stClass to set
	 */
	public void setStClass(String stClass) {
		this.stClass = stClass;
	}

	@Override
	public int hashCode() {
		return Objects.hash(stClass, stId, stMail, stName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		return Objects.equals(stClass, other.stClass) && Objects.equals(stId, other.stId)
				&& Objects.equals(stMail, other.stMail) && Objects.equals(stName, other.stName);
	}

	@Override
	public String toString() {
		return "Students [stId=" + stId + ", stName=" + stName + ", stMail=" + stMail + ", stClass=" + stClass + "]";
	}
	
	
}
