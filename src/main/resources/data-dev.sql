INSERT INTO movie (poster_link, title, released_year, certificate, runtime, genre, imdb_rating,
                   overview, meta_score, director, actor1, actor2, actor3, actor4, number_of_votes,
                   gross_income)
SELECT *
FROM CSVREAD('movies_file.csv');

/*

COPY movie (poster_link, title, released_year, certificate, runtime, genre, imdb_rating,
            overview, meta_score, director, actor1, actor2, actor3, actor4, number_of_votes,
            gross_income)
FROM 'movies_file.csv'
DELIMITER ','
CSV HEADER;

 */