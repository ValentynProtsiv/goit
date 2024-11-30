public abstract class Shape{
    public abstract String getName();
}
class Circle extends Shape {
    private final String name;
    public Circle(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}
class Square extends Shape {
    private final String name;
    public Square(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}
class Triangle extends Shape {
    private final String name;
    public Triangle(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}
class Rectangle extends Shape {
    private final String name;
    public Rectangle(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}
class Quad extends Shape{
    private final String name;
    public Quad(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}
class ShapePrinter{
        public void printShape(Shape shape){
            System.out.println(shape.getName());
        }

    public static void main(String[] args) {
        ShapePrinter shapePrinter = new ShapePrinter();

        Circle circle = new Circle("Circle");
        Square square = new Square("Square");
        Triangle triangle = new Triangle("Triangle");
        Rectangle rectangle = new Rectangle("Rectangle");
        Quad quad = new Quad("Quad");

        shapePrinter.printShape(circle);
        shapePrinter.printShape(square);
        shapePrinter.printShape(triangle);
        shapePrinter.printShape(rectangle);
        shapePrinter.printShape(quad);
    }
}