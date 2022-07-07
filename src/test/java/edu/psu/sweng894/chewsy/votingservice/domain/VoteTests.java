package edu.psu.sweng894.chewsy.votingservice.domain;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VoteTests {
    private Vote classUnderTest;
    String email = "test@email.com";
    String restaurant = "test";
    Long session = Long.parseLong("31");

    @BeforeEach
    public void setUp() {
        classUnderTest = new Vote(session, email, restaurant);
    }

    @Test
    public void shouldCreateVote_thenReturnSession() {
        Long actual = classUnderTest.getSession();

        assertEquals(session, actual);
    }

    @Test
    public void shouldCreateVote_thenReturnEmail() {
        String actual = classUnderTest.getEmail();

        assertEquals(email, actual);
    }

    @Test
    public void shouldCreateVote_thenReturnRestaurant() {
        String actual = classUnderTest.getRestaurant();

        assertEquals(restaurant, actual);
    }

    @Test
    public void shouldCreateString_thenRetunIt() {
        String actual = classUnderTest.toString();
        String expected = "Vote[session='31', email='test@email.com', restaurant='test']";

        assertEquals(expected, actual);
    }
}

