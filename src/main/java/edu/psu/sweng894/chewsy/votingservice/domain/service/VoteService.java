package edu.psu.sweng894.chewsy.votingservice.domain.service;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface VoteService {
    void castVote(Long session, String email, String restaurant);
    void removeVote(Long session, String email, String restaurant);

    List<String> countVotes(Long session, int voters);
}
