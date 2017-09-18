import service.GoodsService;
import service.SalesService;
import config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Home on 12.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        GoodsService goodsService = context.getBean(GoodsService.class);
        SalesService salesService = context.getBean(SalesService.class);

//before storing new Item in goods table, method save(Item item) checks whether
// such object with the same name and price exists in the table
// if exists, the method calls overloaded method update(Item newItem, int id)

//        Item myItem = new Item();
//        myItem.setName("Shoes");
//        myItem.setPrice(22);
//        myItem.setMerchant("Reebok");
//
//        goodsService.save(myItem);
//
//        Item myAnotherItem = new Item();
//        myAnotherItem.setName("Shoes");
//        myAnotherItem.setPrice(25);
//        myAnotherItem.setMerchant("Reebok");
//
//        goodsService.save(myAnotherItem);

        System.out.println("Items by merchant: ");
        goodsService.getByMerchant("Nike").forEach(System.out::println);

        System.out.println("Items by name: ");
        goodsService.getByName("Shoes").forEach(System.out::println);

        System.out.println("Items by price: ");
        goodsService.getByPrice(22).forEach(System.out::println);

        System.out.println("Sales by customer's age: ");
        salesService.getByAge(33).forEach(System.out::println);

        System.out.println("Sales by customers age range : ");
        salesService.getByAge(30, 50).forEach(System.out::println);

        System.out.println("Sales by customer's ID : ");
        salesService.getByCustomerID(2).forEach(System.out::println);

        System.out.println("Sales by customer's name : ");
        salesService.getByCustomerName("Ben").forEach(System.out::println);
    }
}
