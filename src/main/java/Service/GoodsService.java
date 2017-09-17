package Service;

import entity.Item;

import java.util.List;

/**
 * Created by Home on 16.09.2017.
 */
public interface GoodsService{

    Item getById(int id);

    Item getByName(String name);

    Item getByPrice(double price);

    Item getByMerchant(String merchant);

    public void save(Item item);

    public void update(Item newItem);

    public void update(Item newItem, int id);

    public List<Item> getAll();

    public void delete(int id);

    public void delete(String name);
}
