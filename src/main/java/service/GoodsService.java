package service;

import entity.Item;

import java.util.List;

/**
 * Created by Home on 16.09.2017.
 */
public interface GoodsService {

    Item getById(int id);

    List<Item> getByName(String name);

    List<Item> getByPrice(double price);

    List<Item> getByMerchant(String merchant);

    void save(Item item);

    void update(Item newItem);

    void update(Item newItem, int id);

    List<Item> getAll();

    void delete(int id);

    void delete(String name);
}
