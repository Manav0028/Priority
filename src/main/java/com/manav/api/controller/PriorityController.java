package com.manav.api.controller;

import com.manav.api.models.db_model.Priority;
import com.manav.api.models.response_model.UserPriorityRatingListJSON;
import com.manav.api.repository.PriorityRepository;
import com.manav.api.repository.UserPriorityRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
public class PriorityController {

    @Autowired
    public PriorityRepository repository;

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
        priorityRatingList.getPriorityRatings().forEach(p -> p.setUsername(authentication.getName()));
        ratingRepository.saveAll(priorityRatingList.getPriorityRatings());
        return "done";
    }
}
