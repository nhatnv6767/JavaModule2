package Session2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (0 -> 9): ");
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 0:
                System.out.println("Number zero");
                break;
            case 1:
                System.out.println("Number one");
                break;
            case 2:
                System.out.println("Number two");
                break;
            case 3:
                System.out.println("Number three");
                break;
            case 4:
                System.out.println("Number four");
                break;
            case 5:
                System.out.println("Number five");
                break;
            case 6:
                System.out.println("Number six");
                break;
            case 7:
                System.out.println("Number seven");
                break;
            case 8:
                System.out.println("Number eight");
                break;
            case 9:
                System.out.println("Number nine");
                break;
            default:
                System.out.println("Invalid number");
                break;
        }
    }
}
