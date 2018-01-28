package net.devsambuca.view;

import net.devsambuca.controller.SkillController;
import net.devsambuca.model.Developer;
import net.devsambuca.model.Skill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SkillViewer {

    boolean exit;
    SkillController skillController = new SkillController();
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
                showAllSkills();
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
                System.out.println("\nInput ID skill: ");
                System.out.println(skillController.read(Long.parseLong(reader.readLine())));

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
            Skill skill = new Skill();
            skill.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input name: ");
            skill.setName(reader.readLine());
            skillController.create(skill);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            Skill skill = new Skill();
            skill.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input name: ");
            skill.setName(reader.readLine());
            skillController.update(skill);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID skill: ");
            skillController.delete(Long.parseLong(reader.readLine()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllSkills() {
        List<Skill> skills = skillController.getAll();
        for (Skill skill : skills)
            System.out.println(skill);
    }

    private void returnMainMenu() {
        try {
            viewEntity.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

