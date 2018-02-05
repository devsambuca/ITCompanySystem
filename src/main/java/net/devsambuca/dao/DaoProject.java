package net.devsambuca.dao;

import net.devsambuca.model.Project;
import net.devsambuca.model.Team;
import java.io.*;
import java.util.*;

public class DaoProject implements DaoImp<Project> {
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
            File projectFile = new File(FILE_PATH);
            Scanner projectScanner = new Scanner(projectFile);
            while (projectScanner.hasNext()) {
                Project project = new Project();
                String nextLine = projectScanner.nextLine();
                String[] projectData = nextLine.split(",");
                for (int i = 0; i < projectData.length; i++) {
                    if (projectData[i].isEmpty()) continue;
                    switch (i) {
                        case 0:
                            project.setId(Long.parseLong(projectData[i]));
                            continue;
                    }
                    if (i == projectData.length - 1)
                        project.setName(projectData[i]);
                    else {
                        Set<Team> teams = project.getTeams();
                        if (teams == null) teams = new HashSet<>();
                        DaoTeam daoTeam = new DaoTeam();
                        teams.add(daoTeam.read(Long.parseLong(projectData[i])));
                        project.setTeams(teams);
                    }
                }
                if (id == project.getId()) {
                    return project;
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
        List<Project> projectList = new ArrayList<>();
        try {
            File projectFile = new File(FILE_PATH);
            Scanner projectScanner = new Scanner(projectFile);
            while (projectScanner.hasNext()) {
                Project project = new Project();
                String nextLine = projectScanner.nextLine();
                String[] projectData = nextLine.split(",");
                for (int i = 0; i < projectData.length; i++) {
                    if (projectData[i].isEmpty()) continue;
                    switch (i) {
                        case 0:
                            project.setId(Long.parseLong(projectData[i]));
                            continue;
                    }
                    if (i == projectData.length - 1)
                        project.setName((projectData[i]));
                }
                projectList.add(project);
            }
            return projectList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

