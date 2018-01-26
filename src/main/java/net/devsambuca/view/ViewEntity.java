package net.devsambuca.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewEntity {
    boolean exit;

    public void run() throws IOException {
        printHeader();
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
                ProjViewer projViewer = new ProjViewer();
                projViewer.run();
                break;
            case 5:
                ComViewer comViewer = new ComViewer();
                comViewer.run();
                break;
            case 6:
                CustViewer custViewer = new CustViewer();
                custViewer.run();
                break;
            default:
                System.out.println("An unknown error has occured.");
        }
    }

    private int getInputEntity() throws IOException {
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
        while (choice < 0 || choice > 6) {

            try {
                System.out.println("\nEnter your choice: ");
                choice = Integer.parseInt(reader.readLine());
                if(choice == 6)break;
            } catch (NumberFormatException e) {
                System.out.print("The selected operation was not found. Please try again.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

    private void printHeader() {
        System.out.println("-----------------------------------------------");
        System.out.println("|                                             |");
        System.out.println("|        WELCOME DATA BASE IT COMPANY         |");
        System.out.println("|                                             |");
        System.out.println("-----------------------------------------------");
    }

    public void mainMenu() {
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
        System.out.println("\nPlease make a selection 0-5");
        System.out.println("1. create");
        System.out.println("2. read");
        System.out.println("3. update");
        System.out.println("4. delete");
        System.out.println("5. show all");
        System.out.println("6. main menu");
        System.out.println("0. exit");
    }
}

