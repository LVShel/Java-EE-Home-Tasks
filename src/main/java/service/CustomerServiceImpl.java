package service;

import dao.CustomerDao;
import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Home on 16.09.2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer getById(int id) {
        if (id > 0) {
            return customerDao.getUserById(id);
        } else {
            System.out.println("CustomerID must be positive number, bigger than zero!");
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        List<Customer> foundCustomers = customerDao.findCustomers(customer.getName(), customer.getAge());
        if (foundCustomers.size() < 1) {
            customerDao.save(customer);
            System.out.println("New Customer stored in customers table");
        } else {
            System.out.println("This customer already exists. It has been updated!");
            customerDao.update(customer, foundCustomers.get(0).getId());
        }
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void update(Customer customer, int id) {
        customerDao.update(customer, id);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Override
    public void delete(int id) {
        customerDao.delete(id);
    }

    @Override
    public void delete(String name) {
        customerDao.delete(name);
    }

}
