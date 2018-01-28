package net.devsambuca.controller;

import net.devsambuca.dao.IDao;
import net.devsambuca.dao.DaoCustomer;
import net.devsambuca.model.Customer;

import java.util.List;

public class CustController implements IDao<Customer> {

    private DaoCustomer customerDAO = new DaoCustomer();

    public void create(Customer customer) {
        this.customerDAO.create(customer);
    }

    public Customer read(long id) {
        this.customerDAO.read(id);
        return null;
    }

    public void update(Customer customer) {
        this.customerDAO.update(customer);
    }

    public void delete(long id) {
        this.customerDAO.delete(id);
    }

    public List<Customer> getAll() {
        return this.customerDAO.getAll();
    }
}
