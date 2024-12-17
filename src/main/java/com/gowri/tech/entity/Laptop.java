package com.gowri.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author -NaveenWodeyar
 * @date -16-Dec-2024
 * @time - 9:21:29 pm
 * @location -
 */
@Entity
@Table(name = "Laptop_Table")
public class Laptop {
	
	@Id
	private String lapId;
	
	@NotNull(message = "Name can't be empty")
	@Size(min = 5,max = 50,message = "Should be between 2-50 characters")
	private String lapName;
	
	@NotNull(message = "Brand can't be empty")
	@Size(min = 5,max = 50,message = "Should be between 2-50 characters")
	private String lapBrand;
	
	@NotNull(message = "Make can't be empty")
	@Size(min = 5,max = 50,message = "Should be between 2-50 characters")
	private String lapMake;
	
	@NotNull(message = "Price can't be empty")
	@Size(min = 5,max = 50,message = "Should be between 2-50 characters")
	private String lapPrice;
	
	@NotNull(message = "Rating can't be empty")
	@Size(min = 5,max = 50,message = "Should be between 2-50 characters")
	private String lapRating;
	
	@NotNull(message = "Vidyarthi can't be empty")
	@Size(min = 5,max = 50,message = "Should be between 2-50 characters")
	@OneToOne
	private Vidyarthi vidyarthi;
	
	@NotNull(message = "Laptop can't be empty")
	@Size(min = 5,max = 50,message = "Should be between 2-50 characters")
	public Laptop() {}

	/**
	 * @param lapId
	 * @param lapName
	 * @param lapBrand
	 * @param lapMake
	 * @param lapPrice
	 * @param lapRating
	 */
	public Laptop(String lapId, String lapName, String lapBrand, String lapMake, String lapPrice, String lapRating) {
		super();
		this.lapId = lapId;
		this.lapName = lapName;
		this.lapBrand = lapBrand;
		this.lapMake = lapMake;
		this.lapPrice = lapPrice;
		this.lapRating = lapRating;
	}

	/**
	 * @return the lapId
	 */
	public String getLapId() {
		return lapId;
	}

	/**
	 * @param lapId the lapId to set
	 */
	public void setLapId(String lapId) {
		this.lapId = lapId;
	}

	/**
	 * @return the lapName
	 */
	public String getLapName() {
		return lapName;
	}

	/**
	 * @param lapName the lapName to set
	 */
	public void setLapName(String lapName) {
		this.lapName = lapName;
	}

	/**
	 * @return the lapBrand
	 */
	public String getLapBrand() {
		return lapBrand;
	}

	/**
	 * @param lapBrand the lapBrand to set
	 */
	public void setLapBrand(String lapBrand) {
		this.lapBrand = lapBrand;
	}

	/**
	 * @return the lapMake
	 */
	public String getLapMake() {
		return lapMake;
	}

	/**
	 * @param lapMake the lapMake to set
	 */
	public void setLapMake(String lapMake) {
		this.lapMake = lapMake;
	}

	/**
	 * @return the lapPrice
	 */
	public String getLapPrice() {
		return lapPrice;
	}

	/**
	 * @param lapPrice the lapPrice to set
	 */
	public void setLapPrice(String lapPrice) {
		this.lapPrice = lapPrice;
	}

	/**
	 * @return the lapRating
	 */
	public String getLapRating() {
		return lapRating;
	}

	/**
	 * @param lapRating the lapRating to set
	 */
	public void setLapRating(String lapRating) {
		this.lapRating = lapRating;
	}

	@Override
	public String toString() {
		return "Laptop [lapId=" + lapId + ", lapName=" + lapName + ", lapBrand=" + lapBrand + ", lapMake=" + lapMake
				+ ", lapPrice=" + lapPrice + ", lapRating=" + lapRating + "]";
	}

	
}
