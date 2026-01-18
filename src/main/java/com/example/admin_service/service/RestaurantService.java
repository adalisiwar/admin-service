package com.example.admin_service.service;

import com.example.admin_service.entity.Restaurant;
import com.example.admin_service.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            restaurant.setName(restaurantDetails.getName());
            restaurant.setAddress(restaurantDetails.getAddress());
            restaurant.setPhone(restaurantDetails.getPhone());
            restaurant.setCuisineType(restaurantDetails.getCuisineType());
            restaurant.setDescription(restaurantDetails.getDescription());
            return restaurantRepository.save(restaurant);
        }
        return null;
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
