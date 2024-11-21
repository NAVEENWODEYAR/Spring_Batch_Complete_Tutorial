package com.gowri.tech.entity;

import jakarta.persistence.Entity;

/**
 * @author -NaveenWodeyar
 * @date -22-Nov-2024
 * @time - 12:20:32 am
 * @location -
 */
@Entity
public class Address {
	
	private Integer adId;
	
	private String city;
	
	private String state;
	
	private Long pin;

}
