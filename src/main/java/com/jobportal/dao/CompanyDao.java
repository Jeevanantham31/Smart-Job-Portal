package com.jobportal.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.jobportal.entity.Company;
import com.jobportal.util.HibernateUtil;

public class CompanyDao {

    public void registerCompany(Company company) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(company);
            tx.commit();
            System.out.println();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Company login(String email, String password) {
        Transaction transaction = null;
        Company company = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // ✅ Correct field names: email and password
            Query<Company> query = session.createQuery(
                "FROM Company WHERE email = :email AND password = :password", Company.class);
            query.setParameter("email", email);
            query.setParameter("password", password);

            company = query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

        return company;
    }
    }

