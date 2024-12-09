package com.gowri.tech.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author -NaveenWodeyar
 * @date -22-Nov-2024
 * @time - 12:20:32 am
 * @location -
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adId;
	
	@NotNull(message = "City can't be empty")
	@Size(min = 4,max = 50,message = "Should be between 2-50 characters")
    @JsonProperty("CITY") 
	private String city;
	
	@NotNull(message = "State cannot be null") 
	@Size(min = 2, max = 100, message = "State must be between 2 and 100 characters")
    @JsonProperty("STATE") 
	private String state;
	
	@NotNull(message = "Pin cannot be null") 
    @Min(value = 100000, message = "Pin must be at least 6 digits")  
    @JsonProperty("PIN_CODE") 
	private Long pin;

}
