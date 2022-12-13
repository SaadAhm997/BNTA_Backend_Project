package com.example.BNTA_Backend_Project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Review> reviews;

    public User(String name){
        this.name = name;
    }

    public User(){}

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void deleteReview(Review review){
        this.reviews.add(review);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
