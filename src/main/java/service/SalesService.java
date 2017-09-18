package service;

import entity.Item;

import java.util.List;

/**
 * Created by Home on 17.09.2017.
 */
public interface SalesService {

    List<Item> getByAge(int age);

    List<Item> getByAge(int ageFrom, int ageTo);

    List<Item> getByCustomerID(int id);

    List<Item> getByCustomerName(String name);
}
