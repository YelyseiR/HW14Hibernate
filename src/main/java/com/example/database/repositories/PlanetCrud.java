package com.example.database.repositories;

import com.example.database.entities.Planet;
import com.example.database.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * A class that provides CRUD operations for the Planet entity.
 */
public class PlanetCrud implements Crud<Planet> {

    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    /**
     * Persists a Planet object to the database.
     *
     * @param planet The Planet object to be persisted.
     */
    @Override
    public void persist(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(planet);
            tx.commit();
        }
    }

    /**
     * Retrieves a Planet object from the database by its ID.
     *
     * @param id The ID of the Planet object to be retrieved.
     * @return The retrieved Planet object, or null if not found.
     */
    @Override
    public Planet getById(Object id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    /**
     * Merges changes from a detached Planet object into the database.
     *
     * @param planet The Planet object to be merged.
     */
    @Override
    public void merge(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(planet);
            tx.commit();
        }
    }

    /**
     * Removes a Planet object from the database.
     *
     * @param planet The Planet object to be removed.
     */
    @Override
    public void remove(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(planet);
            tx.commit();
        }
    }
}
