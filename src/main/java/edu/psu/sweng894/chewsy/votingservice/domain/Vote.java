package edu.psu.sweng894.chewsy.votingservice.domain;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vote {
    @Id
    private Long id;
    private String email;
    private String restaurant;

    public Vote(final Long id, final String email, final String restaurant) {
        this.id = id;
        this.email = email;
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return String.format(
            "Session[id='%d', email='%s', restaurant='%s']",
            id, email, restaurant);
    }

    public String getEmail() {
        return this.email;
    }

    public String getRestaurant() {
        return this.restaurant;
    }
    
    public Long getId() {
        return this.id;
    }  
}
