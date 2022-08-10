BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');



INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('Music', 'What are the names of the three types of Minor Scale in Western Harmony?', 'Music Theory, Scales, Vocabulary',
'Harmonic, Melodic, and Natural', 2);
INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('Music', 'Who is the Italian composer of the operas Macbeth, La Traviata, and Falstaff?', 'Opera, History, Theatre',
'Giuseppe Verdi', 2);
INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('Music', 'How many keys are there on a standard Grand Piano?', 'Instruments, Music', '88', 2);
INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('Music', 'What famous march written by the English composer Edward Elgar is commonly played at graduation ceremonies?',
'English Music, History, Fun-Facts', 'Pomp and Circumstance', 2);

INSERT INTO deck (name, subject, description, user_id) VALUES ('Classical Music Facts', 'Music', 'These are a random series of questions about composers, pieces of music, and instruments', 2);
INSERT INTO card_deck (card_id, deck_id) VALUES (1, 1), (2, 1), (3, 1), (4, 1);



INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('American History', 'When was the first U.S. dollar printed?', 'History, Currency', '1862', 2);
INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('American History', 'What was the first United States national monument?', 'History, Monuments, Geography', 'Devil’s Tower in Wyoming', 2);
INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('American History', 'What was the date of the Black Tuesday stock market crash?', 'History, Money', 'October 24, 1929', 2);
INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('American History', 'Passed in 1919, which amendment prevented the sale of alcoholic beverages?', 'History, Prohibition, Legislation', 'The 18th Amendment', 2);

INSERT INTO deck (name, subject, description, user_id) VALUES ('Historical Fun Facts', 'American History', 'Questions about places, people, and things from American History', 2);
INSERT INTO card_deck (card_id, deck_id) VALUES (5, 2), (6, 2), (7, 2), (8, 2);



INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('Science', 'What defines the identity of an element?', 'Science, Elements, Chemistry', 'The Number of Protons', 2);
INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('Science', 'When was the idea of the atom first introduced?', 'Science, Atoms, History', '450 B.C.', 2);
INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('Math', 'What is the average of the following numbers: 11, 13, 16, 13, 14', 'Math, Statistics', '13.4', 2);
INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('Math', 'What is 49.32% expressed as a decimal value?', 'Math, Percentages, Fractions', '0.4932', 2);

INSERT INTO deck (name, subject, description, user_id) VALUES ('Science and Math Trivia', 'Science and Math', 'Questions about Science trivia and mathematical expressions', 2);
INSERT INTO card_deck (card_id, deck_id) VALUES (9, 3), (10, 3), (11, 3), (12, 3);

INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('History', 'List in order the first five presidents of the USA.', 'Presidents, History, Government', 'Washington, Adams, Jefferson, Madison, Monroe', 2);
INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('Language', 'How do you say "Hello" in Spanish, French, and German', 'Languages, Culture', 'Hola! Bonjour! Guten Tag!', 2);
INSERT INTO card (subject, question, tags, answer, user_id) VALUES ('Science', 'What are the elements that comprise water? BONUS: give the molecular structure!', 'Chemistry, Molecules, Science', 'Hydrogen and Oxygen: H2O', 2);


COMMIT TRANSACTION;
