package net.devsambuca.dao;

import net.devsambuca.model.Company;
import net.devsambuca.model.Project;

import java.io.*;
import java.util.*;

public class DaoCompany implements DaoImp<Company> {
    public static final String FILE_PATH = "src/main/resources/company.txt";

    public void create(Company company) {
        List<Company> companies = new ArrayList<>();
        companies.add(company);
        Writer writer = null;
        String str = company.getId() + "," + company.getName() + "," + company.getProject();
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
            File companyFile = new File(FILE_PATH);
            Scanner companyScanner = new Scanner(companyFile);
            while (companyScanner.hasNext()) {
                Company company = new Company();
                String nextLine = companyScanner.nextLine();
                String[] companyData = nextLine.split(",");
                for (int i = 0; i < companyData.length; i++) {
                    if (companyData[i].isEmpty()) continue;
                    switch (i) {
                        case 0:
                            company.setId(Long.parseLong(companyData[i]));
                            continue;
                    }
                    if (i == companyData.length - 1)
                        company.setName(companyData[i]);
                    else {
                        Set<Project> projects = company.getProjects();
                        if (projects == null) projects = new HashSet<>();
                        Project project = new Project(Long.parseLong(companyData[i]));
                        if (id == project.getId())
                            projects.add(project);

                        company.setProjects(projects);
                    }
                }
                if (id == company.getId())
                    return company;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }
        return null;
    }

    public void update(Company company) {
        List<Company> listCompany = getAll();
        Iterator<Company> iCompany = listCompany.iterator();
        while (iCompany.hasNext()) {
            Company s = iCompany.next();
            if (s.getId() == company.getId())
                iCompany.remove();
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
        List<Company> listCompany = getAll();
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

    public List<Company> getAll() {
        try {
            List<Company> companyList = new ArrayList<>();
            File companyFile = new File(FILE_PATH);
            Scanner companyScanner = new Scanner(companyFile);
            while (companyScanner.hasNext()) {
                Company company = new Company();
                String nextLine = companyScanner.nextLine();
                String[] companyData = nextLine.split(",");
                for (int i = 0; i < companyData.length; i++) {
                    if (companyData[i].isEmpty()) continue;
                    switch (i) {
                        case 0:
                            company.setId(Long.parseLong(companyData[i]));
                            continue;
                            case 1:
                                company.setName(companyData[i]);
                            continue;

                    }
//                    if (i == companyData.length - 1)
//                        Projects = company.getProjects();
//                        if (projects == null) projects = new HashSet<>();
//                        DaoProject daoProject = new DaoProject();
//                        projects.add(daoProject.read((Long.valueOf(companyData[i]))));
//                        company.setProjects(projects);
//
//
                }
                companyList.add(company);
            }

            return companyList;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }
        return null;
    }
}
