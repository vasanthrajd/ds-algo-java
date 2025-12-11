package designpatterns.creational;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AbstractFactoryPattern {
    public static void main(String[] args) {

    }
}

enum CarType {
    SEDAN,
    HATCHBACK,
    COUPE,
    SUV,
    MIDSUV,
    XUV
}

enum CarColors {
    WHITE("White"),
    BLACK("Black"),
    GREY("Grey"),
    BLUE("Blue"),
    RED("Red"),
    YELLOW("Yellow");

    private final String color;

    CarColors(String color) {
        this.color = color;
    }

    public String color() {
        return color;
    }
}

interface Car {
    CarType getCarType();
    Car createCar();
}

class SedanCar implements Car {

    private final Integer length;
    private final Integer width;
    private final Integer height;
    private final List<String> colors;

    @Override
    public CarType getCarType() {
        return CarType.SEDAN;
    }

    SedanCar() {
        this.length = 5;
        this.width = 4;
        this.height = 3;
        this.colors = List.of(CarColors.BLUE.color(), CarColors.WHITE.color(), CarColors.YELLOW.color());
    }

    @Override
    public Car createCar() {
        return new SedanCar();
    }
}

class HatchBackCar implements Car {

    private final Integer length;
    private final Integer width;
    private final Integer height;
    private final List<String> colors;

    @Override
    public CarType getCarType() {
        return CarType.SEDAN;
    }

    HatchBackCar() {
        this.length = 4;
        this.width = 4;
        this.height = 3;
        this.colors = List.of(CarColors.RED.color(), CarColors.WHITE.color());
    }

    @Override
    public Car createCar() {
        return new HatchBackCar();
    }
}

class SuvCar implements Car {
    private final Integer length;
    private final Integer width;
    private final Integer height;
    private final List<String> colors;

    @Override
    public CarType getCarType() {
        return CarType.SEDAN;
    }

    SuvCar() {
        this.length = 4;
        this.width = 4;
        this.height = 4;
        colors = new ArrayList<>();
        for (CarColors value : CarColors.values()) {
            colors.add(value.color());
        }
    }

    @Override
    public Car createCar() {
        return new SuvCar();
    }
}

interface CarFactory {
    Car createCar();
}

interface CarTypeFactory {
    Car makeCarByType(CarType carType);
}


class NACarFactory implements CarTypeFactory {

    private List<CarType> carTypes;

    public NACarFactory(List<CarType> carTypes) {
        carTypes = carTypes;
    }

    public List<CarType> getCarTypes() {
        return carTypes;
    }

    @Override
    public Car makeCarByType(CarType carType) {
        return null;
    }
}