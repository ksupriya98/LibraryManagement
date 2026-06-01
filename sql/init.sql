-- Library Management database setup
-- Run: mysql -u root -p < sql/init.sql

CREATE DATABASE IF NOT EXISTS library_management
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE library_management;

CREATE TABLE IF NOT EXISTS book (
    id       INT          NOT NULL AUTO_INCREMENT,
    title    VARCHAR(255) NOT NULL,
    author   VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO book (title, author, category) VALUES
    ('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction'),
    ('Clean Code', 'Robert C. Martin', 'Technology'),
    ('Sapiens', 'Yuval Noah Harari', 'History');
