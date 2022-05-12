DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS author;

CREATE TABLE author
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    author         VARCHAR(250) NOT NULL,
    shortBiography VARCHAR(2000) DEFAULT NULL,
    fullBiography  VARCHAR(4000) DEFAULT NULL
);

CREATE TABLE books
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    authorId INT          NOT NULL,
    title    VARCHAR(250) NOT NULL,
    priceOld VARCHAR(250) DEFAULT NULL,
    price    VARCHAR(250) DEFAULT NULL
);

ALTER TABLE books
    ADD FOREIGN KEY (authorId)
        REFERENCES author (id);