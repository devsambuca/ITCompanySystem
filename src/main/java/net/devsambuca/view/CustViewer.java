package net.devsambuca.view;

import net.devsambuca.controller.CustController;
import net.devsambuca.model.Customer;
import net.devsambuca.model.Developer;
import net.devsambuca.model.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

public class CustViewer {
    boolean exit;
    CustController custController = new CustController();
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
                showAllCustomers();
                break;
            case 6:
                returnMainMenu();
                break;
            default:
                System.out.println("An unknown error has occured.");
        }
    }

    private void showDeveloper(Customer customer) {
        Long id;
        String firstName;
        String lastName;
        String address;
        Set<Project> projects;
        id = customer.getId();
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        address = customer.getAdress();
        projects = customer.getProjects();
        System.out.println(id + "," +
                firstName + ","
                + lastName + ","
                + projects + ","
                + address);
    }

    private void pullOutOf(Customer customer){
        long id;
        String customerFirstName,customerLastName,customerAddress;
        id = customer.getId();
        customerFirstName = customer.getFirstName();
        customerLastName = customer.getLastName();
        customerAddress = customer.getAdress();
        System.out.println(id + ", " + customerFirstName + ", " +customerLastName + ", " + customerAddress);
    }

    private void read() {
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("\nInput ID: ");
                showDeveloper(custController.read(Long.parseLong(reader.readLine())));
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
            System.out.println("Input project(s): " + "The format of the entered project should be, for example: 1,2,3");
            customer.setProject(reader.readLine());
            custController.create(customer);
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
            customer.setAdress(reader.readLine());
            System.out.println("Input project: ");
            customer.setProject(reader.readLine());
            custController.update(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            custController.delete(Long.parseLong(reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllCustomers() {
        List<Customer> customers = custController.getAll();
        for(Customer customer : customers)
            pullOutOf(customer);
    }

    private void returnMainMenu() {
        try {
            viewEntity.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
