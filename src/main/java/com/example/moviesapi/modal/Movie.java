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
  private Integer releasedYear;
  private String certificate;
  private Integer runtime;
  private String genre;
  private Float imdbRating;
  private String overview;
  private Float metaScore;
  private String director;
  private String actor1;
  private String actor2;
  private String actor3;
  private String actor4;
  private Integer numberOfVotes;
  private Integer grossIncome;
  private String posterLink;


  public Movie() {
  }


  public Movie(String title, Integer releasedYear, String certificate, Integer runtime,
      String genre,
      Float imdbRating, String overview, Float metaScore, String director, String actor1,
      String actor2, String actor3, String actor4, Integer numberOfVotes, Integer grossIncome,
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

  public Integer getRuntime() {
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
