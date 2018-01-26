package net.devsambuca.dao;

import net.devsambuca.model.Skill;

import java.io.*;
import java.util.*;

public class DaoSkill implements IDao<Skill> {

    private static final String FILE_PATH = "src/main/resources/skills.txt";

    public void create(Skill skill) {
        Set<Skill> skills = new HashSet<Skill>();
        skills.add(skill);
        Writer writer = null;
        String str = skill.getId() + ", " + skill.getName();
        try {
            writer = new FileWriter(FILE_PATH, true);
            writer.write(str + '\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Skill read(long id) {
        try {
            // find the file with the skill date
            File skillFile = new File(FILE_PATH);
            Scanner skScanner = new Scanner(skillFile);
            while (skScanner.hasNext()) {
                Skill skill = new Skill();
                String nextLine = skScanner.nextLine();
                String[] skillData = nextLine.split(",");
                skill.setId((Long.parseLong(skillData[0])));
                skill.setName(skillData[1]);
                if (id == skill.getId()) {
                    return skill;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }

    public void update(Skill skill) {
        List<Skill> skills = getAll();
        Iterator<Skill> iDev = skills.iterator();
        while (iDev.hasNext()) {
            Skill s = iDev.next();
            if (s.getId() == skill.getId())
                iDev.remove();
        }
        skills.add(skill);
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Skill line : skills) {
                writer.write(String.valueOf(line));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        List<Skill> skill = getAll();
        Iterator<Skill> iSkill = skill.iterator();
        while (iSkill.hasNext()) {
            Skill s = iSkill.next();
            if (s.getId() == id)
                iSkill.remove();
        }
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Skill s : skill) {
                writer.write(String.valueOf(s));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();
        try {
            // find the file with the skill date
            File skillFile = new File(FILE_PATH);
            Scanner skScanner = new Scanner(skillFile);
            while (skScanner.hasNext()) {
                Skill skill = new Skill();
                String nextLine = skScanner.nextLine();
                String[] skData = nextLine.split(",");
                skill.setId((Long.parseLong(skData[0])));
                skill.setName(skData[1]);
                skills.add(skill);
            }
            return skills;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}