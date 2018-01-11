package net.devsambuca.dao;

import net.devsambuca.model.Company;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class IDaoCompany implements IDao<Company> {
    public static final String FILE_PATH = "teams.txt";

    public void create(Company team) {
        Writer writer = null;
        String str = team.getId() + "," + team.getName();
        try {
            writer = new FileWriter(FILE_PATH, true);
            writer.write(str + '\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Company read(long id) {
        try {
            // find the file with the team date
            File listCompanyFile = new File(FILE_PATH);
            Scanner listCompanyScanner = new Scanner(listCompanyFile);
            while (listCompanyScanner.hasNext()) {
                Company team = new Company();
                String nextLine = listCompanyScanner.nextLine();
                String[] listCompanyData = nextLine.split(",");
                team.setId((Long.parseLong(listCompanyData[0])));
                team.setName(listCompanyData[1]);

                if (id == team.getId()) {
                    return team;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }

    public void update(Company team) {
        List<Company> listCompany = getAll();
        Iterator<Company> iDev = listCompany.iterator();
        while (iDev.hasNext()) {
            Company s = iDev.next();
            if (s.getId() == team.getId())
                iDev.remove();
        }
        listCompany.add(team);
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Company line : listCompany) {
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
        List<Company> listCompany = getAll();
        Iterator<Company> iDev = listCompany.iterator();
        while (iDev.hasNext()) {
            Company s = iDev.next();
            if (s.getId() == id)
                iDev.remove();
        }
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Company d : listCompany) {
                writer.write(String.valueOf(d));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Company> getAll() {
        List<Company> listCompanyList = new ArrayList<Company>();
        try {
            // find the file with the team date
            File listCompanyFile = new File(FILE_PATH);
            Scanner listCompanyScanner = new Scanner(listCompanyFile);
            while (listCompanyScanner.hasNext()) {
                Company team = new Company();
                String nextLine = listCompanyScanner.nextLine();
                String[] listCompanyData = nextLine.split(",");
                team.setId((Long.parseLong(listCompanyData[0])));
                team.setName(listCompanyData[1]);
                listCompanyList.add(team);
            }
            return listCompanyList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}