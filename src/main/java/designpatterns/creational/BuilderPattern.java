package designpatterns.creational;

/**
 * 1. Create the Outer Class with Default Constructor with Parameter of a Static Class and declare all members with private
 * 2. Create the Static Builder Class with same number of attributes as like outer class and declare separate method
 * for each attributes and provide a method as build returning the current object
 */
public class BuilderPattern {

    public static void main(String[] args) {
        Builder builder = new Builder.CustomBuilder().age(10).name("name").build();
        System.out.println(builder);

        Builder builder1 = new Builder.CustomBuilder().age(10).build();
        System.out.println(builder1);
    }
}

class Builder {
    private Integer age;
    private String name;

    Builder(CustomBuilder customBuilder) {
        this.age = customBuilder.age;
        this.name = customBuilder.name;
    }

    public static class CustomBuilder  {
        private Integer age;
        private String name;
        public CustomBuilder age(Integer age) {
            this.age = age;
            return this;
        }
        public CustomBuilder name(String name) {
            this.name = name;
            return this;
        }
        public Builder build() {
            return new Builder(this);
        }
    }

    @Override
    public String toString() {
        return "Builder{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
