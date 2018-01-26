package net.devsambuca.controller;

import net.devsambuca.dao.DaoSkill;
import net.devsambuca.dao.IDao;
import net.devsambuca.model.Skill;
import java.util.List;

public class SkillController implements IDao<Skill> {

    private DaoSkill daoSkill = new DaoSkill();

    public void create(Skill skill) {
        this.daoSkill.create(skill);
    }

    public Skill read(long id) {
       return this.daoSkill.read(id);
    }

    public void update(Skill skill) {
        this.daoSkill.update(skill);
    }

    public void delete(long id) {
        this.daoSkill.delete(id);
    }

    public List<Skill> getAll() {
        return this.daoSkill.getAll();
    }
}
