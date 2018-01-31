package net.devsambuca.dao;

import net.devsambuca.model.Developer;
import net.devsambuca.model.Skill;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class DaoDeveloper implements DaoImp<Developer> {

    public static final String FILE_PATH = "src/main/resources/developers.txt";

    public void create(Developer developer) {
        List<Developer> developers = new ArrayList<>();
        developers.add(developer);
        Writer writer = null;
        String str = developer.getId() + "," + developer.getFirstName() + "," + developer.getLastName() + "," + developer.getSpecialty() + "," + developer.getSkill() + "," + developer.getSalary();
        try {
            writer = new FileWriter(FILE_PATH, true);
            writer.write(str + '\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Developer read(long id) {
        try {
            File devFile = new File(FILE_PATH);
            Scanner devScanner = new Scanner(devFile);////////ArrayList<Developer> developers = new ArrayList<>();
            while (devScanner.hasNext()) {
                Developer developer = new Developer();
                String nextLine = devScanner.nextLine();
                String[] devData = nextLine.split(",");
                for (int i = 0; i < devData.length; i++) {
                    if (devData[i].isEmpty()) continue;
                    switch (i) {
                        case 0:
                            developer.setId(Long.parseLong(devData[i]));
                            continue;
                        case 1:
                            developer.setFirstName(devData[i]);
                            continue;
                        case 2:
                            developer.setLastName(devData[i]);
                            continue;
                        case 3:
                            developer.setSpecialty(devData[i]);
                            continue;
                    }
                    if (i == devData.length - 1)
                        developer.setSalary(BigDecimal.valueOf(Double.parseDouble(devData[i])));
                    else {
                        Set<Skill> skills = developer.getSkills();
                        if (skills == null) skills = new HashSet<>();
                        DaoSkill daoSkill = new DaoSkill();
                        skills.add(daoSkill.read((Long.valueOf(devData[i]))));
                        developer.setSkills(skills);
                    }
                }
                if (id == developer.getId())
                    return developer;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }
        return null;
    }

    public void update(Developer developer) {
        List<Developer> dev = getAll();
        Iterator<Developer> iDev = dev.iterator();
        while (iDev.hasNext()) {
            Developer s = iDev.next();
            if (s.getId() == developer.getId())
                iDev.remove();
        }
        dev.add(developer);
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Developer line : dev) {
                writer.write(String.valueOf(line));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        List<Developer> dev = getAll();
        Iterator<Developer> iDev = dev.iterator();
        while (iDev.hasNext()) {
            Developer s = iDev.next();
            if (s.getId() == id)
                iDev.remove();
        }
        try (Writer writer = new FileWriter(FILE_PATH)) {
            for (Developer d : dev) {
                writer.write(String.valueOf(d));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Developer> getAll() {
        try {
            File devFile = new File(FILE_PATH);
            Scanner devScanner = new Scanner(devFile);
            List<Developer> devList = new ArrayList<>();
            // find the file with the developer date
            while (devScanner.hasNext()) {
                Developer developer = new Developer();
                String nextLine = devScanner.nextLine();
                String[] devData = nextLine.split(",");
                for (int i = 0; i < devData.length; i++) {
                    if (devData[i].isEmpty()) continue;
                    switch (i) {
                        case 0:
                            developer.setId(Long.parseLong(devData[i]));
                            continue;
                        case 1:
                            developer.setFirstName(devData[i]);
                            continue;
                        case 2:
                            developer.setLastName(devData[i]);
                            continue;
                        case 3:
                            developer.setSpecialty(devData[i]);
                            continue;
                    }
                    if (i == devData.length - 1)
                        developer.setSalary(BigDecimal.valueOf(Double.parseDouble(devData[i])));
                    else {
                        Set<Skill> skills = developer.getSkills();
                        if (skills == null) skills = new HashSet<>();
                        DaoSkill daoSkill = new DaoSkill();
                        skills.add(daoSkill.read((Long.valueOf(devData[i]))));
                        developer.setSkills(skills);
                    }
                }
                devList.add(developer);
            }
            return devList;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }
}



