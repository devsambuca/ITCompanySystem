package net.devsambuca.model;

public class Skill {

    private Long id;
    private String name;

    public Skill() {
    }

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

    public void addIdSkill(long id) {this.id = id; }
    @Override
    public String toString() {
        return  name;
    }
}
