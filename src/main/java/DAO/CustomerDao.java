package DAO;

import entity.Customer;

import java.util.List;

/**
 * Created by Home on 12.09.2017.
 */
public interface CustomerDao {

    void save(Customer customer);

    Customer getUserById(int id);

    Customer update(Customer newCustomer);

    List<Customer> getAll();

    void delete(int id);

    void delete(String name);
}
