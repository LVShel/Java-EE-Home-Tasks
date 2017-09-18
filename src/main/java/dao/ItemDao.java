package dao;

import entity.Item;

import java.util.List;

/**
 * Created by Home on 16.09.2017.
 */
public interface ItemDao {
    void save(Item item);

    Item getItemById(int id);

    List<Item> getItemsByName(String name);

    List<Item> getItemsByPrice(double price);

    List<Item> getItemsByMerchant(String merchant);

    void update(Item newItem);

    void update(Item newItem, int id);

    List<Item> getAll();

    void delete(int id);

    void delete(String name);

    List<Item> findItems(String name, double price);

}
