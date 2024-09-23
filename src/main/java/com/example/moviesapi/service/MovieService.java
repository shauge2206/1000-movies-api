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
    List<Movie> movies = getMovies();
    String lowerCaseSubString = subString.toLowerCase();
    return movies.stream()
        .filter(movie -> movie.getTitle().toLowerCase().contains(lowerCaseSubString))
        .collect(Collectors.toList());
  }

  public List<Movie> filterByActor(String actor) {
    String lowerCaseActor = actor.toLowerCase();
    return getMovies().stream()
        .filter(movie -> {
          return Stream.of(movie.getActor1(), movie.getActor2(), movie.getActor3(),
                  movie.getActor4())
              .filter(java.util.Objects::nonNull)
              .map(String::toLowerCase)
              .anyMatch(act -> act.equals(lowerCaseActor));
        })
        .collect(Collectors.toList());
  }

  //TODO Check out spring jpa data query methods
  public List<Movie> filterByDirector(String director) {
    List<Movie> movies = getMovies();
    String lowerCaseSubString = director.toLowerCase();
    return movies.stream()
        .filter(movie -> movie.getTitle().toLowerCase().contains(lowerCaseSubString))
        .collect(Collectors.toList());
  }

  public List<Movie> filterMoviesByCriteria(FilterRequest request) {
    return getMovies().stream()
        .filter(movie -> movie.getGenre().contains(request.getGenre()))
        .filter(movie -> movie.getGrossIncome() >= request.getGrossIncome())
        .filter(movie -> movie.getReleasedYear() >= request.getReleasedYear())
        .filter(
            movie -> Integer.parseInt(movie.getRuntime().replace(" min", "")) >= Integer.parseInt(
                request.getRuntime()))
        .filter(movie -> movie.getImdbRating() >= request.getImdbRating())
        .toList();
  }

/*
  public static int[] filterDuplicates(int[] data) {
    // Write your code here
    // To debug: System.err.println("Debug messages...");
    return Arrays.stream(data).distinct().collect(Collectors.toList());
  }
*/
}
