package Session1;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float result = 0;
        System.out.print("Nhập điểm Toán: ");
        float score = Float.parseFloat(scanner.nextLine());
        result += score;
        System.out.print("Nhập điểm Lý: ");
        score = Float.parseFloat(scanner.nextLine());
        result += score;
        System.out.print("Nhập điểm Hoá: ");
        score = Float.parseFloat(scanner.nextLine());
        result += score;

        System.out.printf("Trung bình cộng điểm 3 môn: %.2f", result / 3);

    }
}
