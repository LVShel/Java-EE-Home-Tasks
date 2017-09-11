/**
 * Created by Leonid Shelest on 11.09.2017.
 */
public class Circle implements Shape {
    private Rectangle rectangle;
    private Triangle triangle;
    private double radius;
    public static final double PI = Math.PI;

    public Circle(Rectangle rectangle, Triangle triangle, double radius) {
        this.rectangle = rectangle;
        this.triangle = triangle;
        this.radius = radius;
        init();
    }

    @Override
    public double calcArea() {
        double rectangleArea = rectangle.calcArea();
        double triangleArea = triangle.calcArea();
        return (PI * Math.pow(radius, 2)) - (rectangleArea + triangleArea);
    }

    public double calcPlainArea(){
        return PI * Math.pow(radius, 2);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
