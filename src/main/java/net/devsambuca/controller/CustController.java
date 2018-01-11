package net.devsambuca.controller;

import net.devsambuca.dao.IDao;
import net.devsambuca.model.Customer;

public class CustController implements IDao<Customer> {

    private IDaoCustomer customerDAO = new IDaoCustomer();

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
}
