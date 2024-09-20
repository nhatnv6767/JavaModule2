package Session4.Exercise.Ex6;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();

        System.out.println("Bán kính của circle 1: " + circle1.getRadius());
        System.out.println("Diện tích của circle 1: " + circle1.getArea());
        Circle circle2 = new Circle(5.0);

        System.out.println("Bán kính của circle 2: " + circle2.getRadius());
        System.out.println("Diện tích của circle 2: " + circle2.getArea());
    }
}
