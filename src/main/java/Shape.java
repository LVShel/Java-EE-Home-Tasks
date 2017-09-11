/**
 * Created by Home on 11.09.2017.
 */
public interface Shape {
    double calcArea();
    default void init(){
        System.out.println("I'm a shape " + getClass().getName());
    }
}
