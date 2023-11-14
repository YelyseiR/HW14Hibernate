package com.example.database.repositories;

import com.example.database.entities.Ticket;
import com.example.database.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * A class that provides CRUD operations for the Ticket entity.
 */
public class TicketCrud implements Crud<Ticket> {

    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    /**
     * Persists a Ticket object to the database.
     *
     * @param ticket The Ticket object to be persisted.
     */
    @Override
    public void persist(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(ticket);
            tx.commit();
        }
    }

    /**
     * Retrieves a Ticket object from the database by its ID.
     *
     * @param id The ID of the Ticket object to be retrieved.
     * @return The retrieved Ticket object, or null if not found.
     */
    @Override
    public Ticket getById(Object id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    /**
     * Merges changes from a detached Ticket object into the database.
     *
     * @param ticket The Ticket object to be merged.
     */
    @Override
    public void merge(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(ticket);
            tx.commit();
        }
    }

    /**
     * Removes a Ticket object from the database.
     *
     * @param ticket The Ticket object to be removed.
     */
    @Override
    public void remove(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(ticket);
            tx.commit();
        }
    }
}
