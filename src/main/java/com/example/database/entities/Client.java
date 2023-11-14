package com.example.database.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Client entity class represents a client and is used for database mapping and CRUD operations.
 */
@Entity
@Table(name = "clients")
@Data
public class Client {

    private static final Logger LOG = LogManager.getLogger(Client.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", length = 201, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 201, nullable = false)
    private String lastName;

    /**
     * A callback method that logs when a new client is persisted to the database.
     */
    @PostPersist
    public void logNewClientPersisted() {
        LOG.info("Persisted client: '{} {}'", firstName, lastName);
    }

    /**
     * A callback method that logs when a client is loaded from the database.
     */
    @PostLoad
    public void logUserLoad() {
        LOG.info("Loaded client: '{} {}'", firstName, lastName);
    }

    /**
     * A callback method that logs when a client is updated in the database.
     */
    @PostUpdate
    public void logUserUpdated() {
        LOG.info("Updated client: '{} {}'", firstName, lastName);
    }

    /**
     * A callback method that logs when a client is removed from the database.
     */
    @PostRemove
    public void logClientRemoval() {
        LOG.info("Deleted client: '{} {}'", firstName, lastName);
    }
}
