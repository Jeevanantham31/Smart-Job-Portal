package com.jobportal.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.jobportal.entity.User;
import com.jobportal.util.HibernateUtil;

public class UserDao {

    // Register new user
    public void registerUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            System.out.println();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // ✅ Login method to verify user
    public User login(String email, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM User WHERE email = :email AND password = :password";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            User user = query.uniqueResult();

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
