CREATE TABLE IF NOT EXISTS movie (
    movie_id SERIAL PRIMARY KEY,
    poster_link VARCHAR(300),
    title VARCHAR(100),
    released_year INTEGER,
    certificate CHAR(10),
    runtime VARCHAR(20),
    genre VARCHAR(100),
    imdb_rating REAL,
    overview VARCHAR(500),
    meta_score REAL,
    director VARCHAR(100),
    actor1 VARCHAR(100),
    actor2 VARCHAR(100),
    actor3 VARCHAR(100),
    actor4 VARCHAR(100),
    number_of_votes INTEGER,
    gross_income INTEGER DEFAULT 0
    );