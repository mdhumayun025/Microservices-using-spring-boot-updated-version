package com.mc.user.service.services.impl;

import com.mc.user.service.clients.RatingService;
import com.mc.user.service.entities.Ratings;
import com.mc.user.service.entities.User;
import com.mc.user.service.exceptions.ResourceNotFoundException;
import com.mc.user.service.repositories.UserRepository;
import com.mc.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RatingService ratingService;
    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
//        List<Ratings> ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, ArrayList.class);
        List<Ratings> ratings = ratingService.getRatingsByUserId(userId);
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found server!! " + userId));
        user.setRatings(ratings);
        return user;
    }
}
