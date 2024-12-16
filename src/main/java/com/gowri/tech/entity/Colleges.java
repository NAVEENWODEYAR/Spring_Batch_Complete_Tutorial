package com.gowri.tech.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

/**
 * @author -NaveenWodeyar
 * @date -21-Nov-2024
 * @time - 8:16:44 am
 * @location -
 */
@Entity
public class Colleges {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SerializedName("COLLEGE_ID")
	private Integer cId;
	
	@NotNull(message = "College name cannot be null")  
    @JsonProperty("COLLEGE_NAME") 
	@SerializedName("COLLEGE_NAMEŌ")
	private String cName;
	
	@NotNull(message = "College code cannot be null")  
    @JsonProperty("COLLEGE_CODE") 
	@SerializedName("COLLEGE_CODE")
	private String cCode;
	
	@NotNull(message = "Address cannot be null")  
    @JsonProperty("ADDRESS")
	@SerializedName("COLLEGE_ADDRESS")
	private String Address;
	
}
