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

	    public GsonService() {
	        this.gson = new Gson();
	    }

	    // Method to convert an object to JSON string
	    public String toJson(Object obj) {
	        return gson.toJson(obj);
	    }

	    // Method to convert a JSON string to an object of a given type
	    public <T> T fromJson(String json, Class<T> classOfT) {
	        return gson.fromJson(json, classOfT);
	    }
}
