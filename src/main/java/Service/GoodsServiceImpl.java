package Service;

import DAO.ItemDao;
import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Home on 16.09.2017.
 */
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public Item getById(int id) {
        if(id > 0){
            return itemDao.getItemById(id);
        }
        else{
            System.out.println("Item ID must be positive number, bigger than zero!");
            return null;
        }
    }

    @Override
    public Item getByName(String name) {
        if(name.matches("[a-zA-Z]+") && name.length() <= 20){
            return itemDao.getItemByName(name);
        }
        else{
            System.out.println("Item name can contain letters only!");
            return null;
        }
    }

    @Override
    public Item getByPrice(double price) {
        if (price > 0) {
            return itemDao.getItemByPrice(price);
        }
        else{
            System.out.println("Item price cannot be less than 0!");
            return null;
        }
    }

    @Override
    public Item getByMerchant(String merchant) {
        if(merchant.matches("[a-zA-Z]+") && merchant.length() <= 20){
            return itemDao.getItemByMerchant(merchant);
        }
        else{
            System.out.println("Item name can contain letters only!");
            return null;
        }
    }

    @Override
    public void save(Item item) {
        List<Item> foundItems = itemDao.findItem(item.getName(), item.getPrice());
        if(foundItems.size() < 1){
            itemDao.save(item);
            System.out.println("New Item stored in goods table");
        }
        else{
            System.out.println("This item already exists. It has been updated!");
            itemDao.update(item, foundItems.get(0).getId());
        }
    }

    @Override
    public void update(Item newItem) {
        itemDao.update(newItem);
    }

    @Override
    public void update(Item newItem, int id) {
        itemDao.update(newItem, id);
    }

    @Override
    public List<Item> getAll() {
       return itemDao.getAll();
    }

    @Override
    public void delete(int id) {
        itemDao.delete(id);
    }

    @Override
    public void delete(String name) {
        itemDao.delete(name);
    }
}
