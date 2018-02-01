package net.devsambuca.dao;

import net.devsambuca.model.Customer;
import net.devsambuca.model.Project;
import net.devsambuca.view.CustViewer;

import java.io.*;
import java.util.*;

public class DaoCustomer implements DaoImp<Customer> {

    public static final String FILE_PATH = "src/main/resources/customers.txt";

    public void create(Customer customer) {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        Writer writer = null;
        String str = customer.getId() + "," + customer.getFirstName() + "," + customer.getLastName() + "," + customer.getAdress();
        try {
            writer = new FileWriter(FILE_PATH, true);
            writer.write(str + '\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer read(long id) {
        try {
            File customerFile = new File(FILE_PATH);
            Scanner customerScanner = new Scanner(customerFile);
            while (customerScanner.hasNext()) {
                Customer customer = new Customer();
                String nextLine = customerScanner.nextLine();
                String[] customerData = nextLine.split(",");
                for (int i = 0; i <customerData.length; i++) {
                    if (customerData[i].isEmpty()) continue;
                    switch (i) {
                        case 0:
                            customer.setId(Long.parseLong(customerData[i]));
                            continue;
                        case 1:
                            customer.setFirstName(customerData[i]);
                            continue;
                        case 2:
                            customer.setLastName(customerData[i]);
                            continue;
                    }
                    if (i == customerData.length - 1)
                        customer.setAdress(customerData[i]);
                    else {
                        Set<Project> projects = customer.getProjects();
                        if (projects == null) projects = new HashSet<>();
                        DaoProject daoProject = new DaoProject();
                        projects.add(daoProject.read((Long.valueOf(customerData[i]))));
                        customer.setProjects(projects);
                    }
                }
                if (id == customer.getId()) {
                    return customer;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }

    public void update(Customer customer) {
        List<Customer> customerList = getAll();
        Iterator<Customer> iCustomer = customerList.iterator();
        while (iCustomer.hasNext()) {
            Customer s = iCustomer.next();
            if (s.getId() == customer.getId())
                iCustomer.remove();
        }
        customerList.add(customer);
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Customer line : customerList) {
                writer.write(String.valueOf(line));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        List<Customer> customer = getAll();
        Iterator<Customer> iDev = customer.iterator();
        while (iDev.hasNext()) {
            Customer s = iDev.next();
            if (s.getId() == id)
                iDev.remove();
        }
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Customer d : customer) {
                writer.write(String.valueOf(d));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            // find the file with the customer date
            File customerFile = new File(FILE_PATH);
            Scanner customerScanner = new Scanner(customerFile);
            while (customerScanner.hasNext()) {
                Customer customer = new Customer();
                String nextLine = customerScanner.nextLine();
                String[] customerData = nextLine.split(",");
                for (int i = 0; i < customerData.length; i++) {
                    if (customerData[i].isEmpty()) continue;
                    switch (i) {
                        case 0:
                            customer.setId(Long.parseLong(customerData[i]));
                            continue;
                        case 1:
                            customer.setFirstName(customerData[i]);
                            continue;
                        case 2:
                            customer.setLastName(customerData[i]);
                            continue;
                    }
                    if (i == customerData.length - 1)
                        customer.setAdress((customerData[i]));

                }
                customerList.add(customer);
            }
            return customerList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}


