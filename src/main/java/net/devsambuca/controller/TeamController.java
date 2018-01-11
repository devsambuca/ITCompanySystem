package net.devsambuca.controller;

import net.devsambuca.dao.IDao;
import net.devsambuca.dao.IDaoTeam;
import net.devsambuca.model.Team;

public class TeamController implements IDao<Team> {

        private IDaoTeam teamDAO = new IDaoTeam();

        public void create(Team team) {
            this.teamDAO.create(team);
        }

        public Team read(long id) {
            this.teamDAO.read(id);
            return null;
        }

        public void update(Team team) {
            this.teamDAO.update(team);
        }

        public void delete(long id) {
            this.teamDAO.delete(id);
        }
}
