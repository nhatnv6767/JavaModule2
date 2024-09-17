package Session3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] mang = {1, 5, 3, 7, 2, 9, 0};
        int kichThuoc = mang.length;

        System.out.print("Nhập phần tử cần xóa: ");
        int phanTuCanXoa = scanner.nextInt();

        int viTriXoa = -1;
        for (int i = 0; i < kichThuoc; i++) {
            if (mang[i] == phanTuCanXoa) {
                viTriXoa = i;
                break;
            }
        }

        // xoa phan tu neu tim thay
        if (viTriXoa != -1) {
            for (int i = viTriXoa; i < kichThuoc - 1; i++) {
                mang[i] = mang[i + 1];
            }
            kichThuoc--;
            mang[kichThuoc] = 0;

//            System.out.println("Mảng sau khi xóa: " + Arrays.toString(Arrays.copyOf(mang, kichThuoc)));
            System.out.println("Mảng sau khi xóa: " + Arrays.toString(Arrays.copyOf(mang, kichThuoc + 1)));
        } else {
            System.out.println("Phần tử không tồn tại trong mảng.");
        }
    }
}
