CREATE TABLE movie (
   movie_id INTEGER AUTO_INCREMENT PRIMARY KEY,
   poster_link VARCHAR(200),
   title VARCHAR(100),
   released_year INTEGER,
   certificate CHAR(10),
   runtime VARCHAR(20),
   genre VARCHAR(100),
   imdb_rating FLOAT,
   overview VARCHAR(500),
   meta_score FLOAT,
   director VARCHAR(100),
   actor1 VARCHAR(100),
   actor2 VARCHAR(100),
   actor3 VARCHAR(100),
   actor4 VARCHAR(100),
   number_of_votes INTEGER,
   gross_income INTEGER DEFAULT 0
);