package edu.psu.sweng894.chewsy.votingservice.application.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CastVoteRequest {
    @NotNull private Long id;
    @NotNull private String email;
    @NotNull private String restaurant;

    @JsonCreator
    public CastVoteRequest(@JsonProperty("id") final Long id, @JsonProperty("email") final String email, @JsonProperty("restaurant") final String restaurant) {
        this.id = id;
        this.email = email;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRestaurant() {
        return restaurant;
    }
}
