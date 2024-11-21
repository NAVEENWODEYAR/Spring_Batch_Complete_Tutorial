package com.gowri.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
	
	private String cName;
	
	private String cCode;
	
	private String Address;
}
