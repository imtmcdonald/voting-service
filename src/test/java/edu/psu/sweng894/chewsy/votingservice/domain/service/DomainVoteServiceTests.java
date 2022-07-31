package edu.psu.sweng894.chewsy.votingservice.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import edu.psu.sweng894.chewsy.votingservice.domain.Vote;
import edu.psu.sweng894.chewsy.votingservice.domain.repository.VoteRepository;

public class DomainVoteServiceTests {
    private VoteRepository voteRepository;
    private DomainVoteService classUnderTest;

    @BeforeEach
    public void setUp() {
        voteRepository = mock(VoteRepository.class);
        classUnderTest = new DomainVoteService(voteRepository);
    }

    @Test
    public void shouldCastVote_thenSaveIt() {
        final Long id = Long.parseLong("31");
        final String email = "test@email.com";
        final String restaurant = "test";

        Vote newVote = new Vote(id, email, restaurant);

        when(voteRepository.save(any(Vote.class))).thenReturn(newVote);

        classUnderTest.castVote(id, email, restaurant);

        verify(voteRepository).save(any(Vote.class));
    }

    @Test
    public void shouldCastVotes_thenReturnConsensus() {
        final List<Vote> votes = new ArrayList();
        final List<String> expected = new ArrayList();
        final Long id = Long.parseLong("31");
        final String emailA = "testa@email.com";
        final String emailB = "testb@email.com";
        final String emailC = "testc@email.com";
        final String restaurant = "testA";
        final String restaurantOp = "testB";
        final Vote voteA = new Vote(id, emailA, restaurant);
        final Vote voteB = new Vote(id, emailB, restaurant);
        final Vote voteC = new Vote(id, emailB, restaurantOp);
        final Vote voteD = new Vote(id, emailC, restaurant);
        final Vote voteE = new Vote(id, emailC, restaurantOp);
        final int voters = 3;

        expected.add(restaurant);

        votes.add(voteA);
        votes.add(voteB);
        votes.add(voteC);
        votes.add(voteD);
        votes.add(voteE);

        when(voteRepository.findBySession(anyLong())).thenReturn(votes);
        
        List<String> actual = classUnderTest.countVotes(id, voters);

        assertEquals(expected, actual);
    }
}
