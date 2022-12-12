package com.example.BNTA_Backend_Project.component;

import com.example.BNTA_Backend_Project.models.Movie;
import com.example.BNTA_Backend_Project.models.Review;
import com.example.BNTA_Backend_Project.models.User;
import com.example.BNTA_Backend_Project.repositories.MovieRepository;
import com.example.BNTA_Backend_Project.repositories.ReviewRepository;
import com.example.BNTA_Backend_Project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Users
        User user1 = new User("Sara");
        userRepository.save(user1);

        User user2 = new User("Radhika");
        userRepository.save(user2);

        User user3 = new User("Isabel");
        userRepository.save(user3);

        User user4 = new User("Saad");
        userRepository.save(user4);

        User user5 = new User("John");
        userRepository.save(user5);

//        Movies
        Movie movie1 = new Movie("Alien", "sci-fi", 117);
        movieRepository.save(movie1);

        Movie movie2 = new Movie("The Imitation Game", "adventure", 114);
        movieRepository.save(movie2);

        Movie movie3 = new Movie("Iron Man", "adventure", 126);
        movieRepository.save(movie3);

        Movie movie4 = new Movie("The Martian", "adventure", 144);
        movieRepository.save(movie4);

        Movie movie5 = new Movie("Bravenheart", "adventure", 150);
        movieRepository.save(movie5);

//        Reviews
        Review review1 = new Review(8, "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", movie1, user1);
        reviewRepository.save(review1);

        Review review2 = new Review(6, "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",movie2, user2);
        reviewRepository.save(review2);

        Review review3 = new Review(9, "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",movie3, user3);
        reviewRepository.save(review3);

        Review review4 = new Review(9, "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", movie4, user4);
        reviewRepository.save(review4);

        Review review5 = new Review(9, "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", movie5, user5);
        reviewRepository.save(review5);

//        ONE USER MANY REVIEWS
        Review review6 = new Review(9, "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", movie4, user1);
        reviewRepository.save(review6);

        Review review7 = new Review(9, "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", movie1, user2);
        reviewRepository.save(review7);

    }

}
