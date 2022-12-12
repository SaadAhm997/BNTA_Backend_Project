package com.example.BNTA_Backend_Project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "reviews")
public class Review {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rating")
    private int rating;
    @Column(name = "reviewBody")
    private String reviewBody;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties("reviews")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("reviews")
    private User user;


    public Review(int rating, String reviewBody, Movie movie, User user){
        this.rating = rating;
        this.reviewBody = reviewBody;
        this.movie = movie;
        this.user = user;
    }

    public Review(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
