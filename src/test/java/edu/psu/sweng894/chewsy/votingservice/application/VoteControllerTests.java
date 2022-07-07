package edu.psu.sweng894.chewsy.votingservice.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void shouldCountVotes_thenReturnCount() {
        Long id = Long.parseLong("31");
        String restaurant = "test";
        CountVotesRequest countVotesRequest = new CountVotesRequest(id, restaurant);
        int expected = 3;
        
        when(voteService.countVotes(anyLong(), anyString())).thenReturn(expected);
        
        int actual = classUnderTest.countVotes(countVotesRequest).getCount();

        assertEquals(expected, actual);
    }
    
}
