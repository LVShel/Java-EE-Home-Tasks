package DAO;

import Mappers.UserMapper;
import entity.Customer;
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
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public Customer update(Customer newCustomer) {
        String sql = "UPDATE customers SET name=?, email=?, age=? WHERE id=?";
        int update = jdbcTemplate.update(sql, newCustomer.getName(), newCustomer.getEmail(), newCustomer.getAge(), newCustomer.getId());
        System.out.println("return + " + update);
        return null;
    }

    @Override
    public List<Customer> getAll() {
        String sql = "SELECT * FROM customers";
        return jdbcTemplate.query(sql, new UserMapper());
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
}
