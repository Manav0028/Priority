package com.manav.api.models;

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
