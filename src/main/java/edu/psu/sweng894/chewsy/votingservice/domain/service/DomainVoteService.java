package edu.psu.sweng894.chewsy.votingservice.domain.service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

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
    public void removeVote(Long session, String email, String restaurant) {
        final Vote vote = new Vote(session, email, restaurant);
        if (voteRepository.findBySessionAndRestaurantAndEmail(session, restaurant, email).size() == 1) {
            System.out.println("removing vote");
            voteRepository.delete(vote);
        }
    }

    @Override
    public List<String> countVotes(Long session, int voters) {
        List<String> restaurants = new ArrayList();
        LinkedHashMap<String, BigDecimal> counts = new LinkedHashMap<String, BigDecimal>();
        List<String> consensus = new ArrayList();
        List<Vote> votes = voteRepository
          .findBySession(session);

        for (int i = 0; i < votes.size(); i++) {
            restaurants.add(votes.get(i).getRestaurant());
        }
        
        Set<String> distinct = new HashSet<>(restaurants);
        for (String s: distinct) {
            double ratio = (double) Collections.frequency(restaurants, s) / voters;
            counts.put(s, BigDecimal.valueOf(ratio).setScale(2, RoundingMode.HALF_UP));
        }

        BigDecimal maxRatio = Collections.max(counts.values());
        Set<String> keys = counts.keySet();

        for (String key : keys) {
            if (counts.get(key).compareTo(maxRatio) == 0) {
                consensus.add(key);
            }
        }

        return consensus;
    }    
}
