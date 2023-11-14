package com.example.database.repositories;

import com.example.database.entities.Client;
import com.example.database.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * A class that provides CRUD operations for the Client entity.
 */
public class ClientCrud implements Crud<Client> {

    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    /**
     * Persists a Client object to the database.
     *
     * @param client The Client object to be persisted.
     */
    @Override
    public void persist(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        }
    }

    /**
     * Retrieves a Client object from the database by its ID.
     *
     * @param id The ID of the Client object to be retrieved.
     * @return The retrieved Client object, or null if not found.
     */
    @Override
    public Client getById(Object id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    /**
     * Merges changes from a detached Client object into the database.
     *
     * @param client The Client object to be merged.
     */
    @Override
    public void merge(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(client);
            tx.commit();
        }
    }

    /**
     * Removes a Client object from the database.
     *
     * @param client The Client object to be removed.
     */
    @Override
    public void remove(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(client);
            tx.commit();
        }
    }
}
