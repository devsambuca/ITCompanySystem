package net.devsambuca.dao;

import net.devsambuca.model.Developer;
import net.devsambuca.model.Skill;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDaoDeveloper implements IDao<Developer> {

    public static final String FILE_PATH = "src/main/resources/developers.txt";
    public static final String FILE_SKILL_PATH = "src/main/resources/skill.txt";

    public void create(Developer developer) {
        Set<Developer> developers = new HashSet<Developer>();
        developers.add(developer);
        Writer writer = null;
        String str = developer.getId() + "," + developer.getFirstName() + "," + developer.getLastName() + "," + developer.getSpecialty() + "," + developer.getSalary();

        try {
            writer = new FileWriter(FILE_PATH, true);
            writer.write(str + '\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Developer read(long id) throws FileNotFoundException {

        File devFile = new File(FILE_PATH);
        Scanner devScanner = new Scanner(devFile);
        List<Developer> developers = new ArrayList<>();

        while (devScanner.hasNext()) {
            Developer developer = new Developer();
            String nextLine = devScanner.nextLine();
            String[] devData = nextLine.split(",|}|\\{");
            for (int i = 0; i < devData.length; i++) {
                if (devData[i].isEmpty()) continue;
                switch (i) {
                    case 0:
                        developer.setId((Long.parseLong(devData[i])));
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
                if (i == devData.length - 1) developer.setSalary(BigDecimal.valueOf(Double.parseDouble(devData[i])));
                else {
//оптимальнее в классе Skill добавить метод типа addSkills(), в котором выполнится создание коллекции, если это необходимо, либо обычное добавление элемента. Это избавит от некоторой части создаваемых HashSet
                    Set<Skill> skills = developer.getSkills();
                    if (skills == null) skills = new HashSet<>();
                    // не знаю, как у вас реализовано создание класса Skill, посему кавычки с названием скила пустые
                    skills.add(new Skill(Long.valueOf(devData[i]), devData[i]));
                    developer.setSkills(skills);
                }
            }
            developers.add(developer);
        }
        return (Developer) developers;
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
            e.printStackTrace();
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
        // Writer writer;
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
                devList.add(developer);
            }
            return devList;
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
        return null;
    }
}

