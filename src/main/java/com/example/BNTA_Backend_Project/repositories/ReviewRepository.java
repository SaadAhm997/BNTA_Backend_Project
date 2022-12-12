package com.example.BNTA_Backend_Project.repositories;

import com.example.BNTA_Backend_Project.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}
