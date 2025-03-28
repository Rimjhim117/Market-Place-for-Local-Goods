package com.example.demo.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MarketplaceItem;
@Repository
public interface MarketplaceItemRepository extends JpaRepository<MarketplaceItem, Long> {
    
    // Find items by their name (case-insensitive search)
    List<MarketplaceItem> findByNameContainingIgnoreCase(String name);
    

    // Find items by price range
    List<MarketplaceItem> findByPriceBetween(double minPrice, double maxPrice);

    // Find items by their description (case-insensitive search)
    List<MarketplaceItem> findByDescriptionContainingIgnoreCase(String description);

    // Find all items sorted by price (ascending order)
    List<MarketplaceItem> findAllByOrderByPriceAsc();

    // Find all items sorted by price (descending order)
    List<MarketplaceItem> findAllByOrderByPriceDesc();

    // Find items by category (assuming a category field in the MarketplaceItem model)
    List<MarketplaceItem> findByCategory(String category);

    // Custom query to find items by price range and description
    @Query("SELECT m FROM MarketplaceItem m WHERE m.price BETWEEN :minPrice AND :maxPrice AND m.description LIKE %:description%")
    List<MarketplaceItem> findItemsByPriceAndDescription(
            @Param("minPrice") double minPrice,
            @Param("maxPrice") double maxPrice,
            @Param("description") String description);

    // Find items by name and price range
    List<MarketplaceItem> findByNameContainingIgnoreCaseAndPriceBetween(String name, double minPrice, double maxPrice);
}

