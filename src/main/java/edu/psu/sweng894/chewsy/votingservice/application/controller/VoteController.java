package edu.psu.sweng894.chewsy.votingservice.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import edu.psu.sweng894.chewsy.votingservice.application.request.CastVoteRequest;
import edu.psu.sweng894.chewsy.votingservice.application.request.CountVotesRequest;
import edu.psu.sweng894.chewsy.votingservice.application.response.CountVotesResponse;
import edu.psu.sweng894.chewsy.votingservice.domain.service.VoteService;

@RestController
@RequestMapping("/vote")
public class VoteController {
    private final VoteService voteService;
    
    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/{id}/cast", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void castVote(@RequestBody final CastVoteRequest castVoteRequest) {
        voteService.castVote(castVoteRequest.getId(), castVoteRequest.getEmail(), castVoteRequest.getRestaurant()); 
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/{id}/count", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CountVotesResponse countVotes(@RequestBody final CountVotesRequest countVotesRequest) {
        final int count = voteService.countVotes(countVotesRequest.getId(), countVotesRequest.getRestaurant()); 
        CountVotesResponse response = new CountVotesResponse(count);

        System.out.println(count);
        return response;
    }
}
