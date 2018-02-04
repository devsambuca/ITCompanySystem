package net.devsambuca.view;

import com.sun.org.apache.xpath.internal.SourceTree;
import net.devsambuca.controller.ComController;
import net.devsambuca.controller.ProjController;
import net.devsambuca.model.Company;
import net.devsambuca.model.Project;
import net.devsambuca.model.Skill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
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

    private void pullOutOf(Company company) {
        long id;
        String companyName;
        id = company.getId();
        companyName = company.getName();
        System.out.println(id + "," + companyName);
    }

    private void showCompany(Company company) {
        Long id;
        String companyName;
        Set<Project> projects;
        id = company.getId();
        companyName = company.getName();
        projects = company.getProjects();
        System.out.println(id + ", "
                + companyName + ","
                + projects);
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
                showAllCompanies();
                break;
            case 6:
                returnMainMenu();
                break;
            default:
                System.out.println("An unknown error has occured.");
        }
    }

    private void showDetailsOfTheCompany(Company company) {
        Long id;
        String companyName;
        Set<Project> projects;
        id = company.getId();
        companyName = company.getName();
        projects = company.getProjects();
        System.out.println(id + "," +
                companyName + ","
                + projects);
    }

    private void read() {
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("\nInput ID: ");
                showDetailsOfTheCompany(comController.read(Long.parseLong(reader.readLine())));

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
            Company company = new Company();
            company.setId(Long.parseLong(reader.readLine()));
            System.out.println("Input name: ");
            company.setName(reader.readLine());
            System.out.println("Input project: ");
            company.setProject(reader.readLine().toString());

            comController.create(company);
        } catch (NumberFormatException e) {
            System.out.print("Invalid selection. Please try again.");
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
            System.out.println("Input project: ");
            company.setProject(reader.readLine().toString());
            comController.update(company);
        } catch (NumberFormatException e) {
            System.out.print("Invalid selection. Please try again.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input ID: ");
            comController.delete(Long.parseLong(reader.readLine()));
        } catch (NumberFormatException e) {
            System.out.print("Invalid selection. Please try again.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllCompanies() {
        List<Company> companies = comController.getAll();
        for (Company company : companies) {
            pullOutOf(company);
        }
    }

    private void returnMainMenu() {
        try {
            viewEntity.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
