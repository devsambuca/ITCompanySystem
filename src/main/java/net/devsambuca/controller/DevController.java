package net.devsambuca.controller;

import net.devsambuca.dao.IDao;
import net.devsambuca.dao.IDaoDeveloper;
import net.devsambuca.dao.IDaoSkill;
import net.devsambuca.model.Developer;
import net.devsambuca.model.Skill;

import java.util.List;
import java.util.Set;

public class DevController implements IDao<Developer> {

    private IDaoDeveloper developerDAO = new IDaoDeveloper();

    public void create(Developer developer) {
        this.developerDAO.create(developer);
    }

    public Developer read(long id) {
          return this.developerDAO.read(id);
    }

    public void update(Developer developer) {
        this.developerDAO.update(developer);
    }

    public void delete(long id) {
        this.developerDAO.delete(id);
    }

   }

