package designpatterns.solid;

import java.util.List;

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Shape circle = new Circle(10);
        Shape rectange = new Rectangle(20, 20);
        Shape square = new Square(2);
        List<Shape> shapeList = List.of(circle, rectange, square);
        shapeList.forEach(shape -> System.out.println(shape.getArea()));
    }
}

abstract class Shape {
    abstract int getArea();
}

class Rectangle extends Shape {
    int length;
    int breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
     int getArea() {
        return this.length * this.breadth;
    }
}

class Circle extends Shape {

    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    int getArea() {
        return 22/7 * this.radius * this.radius;
    }
}

class Square extends Shape {

    int side;

    Square(int side) {
        this.side = side;
    }

    @Override
    int getArea() {
        return this.side * this.side;
    }
}