package edu.psu.sweng894.chewsy.votingservice.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompositeKey.class)
public class Vote {
    @Id
    private Long session;
    @Id
    private String email;
    @Id
    private String restaurant;

    private Vote(){}

    public Vote(final Long session, final String email, final String restaurant) {
        this.session = session;
        this.email = email;
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return String.format(
            "Vote[session='%d', email='%s', restaurant='%s']",
            session, email, restaurant);
    }

    public String getEmail() {
        return this.email;
    }

    public String getRestaurant() {
        return this.restaurant;
    }

    public Long getSession() {
        return this.session;
    }  
}
