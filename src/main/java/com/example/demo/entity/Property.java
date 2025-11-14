package com.example.demo.entity;
/*2. 

Assignment: Real Estate Property Management System

Develop a Spring Boot REST API using Spring Data JPA to manage property listings.
Use a single entity (Property) and implement maximum JPA magic methods (findBy, existsBy, deleteBy, countBy, etc.).
All endpoints must return a ResponseEntity with correct HTTP status codes,
and use @RequestParam wherever possible for flexibility.

🧱 Entity: Property
Field		Type	Description
id		Long	Primary key
title		String	Property title (e.g., “Luxury Villa in Goa”)
city		String	City where the property is located
type		String	Type of property (Apartment, Villa, Plot, Office)
price		Double	Price in INR
bedrooms	Integer	Number of bedrooms
furnished	Boolean	Whether the property is furnished
listedBy	String	Owner or agent who listed the property
status		String	Status (Available, Sold, Rented)
⚙️ Functional Requirements

You need to implement full CRUD operations and queries for search, filter, existence check, counting, and deletion using Spring Data JPA magic methods.
Use @RequestParam in most endpoints and ensure meaningful HTTP status codes in responses.
 * 
 * 🌐 Required REST Endpoints
HTTP	Endpoint	Description	Required Query Parameters
POST	/properties	Add a new property listing	—
GET	/properties	Retrieve all properties (return 204 if empty)	—
GET	/properties/search	Search properties by title (partial, case-insensitive)	title
GET	/properties/by-city	Get all properties in a specific city	city
GET	/properties/by-type	Get properties by type	type
GET	/properties/filter	Filter properties by city and type	city, type
GET	/properties/by-price-range	Get properties within a specific price range	minPrice, maxPrice
GET	/properties/bedrooms	Get properties having at least a certain number of bedrooms	minBedrooms
GET	/properties/furnished	Get furnished or unfurnished properties	furnished
GET	/properties/status	Get properties by availability status	status
GET	/properties/sorted	Get all properties sorted by price (descending)	—
GET	/properties/count-by-city	Count properties in a specific city	city
GET	/properties/count-by-type	Count total properties by type	type
GET	/properties/exist	Check if a property exists by title	title
GET	/properties/exist-by-owner	Check if a property exists by owner/agent name	listedBy
GET	/properties/exist-by-city-and-type	Check if any property exists by both city and type	city, type
✅ GET	/properties/exist-by-city-type-bedrooms	Check if a property exists for a given city, type, and number of bedrooms	city, type, bedrooms
DELETE	/properties/delete-by-title	Delete a property by title	title
DELETE	/properties/delete-by-status	Delete all properties having a specific status (e.g., Sold)	status
DELETE	/properties/delete-by-city	Delete all properties from a specific city	city
GET	/properties/by-owner	Retrieve all properties listed by a specific owner/agent	listedBy
GET	/properties/filter-by-multiple	Filter by city, min price, max price, and furnished status	city, minPrice, maxPrice, furnished
GET	/properties/top	Get top 5 most expensive properties	—
GET	/properties/latest	Get latest 3 added properties	—
🧠 Technical Requirements

Use Spring Data JPA repository magic methods (findBy, existsBy, countBy, deleteBy, etc.) for all queries.

Handle all responses with ResponseEntity and use these status codes:

201 CREATED → On successful creation

200 OK → On successful retrieval or operation

204 NO_CONTENT → If no data found

404 NOT_FOUND → If property not found for delete/existence check

400 BAD_REQUEST → Invalid or missing request parameters

Include a Service Layer to separate logic from controller.

Implement basic exception handling for invalid or empty data.
 * 
 */
import jakarta.persistence.*;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String city;
    private String type;
    private Double price;
    private Integer bedrooms;
    private Boolean furnished;
    private String listedBy;
    private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}
	public Boolean getFurnished() {
		return furnished;
	}
	public void setFurnished(Boolean furnished) {
		this.furnished = furnished;
	}
	public String getListedBy() {
		return listedBy;
	}
	public void setListedBy(String listedBy) {
		this.listedBy = listedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Property(Long id, String title, String city, String type, Double price, Integer bedrooms, Boolean furnished,
			String listedBy, String status) {
		super();
		this.id = id;
		this.title = title;
		this.city = city;
		this.type = type;
		this.price = price;
		this.bedrooms = bedrooms;
		this.furnished = furnished;
		this.listedBy = listedBy;
		this.status = status;
	}
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", title=" + title + ", city=" + city + ", type=" + type + ", price=" + price
				+ ", bedrooms=" + bedrooms + ", furnished=" + furnished + ", listedBy=" + listedBy + ", status="
				+ status + "]";
	}
    
	
	
	
}