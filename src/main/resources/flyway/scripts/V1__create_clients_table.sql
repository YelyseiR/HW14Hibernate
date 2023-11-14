CREATE TABLE clients
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(201) NOT NULL,
    last_name  VARCHAR(201) NOT NULL,
    CHECK (LENGTH(first_name) >= 3 AND LENGTH(last_name) >= 3)
);