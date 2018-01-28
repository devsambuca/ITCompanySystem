package net.devsambuca.model;

import java.util.Set;

public class Team {
    private Long id;
    private String name;
    private String developer;

    private Set<Developer> developers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {
        return id +
                ", " + name + ", " + developers;
    }
}
