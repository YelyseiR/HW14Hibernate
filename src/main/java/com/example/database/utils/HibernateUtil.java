package com.example.database.utils;

import com.example.database.entities.Client;
import com.example.database.entities.Planet;
import com.example.database.entities.Ticket;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Getter
public class HibernateUtil {

    private static final HibernateUtil INSTANCE;

    private final SessionFactory sessionFactory;

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    static {
        INSTANCE = new HibernateUtil();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
