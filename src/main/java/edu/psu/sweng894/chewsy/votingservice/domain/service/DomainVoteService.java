package edu.psu.sweng894.chewsy.votingservice.domain.service;
import org.springframework.stereotype.Service;

import edu.psu.sweng894.chewsy.votingservice.domain.Vote;
import edu.psu.sweng894.chewsy.votingservice.domain.repository.VoteRepository;

@Service
public class DomainVoteService implements VoteService {
    private final VoteRepository voteRepository;

    public DomainVoteService(final VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public void castVote(Long session, String email, String restaurant) {
        final Vote vote = new Vote(session, email, restaurant);
        voteRepository.save(vote);
    }

    @Override
    public int countVotes(Long session, String restaurant) {
        return voteRepository
          .findBySessionAndRestaurant(session, restaurant).size();
    }    
}
