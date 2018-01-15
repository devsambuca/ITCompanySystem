package net.devsambuca.controller;

import net.devsambuca.dao.IDao;
import net.devsambuca.dao.IDaoSkill;
import net.devsambuca.model.Skill;
import java.util.List;

public class SkillController implements IDao<Skill> {

    private IDaoSkill iDaoSkill = new IDaoSkill();

    public void create(Skill skill) {
        this.iDaoSkill.create(skill);
    }

    public Skill read(long id) {
        this.iDaoSkill.read(id);
        return null;
    }

    public void update(Skill skill) {
        this.iDaoSkill.update(skill);
    }

    public void delete(long id) {
        this.iDaoSkill.delete(id);
    }

    public List<Skill> getAll() {
        return this.iDaoSkill.getAll();
    }
}
