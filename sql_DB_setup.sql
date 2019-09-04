DROP TABLE books;

CREATE TABLE books (
	isbn INT,
	title VARCHAR(50),
	author VARCHAR(50),
	price FLOAT,
	copies INT,
	PRIMARY KEY (isbn)
);

INSERT INTO books VALUES (1001, 'Java for dummies', 'Tan Ah Teck', 11.11, 11);
INSERT INTO books VALUES (1002, 'More Java for dummies', 'Tan Ah Teck', 22.22, 22);
INSERT INTO books VALUES (1003, 'More Java for more dummies', 'Mohammad Ali', 33.33, 33);
INSERT INTO books VALUES (1004, 'A Cup of Java', 'Kumar', 44.44, 44);
INSERT INTO books VALUES (1005, 'A Teaspoon of Java', 'Kevin Jones', 55.55, 55);
