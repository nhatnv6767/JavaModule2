package Session1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String yourName = scanner.nextLine();

        System.out.printf("Hello: %s", yourName);
    }
}
