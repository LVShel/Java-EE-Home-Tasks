/**
 * Created by Leonid Shelest on 11.09.2017.
 */
public class Rectangle implements Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        init();
    }

    public Rectangle() {
    }

    @Override
    public double calcArea() {
        //In the current application it is defined that rectangle doesn't have any shapes
        //inside, so it's area remains plain
        return calcPlainArea();
    }

    @Override
    public double calcPlainArea() {
        return height * width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
