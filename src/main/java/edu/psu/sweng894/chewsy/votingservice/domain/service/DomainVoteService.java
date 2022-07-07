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
    public void castVote(Long id, String email, String restaurant) {
        final Vote vote = new Vote(id, email, restaurant);
        voteRepository.save(vote);
    }

    @Override
    public int countVotes(Long id, String restaurant) {
        return voteRepository
          .findByIdAndRestaurant(id, restaurant).size();
    }    
}
