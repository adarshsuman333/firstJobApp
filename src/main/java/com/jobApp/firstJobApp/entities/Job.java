package com.jobApp.firstJobApp.entities;

import jakarta.persistence.*;

@Entity
//@Table(name="first_job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private Integer version; // This is needed for optimistic locking
//    The @Version annotation ensures that Hibernate checks the version before updating the record, preventing concurrent modifications.

    private String title;
    private String description;
    private int minSalary;
    private int maxSalary;
    private String location;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job() {

    }

    public Job(String description, long id, String location, int maxSalary, int minSalary, String title) {
        this.description = description;
        this.id = id;
        this.location = location;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
