package com.example.database.repositories;

/**
 * An interface that defines basic CRUD (Create, Read, Update, Delete) operations for entities.
 * The generic type T represents the type of entities being managed.
 *
 * @param <T> The type of entity for which CRUD operations are defined.
 */
public interface Crud<T> {
    /**
     * Persists an entity in the database.
     *
     * @param entity The entity to be persisted.
     */
    void persist(T entity);

    /**
     * Retrieves an entity from the database by its ID.
     *
     * @param id The ID of the entity to be retrieved.
     * @return The retrieved entity, or null if not found.
     */
    T getById(Object id);

    /**
     * Merges changes from a detached entity into the database.
     *
     * @param entity The entity to be merged.
     */
    void merge(T entity);

    /**
     * Removes an entity from the database.
     *
     * @param entity The entity to be removed.
     */
    void remove(T entity);
}
