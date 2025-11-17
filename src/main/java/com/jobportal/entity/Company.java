package com.jobportal.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;
    private String location; // added location field

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Job> jobs;

    public Company() {}

    // Existing constructors (if any) kept...
    public Company(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // ✅ New 4-argument constructor required by MainApp
    public Company(String name, String email, String password, String location) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.location = location;
    }

    // Getters & setters
    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Job> getJobs() { return jobs; }
    public void setJobs(List<Job> jobs) { this.jobs = jobs; }
}
