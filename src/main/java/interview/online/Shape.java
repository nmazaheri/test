package interview.online;

public interface Shape {
    int GetArea();
}

class Rectangle implements Shape {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public int GetArea() {
        return height * width;
    }
}

class Triangle implements Shape {
    private int height;
    private int width;

    public Triangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public int GetArea() {
        return (height * width) / 2;
    }
}

class Circle implements Shape {
    private static double pi = 3.14;
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int GetArea() {
        double exactArea = radius * radius * pi;
        return (int) Math.round(exactArea);
    }
}

