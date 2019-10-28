package com.example.demo.Services;

import com.example.demo.Model.Movie;

import java.util.List;

public interface MovieService {



    void save(Movie mov);

    void update(Movie mov);

    void delete(int id);

    Movie findById(int id);

    List<Movie> changer();

    List<Movie> search(String sea);

    void saveRating(Movie movie);

    void updateRating();


}
