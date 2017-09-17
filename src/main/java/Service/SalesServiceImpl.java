package Service;

import DAO.SalesDao;
import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Home on 17.09.2017.
 */
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesDao salesDao;

    @Override
    public List<Item> getSalesByAge(int age) {
        if (age > 0 && age <=100) {
            return salesDao.getSalesByAge(age);
        }
        else{
            System.out.println("Age must be between 0 and 100!");
            return null;
        }
    }

    @Override
    public List<Item> getSalesByAge(int ageFrom, int ageTo) {
        if ((ageFrom > 0 && ageFrom <=100) && (ageTo > 0 && ageTo <=100)) {
            return salesDao.getSalesByAge(ageFrom, ageTo);
        }
        else{
            System.out.println("Age must be between 0 and 100!");
            return null;
        }
    }

    @Override
    public List<Item> getSalesByCustomerID(int id) {
        if (id > 0) {
            return salesDao.getSalesByCustomerID(id);
        }
        else{
            System.out.println("Id must be bigger than 0!");
            return null;
        }
    }

    @Override
    public List<Item> getSalesByCustomerName(String name) {
        if(name.matches("[a-zA-Z]+") && name.length() <= 20){
            return salesDao.getSalesByCustomerName(name);
        }
        else{
            System.out.println("Item name can contain letters only!");
            return null;
        }
    }
}
