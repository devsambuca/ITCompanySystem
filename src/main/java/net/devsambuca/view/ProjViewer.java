package net.devsambuca.view;

import net.devsambuca.controller.ProjController;
import net.devsambuca.model.Project;
import net.devsambuca.model.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

public class ProjViewer {
    boolean exit;
    ProjController projController = new ProjController();
    ViewEntity viewEntity = new ViewEntity();

    public void run() {
        while (!exit) {
            viewEntity.showMenu();
            int choice = viewEntity.getInputOperation();
            performAction(choice);
        }
    }

    private void pullOutOf(Project project){
        long projectId;
        String projectName;
        projectId = project.getId();
        projectName = project.getName();
        System.out.println(projectId + ", " + projectName);
    }

    private void performAction(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Thanks for using our application");
                break;
            case 1:
                create();
                break;
            case 2:
                read();
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
                break;
            case 5:
                showAllProjects();
                break;
            case 6:
                returnMainMenu();
                break;

            default:
                System.out.println("An unknown error has occured.");
        }
    }

    private void read() {
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("\nInput ID: ");
                showDetailsOfTheProject(projController.read(Long.parseLong(reader.readLine())));

            } catch (NumberFormatException e) {
                System.out.print("Invalid selection. Please try again.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    }

    private void create() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            Project project = new Project();
            project.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input name: ");
            project.setName(reader.readLine());
            System.out.println("Input team: ");
            project.setTeam(reader.readLine().toString());
            projController.create(project);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            Project project = new Project();
            project.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input name: ");
            project.setName(reader.readLine());
            System.out.println("Input team: ");
            project.setTeam(reader.readLine().toString());
            projController.update(project);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            projController.delete(Long.parseLong(reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllProjects(){
        List<Project> projects = projController.getAll();
        for(Project project : projects)
            pullOutOf(project);
    }

    private void showDetailsOfTheProject(Project project) {
        String projectName;
        Set<Team> teams;
        projectName = project.getName();
        teams = project.getTeams();
        System.out.println("<----- Information about the project ----->" + '\n');
        System.out.println("Project name: " + projectName + '\n' +
                "Teams: " + teams);
    }

    private void returnMainMenu() {
        try {
            viewEntity.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

