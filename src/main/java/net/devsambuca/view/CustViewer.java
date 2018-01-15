package net.devsambuca.view;

import net.devsambuca.controller.CustController;
import net.devsambuca.model.Customer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustViewer {
    boolean exit;
    CustController projController = new CustController();
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
            default:
                System.out.println("An unknown error has occured.");
        }
    }

    private void read() {
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("\nInput ID: ");
                projController.read(Long.parseLong(reader.readLine()));
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
            Customer customer = new Customer();
            customer.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input firstname: ");
            customer.setFirstName(reader.readLine());
            System.out.println("Input lastname: ");
            customer.setLastName(reader.readLine());
            System.out.println("Input address: ");
            customer.setAdress(reader.readLine());
            projController.create(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            Customer customer = new Customer();
            customer.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input firstname: ");
            customer.setFirstName(reader.readLine());
            System.out.println("Input lastname: ");
            customer.setLastName(reader.readLine());
            System.out.println("Input address: ");
            customer.setAdress( reader.readLine());
            projController.update(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            projController.delete(Long.parseLong(reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
