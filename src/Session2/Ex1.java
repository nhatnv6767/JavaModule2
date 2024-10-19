package Session2;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = Integer.parseInt(scanner.nextLine());
        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("%d divisible by 3 and 5");
        } else {
            System.out.printf("%d not divisible by 3 and 5", number);
        }
    }
}
