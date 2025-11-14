package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Property;
import com.example.demo.service.PropertyService;

@RestController
@RequestMapping("/properties")
public class PropertyController {

	@Autowired
	private PropertyService service;

	// POST http://localhost:8080/properties
	@PostMapping
	public List<Property> addProperties(@RequestBody List<Property> properties) {
		return service.addProperties(properties);
	}

	// http://localhost:8080/properties
	@GetMapping
	public List<Property> getAllProperties() {
		return service.getAllProperties();
	}

	// http://localhost:8080/properties/search?title=Villa
	@GetMapping("/search")
	public List<Property> getByTitle(@RequestParam String title) {
		return service.getByTitle(title);
	}

	// http://localhost:8080/properties/by-city?city=Mumbai
	@GetMapping("/by-city")
	public List<Property> getByCity(@RequestParam String city) {
		return service.getByCity(city);
	}

	// http://localhost:8080/properties/by-type?type=Apartment
	@GetMapping("/by-type")
	public List<Property> getByType(@RequestParam String type) {
		return service.getByType(type);
	}

	// http://localhost:8080/properties/filter?city=Goa&type=Villa
	@GetMapping("/filter")
	public List<Property> filterCityType(@RequestParam String city, @RequestParam String type) {
		return service.filterByCityAndType(city, type);
	}

	// http://localhost:8080/properties/by-price-range?minPrice=2000000&maxPrice=8000000
	@GetMapping("/by-price-range")
	public List<Property> byPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
		return service.getByPriceRange(minPrice, maxPrice);
	}

	// http://localhost:8080/properties/bedrooms?minBedrooms=3
	@GetMapping("/bedrooms")
	public List<Property> getByBedrooms(@RequestParam int minBedrooms) {
		return service.getByMinBedrooms(minBedrooms);
	}

	// http://localhost:8080/properties/furnished?furnished=true
	@GetMapping("/furnished")
	public List<Property> getByFurnished(@RequestParam boolean furnished) {
		return service.getByFurnished(furnished);
	}

	// http://localhost:8080/properties/status?status=Available
	@GetMapping("/status")
	public List<Property> getByStatus(@RequestParam String status) {
		return service.getByStatus(status);
	}

	// http://localhost:8080/properties/sorted
	@GetMapping("/sorted")
	public List<Property> sortedByPrice() {
		return service.getSortedByPriceDesc();
	}

	// http://localhost:8080/properties/count-by-city?city=Delhi
	@GetMapping("/count-by-city")
	public long countByCity(@RequestParam String city) {
		return service.countByCity(city);
	}

	// http://localhost:8080/properties/count-by-type?type=Villa
	@GetMapping("/count-by-type")
	public long countByType(@RequestParam String type) {
		return service.countByType(type);
	}

	// http://localhost:8080/properties/exist?title=Luxury Villa
	@GetMapping("/exist")
	public boolean existsByTitle(@RequestParam String title) {
		return service.existsByTitle(title);
	}

	// http://localhost:8080/properties/exist-by-owner?listedBy=Raj Realtors
	@GetMapping("/exist-by-owner")
	public boolean existsByOwner(@RequestParam String listedBy) {
		return service.existsByListedBy(listedBy);
	}

	// http://localhost:8080/properties/exist-by-city-and-type?city=Goa&type=Villa
	@GetMapping("/exist-by-city-and-type")
	public boolean existsByCityType(@RequestParam String city, @RequestParam String type) {
		return service.existsByCityAndType(city, type);
	}

	// http://localhost:8080/properties/exist-by-city-type-bedrooms?city=Goa&type=Villa&bedrooms=3
	@GetMapping("/exist-by-city-type-bedrooms")
	public boolean existsByCityTypeBedrooms(@RequestParam String city, @RequestParam String type,
			@RequestParam int bedrooms) {
		return service.existsByCityTypeBedrooms(city, type, bedrooms);
	}

	// http://localhost:8080/properties/delete-by-title?title=Luxury Villa
	@DeleteMapping("/delete-by-title")
	public long deleteByTitle(@RequestParam String title) {
		return service.deleteByTitle(title);
	}

	// http://localhost:8080/properties/delete-by-status?status=Sold
	@DeleteMapping("/delete-by-status")
	public long deleteByStatus(@RequestParam String status) {
		return service.deleteByStatus(status);
	}

	// http://localhost:8080/properties/delete-by-city?city=Mumbai
	@DeleteMapping("/delete-by-city")
	public long deleteByCity(@RequestParam String city) {
		return service.deleteByCity(city);
	}

	// http://localhost:8080/properties/by-owner?listedBy=City Homes
	@GetMapping("/by-owner")
	public List<Property> getByOwner(@RequestParam String listedBy) {
		return service.getByListedBy(listedBy);
	}

	// http://localhost:8080/properties/filter-by-multiple?city=Goa&minPrice=2000000&maxPrice=9000000&furnished=true
	@GetMapping("/filter-by-multiple")
	public List<Property> filterByMultiple(@RequestParam String city, @RequestParam double minPrice,
			@RequestParam double maxPrice, @RequestParam boolean furnished) {
		return service.filterByMultiple(city, minPrice, maxPrice, furnished);
	}

	// http://localhost:8080/properties/top
	@GetMapping("/top")
	public List<Property> getTop5() {
		return service.getTop5Expensive();
	}

// http://localhost:8080/properties/latest
	@GetMapping("/latest")
	public List<Property> getLatest3() {
		return service.getLatest3();
	}
}
