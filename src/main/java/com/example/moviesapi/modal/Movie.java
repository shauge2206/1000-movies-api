package com.example.moviesapi.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long movieId;

  private String title;
  private int releasedYear;
  private String certificate;
  private String runtime;
  private String genre;
  private float imdbRating;
  private String overview;
  private float metaScore;
  private String director;
  private String actor1;
  private String actor2;
  private String actor3;
  private String actor4;
  private int numberOfVotes;
  private int grossIncome;
  private String posterLink;


  public Movie() {
  }


  public Movie(String title, int releasedYear, String certificate, String runtime, String genre,
      float imdbRating, String overview, int metaScore, String director, String actor1,
      String actor2, String actor3, String actor4, int numberOfVotes, int grossIncome,
      String posterLink) {
    this.title = title;
    this.releasedYear = releasedYear;
    this.certificate = certificate;
    this.runtime = runtime;
    this.genre = genre;
    this.imdbRating = imdbRating;
    this.overview = overview;
    this.metaScore = metaScore;
    this.director = director;
    this.actor1 = actor1;
    this.actor2 = actor2;
    this.actor3 = actor3;
    this.actor4 = actor4;
    this.numberOfVotes = numberOfVotes;
    this.grossIncome = grossIncome;
    this.posterLink = posterLink;
  }

  public String getTitle() {
    return title;
  }

  public int getReleasedYear() {
    return releasedYear;
  }

  public String getCertificate() {
    return certificate;
  }

  public String getRuntime() {
    return runtime;
  }

  public String getGenre() {
    return genre;
  }

  public float getImdbRating() {
    return imdbRating;
  }

  public String getOverview() {
    return overview;
  }

  public float getMetaScore() {
    return metaScore;
  }

  public String getDirector() {
    return director;
  }

  public String getActor1() {
    return actor1;
  }

  public String getActor2() {
    return actor2;
  }

  public String getActor3() {
    return actor3;
  }

  public String getActor4() {
    return actor4;
  }

  public int getNumberOfVotes() {
    return numberOfVotes;
  }

  public int getGrossIncome() {
    return grossIncome;
  }

  public String getPosterLink() {
    return this.posterLink;
  }
}
