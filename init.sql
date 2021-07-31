CREATE TABLE feeds (
	feed_id serial PRIMARY KEY,
	link VARCHAR ( 255 ) UNIQUE NOT NULL
);