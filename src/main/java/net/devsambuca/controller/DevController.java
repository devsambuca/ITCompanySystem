package net.devsambuca.controller;

import net.devsambuca.dao.GenericDAO;
import net.devsambuca.dao.DaoDeveloper;
import net.devsambuca.model.Developer;

import java.util.List;

public class DevController implements GenericDAO<Developer> {

    private DaoDeveloper developerDAO = new DaoDeveloper();

    public void create(Developer developer) {
        this.developerDAO.create(developer);
    }

    public Developer read(long id){
        return this.developerDAO.read(id);
    }

    public void update(Developer developer) {
        this.developerDAO.update(developer);
    }

    public void delete(long id) {
        this.developerDAO.delete(id);
    }

    public List<Developer> getAll() {
        return this.developerDAO.getAll();
    }
}
