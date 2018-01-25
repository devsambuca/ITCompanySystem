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

    public Developer read(long id) {
        try {
            // find the file with the developer date
            String pattern = "(^\\d)[\\,](\\w+)[\\,](\\w+)[\\,](\\w+[\\s]\\w+)[\\,][\\{]([0-9,]+)}[\\,](\\w+\\.\\w)";
            ArrayList<Developer> list = new ArrayList<>();
            Developer developer = new Developer();
            Set<Skill> skills = new HashSet<>();
            Skill skill = new Skill();
            File devFile = new File(FILE_PATH);
            Scanner devScanner = new Scanner(devFile);
            while (devScanner.hasNext()) {
                String nextLine = devScanner.nextLine();
                Pattern pt1 = Pattern.compile(pattern);
                Matcher m1 = pt1.matcher(nextLine);
                if (m1.find())
                    developer.setId((Long.parseLong(m1.group(1))));
                developer.setFirstName(m1.group(2));
                developer.setLastName(m1.group(3));
                developer.setSpecialty(m1.group(4));

                String[] ar = m1.group(5).split(",");

                for (int i = 0; i < ar.length; i++)
                    if (Long.valueOf(ar[i]) == skill.getId()) {

                        skill.setId(Long.parseLong(ar[i]));
                        skill.setName(skill.getName());
                        skills.add(skill);
                        developer.getSkills();
                    }
                developer.setSalary(BigDecimal.valueOf(Double.parseDouble(m1.group(6))));
                list.add(developer);
                if (id == developer.getId()) {
                    return developer;
                }
            }

//            Pattern pt = Pattern.compile("[\\{]([0-9,]+)}");
//            Matcher m = pt.matcher(nextLine);
//            Skill skill = new Skill();
//            Set<Skill>skills = new HashSet<>();
//            while (m.find()) {
//                String[] ar = m.group(1).split(",");
//
//                for(int i = 0; i < ar.length; i++)
//                    if(Long.valueOf(ar[i]) == skill.getId()){
//
//                        skill.setId(Long.parseLong(ar[i]));
//                        skill.setName(skill.getName());
//                        skills.add(skill);
//                        return d;

        } catch (
                FileNotFoundException e)

        {
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

