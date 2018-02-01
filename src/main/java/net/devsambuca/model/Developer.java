package net.devsambuca.model;

import java.math.BigDecimal;
import java.util.Set;


public class Developer {

    private Long id;
    private String firstName;
    private String lastName;
    private String specialty;
    private Set<Skill> skills;
    private BigDecimal salary;
    private String skill;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSkill() {
        return skill;
    }


    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }


    @Override
    public String toString() {
        return id +
                ", " + firstName +
                ", " + lastName +
                ", " + specialty +
                ", " + skills +
                ", " + salary;

    }
}
