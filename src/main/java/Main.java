import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonid Shelest on 11.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        double sumOfAllShapesArea = 0;
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Shape rectangle = (Rectangle) context.getBean("rectangle");
        Shape triangle = (Triangle) context.getBean("triangle");
        Shape circle = (Circle) context.getBean("circle");

        shapes.add(rectangle);
        shapes.add(triangle);
        shapes.add(circle);

        shapes.forEach(s -> System.out.println(s.getClass().getName() + " area is " + s.calcArea()));
        sumOfAllShapesArea = shapes.stream().mapToDouble(Shape::calcArea).sum();

        System.out.println("Sum of all shapes area is " + sumOfAllShapesArea);
        System.out.println("Circle plain area is " + circle.calcPlainArea());
        System.out.println("Task completed successfully: " + (circle.calcPlainArea() == sumOfAllShapesArea));
    }
}
