package Session4.Exercise.Ex3;

import java.util.Scanner;

public class Action {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double discriminant = equation.getDiscriminant();

        if (discriminant > 0) {
            System.out.println("Nghiệm thứ nhất: " + equation.getRoot1());
            System.out.println("Nghiệm thứ hai: " + equation.getRoot2());
        } else if (discriminant == 0) {
            System.out.println("Nghiệm kép: " + equation.getRoot1());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }

    }
}
