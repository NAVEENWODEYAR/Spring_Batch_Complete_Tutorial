package com.gowri.tech.entity;

import java.util.Objects;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author -NaveenWodeyar
 * @date -16-Dec-2024
 * @time - 9:18:48 pm
 * @location -
 */
@Entity
@Table(name = "Vidyarthi_Table")
public class Vidyarthi {
	
	@Id
	private String vId;
	
	@NotNull(message = "Name can't be empty")
	@Size(min = 5,max = 50,message = "Should be between 2-50 characters")
	private String vName;
	
	@NotNull(message = "Class can't be empty")
	@Size(min = 5,max = 50,message = "Should be between 2-50 characters")
	private String vClass;
	
	@OneToOne 
	private Laptop laptop;
	
	public Vidyarthi() {}

	/**
	 * @param vId
	 * @param vName
	 * @param vClass
	 * @param laptop
	 */
	public Vidyarthi(String vId, String vName, String vClass, Laptop laptop) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vClass = vClass;
		this.laptop = laptop;
	}

	/**
	 * @return the vId
	 */
	public String getvId() {
		return vId;
	}

	/**
	 * @param vId the vId to set
	 */
	public void setvId(String vId) {
		this.vId = vId;
	}

	/**
	 * @return the vName
	 */
	public String getvName() {
		return vName;
	}

	/**
	 * @param vName the vName to set
	 */
	public void setvName(String vName) {
		this.vName = vName;
	}

	/**
	 * @return the vClass
	 */
	public String getvClass() {
		return vClass;
	}

	/**
	 * @param vClass the vClass to set
	 */
	public void setvClass(String vClass) {
		this.vClass = vClass;
	}

	/**
	 * @return the laptop
	 */
	public Laptop getLaptop() {
		return laptop;
	}

	/**
	 * @param laptop the laptop to set
	 */
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public int hashCode() {
		return Objects.hash(laptop, vClass, vId, vName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vidyarthi other = (Vidyarthi) obj;
		return Objects.equals(laptop, other.laptop) && Objects.equals(vClass, other.vClass)
				&& Objects.equals(vId, other.vId) && Objects.equals(vName, other.vName);
	}

	@Override
	public String toString() {
		return "Vidyarthi [vId=" + vId + ", vName=" + vName + ", vClass=" + vClass + ", laptop=" + laptop + "]";
	}


}
