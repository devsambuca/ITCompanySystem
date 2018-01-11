package net.devsambuca.controller;

import net.devsambuca.dao.IDao;
import net.devsambuca.dao.IDaoCompany;
import net.devsambuca.model.Company;

public class ComController implements IDao<Company> {

    private IDaoCompany companyDAO = new IDaoCompany();

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
}
