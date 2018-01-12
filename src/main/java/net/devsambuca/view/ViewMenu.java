package net.devsambuca.view;

import net.devsambuca.controller.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewMenu {
    boolean exit;

    public void run() {
        while (!exit) {
            printHeader();
            selectMenu();
            int choice = getInputEntity();
            performAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("-----------------------------------------------");
        System.out.println("|                                             |");
        System.out.println("|        WELCOME DATA BASE IT COMPANY         |");
        System.out.println("|                                             |");
        System.out.println("-----------------------------------------------");
    }

    private void selectMenu() {
        System.out.println("\nPlease make a selection");
        System.out.println("1. developer");
        System.out.println("2. skill");
        System.out.println("3. team");
        System.out.println("4. project");
        System.out.println("5. company");
        System.out.println("6. customer");
        System.out.println("0. Exit");
    }

    private void performAction(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Thanks for using our application");
                break;
            case 1:
                view();
                break;
            case 2:
                skill();
                break;
            case 3:
                team();
                break;
            case 4:
                project();
                break;
            case 5:
                company();
                break;
            case 6:
                customer();
                break;
            default:
                System.out.println("An unknown error has occured.");
        }
    }

    public void view(){
        ViewEntity viewEntity = new ViewEntity();
        viewEntity.run();

    }
    public void company(){
        new ComController();
    }
    public void customer(){
        new CustController();
    }
    public void team(){
        new TeamController();
    }
    public void project(){
        new ProjController();
    }
    public void skill(){
        new SkillController();
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
}
