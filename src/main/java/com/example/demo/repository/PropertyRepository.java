package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    // Search & Filters
    List<Property> findByTitleContainingIgnoreCase(String title);
    List<Property> findByCity(String city);
    List<Property> findByType(String type);
    List<Property> findByCityAndType(String city, String type);
    List<Property> findByPriceBetween(Double min, Double max);
    List<Property> findByBedroomsGreaterThanEqual(Integer minBedrooms);
    List<Property> findByFurnished(Boolean furnished);
    List<Property> findByStatus(String status);
    List<Property> findByListedBy(String listedBy);

    List<Property> findByCityAndPriceBetweenAndFurnished(String city, Double min, Double max, Boolean furnished);

    List<Property> findTop5ByOrderByPriceDesc();
    List<Property> findTop3ByOrderByIdDesc(); 

    // Existence Checks
    boolean existsByTitle(String title);
    boolean existsByListedBy(String listedBy);
    boolean existsByCityAndType(String city, String type);
    boolean existsByCityAndTypeAndBedrooms(String city, String type, Integer bedrooms);

    // Count
    long countByCity(String city);
    long countByType(String type);

    // Delete
    Long deleteByTitle(String title);
    Long deleteByStatus(String status);
    Long deleteByCity(String city);
    
}