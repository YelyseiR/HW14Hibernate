CREATE TABLE tickets
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id      INT          NOT NULL,
    from_planet_id VARCHAR(255) NOT NULL,
    to_planet_id   VARCHAR(255) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients (id) ON DELETE CASCADE,
    FOREIGN KEY (from_planet_id) REFERENCES planets (id) ON DELETE CASCADE,
    FOREIGN KEY (to_planet_id) REFERENCES planets (id) ON DELETE CASCADE
);