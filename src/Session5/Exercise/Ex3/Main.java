package Session5.Exercise.Ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài 3 cạnh của tam giác: ");
        double side1 = Double.parseDouble(scanner.nextLine());
        double side2 = Double.parseDouble(scanner.nextLine());
        double side3 = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập màu sắc của tam giác: ");
        String color = scanner.nextLine();

        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        System.out.println(triangle);
        
    }
}
