package net.devsambuca.model;

public class Skill {

    private Long id;
    private String name;

    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Skill(){}

    public Skill(Skill read) {
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

    @Override
    public String toString() {
        return name;
    }
}
