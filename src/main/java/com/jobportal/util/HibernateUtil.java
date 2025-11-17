package com.jobportal.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.jobportal.entity.User;
import com.jobportal.entity.Company;
import com.jobportal.entity.Job;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Company.class)
                    .addAnnotatedClass(Job.class) // ✅ register Job entity
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
