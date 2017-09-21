package dao;

import entity.Customer;

import java.util.List;

/**
 * Created by Home on 12.09.2017.
 */
public interface CustomerDao {

    void save(Customer customer);

    Customer getUserById(int id);

    void update(Customer newCustomer);

    void update(Customer customer, int id);

    List<Customer> getAll();

    void delete(int id);

    void delete(String name);

    List<Customer> findCustomers(String name, int age);
}
