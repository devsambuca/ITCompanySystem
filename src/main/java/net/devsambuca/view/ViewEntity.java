package net.devsambuca.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewEntity {
    boolean exit;

    public void run() {
            showMenu();
            int choice = getInputEntity();
            performAction(choice);
        }

    private void performAction(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Thanks for using our application");
                break;
            case 1:
                DevViewer devViewer = new DevViewer();
                devViewer.run();
                break;
//            case 2:
//                read();
//                break;
//            case 3:
//                update();
//                break;
//            case 4:
//                delete();
//                break;
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


    private void showMenu() {
        System.out.println("\nPlease make a selection");
        System.out.println("1. Developer");
        System.out.println("2. Skill");
        System.out.println("3. Team");
        System.out.println("4. Project");
        System.out.println("5. Company");
        System.out.println("6. Customer");
        System.out.println("0. Exit");
    }
}

