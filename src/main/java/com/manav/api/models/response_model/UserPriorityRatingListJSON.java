package com.manav.api.models.response_model;

import com.manav.api.models.db_model.UserPriorityRating;

import java.util.List;

public class UserPriorityRatingListJSON {
    List<UserPriorityRating> priorityRatings;

    public List<UserPriorityRating> getPriorityRatings() {
        return priorityRatings;
    }

    public void setPriorityRatings(List<UserPriorityRating> priorityRatings) {
        this.priorityRatings = priorityRatings;
    }
}
