package com.example.BNTA_Backend_Project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "genre")
    private String genre;
    @Column(name = "duration")
    private int duration;
    @OneToMany(mappedBy = "movie")
    @JsonIgnoreProperties("movie")
    private List<Review> reviews;


    public Movie(String title, String genre, int duration){
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.reviews = new ArrayList<>();
    }

    public Movie(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}