package net.devsambuca.controller;

import net.devsambuca.dao.IDao;
import net.devsambuca.dao.IDaoDeveloper;
import net.devsambuca.model.Developer;
import java.io.FileNotFoundException;
import java.util.List;

public class DevController implements IDao<Developer> {

    private IDaoDeveloper developerDAO = new IDaoDeveloper();

    public void create(Developer developer) {
        this.developerDAO.create(developer);
    }

    public Developer read(long id) throws FileNotFoundException {
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
