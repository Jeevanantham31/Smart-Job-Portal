package com.jobportal.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String location;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Job() {} // default constructor (needed by Hibernate)

    // ✅ Add this constructor to fix "undefined constructor" error
    public Job(String title, String description, String location, Company company) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.company = company;
    }

    // Optional constructor if salary is also included
    public Job(String title, String description, double salary, String location, Company company) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.location = location;
        this.company = company;
    }

    // --- Getters and Setters ---
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public double getSalary() {
        return salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
