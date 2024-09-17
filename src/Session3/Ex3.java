package Session3;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập kích thước của mảng 1: ");
        int sizeArr1 = scanner.nextInt();
        int[] arr1 = new int[sizeArr1];
        setArray(arr1, scanner, "1");

        System.out.print("Nhập kích thước của mảng 2: ");
        int sizeArr2 = scanner.nextInt();
        int[] arr2 = new int[sizeArr2];
        setArray(arr2, scanner, "1");


        int[] arr3 = new int[sizeArr1 + sizeArr2];

        // arr1: day la mang nguon, cac phan tu o trong nay se duoc sao chep
        // 0: Chi dinh vi tri bat dau sao chep trong mang nguon
        // mang 3: mang dich, noi cac phan tu se duoc sao chep den
        // 0: chi dinh vi tri bat dau chen cac phan tu sao chep vao mang dich'
        // sizeArr1: xac dinh so luong phan tu can sao chep tu mang nguon
        System.arraycopy(arr1, 0, arr3, 0, sizeArr1);
        System.arraycopy(arr2, 0, arr3, sizeArr1, sizeArr2);

        System.out.print("Mảng sau khi gộp: ");
        getArray(arr3);

    }

    public static void setArray(int[] mang, Scanner scanner, String tenMang) {
        System.out.println("Nhập các phần tử của mảng " + tenMang + ":");
        for (int i = 0; i < mang.length; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            mang[i] = scanner.nextInt();
        }
    }

    public static void getArray(int[] mang) {
        for (int phanTu : mang) {
            System.out.print(phanTu + " ");
        }
        System.out.println();
    }
}
