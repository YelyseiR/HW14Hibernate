package com.example.database.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Planet entity class represents a planet and is used for database mapping and CRUD operations.
 */
@Entity
@Table(name = "planets")
@Data
public class Planet {

    private static final Logger LOG = LogManager.getLogger(Planet.class);

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", length = 501, nullable = false)
    private String name;

    /**
     * A callback method that logs when a new planet is persisted to the database.
     */
    @PostPersist
    public void logNewClientPersisted() {
        LOG.info("Persisted planet: '{}'", name);
    }

    /**
     * A callback method that logs when a planet is loaded from the database.
     */
    @PostLoad
    public void logUserLoad() {
        LOG.info("Loaded planet: '{}'", name);
    }

    /**
     * A callback method that logs when a planet is updated in the database.
     */
    @PostUpdate
    public void logUserUpdated() {
        LOG.info("Updated planet: '{}'", name);
    }

    /**
     * A callback method that logs when a planet is removed from the database.
     */
    @PostRemove
    public void logClientRemoval() {
        LOG.info("Deleted planet: '{}'", name);
    }
}
