package net.devsambuca.model;

        import java.util.Set;

public class Project {

    private Long id;
    private String name;
    private Set<Team> teams;

    public Project() {

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
        return id + ", " + name+ ", " + teams;
    }
}
