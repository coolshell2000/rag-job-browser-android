package com.example.ragjobbrowser;

import java.io.Serializable;

public class Job implements Serializable {
    private int id;
    private String title;
    private String company;
    private String location;
    private String description;
    private String url;
    private String salary;
    private String posted_date;

    // 构造函数
    public Job(int id, String title, String company, String location, String description, String url, String salary, String posted_date) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
        this.url = url;
        this.salary = salary;
        this.posted_date = posted_date;
    }

    // Getter和Setter方法
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getSalary() { return salary; }
    public void setSalary(String salary) { this.salary = salary; }

    public String getPostedDate() { return posted_date; }
    public void setPostedDate(String posted_date) { this.posted_date = posted_date; }
    
    @Override
    public String toString() {
        return title + " - " + company;
    }
}
