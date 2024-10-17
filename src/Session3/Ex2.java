package Session3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] mang = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0};
        int N = mang.length;

        System.out.println("Mảng ban đầu: " + Arrays.toString(mang));

        System.out.print("Nhập giá trị cần chèn (x): ");
        int X = scanner.nextInt();

        System.out.print("Nhập vị trí cần chèn (index): ");
        int index = scanner.nextInt();

        if (index < 0 || index > N - 1) {
            System.err.println("Không thể chèn phần tử vào mảng.");
            return;
        }

        // dich chuyen cac phan tu tu vi tri chen ve sau sang phai 1 vi tri
        for (int i = N - 1; i > index; i--) {
            mang[i] = mang[i - 1];
        }

        mang[index] = X;
        System.out.println("Mảng sau khi chèn: " + Arrays.toString(mang));
        scanner.close();


    }
}
