package net.devsambuca.dao;

import net.devsambuca.model.Skill;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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
        try {
            // find the file with the skill date
            File devFile = new File(FILE_PATH);
            Scanner devScanner = new Scanner(devFile);
            while (devScanner.hasNext()) {
                Skill skill = new Skill();
                String nextLine = devScanner.nextLine();
                String[] devData = nextLine.split(",");
                skill.setId((Long.parseLong(devData[0])));
                skill.setName(devData[1]);
                
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
        List<Skill> dev = getAll();
        Iterator<Skill> iDev = dev.iterator();
        while (iDev.hasNext()) {
            Skill s = iDev.next();
            if (s.getId() == skill.getId())
                iDev.remove();
        }
        dev.add(skill);
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Skill line : dev) {
                writer.write(String.valueOf(line));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        List<Skill> dev = getAll();
        Iterator<Skill> iDev = dev.iterator();
        while (iDev.hasNext()) {
            Skill s = iDev.next();
            if (s.getId() == id)
                iDev.remove();
        }
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Skill d : dev) {
                writer.write(String.valueOf(d));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Skill> getAll() {
        List<Skill> devList = new ArrayList<Skill>();
        try {
            // find the file with the skill date
            File devFile = new File(FILE_PATH);
            Scanner devScanner = new Scanner(devFile);
            while (devScanner.hasNext()) {
                Skill skill = new Skill();
                String nextLine = devScanner.nextLine();
                String[] devData = nextLine.split(",");
                skill.setId((Long.parseLong(devData[0])));
                skill.setName(devData[1]);
                devList.add(skill);
            }
            return devList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}