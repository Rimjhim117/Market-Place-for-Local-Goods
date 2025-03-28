package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class City {
    @Id
    private String name;
    private String description;

    // Constructors, getters, and setters
    public City(String name, String description) {
        this.name = name;
        this.description = description;
    }

    

// Getter for 'name'
public String getName() {
    return name;
}

// Setter for 'name'
public void setName(String name) {
    this.name = name;
}

// Getter for 'description'
public String getDescription() {
    return description;
}

// Setter for 'description'
public void setDescription(String description) {
    this.description = description;
}
}

