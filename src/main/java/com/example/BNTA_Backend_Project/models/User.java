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

    @Column(name = "runTimeTerrorCrypto")
    public int runTimeTerrorCrypto;

    @OneToMany(mappedBy = "user")

    @JsonIgnoreProperties("user")

    private List<Review> reviews;

    // ME
    public User(String name){
        this.name = name;
        this.runTimeTerrorCrypto = 0;
    }

    public User(){}

    public void addCryptoPoints() {
        this.runTimeTerrorCrypto++;
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

    public int getRunTimeTerrorCrypto() {
        return runTimeTerrorCrypto;
    }

    public void setRunTimeTerrorCrypto(int runTimeTerrorCrypto) {
        this.runTimeTerrorCrypto = runTimeTerrorCrypto;
    }
}
