package net.devsambuca.model;

import java.util.Set;

public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private Set projects;
    private String project;

    public Customer() {
    }

//    public Customer(String [] line) {
//        this.id = Long.parseLong(line[0]);
//        this.firstName = line[1];
//        this.lastName = line[2];
//        this.address = line[line.length - 1];
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Set getProjects() {
        return projects;
    }

    public void setProjects(Set projects) {
        this.projects = projects;
    }

//    @Override
//    public String toString() {
//        return id +
//                ", " + firstName +
//                ", " + lastName +
//                ", " + address +
//                ", " + projects;
//    }
}
