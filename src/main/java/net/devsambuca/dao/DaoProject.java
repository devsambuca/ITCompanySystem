package net.devsambuca.dao;

import net.devsambuca.model.Project;

import java.io.*;
import java.util.*;

public class DaoProject implements IDao<Project> {
    public static final String FILE_PATH = "src/main/resources/project.txt";

    public void create(Project project) {
        List<Project> projects = new ArrayList<>();
        projects.add(project);
        Writer writer = null;
        String str = project.getId() + "," + project.getName() + "," + project.getTeam();
        try {
            writer = new FileWriter(FILE_PATH, true);
            writer.write(str + '\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Project read(long id) {
        try {
            // find the file with the team date
            File listProjectFile = new File(FILE_PATH);
            Scanner listProjectScanner = new Scanner(listProjectFile);
            while (listProjectScanner.hasNext()) {
                Project team = new Project();
                String nextLine = listProjectScanner.nextLine();
                String[] listProjectData = nextLine.split(",");
                team.setId((Long.parseLong(listProjectData[0])));
                team.setName(listProjectData[1]);

                if (id == team.getId()) {
                    return team;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }

    public void update(Project team) {
        List<Project> listProject = getAll();
        Iterator<Project> iDev = listProject.iterator();
        while (iDev.hasNext()) {
            Project s = iDev.next();
            if (s.getId() == team.getId())
                iDev.remove();
        }
        listProject.add(team);
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Project line : listProject) {
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
        List<Project> listProject = getAll();
        Iterator<Project> iDev = listProject.iterator();
        while (iDev.hasNext()) {
            Project s = iDev.next();
            if (s.getId() == id)
                iDev.remove();
        }
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Project d : listProject) {
                writer.write(String.valueOf(d));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Project> getAll() {
        List<Project> listProjectList = new ArrayList<>();
        try {
            // find the file with the team date
            File listProjectFile = new File(FILE_PATH);
            Scanner listProjectScanner = new Scanner(listProjectFile);
            while (listProjectScanner.hasNext()) {
                Project team = new Project();
                String nextLine = listProjectScanner.nextLine();
                String[] listProjectData = nextLine.split(",");
                team.setId((Long.parseLong(listProjectData[0])));
                team.setName(listProjectData[1]);
                listProjectList.add(team);
            }
            return listProjectList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

