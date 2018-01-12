package net.devsambuca.view;

import net.devsambuca.controller.DevController;
import net.devsambuca.model.Developer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ViewEntity {
    boolean exit;
    DevController devController = new DevController();

    public void run() {
        while (!exit) {
            showMenu();
            int choice1 = getInputEntity();
            performAction(choice1);
        }
    }

    private int getInputEntity() {
        int choice1 = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (choice1 < 0 || choice1 > 6) {
            try {
                System.out.println("\nEnter your choice: ");
                choice1 = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.print("Entity not found. Please try again.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return choice1;
    }

    private void performAction(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Thanks for using our application");
                break;
            case 1:
                showAll();
                break;
            case 2:
                create();
                break;
            case 3:
                read();
                break;
            case 4:
                update();
                break;
            case 5:
                delete();
                break;
            default:
                System.out.println("An unknown error has occured.");
        }
    }

    private void showAll(){
        List<Developer> dev = devController.getAll();
        for (Developer d1 : dev)
            System.out.println(d1);
    }

    private void read() {
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

    private void create() {
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
           System.out.println("Input salary: ");
//            developer.setSkills();
            devController.create(developer);
            System.out.println(developer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() {
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
           System.out.println("Input salary: ");
//            developer.setSkills(reader.readLine());
            devController.update(developer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID developer: ");
            devController.delete(Long.parseLong(reader.readLine()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMenu() {
        System.out.println("\nPlease make a selection");
        System.out.println("1. Show all");
        System.out.println("2. read");
        System.out.println("3. create");
        System.out.println("4. update");
        System.out.println("5. delete");
        System.out.println("0. Exit");
    }
}

