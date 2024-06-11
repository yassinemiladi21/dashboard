DROP TABLE match IF EXISTS;

CREATE TABLE match  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    season VARCHAR(255),
    city VARCHAR(255),
    date VARCHAR(255),
    player_of_match VARCHAR(255),
    venue VARCHAR(255),
    team1 VARCHAR(255),
    team2 VARCHAR(255),
    toss_winner VARCHAR(255),
    toss_decision VARCHAR(255),
    match_winner VARCHAR(255),
    result VARCHAR(255),
    result_margin VARCHAR(255),
    umpire1 VARCHAR(255),
    umpire2 VARCHAR(255),
);