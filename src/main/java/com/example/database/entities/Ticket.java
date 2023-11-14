package com.example.database.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;

/**
 * The Ticket entity class represents a ticket and is used for database mapping and CRUD operations.
 */
@Entity
@Table(name = "tickets")
@Data
public class Ticket {

    private static final Logger LOG = LogManager.getLogger(Ticket.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanet;

    /**
     * A callback method that logs when a new ticket is persisted to the database.
     */
    @PostPersist
    public void logNewClientPersisted() {
        LOG.info("Persisted ticket: '{}'", id);
    }

    /**
     * A callback method that logs when a ticket is loaded from the database.
     */
    @PostLoad
    public void logUserLoad() {
        LOG.info("Loaded ticket: '{}'", id);
    }

    /**
     * A callback method that logs when a ticket is updated in the database.
     */
    @PostUpdate
    public void logUserUpdated() {
        LOG.info("Updated ticket: '{}'", id);
    }

    /**
     * A callback method that logs when a ticket is removed from the database.
     */
    @PostRemove
    public void logClientRemoval() {
        LOG.info("Deleted ticket: '{}'", id);
    }
}
