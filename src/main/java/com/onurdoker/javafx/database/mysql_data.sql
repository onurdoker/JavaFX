-- Database Create
CREATE DATABASE user_management;

-- Oluşturulmuş database seçmek
USE user_management;

-- user adında bir tablo oluştur
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- ###################################################################################################################

-- Insert
INSERT INTO users(username,password,email) VALUES ('Onur','1234','odoker@msn.com');

-- Select
select * FROM users;

-- Find User
SELECT  *  FROM users WHERE username='Onur' AND '1234';

-- Update
UPDATE users SET username='Onur2', password='12345644', email='odoker@hootmail.com' WHERE id=1;

-- delete
DELETE FROM users  WHERE id=1;
