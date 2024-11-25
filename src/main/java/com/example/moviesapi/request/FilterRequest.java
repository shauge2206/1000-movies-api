package com.example.moviesapi.request;

public class FilterRequest {

  private String genre;
  private int releasedYear;
  private String runtime;
  private float imdbRating;

  public float getImdbRating() {
    return imdbRating;
  }

  public void setImdbRating(float imdbRating) {
    this.imdbRating = imdbRating;
  }

  public String getRuntime() {
    return runtime;
  }

  public void setRuntime(String runtime) {
    this.runtime = runtime;
  }

  public int getReleasedYear() {
    return releasedYear;
  }

  public void setReleasedYear(int releasedYear) {
    this.releasedYear = releasedYear;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }
}

