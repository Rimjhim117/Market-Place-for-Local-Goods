package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.City;


@Repository
public interface CityRepository extends JpaRepository<City, String> {

    // Find a city by its name
    City findByName(String name);

    // Find cities by description (using LIKE for partial matches)
    List<City> findByDescriptionContaining(String description);

    // Count cities by a specific description
    long countByDescriptionContaining(String description);

    // Custom query to find cities based on description
    @Query("SELECT c FROM City c WHERE c.description LIKE %:description%")
    List<City> findCitiesByDescription(@Param("description") String description);

    // Delete cities by description
    void deleteByDescriptionContaining(String description);
}


