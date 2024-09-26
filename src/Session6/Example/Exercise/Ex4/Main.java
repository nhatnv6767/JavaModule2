package Session6.Example.Exercise.Ex4;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("blue", 50, 40);
        Circle circle = new Circle("orange", 55);

        System.out.println("Diện tích hình chữ nhật: " + rectangle.getArea());
        rectangle.display();

        System.out.println("Diện tích hình tròn: " + circle.getArea());
        circle.display();
    }
}
