package net.devsambuca.view;

import net.devsambuca.controller.ComController;
import net.devsambuca.controller.ProjController;
import net.devsambuca.model.Company;
import net.devsambuca.model.Project;
import net.devsambuca.model.Skill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class ComViewer {
    boolean exit;
    ComController comController = new ComController();
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
//            case 5:
//                addSkill();
            default:
                System.out.println("An unknown error has occured.");
        }
    }

    private void read() {
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("\nInput ID: ");
                comController.read(Long.parseLong(reader.readLine()));
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
            Company comect = new Company();
            comect.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input name: ");
            comect.setName(reader.readLine());
            comController.create(comect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            Company company = new Company();
            company.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input name: ");
            company.setName(reader.readLine());
            comController.update(company);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            comController.delete(Long.parseLong(reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private Set<Project> addSkill () {
//        System.out.println("Выберите проекты");
//        ProjController projController = new ProjController();
//        projController.create(S);
//    }

}
