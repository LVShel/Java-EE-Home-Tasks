package DAO;

import Mappers.ItemMapper;
import entity.Item;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Home on 17.09.2017.
 */
public class SalesDaoImpl implements SalesDao {
    private JdbcTemplate jdbcTemplate;

    public SalesDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Item> getSalesByAge(int age) {
        String sql = "SELECT * FROM goods LEFT JOIN customers on goods.customerID = customers.id WHERE customers.age = ?";
        return jdbcTemplate.query(sql, new ItemMapper(), age);
    }

    @Override
    public List<Item> getSalesByAge(int ageFrom, int ageTo) {
        String sql = "SELECT * FROM goods LEFT JOIN customers on goods.customerID = customers.id WHERE customers.age BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, new ItemMapper(), ageFrom, ageTo);
    }

    @Override
    public List<Item> getSalesByCustomerID(int id) {
        String sql = "SELECT * FROM goods LEFT JOIN customers on goods.customerID = customers.id WHERE customers.id = ?";
        return jdbcTemplate.query(sql, new ItemMapper(), id);
    }

    @Override
    public List<Item> getSalesByCustomerName(String name) {
        String sql = "SELECT * FROM goods LEFT JOIN customers on goods.customerID = customers.id WHERE customers.name = ?";
        return jdbcTemplate.query(sql, new ItemMapper(), name);
    }
}
