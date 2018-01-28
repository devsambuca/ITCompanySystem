package net.devsambuca.view;

import net.devsambuca.controller.TeamController;
import net.devsambuca.model.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class TeamViewer {
    boolean exit;

    TeamController teamController = new TeamController();
    ViewEntity viewEntity = new ViewEntity();

    public void run() {
        while (!exit) {
            viewEntity.showMenu();
            int choice = viewEntity.getInputOperation();
            performAction(choice);
        }
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
                showAllTeam();
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
                System.out.println("\nInput ID team: ");
                teamController.read(Long.parseLong(reader.readLine()));
                System.out.println(reader);
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
            Team team = new Team();
            team.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input name: ");
            team.setName(reader.readLine());
            System.out.println("Input developer: ");
            team.setDeveloper(reader.readLine().toString());
            teamController.create(team);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            Team team = new Team();
            team.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input name: ");
            team.setName(reader.readLine());
            System.out.println("Input developer: ");
            team.setDeveloper(reader.readLine().toString());
            teamController.update(team);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID team: ");
            teamController.delete(Long.parseLong(reader.readLine()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllTeam() {
        List<Team> teams = teamController.getAll();
        for (Team team : teams)
            System.out.println(team);
    }

    private void returnMainMenu() {
        try {
            viewEntity.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


