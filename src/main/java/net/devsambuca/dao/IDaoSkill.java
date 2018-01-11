package net.devsambuca.dao;

import net.devsambuca.model.Skill;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class IDaoSkill implements IDao<Skill> {
    public static final String FILE_PATH = "skills.txt";
    public void create(Skill skill) {
        Writer writer = null;
        String str = skill.getId() + "," + skill.getName();
        try {
            writer = new FileWriter(FILE_PATH, true);
            writer.write(str + '\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Skill read(long id) {
        return null;
    }

    public void update(Skill skill) {

    }

    public void delete(long id) {

    }
}
