package edu.psu.sweng894.chewsy.votingservice.application.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CountVotesRequest {
    @NotNull private Long id;
    @NotNull private String restaurant;

    @JsonCreator
    public CountVotesRequest(@JsonProperty("id") final Long id, @JsonProperty("restaurant") final String restaurant) {
        this.id = id;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public String getRestaurant() {
        return restaurant;
    }
}
