BEGIN TRANSACTION;

DROP TABLE IF EXISTS book_info, users, users_books CASCADE;

DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE book_info (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
	isbn int
	
);

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	family_id varchar(255) NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	email varchar(255) NOT NULL,
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(255) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE users_books (
	user_id int NOT NULL,
	book_id int NOT NULL,
	times_read int,
	past_book boolean,
	current_book boolean,
	future_book boolean,
	CONSTRAINT PK_users_books PRIMARY KEY(user_id, book_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id),
    FOREIGN KEY(book_id) REFERENCES book_info(book_id)
	
);

INSERT INTO users (username, family_id, first_name, last_name, email, password_hash, role) 
VALUES 
	('user', '1', 'Colin', 'Davis', 'cd@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'),
	('admin', '1', 'Nolan', 'Tsai', 'nt@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'),
	('username', '2', 'Reg', 'Arnedo', 'reg@hotmail.com', 'testpasshash', 'ROLE_USER'),
	('username1', '2', 'Kai', 'Wolf', 'Kai@hotmail.com', 'passwordhash', 'ROLE_USER'),
	('dolphinnet', '3', 'Bill', 'Gates', 'bill@outlook.com', 'microsoft', 'ROLE_ADMIN'),
	('deepdive', '3', 'Feng-hsiung', 'Hsu', 'Hsu@fenghsi.ung', 'taiwan', 'ROLE_USER'),
	('robotbill', '3', 'William', 'Normal', 'bill@gmail.com', 'passwordbill', 'ROLE_USER'),
	('elevatorman', '4', 'Carlos', 'Bootcamp', 'carlos@techelevator.com', 'elevator', 'ROLE_USER'),
	('notnull', '4', 'Joe', 'Null', 'joe@nu.ll', 'fakedata', 'ROLE_USER'),
	('realname', '4', 'Real', 'Name', 'realemail@hotmail.com', 'realpass', 'ROLE_ADMIN'),
	('KingJames', '5', 'Lebron', 'James', 'Lebron@nba.org', 'jamesjames', 'ROLE_USER'),
	('LBird', '5', 'Larry', 'Bird', 'Larry@mlb.org', 'birdman', 'ROLE_USER');

INSERT INTO book_info (title, author, isbn)
VALUES
    ('Book Title 1', 'Colin Davis', 12345),
    ('Book Title 2', 'Nolan Tsai', 23456),
	('Book Title 3', 'Reginald Arnedo', 34567),
	('Book Title 4', 'Kai Indigo Wolf', 45678),
	('How to Play Your Best Golf All the Time', 'Tommy Armour', 164164),
	('The Rainbow Fish', 'J Alison James', 13722),
	('Just Me and My Dad', 'Mercer Mayer', 11911),
	('If You Give a Mouse a Cookie', 'Felicia Bond', 9939),
	('Where the Wild Things Are', 'Maurice Sendak', 29404),
	('Brown Bear, Brown Bear, What Do You See?', 'Brown Bear', 39572),
	('The Very Hungry Caterpillar', 'Reginald Arnedo', 9027),
	('Strictly No Elephants', 'Taeeun Yoo', 3106);

INSERT INTO users_books (user_id, book_id, times_read, past_book, current_book, future_book) 
VALUES 
	(1, 1, 1, true, false, false),
	(1, 2, 0, false, false, true),
	(2, 1, 3, true, true, false),
	(2, 3, 0, false, true, false),
	(3, 3, 0, false, false, true),
	(4, 3, 5, true, false, false),
	(4, 8, 0, false, false, true),
	(5, 9, 0, false, true, false),
	(5, 11, 1, true, true, false),
	(6, 2, 0, false, false, true),
	(7, 5, 0, false, true, false),
	(8, 9, 2, true, false, false);

--- USER SETUP (Do Not Modify)
DROP USER IF EXISTS final_capstone_owner;
DROP USER IF EXISTS final_capstone_appuser;

CREATE USER final_capstone_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

CREATE USER final_capstone_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;

COMMIT TRANSACTION;