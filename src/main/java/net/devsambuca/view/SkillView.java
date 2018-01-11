package net.devsambuca.view;

import net.devsambuca.controller.SkillController;
import net.devsambuca.model.Skill;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SkillView {
    boolean exit;
    SkillController skillController = new SkillController();


    public void run() {
        printHeader();
        while (!exit) {
            selectMenu();
            int choice1 = getInputEntity();
            performAction(choice1);
            showMenu();
            int choice2 = getInputMenu();
            performAction(choice2);

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

    private int getInputMenu() {
        int choice2 = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (choice2 < 0 || choice2 > 6) {
            try {
                System.out.println("\nEnter your choice: ");
                choice2 = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid selection. Please try again.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return choice2;
    }

    private void performAction(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Thanks for using our application");
                break;
            case 1:
                showAllSkill();
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

    private void showAllSkill(){
        List<Skill> skill = skillController.getAll();
        for (Skill d1 : skill)
            System.out.println(d1);
    }

    private void read() {
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("\nInput ID skilleloper: ");
                skillController.read(Long.parseLong(reader.readLine()));
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
            Skill skilleloper = new Skill();
            skilleloper.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input name: ");
            skilleloper.setName(reader.readLine());
            skillController.create(skilleloper);
            System.out.println(skilleloper);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            Skill skilleloper = new Skill();
            skilleloper.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input name: ");
            skilleloper.setName(reader.readLine());
            skillController.update(skilleloper);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID skilleloper: ");
            skillController.delete(Long.parseLong(reader.readLine()));

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
        System.out.println("1. Show all skillelopers");
        System.out.println("2. Find skilleloper by ID");
        System.out.println("3. Create skilleloper");
        System.out.println("4. Update skilleloper");
        System.out.println("5. Delete skilleloper");
        System.out.println("0. Exit");
    }

    private void selectMenu() {
        System.out.println("\nPlease make a selection");
        System.out.println("1. skilleloper");
        System.out.println("2. skill");
        System.out.println("3. team");
        System.out.println("4. project");
        System.out.println("5. company");
        System.out.println("6. customer");
        System.out.println("0. Exit");
    }
}
