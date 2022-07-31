package edu.psu.sweng894.chewsy.votingservice.application.response;

import java.util.List;

public class CountVotesResponse {
    private final List<String> consensus;

    public CountVotesResponse(final List<String> consensus) {
        this.consensus = consensus;
    }

    public List<String> getCount() {
        return consensus;
    }
}
