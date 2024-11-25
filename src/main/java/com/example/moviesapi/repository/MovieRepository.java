package com.example.moviesapi.repository;


import com.example.moviesapi.modal.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

  List<Movie> findByDirectorContainingIgnoreCase(String director);

  List<Movie> findByTitleContainingIgnoreCase(String title);
}