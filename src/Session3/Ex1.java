package Session3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] arr = {1, 5, 3, 7, 2, 9, 0};
        int lengArr = arr.length;

        System.out.print("Nhập phần tử cần xóa: ");
        int deleteElement = scanner.nextInt();

        int deleteIndex = -1;
        for (int i = 0; i < lengArr; i++) {
            if (arr[i] == deleteElement) {
                deleteIndex = i;
                break;
            }
        }

        // xoa phan tu neu tim thay
        if (deleteIndex != -1) {
            for (int i = deleteIndex; i < lengArr - 1; i++) {
                arr[i] = arr[i + 1];
            }
            lengArr--;
            arr[lengArr] = 0;

//            System.out.println("Mảng sau khi xóa: " + Arrays.toString(Arrays.copyOf(arr, lengArr)));
            System.out.println("Mảng sau khi xóa: " + Arrays.toString(Arrays.copyOf(arr, lengArr + 1)));
        } else {
            System.out.println("Phần tử không tồn tại trong mảng.");
        }
    }
}
