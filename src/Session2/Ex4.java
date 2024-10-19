package Session2;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int so1, so2;
        int tong = 0;

        do {
            System.out.println("");
            System.out.print("Nhập 2 số nguyên, cách nhau bởi dấu cách: ");
            String input = scanner.nextLine();

            String[] numberStr = input.split(" ");
            if (numberStr.length != 2) {
                System.out.println("Vui lòng nhập đúng 2 số");
                break;
            }
            so1 = Integer.parseInt(numberStr[0]);
            so2 = Integer.parseInt(numberStr[1]);

            int gioiHanDuoi = Math.min(so1, so2);
            int gioiHanTren = Math.max(so1, so2);

            for (int i = gioiHanDuoi; i <= gioiHanTren; i++) {
                if (i % 2 == 0) {
                    tong += i;
                }
            }
            System.out.printf("Tong cac so chan trong khoang tu %d den %d la %d", gioiHanDuoi, gioiHanTren, tong);

        } while (true);

    }
}
