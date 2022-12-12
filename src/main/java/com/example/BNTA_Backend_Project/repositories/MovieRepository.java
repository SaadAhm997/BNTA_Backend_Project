package com.example.BNTA_Backend_Project.repositories;

import com.example.BNTA_Backend_Project.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
