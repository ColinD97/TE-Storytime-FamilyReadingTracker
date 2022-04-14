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
	isbn BIGINT,
	difficulty int
);

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	family_id varchar(255) NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	email varchar(255),
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(255) NOT NULL,
	role varchar(50) NOT NULL,
	total_minutes int,
	points_balance int,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE users_books (
	user_id int NOT NULL,
	book_id int NOT NULL,
	minutes_read int,
	reading_format varchar (50) NOT NULL,
	times_read int,
	past_book boolean,
	current_book boolean,
	future_book boolean,
	notes varchar (50),
	CONSTRAINT PK_users_books PRIMARY KEY(user_id, book_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id),
    FOREIGN KEY(book_id) REFERENCES book_info(book_id)

);

INSERT INTO users (username, family_id, first_name, last_name, email, password_hash, role, total_minutes)
VALUES
	('user', 1, 'Colin', 'Davis', 'cd@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','parent', 0),
	('admin', 1, 'Nolan', 'Tsai', 'nt@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','child', 2450);


INSERT INTO book_info (title, author, isbn, difficulty)
VALUES
    ('The Super Cool Life of a Tech Lead', 'Colin Davis', 1234216543535, 4 ),
    ('What is For Dinner?', 'Nolan Tsai', 2348734681156, 3),
	('Project Managing, Like a Boss', 'Reginald Arnedo', 3458130428567, 5),
	('Just Let me Make it Pretty', 'Kai Indigo Wolf', 4568142953178, 2),
	('How to Play Your Best Golf All the Time', 'Tommy Armour', 1640569132164, 5),
	('The Rainbow Fish', 'J Alison James', 1379158253022, 1),
	('Just Me and My Dad', 'Mercer Mayer', 1191739256711, 2),
	('If You Give a Mouse a Cookie', 'Felicia Bond', 99017989234539, 2),
	('Where the Wild Things Are', 'Maurice Sendak', 2901623865404, 2),
	('Brown Bear, Brown Bear, What Do You See?', 'Brown Bear', 3987123096572, 1),
	('The Very Hungry Caterpillar', 'Reginald Arnedo', 9009890674127, 1),
	('Strictly No Elephants', 'Taeeun Yoo', 3116237654306, 2);

INSERT INTO users_books (user_id, book_id, minutes_read, reading_format, times_read, past_book, current_book, future_book, notes)
VALUES
	(1, 1, 30, '', 2, true, false, false, 'Definitely good for sleepy time.'),
	(1, 2, 30, '', 1, false, false, true, ''),
	(2, 1, 60, '', 1, true, true, false, 'Colin said this one is too wordy.'),
	(2, 3, 60, '', 2, false, true, false, ''),
	(1, 3, 90, '', 3, false, false, true, ''),
	(2, 4, 90, '', 1, true, false, false, ''),
	(2, 8, 30, '', 1, false, false, true, ''),
	(1, 9, 60, '', 5, false, true, false, 'Reg loves this one! He asks for it every night.');

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