package net.devsambuca.controller;

import net.devsambuca.dao.DaoImp;
import net.devsambuca.dao.DaoCompany;
import net.devsambuca.model.Company;

import java.util.List;

public class ComController implements DaoImp<Company> {

    private DaoCompany companyDAO = new DaoCompany();

    public void create(Company company) {
        this.companyDAO.create(company);
    }

    public Company read(long id) {
        this.companyDAO.read(id);
        return null;
    }

    public void update(Company company) {
        this.companyDAO.update(company);
    }

    public void delete(long id) {
        this.companyDAO.delete(id);
    }

    public List<Company> getAll() {
        return this.companyDAO.getAll();
    }
}
