package edu.psu.sweng894.chewsy.votingservice.application.response;

public class CountVotesResponse {
    private final int count;

    public CountVotesResponse(final int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
