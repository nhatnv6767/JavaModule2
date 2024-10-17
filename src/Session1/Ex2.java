package Session1;


import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        final float RATE_CURRENCY = 24587.48f;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your money in USD: ");
        float amount = Float.parseFloat(scanner.nextLine());

        System.out.printf("%.2f $USD = %.2f VND ", amount, amount * RATE_CURRENCY);
    }
}
