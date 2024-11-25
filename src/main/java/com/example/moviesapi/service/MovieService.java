package com.example.moviesapi.service;

import com.example.moviesapi.modal.Movie;
import com.example.moviesapi.repository.MovieRepository;
import com.example.moviesapi.request.FilterRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private final MovieRepository movieRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> getMovies() {
    return movieRepository.findAll();
  }

  public Optional<Movie> findMovieById(long id) {
    return movieRepository.findById(id);
  }

  public List<Movie> filterByTitle(String subString) {
    return movieRepository.findByTitleContainingIgnoreCase((subString));
  }

  public List<Movie> filterByActor(String actor) {
    String lowerCaseActor = actor.toLowerCase();
    return getMovies().stream()
        .filter(movie -> Stream.of(movie.getActor1(), movie.getActor2(), movie.getActor3(),
                movie.getActor4())
            .map(String::toLowerCase)
            .anyMatch(act -> act.equals(lowerCaseActor)))
        .collect(Collectors.toList());
  }

  public List<Movie> filterByDirector(String director) {
    return movieRepository.findByDirectorContainingIgnoreCase(director);
  }

  public List<Movie> filterMoviesByCriteria(FilterRequest request) {
    return getMovies().stream()
        .filter(movie -> movie.getGenre().contains(request.getGenre()))
        .filter(movie -> movie.getReleasedYear() >= request.getReleasedYear())
        .filter(
            movie -> movie.getRuntime() >= Integer.parseInt(
                request.getRuntime()))
        .filter(movie -> movie.getImdbRating() >= request.getImdbRating())
        .toList();
  }
}
