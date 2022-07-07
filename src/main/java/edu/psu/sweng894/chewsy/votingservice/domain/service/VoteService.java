package edu.psu.sweng894.chewsy.votingservice.domain.service;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {
    void castVote(Long id, String email, String restaurant);

    int countVotes(Long id, String restaurant);
}
