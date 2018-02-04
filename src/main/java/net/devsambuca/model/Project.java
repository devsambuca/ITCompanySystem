package net.devsambuca.model;

        import java.util.Set;

public class Project {

    private Long id;
    private String name;
    private Set<Team> teams;
    private String team;

    public Project() {

    }

    public Project(Long id) {
        this.id = id;
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

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
}
