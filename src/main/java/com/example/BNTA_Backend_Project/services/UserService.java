package com.example.BNTA_Backend_Project.services;

import com.example.BNTA_Backend_Project.models.Review;
import com.example.BNTA_Backend_Project.models.User;
import com.example.BNTA_Backend_Project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReviewService reviewService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User updateUser(User user, Long id) {
        User userToUpdate = userRepository.findById(id).get();
        if (user.getName() != null) {
            userToUpdate.setName(user.getName());
        }
            return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        List<Review> reviews = user.getReviews();
        for (Review review : reviews){
            reviewService.deleteReview(review.getId());
        }
        userRepository.deleteById(id);
    }

    public List<User> findUserByName(String name){
        return userRepository.findByName(name);
    }
}
