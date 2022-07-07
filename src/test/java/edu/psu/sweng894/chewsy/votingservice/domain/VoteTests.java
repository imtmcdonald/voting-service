package edu.psu.sweng894.chewsy.votingservice.domain;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VoteTests {
    private Vote classUnderTest;
    String email = "test@email.com";
    String restaurant = "test";
    Long id = Long.parseLong("31");

    @BeforeEach
    public void setUp() {
        classUnderTest = new Vote(id, email, restaurant);
    }

    @Test
    public void shouldCreateVote_thenReturnId() {
        String actual = classUnderTest.getEmail();

        assertEquals(email, actual);
    }

    @Test
    public void shouldCreateVote_thenReturnEmail() {
        Long actual = classUnderTest.getId();

        assertEquals(id, actual);
    }

    @Test
    public void shouldCreateVote_thenReturnRestaurant() {
        String actual = classUnderTest.getRestaurant();

        assertEquals(restaurant, actual);
    }
}

