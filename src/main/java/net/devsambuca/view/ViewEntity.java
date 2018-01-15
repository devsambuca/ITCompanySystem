package net.devsambuca.view;

import net.devsambuca.model.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewEntity {
    boolean exit;

    public void run() {
            mainMenu();
            int choice = getInputEntity();
            performActionWithEntity(choice);
        }

    private void performActionWithEntity(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Thanks for using our application");
                break;
            case 1:
                DevViewer devViewer = new DevViewer();
                devViewer.run();
                break;
            case 2:
                SkillViewer skillViewer = new SkillViewer();
                skillViewer.run();
                break;
            case 3:
                TeamViewer teamViewer = new TeamViewer();
                teamViewer.run();
                break;
            case 4:
                delete();
                break;
            default:
                System.out.println("An unknown error has occured.");
        }
    }



    private int getInputEntity() {
        int choice = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (choice < 0 || choice > 6) {
            try {
                System.out.println("\nEnter your choice: ");
                choice = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.print("Entity not found. Please try again.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

    public int getInputOperation() {
        int choice = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (choice < 0 || choice > 5) {
            try {
                System.out.println("\nEnter your choice: ");
                choice = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.print("Entity not found. Please try again.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

    private void mainMenu() {
        System.out.println("\nPlease make a selection 0-6");
        System.out.println("1. Developer");
        System.out.println("2. Skill");
        System.out.println("3. Team");
        System.out.println("4. Project");
        System.out.println("5. Company");
        System.out.println("6. Customer");
        System.out.println("0. Exit");
    }

    public void showMenu() {
        System.out.println("\nPlease make a selection 0-4");
        System.out.println("1. create");
        System.out.println("2. read");
        System.out.println("3. update");
        System.out.println("4. delete");
        System.out.println("0. exit");
    }

}

