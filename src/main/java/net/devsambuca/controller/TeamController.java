package net.devsambuca.controller;

import net.devsambuca.dao.GenericDAO;
import net.devsambuca.dao.DaoTeam;
import net.devsambuca.model.Team;
import java.util.List;

public class TeamController implements GenericDAO<Team> {

        private DaoTeam teamDAO = new DaoTeam();

        public void create(Team team) {
            this.teamDAO.create(team);
        }

        public Team read(long id) {
            return this.teamDAO.read(id);

        }

        public void update(Team team) {
            this.teamDAO.update(team);
        }

        public void delete(long id) {
            this.teamDAO.delete(id);
        }

    public List<Team> getAll() {
        return this.teamDAO.getAll();
    }
}
