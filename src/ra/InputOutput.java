package ra;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên: ");
        int soNguyen = scanner.nextInt();
        scanner.nextLine(); // Đọc và bỏ qua dấu xuống dòng còn lại

        System.out.print("Nhập chuỗi: ");
        String chuoi = scanner.nextLine();
    }
}
