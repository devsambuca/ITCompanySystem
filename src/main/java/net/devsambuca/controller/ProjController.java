package net.devsambuca.controller;

import net.devsambuca.dao.IDao;
import net.devsambuca.dao.IDaoProject;
import net.devsambuca.model.Project;

/**
 * Created by smb on 12.01.2018.
 */
public class ProjController implements IDao<Project> {

        private IDaoProject projectDAO = new IDaoProject();

        public void create(Project project) {
            this.projectDAO.create(project);
        }

        public Project read(long id) {
            this.projectDAO.read(id);
            return null;
        }

        public void update(Project project) {
            this.projectDAO.update(project);
        }

        public void delete(long id) {
            this.projectDAO.delete(id);
        }
}
