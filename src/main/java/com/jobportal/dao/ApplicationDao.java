package com.jobportal.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.jobportal.entity.Application;
import com.jobportal.entity.User;
import org.hibernate.query.Query;

import com.jobportal.util.HibernateUtil;

public class ApplicationDao {

    // ✅ Apply for a job
    public void applyJob(Application application) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(application);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // ✅ Fetch all applications by a given user
    public List<Application> getApplicationsByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Application> query = session.createQuery(
                "FROM Application WHERE user = :user", Application.class);
            query.setParameter("user", user);
            return query.list();
        }
    }
}
