package net.devsambuca.view;

import net.devsambuca.controller.DevController;
import net.devsambuca.model.Developer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeveloperView {
    boolean exit;
    DevController devController = new DevController();


    public void run() {
        printHeader();
        while (!exit) {
            showMenu();
            int choice = getInput();
            performAction(choice);

        }
    }

    private int getInput() {
        int choice = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (choice < 0 || choice > 5) {
            try {
                System.out.println("\nEnter your choice: ");
                choice = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid selection. Please try again.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

    private void performAction(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Thanks for using our application");
                break;
//            case 1:
//                showAllDeveloper();
//                break;
            case 2:
                inputID();
                break;
            case 3:
                createDeveloper();
                break;
            case 4:
                updateDeveloper();
                break;
            case 5:
                deleteDeveloper();
                break;
            default:
                System.out.println("An unknown error has occured.");
        }
    }

//    private void showAllDeveloper(){
//        List<Developer> dev = devController.getAll();
//        for (Developer d1 : dev)
//            System.out.println(d1);
//    }

    private void inputID() {
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("\nInput ID developer: ");
                devController.read(Long.parseLong(reader.readLine()));
                System.out.println(reader);

            } catch (NumberFormatException e) {
                System.out.print("Invalid selection. Please try again.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    }

    private void createDeveloper() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            Developer developer = new Developer();
            developer.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input firstname: ");
            developer.setFirstName(reader.readLine());
            System.out.println("Input lastname: ");
            developer.setLastName(reader.readLine());
            System.out.println("Input specialty: ");
            developer.setSpecialty(reader.readLine());
//            System.out.println("Input salary: ");
//            developer.setSkills();
            devController.create(developer);
            System.out.println(developer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateDeveloper() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            Developer developer = new Developer();
            developer.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input firstname: ");
            developer.setFirstName(reader.readLine());
            System.out.println("Input lastname: ");
            developer.setLastName(reader.readLine());
            System.out.println("Input specialty: ");
            developer.setSpecialty(reader.readLine());
//            System.out.println("Input salary: ");
//            developer.setSkills(reader.readLine());
            devController.update(developer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteDeveloper(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID developer: ");
            devController.delete(Long.parseLong(reader.readLine()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printHeader() {
        System.out.println("-----------------------------------------------");
        System.out.println("|                                             |");
        System.out.println("|        WELCOME DATA BASE IT COMPANY         |");
        System.out.println("|                                             |");
        System.out.println("-----------------------------------------------");
    }

    private void showMenu() {
        System.out.println("\nPlease make a selection");
        System.out.println("1. Show all developers");
        System.out.println("2. Find developer by ID");
        System.out.println("3. Create developer");
        System.out.println("4. Update developer");
        System.out.println("5. Delete developer");
        System.out.println("0. Exit");
    }
}

