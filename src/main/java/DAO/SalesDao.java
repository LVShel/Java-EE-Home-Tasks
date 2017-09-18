package DAO;

import entity.Item;

import java.util.List;

/**
 * Created by Home on 17.09.2017.
 */
public interface SalesDao {

    List<Item> getSalesByAge(int age);

    List<Item> getSalesByAge(int ageFrom, int ageTo);

    List<Item> getSalesByCustomerID(int id);

    List<Item> getSalesByCustomerName(String name);
}
