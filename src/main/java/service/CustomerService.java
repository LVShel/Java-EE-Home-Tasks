package service;

import entity.Customer;

import java.util.List;

/**
 * Created by Home on 16.09.2017.
 */
public interface CustomerService {

    Customer getById(int id);

    void save(Customer customer);

    void update(Customer customer);

    void update(Customer customer, int id);

    List<Customer> getAll();

    void delete(int id);

    void delete(String name);
}
