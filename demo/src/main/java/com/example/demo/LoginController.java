package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final CityPreferencesService cityPreferencesService; // Keep the variable name intact

    // Constructor-based dependency injection for CityPreferencesService
    
    public LoginController(CityPreferencesService cityPreferencesService) {
        this.cityPreferencesService = cityPreferencesService;
    }

    // Show the landing page (index.html)
    @GetMapping("/")
    public String index() {
        return "index"; // index.html
    }

    // Show the login page (login.html)
    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }

    // Handle login logic (POST request)
    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Basic validation logic for demonstration
        if ("user".equals(username) && "password".equals(password)) {
            // Add success message to model
            model.addAttribute("username", username);
            return "redirect:/cityPreferences"; // Redirect to the city preferences page after login
        } else {
            // Add error message to model if login fails
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Stay on the login page if credentials are invalid
        }
    }

    // Display the city preferences page
    @GetMapping("/cityPreferences")
    public String cityPreferences(@RequestParam(required = false, defaultValue = "NewYork") String city, Model model) {
        // Use the cityPreferencesService to get city preferences
        String preferences = cityPreferencesService.getCityPreferences(city);
        
        // Add city preferences to the model
        model.addAttribute("city", city);
        model.addAttribute("preferences", preferences);
        
        return "cityPreferences"; // cityPreferences.html
    }
}
