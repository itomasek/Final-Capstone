BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS card CASCADE;
DROP TABLE IF EXISTS deck CASCADE;
DROP TABLE IF EXISTS card_deck CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE card (
    card_id SERIAL,
    subject varchar(50) NOT NULL,
    question varchar(200) NOT NULL,
    tags varchar(200) NOT NULL,
    answer varchar(200) NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT PK_card PRIMARY KEY (card_id),
    CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE deck (
    deck_id SERIAL,
    name varchar(50) NOT NULL,
    subject varchar(50) NOT NULL,
    description varchar(200) NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT PK_deck PRIMARY KEY (deck_id),
    CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE card_deck (
    card_id int NOT NULL,
    deck_id int NOT NULL,
    CONSTRAINT PK_card_deck PRIMARY KEY (card_id, deck_id),
    CONSTRAINT FK_card_deck_card FOREIGN KEY (card_id) REFERENCES card (card_id),
    CONSTRAINT FK_car_deck_deck FOREIGN KEY (deck_id) REFERENCES deck (deck_id)
);


COMMIT TRANSACTION;
