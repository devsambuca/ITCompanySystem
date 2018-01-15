package net.devsambuca.view;

import net.devsambuca.controller.TeamController;
import net.devsambuca.model.Team;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
}


