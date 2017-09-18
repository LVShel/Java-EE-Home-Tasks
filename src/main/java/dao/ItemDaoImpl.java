package dao;

import mappers.ItemMapper;
import entity.Item;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Home on 16.09.2017.
 */
public class ItemDaoImpl implements ItemDao {
    private JdbcTemplate jdbcTemplate;

    public ItemDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Item item) {
        String sql = "INSERT INTO goods(name, price, merchant) VALUES(?,?,?)";
        jdbcTemplate.update(sql, item.getName(), item.getPrice(), item.getMerchant());
    }

    @Override
    public Item getItemById(int id) {
        String sql = "SELECT * FROM goods WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new ItemMapper(), id);
    }

    @Override
    public List<Item> getItemsByName(String name) {
        String sql = "SELECT * FROM goods WHERE name = ?";
        return jdbcTemplate.query(sql, new ItemMapper(), name);
    }

    @Override
    public List<Item> getItemsByPrice(double price) {
        String sql = "SELECT * FROM goods WHERE price = ?";
        return jdbcTemplate.query(sql, new ItemMapper(), price);
    }

    @Override
    public List<Item> getItemsByMerchant(String merchant) {
        String sql = "SELECT * FROM goods WHERE merchant = ?";
        return jdbcTemplate.query(sql, new ItemMapper(), merchant);
    }

    @Override
    public void update(Item newItem) {
        String sql = "UPDATE goods SET name=?, price=?, merchant=? WHERE id=?";
        int updated = jdbcTemplate.update(sql, newItem.getName(), newItem.getPrice(), newItem.getMerchant(), newItem.getId());
        System.out.println("Updated in table goods: " + updated);
    }

    @Override
    public void update(Item newItem, int id) {
        String sql = "UPDATE goods SET name=?, price=?, merchant=? WHERE id=?";
        int updated = jdbcTemplate.update(sql, newItem.getName(), newItem.getPrice(), newItem.getMerchant(), id);
        System.out.println("Updated in table goods: " + updated);
    }

    @Override
    public List<Item> getAll() {
        String sql = "SELECT * FROM goods";
        return jdbcTemplate.query(sql, new ItemMapper());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM goods WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void delete(String name) {
        String sql = "DELETE FROM goods WHERE name=?";
        jdbcTemplate.update(sql, name);

    }

    public List<Item> findItems(String name, double price) {
        String sql = "SELECT * FROM goods WHERE name = ? AND price = ?";
        return jdbcTemplate.query(sql, new ItemMapper(), name, price);
    }
}
