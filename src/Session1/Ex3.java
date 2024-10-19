package Session1;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào cạnh hình vuông: ");
        float edgeSquare = Float.parseFloat(scanner.nextLine());
        double perimeter = 4 * edgeSquare;
        double area = edgeSquare * edgeSquare;
        System.out.printf("Chu vi hình vuông là: %.2f\n", perimeter);
        System.out.printf("Diện tích hình vuông là: %.2f", area);
    }
}
