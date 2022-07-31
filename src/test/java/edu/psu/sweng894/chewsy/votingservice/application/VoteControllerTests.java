package edu.psu.sweng894.chewsy.votingservice.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.psu.sweng894.chewsy.votingservice.application.controller.VoteController;
import edu.psu.sweng894.chewsy.votingservice.application.request.CastVoteRequest;
import edu.psu.sweng894.chewsy.votingservice.application.request.CountVotesRequest;
import edu.psu.sweng894.chewsy.votingservice.domain.service.VoteService;

public class VoteControllerTests {
    private VoteController classUnderTest;
    private VoteService voteService;
    
    @BeforeEach
    public void setUp() {
        voteService = mock(VoteService.class);
        classUnderTest = new VoteController(voteService);
    }

    @Test
    public void shouldCastVote_thenReturnVerifyIt() {
        Long id = Long.parseLong("31");
        String email = "test@email.com";
        String restaurant = "test";
        CastVoteRequest castVoteRequest = new CastVoteRequest(id, email, restaurant);
     
        classUnderTest.castVote(castVoteRequest);

        verify(voteService).castVote(id, email, restaurant);
    }

    @Test
    public void shouldCountVotes_thenReturnConsensus() {
        List<String> expected = new ArrayList();
        Long id = Long.parseLong("31");
        int voters = 5;
        String restaurant = "test";
        CountVotesRequest countVotesRequest = new CountVotesRequest(id, voters);

        expected.add(restaurant);
        
        when(voteService.countVotes(anyLong(), anyInt())).thenReturn(expected);
        
        List<String> actual = classUnderTest.countVotes(countVotesRequest).getCount();

        assertEquals(expected, actual);
    }
    
}
