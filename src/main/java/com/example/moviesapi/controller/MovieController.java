package com.example.moviesapi.controller;

import com.example.moviesapi.modal.Movie;
import com.example.moviesapi.request.FilterRequest;
import com.example.moviesapi.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Movies", description = "Controller for retrieval of Movie entities based on specified criteria.")
@RestController
@RequestMapping("/api")
public class MovieController {

  private final MovieService movieService;

  @Autowired
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @Operation(summary = "Fetch all movies", description = "fetches all movie entities in database")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation")
  })
  @RequestMapping(value = "/movies", method = RequestMethod.GET)
  public List<Movie> getAllMovies() {
    return movieService.getMovies();
  }

  //TODO Correctly handle errors
  @Operation(summary = "Fetch movie based on ID", description = "fetches a movie entity using ID")
  @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
  public Optional<Movie> getMovieById(@PathVariable long id) {
    Optional<Movie> movie = movieService.findMovieById(id);
    if (movie.isPresent()) {
      return movieService.findMovieById(id);
    }
    return movie;
  }

  @Operation(summary = "Fetch movie entities based on title", description = "fetches all movie entities where title matches input string")
  @RequestMapping(value = "/movies/search/title", method = RequestMethod.GET)
  public List<Movie> searchByTitle(@RequestParam(value = "title") String subString) {
    return movieService.filterByTitle(subString);
  }

  @Operation(summary = "Fetch movie entities based on actor", description = "fetches all movie entities where at least one actor matches input string")
  @RequestMapping(value = "/movies/search/actor", method = RequestMethod.GET)
  public List<Movie> searchByActor(@RequestParam(value = "actor") String actor) {
    return movieService.filterByActor(actor);
  }

  @Operation(summary = "Fetch movie entities based on director", description = "fetches all movie entities where director matches input string")
  @RequestMapping(value = "/movies/search/director", method = RequestMethod.GET)
  public List<Movie> searchByDirector(@RequestParam(value = "director") String director) {
    return movieService.filterByDirector(director);
  }

  @Operation(summary = "Fetch movie entities based on multiple criteria", description = "fetches all movie entities where genre,gross income, released year, runtime and IMDB rating are equal or greater than input values. Ignores criteria if it is not present.")
  @RequestMapping(value = "/movies/filter", method = RequestMethod.POST)
  public List<Movie> filterMovies(@RequestBody FilterRequest request) {
    return movieService.filterMoviesByCriteria(request);
  }
}
