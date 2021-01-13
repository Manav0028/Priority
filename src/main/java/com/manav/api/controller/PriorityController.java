package com.manav.api.controller;

import com.manav.api.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class PriorityController {

    @Autowired
    public PriorityRepository repository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    public UserPriorityRatingRepository ratingRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Priority> getAllPriorities() {
        return repository.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addPriority(@RequestBody String priorityName) {
        Priority priority = new Priority();
        priority.setPriorityName(priorityName);
        repository.save(priority);
        return "Priority Added";
    }

    @PostMapping(path = "/rate")
    public @ResponseBody String ratePriority(Authentication authentication, @RequestBody UserPriorityRatingListJSON priorityRatingList) {
//        UserDetails user = userDetailsService.loadUserByUsername(authentication.getName());
        priorityRatingList.getPriorityRatings().forEach(p -> p.setUsername(authentication.getName()));
        ratingRepository.saveAll(priorityRatingList.getPriorityRatings());
        return "done";
    }
}
