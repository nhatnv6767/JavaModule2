package Session8.Example;

import java.util.Scanner;

public class Exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so nguyen thu nhat:");
        int firstNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap so nguyen thu hai:");
        int secondNumnber = Integer.parseInt(scanner.nextLine());
        int div = firstNumber / secondNumnber;
        System.out.printf("Ket qua cua phep chia giua %d va %d la: %d\n", firstNumber, secondNumnber, div);

    }
}
