package edu.psu.sweng894.chewsy.votingservice.application.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CastVoteRequest {
    @NotNull private Long session;
    @NotNull private String email;
    @NotNull private String restaurant;

    @JsonCreator
    public CastVoteRequest(@JsonProperty("session") final Long session, @JsonProperty("email") final String email, @JsonProperty("restaurant") final String restaurant) {
        this.session = session;
        this.email = email;
        this.restaurant = restaurant;
    }

    public Long getSession() {
        return session;
    }

    public String getEmail() {
        return email;
    }

    public String getRestaurant() {
        return restaurant;
    }
}
