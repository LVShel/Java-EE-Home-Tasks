package dao;

import entity.Customer;
import mappers.CustomerMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Home on 12.09.2017.
 */
public class CustomerDaoImpl implements CustomerDao {
    private JdbcTemplate jdbcTemplate;

    public CustomerDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Customer customer) {
        String sql = "INSERT INTO customers(name, email, age) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getAge());
    }

    @Override
    public Customer getUserById(int id) {
        String sql = "SELECT * FROM customers WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new CustomerMapper(), id);
    }

    @Override
    public void update(Customer newCustomer) {
        String sql = "UPDATE customers SET name=?, email=?, age=? WHERE id=?";
        int update = jdbcTemplate.update(sql, newCustomer.getName(), newCustomer.getEmail(), newCustomer.getAge(), newCustomer.getId());
    }

    @Override
    public void update(Customer newCustomer, int id) {
        String sql = "UPDATE customers SET name=?, email=?, age=? WHERE id=?";
        int update = jdbcTemplate.update(sql, newCustomer.getName(), newCustomer.getEmail(), newCustomer.getAge(), id);
    }

    @Override
    public List<Customer> getAll() {
        String sql = "SELECT * FROM customers";
        return jdbcTemplate.query(sql, new CustomerMapper());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM customers WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void delete(String name) {
        String sql = "DELETE FROM customers WHERE name=?";
        jdbcTemplate.update(sql, name);
    }

    @Override
    public List<Customer> findCustomers(String name, int age) {
        String sql = "SELECT * FROM customers WHERE name = ? AND age = ?";
        return jdbcTemplate.query(sql, new CustomerMapper(), name, age);
    }
}
