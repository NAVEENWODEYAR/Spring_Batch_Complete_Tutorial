package com.gowri.tech.service;

import com.google.gson.Gson;

/**
 * @author -NaveenWodeyar
 * @date -22-Nov-2024
 * @time - 11:08:25 pm
 * @location -
 */
public class GsonService {

	 private final Gson gson;

	    // Constructor injection of Gson
	    public GsonService() {
	        this.gson = new Gson();
	    }

}
