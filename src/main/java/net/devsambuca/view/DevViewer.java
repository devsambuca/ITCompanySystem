package net.devsambuca.view;

import net.devsambuca.controller.DevController;
import net.devsambuca.model.Developer;
import net.devsambuca.model.Skill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Set;

public class DevViewer {
    boolean exit;
    DevController devController = new DevController();
    ViewEntity viewEntity = new ViewEntity();

    public void run() {
       while (!exit) {
            viewEntity.showMenu();
            int choice = viewEntity.getInputOperation();
            performAction(choice);
       }
    }

    public void performAction(int choice) {
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
                System.out.println("\nInput ID developer: ");
                System.out.println(devController.read(Long.parseLong(reader.readLine())));

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
            Skill skill = new Skill();
            developer.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input firstname: ");
            developer.setFirstName(reader.readLine());
            System.out.println("Input lastname: ");
            developer.setLastName(reader.readLine());
            System.out.println("Input specialty: ");
            developer.setSpecialty(reader.readLine());
            System.out.println("Input salary: ");
            developer.setSalary(BigDecimal.valueOf(Double.parseDouble(reader.readLine())));
            System.out.println("Input skill");
            skill.setName(reader.readLine());
            devController.create(developer);
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
            developer.setSalary(BigDecimal.valueOf(Double.parseDouble(reader.readLine())));
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
}

