package com.jobportal.dao;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.jobportal.entity.Company;
import com.jobportal.entity.Job;
import com.jobportal.util.HibernateUtil;
import org.hibernate.query.Query;
import java.util.*;

public class JobDao {

    // ✅ Post a new job
    public void postJob(Job job) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(job);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // ✅ Display all jobs with company info
    public boolean displayAllJobs() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Job> jobs = session.createQuery("FROM Job", Job.class).list();

            if (jobs.isEmpty()) {
                System.out.println("No jobs available.");
                return false;
            }

            System.out.println("\nAvailable Jobs:");
            System.out.println("----------------------------------");

            for (Job job : jobs) {
                System.out.println(
                    "ID: " + job.getId() +
                    " | Title: " + job.getTitle() +
                    " | Company: " + job.getCompany().getName() +
                    " | Location: " + job.getLocation()
                );
            }

            return true;
        }
    }


    // ✅ Get job by ID
    public Job getJobById(int jobId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Job.class, jobId);
        }
    }

    // ✅ Get all jobs for a company
    public List<Job> getJobsByCompany(Company company) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Job> query = session.createQuery("FROM Job WHERE company = :company", Job.class);
            query.setParameter("company", company);
            return query.list();
        }
    }
}
