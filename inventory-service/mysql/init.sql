-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS inventory_service;

-- Use the database
USE inventory_service;

-- Create the user and grant all privileges
CREATE USER IF NOT EXISTS 'inventoryuser'@'%' IDENTIFIED BY 'inventorypassword';
GRANT ALL PRIVILEGES ON inventory_service.* TO 'inventoryuser'@'%';
FLUSH PRIVILEGES;