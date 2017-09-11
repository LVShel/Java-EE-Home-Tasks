import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 11.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        double sumOfAllShapesArea = 0;
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Rectangle rectangle = (Rectangle) context.getBean("rectangle");
        Triangle triangle = (Triangle) context.getBean("triangle");
        Circle circle = (Circle) context.getBean("circle");

        shapes.add(rectangle);
        shapes.add(triangle);
        shapes.add(circle);

        for(Shape shape : shapes){
            System.out.println(shape.getClass().getName() + " area is "  + shape.calcArea());
            sumOfAllShapesArea += shape.calcArea();;
        }

        System.out.println("Sum of all shapes area is " + sumOfAllShapesArea);
        System.out.println("Circle plain area is " + circle.calcPlainArea());
        System.out.println("Task completed successfully: " + (circle.calcPlainArea() == sumOfAllShapesArea));
    }
}
