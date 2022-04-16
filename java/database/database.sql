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

INSERT INTO users (username, family_id, first_name, last_name, email, password_hash, role, total_minutes, points_balance)
VALUES
	('user', 1, 'Colin', 'Davis', 'cd@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PARENT', 90,100),
	('admin', 1, 'Nolan', 'Tsai', 'nt@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_CHILD', 2450,200);


INSERT INTO book_info (title, author, isbn, difficulty)
VALUES
	('How to Play Your Best Golf All the Time', 'Tommy Armour', 9780684813790, 5),
	('The Rainbow Fish', 'J Alison James', 1558580093, 1),
	('1984', 'George Orwell', 9780140009729, 5),
	('Just Me and My Dad', 'Mercer Mayer', 0307118398, 2),
	('Macbeth', 'William Shakespeare', 9780333419991, 5),
	('If You Give a Mouse a Cookie', 'Felicia Bond', 9780064434096, 2),
	('Inside Out & Back Again', 'Thanhha Lai', 9780545508971, 3),
	('Where the Wild Things Are', 'Maurice Sendak', 9780064431781, 2),
	('The Giver', 'Louis Lowry', 9780395645666, 4),
	('Charlotte''s Web', 'Jennifer Frantz', 9780060882846, 3 ),
	('Brown Bear, Brown Bear, What Do You See?', 'Brown Bear', 0805017445, 1),
	('The Very Hungry Caterpillar', 'Reginald Arnedo', 0399227539, 1),
	('Strictly No Elephants', 'Taeeun Yoo', 9781481416474, 2),
	('Harry Potter and the Deathly Hollows', 'J. K. Rowling', 9780545139700, 5);


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