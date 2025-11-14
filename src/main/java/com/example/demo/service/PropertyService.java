package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Property;
import com.example.demo.repository.PropertyRepository;

@Service
public class PropertyService {

	
	    @Autowired
	    private PropertyRepository repository;

	    public List<Property> addProperties(List<Property> properties) {
	        return repository.saveAll(properties);
	    }


	    // GET ALL PROPERTIES
	    public List<Property> getAllProperties() {
	        return repository.findAll();
	    }

	    // SEARCH BY TITLE (partial, case-insensitive)
	    public List<Property> getByTitle(String title) {
	        return repository.findByTitleContainingIgnoreCase(title);
	    }

	    // BY CITY
	    public List<Property> getByCity(String city) {
	        return repository.findByCity(city);
	    }

	    // BY TYPE
	    public List<Property> getByType(String type) {
	        return repository.findByType(type);
	    }

	    // FILTER BY CITY + TYPE
	    public List<Property> filterByCityAndType(String city, String type) {
	        return repository.findByCityAndType(city, type);
	    }

	    // PRICE RANGE
	    public List<Property> getByPriceRange(double min, double max) {
	        return repository.findByPriceBetween(min, max);
	    }

	    // MIN BEDROOMS
	    public List<Property> getByMinBedrooms(int minBedrooms) {
	        return repository.findByBedroomsGreaterThanEqual(minBedrooms);
	    }

	    // FURNISHED OR NOT
	    public List<Property> getByFurnished(boolean furnished) {
	        return repository.findByFurnished(furnished);
	    }

	    // BY STATUS (Available, Sold, Rented)
	    public List<Property> getByStatus(String status) {
	        return repository.findByStatus(status);
	    }

	    // SORT BY PRICE DESC
	    public List<Property> getSortedByPriceDesc() {
	        return repository.findAll()                     // load all
	                .stream()
	                .sorted((a, b) -> b.getPrice().compareTo(a.getPrice()))
	                .toList();
	    }

	    // COUNT BY CITY
	    public long countByCity(String city) {
	        return repository.countByCity(city);
	    }

	    // COUNT BY TYPE
	    public long countByType(String type) {
	        return repository.countByType(type);
	    }

	    // EXISTS BY TITLE
	    public boolean existsByTitle(String title) {
	        return repository.existsByTitle(title);
	    }

	    // EXISTS BY OWNER/AGENT
	    public boolean existsByListedBy(String listedBy) {
	        return repository.existsByListedBy(listedBy);
	    }

	    // EXISTS BY CITY + TYPE
	    public boolean existsByCityAndType(String city, String type) {
	        return repository.existsByCityAndType(city, type);
	    }

	    // EXISTS BY CITY + TYPE + BEDROOMS
	    public boolean existsByCityTypeBedrooms(String city, String type, int bedrooms) {
	        return repository.existsByCityAndTypeAndBedrooms(city, type, bedrooms);
	    }

	    // DELETE BY TITLE
	    public long deleteByTitle(String title) {
	        return repository.deleteByTitle(title);
	    }

	    // DELETE BY STATUS
	    public long deleteByStatus(String status) {
	        return repository.deleteByStatus(status);
	    }

	    // DELETE BY CITY
	    public long deleteByCity(String city) {
	        return repository.deleteByCity(city);
	    }

	    // BY OWNER/AGENT
	    public List<Property> getByListedBy(String listedBy) {
	        return repository.findByListedBy(listedBy);
	    }

	    // FILTER BY CITY + PRICE RANGE + FURNISHED
	    public List<Property> filterByMultiple(String city, double min, double max, boolean furnished) {
	        return repository.findByCityAndPriceBetweenAndFurnished(city, min, max, furnished);
	    }

	    // TOP 5 EXPENSIVE
	    public List<Property> getTop5Expensive() {
	        return repository.findTop5ByOrderByPriceDesc();
	    }

	    // LATEST 3 PROPERTIES
	    public List<Property> getLatest3() {
	        return repository.findTop3ByOrderByIdDesc();
	    }
	}


