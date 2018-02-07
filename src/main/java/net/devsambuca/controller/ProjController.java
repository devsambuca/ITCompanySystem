package net.devsambuca.controller;

import net.devsambuca.dao.GenericDAO;
import net.devsambuca.dao.DaoProject;
import net.devsambuca.model.Project;

import java.util.List;

public class ProjController implements GenericDAO<Project> {

    private DaoProject projectDAO = new DaoProject();

    public void create(Project project) {
        this.projectDAO.create(project);
    }

    public Project read(long id) {
        return this.projectDAO.read(id);

    }

    public void update(Project project) {
        this.projectDAO.update(project);
    }

    public void delete(long id) {
        this.projectDAO.delete(id);
    }

    public List<Project> getAll() {
        return this.projectDAO.getAll();
    }
}
