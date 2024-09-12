package Session1;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        final float PI = 3.14F;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nập vào bán kính hình tròn: ");
        float r = Float.parseFloat(scanner.nextLine());
        System.out.printf("Chu vi hình tròn: %.2f - Dện tích hình tròn: %.2f", 2 * PI * r, PI * r * r);
    }
}
