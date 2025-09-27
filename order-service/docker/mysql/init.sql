-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS order_service;

-- Use the database
USE order_service;

-- Create the user and grant all privileges
CREATE USER IF NOT EXISTS 'orderuser'@'%' IDENTIFIED BY 'orderpassword';
GRANT ALL PRIVILEGES ON order_service.* TO 'orderuser'@'%';
FLUSH PRIVILEGES;