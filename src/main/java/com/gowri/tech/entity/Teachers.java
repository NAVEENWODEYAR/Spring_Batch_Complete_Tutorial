package com.gowri.tech.entity;

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
import jakarta.validation.constraints.AssertFalse.List;

/**
 * @author -NaveenWodeyar
 * @date -18-Nov-2024
 * @time - 2:56:19 pm
 * @location -
 */
@Entity
public class Teachers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer thId;
	
	private String thName;
	
	private String thMail;
	
	private String thSubjet;
	
	private String thAddress;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "TEACHER_STUDENT_TABLE",joinColumns = {
			@JoinColumn(referencedColumnName = "thId",name = "teacherId")
	},
	inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "stId",name = "studentId")
	})
	private java.util.List<Students> students;
	
	public Teachers() {}

	/**
	 * @param thId
	 * @param thName
	 * @param thMail
	 * @param thSubjet
	 * @param thAddress
	 */
	public Teachers(Integer thId, String thName, String thMail, String thSubjet, String thAddress) {
		super();
		this.thId = thId;
		this.thName = thName;
		this.thMail = thMail;
		this.thSubjet = thSubjet;
		this.thAddress = thAddress;
	}

	/**
	 * @return the thId
	 */
	public Integer getThId() {
		return thId;
	}

	/**
	 * @param thId the thId to set
	 */
	public void setThId(Integer thId) {
		this.thId = thId;
	}

	/**
	 * @return the thName
	 */
	public String getThName() {
		return thName;
	}

	/**
	 * @param thName the thName to set
	 */
	public void setThName(String thName) {
		this.thName = thName;
	}

	/**
	 * @return the thMail
	 */
	public String getThMail() {
		return thMail;
	}

	/**
	 * @param thMail the thMail to set
	 */
	public void setThMail(String thMail) {
		this.thMail = thMail;
	}

	/**
	 * @return the thSubjet
	 */
	public String getThSubjet() {
		return thSubjet;
	}

	/**
	 * @param thSubjet the thSubjet to set
	 */
	public void setThSubjet(String thSubjet) {
		this.thSubjet = thSubjet;
	}

	/**
	 * @return the thAddress
	 */
	public String getThAddress() {
		return thAddress;
	}

	/**
	 * @param thAddress the thAddress to set
	 */
	public void setThAddress(String thAddress) {
		this.thAddress = thAddress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(thAddress, thId, thMail, thName, thSubjet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teachers other = (Teachers) obj;
		return Objects.equals(thAddress, other.thAddress) && Objects.equals(thId, other.thId)
				&& Objects.equals(thMail, other.thMail) && Objects.equals(thName, other.thName)
				&& Objects.equals(thSubjet, other.thSubjet);
	}

	@Override
	public String toString() {
		return "Teachers [thId=" + thId + ", thName=" + thName + ", thMail=" + thMail + ", thSubjet=" + thSubjet
				+ ", thAddress=" + thAddress + "]";
	}
	
	
	
}
