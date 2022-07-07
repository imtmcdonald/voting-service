package edu.psu.sweng894.chewsy.votingservice.application.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CountVotesRequest {
    @NotNull private Long session;
    @NotNull private String restaurant;

    @JsonCreator
    public CountVotesRequest(@JsonProperty("session") final Long session, @JsonProperty("restaurant") final String restaurant) {
        this.session = session;
        this.restaurant = restaurant;
    }

    public Long getSession() {
        return session;
    }

    public String getRestaurant() {
        return restaurant;
    }
}
