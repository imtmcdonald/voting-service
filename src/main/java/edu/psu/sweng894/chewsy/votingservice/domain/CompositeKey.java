package edu.psu.sweng894.chewsy.votingservice.domain;

import java.io.Serializable;

public class CompositeKey implements Serializable {
    private Long session;
    private String email;
    private String restaurant;
}
