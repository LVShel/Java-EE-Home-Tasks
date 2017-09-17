
import Service.GoodsService;
import config.SpringConfig;
import entity.Item;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Home on 12.09.2017.
 */
public class app {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        GoodsService goodsService = context.getBean(GoodsService.class);

//before storing new Item in goods table, method save(Item item) checks whether
// such object with the same name and price exists in the table
// if exists, the method calls overloaded method update(Item newItem, int id)
        Item myItem = new Item();
        myItem.setName("Shoes");
        myItem.setPrice(22);
        myItem.setMerchant("Reebok");

        goodsService.save(myItem);

        Item myAnotherItem = new Item();
        myAnotherItem.setName("Shoes");
        myAnotherItem.setPrice(25);
        myAnotherItem.setMerchant("Reebok");

        goodsService.save(myAnotherItem);


    }
}
