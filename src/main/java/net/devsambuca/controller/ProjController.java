package net.devsambuca.controller;

import net.devsambuca.dao.DaoImp;
import net.devsambuca.dao.DaoProject;
import net.devsambuca.model.Project;

import java.util.List;

public class ProjController implements DaoImp<Project> {

    private DaoProject projectDAO = new DaoProject();

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

    public List<Project> getAll() {
        return this.projectDAO.getAll();
    }
}
