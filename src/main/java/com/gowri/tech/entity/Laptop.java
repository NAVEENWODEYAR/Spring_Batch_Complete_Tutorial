package com.gowri.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	
	private String lapName;
	
	private String lapBrand;
	
	private String lapMake;
	
	private String lapPrice;
	
	private String lapRating;
	
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
