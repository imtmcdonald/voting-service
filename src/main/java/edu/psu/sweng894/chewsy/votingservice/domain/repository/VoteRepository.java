package edu.psu.sweng894.chewsy.votingservice.domain.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.psu.sweng894.chewsy.votingservice.domain.Vote;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {
    List<Vote> findBySessionAndRestaurant(Long session, String restaurant);
    List<Vote> findBySessionAndRestaurantAndEmail(Long session, String restaurant, String email);
    List<Vote> findBySession(Long session);
}
