CREATE DATABASE IF NOT EXISTS microservice;
USE microservice;

CREATE TABLE IF NOT EXISTS products (
    id INT(11) AUTO_INCREMENT,
    name VARCHAR(255),
    price DECIMAL(10, 2),
    PRIMARY KEY (id)
);

INSERT INTO products VALUE (0, 'microservice', 100);
INSERT INTO products VALUE (0, 'monolito', 10);