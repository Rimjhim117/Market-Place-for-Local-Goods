package com.example.demo;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.City;
import com.example.demo.model.MarketplaceItem;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.MarketplaceItemRepository;

@Service
public class CityPreferencesService {

    private final CityRepository cityRepository;
    private final MarketplaceItemRepository marketplaceItemRepository;

    // Constructor-based dependency injection
    public CityPreferencesService(CityRepository cityRepository, MarketplaceItemRepository marketplaceItemRepository) {
        this.cityRepository = cityRepository;
        this.marketplaceItemRepository = marketplaceItemRepository;
    }
    public String getCityPreferences(String city) {
        // Example logic to fetch city preferences, this could be from a database or static data.
        if (city.equalsIgnoreCase("NewYork")) {
            return "New York: Central Park, Statue of Liberty";
        } else if (city.equalsIgnoreCase("Paris")) {
            return "Paris: Eiffel Tower, Louvre Museum";
        } else {
            return "City preferences not available.";
        }
    }
    // Fetch city details and marketplace items
    public City getCityDetails(String cityName) {
        return cityRepository.findByName(cityName);
    }

    public List<MarketplaceItem> getMarketplaceItems() {
        return marketplaceItemRepository.findAll();
    }
}

