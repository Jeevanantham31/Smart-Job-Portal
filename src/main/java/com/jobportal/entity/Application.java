package com.jobportal.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private String status;

    public Application() {}

    public Application(User user, Job job, String status) {
        this.user = user;
        this.job = job;
        this.status = status;
    }

    public int getId() { return id; }
    public User getUser() { return user; }
    public Job getJob() { return job; }
    public String getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setJob(Job job) { this.job = job; }
    public void setStatus(String status) { this.status = status; }
}
