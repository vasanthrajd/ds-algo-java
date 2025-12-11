package designpatterns.creational;

public class ProtoTypePattern {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        ShapeClient shapeClient = new ShapeClient(circle);
        System.out.println(shapeClient);
        Shape prototypeClient = shapeClient.createShapePrototype();
        System.out.println(prototypeClient);
    }
}

interface Shape {
    Shape prototype();
    void draw();
}

class Circle implements Shape {

    public Circle() {

    }

    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public Shape prototype() {
        return new Circle(this.color);
    }

    @Override
    public void draw() {
        System.out.println("Circle is drawn for the Color " + this.color);
    }
}

class Rectangle implements Shape {

    private String color;

    public Rectangle(String color) {
        this.color = color;
    }

    @Override
    public Shape prototype() {
        return new Rectangle(this.color);
    }

    @Override
    public void draw() {
        System.out.println("Rectangle is drawn for the Color " + this.color);
    }
}

class ShapeClient {
    private Shape shapeClient;

    public ShapeClient(Shape shapePrototype) {
        this.shapeClient = shapePrototype;
    }

    public Shape createShapePrototype() {
        return shapeClient.prototype();
    }
}