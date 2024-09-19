package Session4.Exercise.Ex2;

/*
 * Thuộc tính:
 * - radius: kiểu double
 * */

import java.util.Scanner;

public class Employee {
    private double radius;
    private String color;

    public Employee() {
        this.radius = 0.0;
        this.color = "đỏ";
    }

    public Employee(double radius, String color) {
        if (radius < 0) {
            throw new IllegalArgumentException("radius must be positive");
        }
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) throw new IllegalArgumentException("radius must be positive");
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double chuVi() {
        return 2 * Math.PI * radius;
    }

    public double dienTich() {
        return Math.PI * radius * radius;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập bán kính: ");
            radius = scanner.nextDouble();
            scanner.nextLine();
            if (radius < 0) {
                System.out.println("Bán kính không thể âm. Xin vui lòng nhập lại");
            }
        } while (radius < 0);

        System.out.print("Nhập màu sắc: ");
        color = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("Bán kính: " + radius);
        System.out.println("Màu sắc: " + color);
    }
}
