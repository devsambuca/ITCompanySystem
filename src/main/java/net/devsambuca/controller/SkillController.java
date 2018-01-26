package net.devsambuca.controller;

import net.devsambuca.dao.IDao;
import net.devsambuca.dao.IDaoSkill;
import net.devsambuca.model.Skill;

import java.util.List;
import java.util.Set;


public class SkillController implements IDao<Skill> {

    private IDaoSkill iDaoSkill = new IDaoSkill();

    public void create(Skill skill) {
        this.iDaoSkill.create(skill);
    }

    public Skill read(long id) {
       return this.iDaoSkill.read(id);
    }

    public void update(Skill skill) {
        this.iDaoSkill.update(skill);
    }

    public void delete(long id) {
        this.iDaoSkill.delete(id);
    }

    public List<Skill> skills() {
        return this.iDaoSkill.allSkills();
    }
}
