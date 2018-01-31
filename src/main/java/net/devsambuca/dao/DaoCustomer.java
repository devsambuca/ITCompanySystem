package net.devsambuca.dao;

import net.devsambuca.model.Customer;
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
            // find the file with the customer date
            File devFile = new File(FILE_PATH);
            Scanner devScanner = new Scanner(devFile);
            while (devScanner.hasNext()) {
                Customer customer = new Customer();
                String nextLine = devScanner.nextLine();
                String[] devData = nextLine.split(",");
                customer.setId((Long.parseLong(devData[0])));
                customer.setFirstName(devData[1]);
                customer.setLastName(devData[2]);
                customer.setAdress(devData[3]);

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
        List<Customer> dev = getAll();
        Iterator<Customer> iDev = dev.iterator();
        while (iDev.hasNext()) {
            Customer s = iDev.next();
            if (s.getId() == customer.getId())
                iDev.remove();
        }
        dev.add(customer);
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Customer line : dev) {
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
        List<Customer> dev = getAll();
        Iterator<Customer> iDev = dev.iterator();
        while (iDev.hasNext()) {
            Customer s = iDev.next();
            if (s.getId() == id)
                iDev.remove();
        }
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Customer d : dev) {
                writer.write(String.valueOf(d));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAll() {
        List<Customer> devList = new ArrayList<>();
        try {
            // find the file with the customer date
            File devFile = new File(FILE_PATH);
            Scanner devScanner = new Scanner(devFile);
            while (devScanner.hasNext()) {
                Customer customer = new Customer();
                String nextLine = devScanner.nextLine();
                String[] devData = nextLine.split(",");
                customer.setId((Long.parseLong(devData[0])));
                customer.setFirstName(devData[1]);
                customer.setLastName(devData[2]);
                customer.setAdress(devData[3]);
                devList.add(customer);
            }
            return devList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}


