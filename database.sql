-- Create database (skip if it already exists)
CREATE DATABASE IF NOT EXISTS testdb
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

USE testdb;

-- Clean start (optional)
DROP TABLE IF EXISTS students;

-- Matches model.Student (id, name, age)
CREATE TABLE students (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  age INT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Sample data
INSERT INTO students (name, age) VALUES
  ('Alice', 20),
  ('Bob', 22),
  ('Charlie', NULL),
  ('Diana', 19),
  ('Evan', 23);

-- Optional index for name lookups
CREATE INDEX idx_students_name ON students(name);