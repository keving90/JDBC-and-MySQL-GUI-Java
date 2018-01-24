-- MySQL

-- provision.sql by Kevin Geiszler

-- This script is used to create and insert data into a MySQL table called courselist
-- inside a database called test1. It is used for the JDBC_and_MySQL_GUI_Java GitHub
-- project. For more information, visit https://github.com/keving90.

-- 1. Create a database called test1 in MySQL using: CREATE DATABASE test1;
-- 2. Use the database in MySQL with: use test1;
-- 3. Run the script using: SOURCE /PATH/TO/FILE/provision.sql

-- SOURCE /Users/Kevin/Desktop/provision.sql

-- If you decide you no longer want the table in your database, then use: DROP TABLE courselist;
-- To delete the test1 database, use: DROP DATABASE test1;

-- WARNING: Be very careful when dropping tables or deleting databases. You don't want to 
-- accidentally drop/delete the wrong thing.

CREATE TABLE IF NOT EXISTS courselist (
    course_name VARCHAR(100),
    course_number VARCHAR(50),
    enrollment INT(2),
    start_date VARCHAR(10),
    end_date VARCHAR(10),
    
    PRIMARY KEY (course_number)
);

INSERT INTO courselist
(course_name, course_number, enrollment, start_date, end_date)
VALUES
('Object-Oriented Programming',     'COEN 275', '39', '2014-04-31', '2014-06-13'),
('Computer Architecture',           'COEN 122', '27', '2014-04-31', '2014-06-13'),
('Design & Analysis of Algorithms', 'COEN 279', '48', '2014-04-31', '2014-06-13'),
('Introduction to Programming',     'COEN 010', '84', '2014-04-31', '2014-06-13'),
('Machine Learning',                'COEN 240', '20', '2014-04-31', '2014-06-13');