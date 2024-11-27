package com.gowri.tech.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
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
	private Integer cId;
	
	@NotNull(message = "College name cannot be null")  
    @Min(value = 100000, message = "Pin must be at least 6 digits")  
    @JsonProperty("COLLEGE_NAME") 
	private String cName;
	
	@NotNull(message = "College code cannot be null")  
    @Min(value = 100000, message = "Pin must be at least 6 digits")  
    @JsonProperty("COLLEGE_CODE") 
	private String cCode;
	
	@NotNull(message = "Address cannot be null")  
    @Min(value = 100000, message = "Pin must be at least 6 digits")  
    @JsonProperty("ADDRESS") 
	private String Address;
}
