package edu.psu.sweng894.chewsy.votingservice.application.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CountVotesRequest {
    @NotNull private Long session;
    @NotNull private int voters;

    @JsonCreator
    public CountVotesRequest(@JsonProperty("session") final Long session, @JsonProperty("voters") final int voters) {
        this.session = session;
        this.voters = voters;
    }

    public Long getSession() {
        return session;
    }

    public int getVoters() {
        return voters;
    }
}
