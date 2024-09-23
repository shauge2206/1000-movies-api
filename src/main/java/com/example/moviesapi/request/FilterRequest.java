package com.example.moviesapi.request;

public class FilterRequest {

  private String genre;
  private int grossIncome;
  private int releasedYear;
  private String runtime;
  private float imdbRating;

  public float getImdbRating() {
    return imdbRating;
  }

  public String getRuntime() {
    return runtime;
  }

  public int getReleasedYear() {
    return releasedYear;
  }

  public int getGrossIncome() {
    return grossIncome;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setGrossIncome(int grossIncome) {
    this.grossIncome = grossIncome;
  }

  public void setReleasedYear(int releasedYear) {
    this.releasedYear = releasedYear;
  }

  public void setRuntime(String runtime) {
    this.runtime = runtime;
  }

  public void setImdbRating(float imdbRating) {
    this.imdbRating = imdbRating;
  }
}

