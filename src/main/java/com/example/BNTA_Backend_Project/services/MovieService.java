package com.example.BNTA_Backend_Project.services;

import com.example.BNTA_Backend_Project.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
}
