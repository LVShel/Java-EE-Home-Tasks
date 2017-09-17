package DAO;

import entity.Item;

import java.util.List;

/**
 * Created by Home on 16.09.2017.
 */
public interface ItemDao {
    void save(Item item);

    Item getItemById(int id);

    Item getItemByName(String name);

    Item getItemByPrice(double price);

    Item getItemByMerchant(String merchant);

    void update(Item newItem);

    void update(Item newItem, int id);

    List<Item> getAll();

    void delete(int id);

    void delete(String name);

    public List<Item> findItem(String name, double price);

}
