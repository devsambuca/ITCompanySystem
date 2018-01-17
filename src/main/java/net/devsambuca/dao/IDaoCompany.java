package net.devsambuca.dao;

import net.devsambuca.model.Company;
import net.devsambuca.model.Project;

import java.io.*;
import java.util.*;

public class IDaoCompany implements IDao<Company> {
    public static final String FILE_PATH = "D:/JAVA/project/ITCompanySystem/src/main/resources/company.txt";

    public void create(Company company) {
        Set<Company> companies = new HashSet<Company>();
        companies.add(company);
        Writer writer = null;
        String str = company.getId() + "," + company.getName();
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

    public void update(Company company) {
        Set<Company> listCompany = getAll();
        Iterator<Company> iDev = listCompany.iterator();
        while (iDev.hasNext()) {
            Company s = iDev.next();
            if (s.getId() == company.getId())
                iDev.remove();
        }
        listCompany.add(company);
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
        Set<Company> listCompany = getAll();
        Iterator<Company> iCom = listCompany.iterator();
        while (iCom.hasNext()) {
            Company s = iCom.next();
            if (s.getId() == id)
                iCom.remove();
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

    public Set<Company> getAll() {
        Set<Company> listCompanyList = new HashSet<Company>();
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

    public void create(){

    }
}
