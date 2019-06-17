package interview.online;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Triangle triangle = new Triangle(3, 5);
    Circle circle = new Circle(3);

    @Test
    public void test() {
        int result = triangle.GetArea();
        System.out.println(result);
    }

    @Test
    public void test2() {
        int result = circle.GetArea();
        System.out.println(result);
    }

}