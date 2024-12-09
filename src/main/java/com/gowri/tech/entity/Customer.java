package com.gowri.tech.entity;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import jakarta.persistence.*;

/**
 * @author -NaveenWodeyar
 * @date -26-Oct-2024
 * @time - 12:44:07 pm
 * @location -
 */

@Entity
@Table(name = "CUSTOMERS_INFO")
public class Customer {
	
	@Id
	@Column(name = "CUSTOMER_ID")
	@SerializedName("CUSTOMER_ID")
	private Integer id;
	
	@Column(name = "FIRST_NAME")
	@SerializedName("CUSTOMER_FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	@SerializedName("CUSTOMER_LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	@SerializedName("CUSTOMER_EMAIL")
	private String email;
	
	@Column(name = "GENDER")
	@SerializedName("CUSTOMER_GENDER")
	private String gender;
	
	@Column(name = "CONTACT")
	@SerializedName("CUSTOMER_MOBILE")
	private String contactNo;
	
	@Column(name = "COUNTRY")
	@SerializedName("CUSTOMER_COUNTRY")
	private String country;
	
	@Column(name = "DOB")
	@SerializedName("CUSTOMER_DOB")
	private String dob;
	
	public Customer() {}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param gender
	 * @param contactNo
	 * @param country
	 * @param dob
	 */
	public Customer(int id, String firstName, String lastName, String email, String gender, String contactNo,
			String country, String dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.contactNo = contactNo;
		this.country = country;
		this.dob = dob;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactNo, country, dob, email, firstName, gender, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(contactNo, other.contactNo) && Objects.equals(country, other.country)
				&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", contactNo=" + contactNo + ", country=" + country + ", dob=" + dob + "]";
	}
	
	
}
