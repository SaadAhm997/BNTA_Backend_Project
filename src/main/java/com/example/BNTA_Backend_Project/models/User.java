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

    @Column(name = "terrorRuntimeCrypto")
    public int terrorRuntimeCrypto;

    @OneToMany(mappedBy = "user")

    @JsonIgnoreProperties("user")

    private List<Review> reviews;

    // ME
    public User(String name){
        this.name = name;
        this.terrorRuntimeCrypto = 0;
    }

    public User(){}

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void deleteReview(Review review){
        this.reviews.add(review);
    }
    // me
    public void addCryptoPoints() {
        this.terrorRuntimeCrypto++;
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

    public int getTerrorRuntimeCrypto() {
        return terrorRuntimeCrypto;
    }

    public void setTerrorRuntimeCrypto(int terrorRunCrypto) {
        this.terrorRuntimeCrypto = terrorRunCrypto;
    }
}
