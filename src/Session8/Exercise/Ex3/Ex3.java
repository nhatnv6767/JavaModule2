package Session8.Exercise.Ex3;

import java.util.Random;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // random so luong phan tu cua mang (0 - 50)
        int n = random.nextInt(51) + 0;
        int[] arr = new int[n];

        // random cac gia tri so nguyen tu - 99 den 400
        System.out.print("Mảng được tạo: [");
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(400 + 99 + 1) - 99;
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        try {
            int max = findMax(arr);
            System.out.println("Max in array: " + max);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }

    public static int findMax(int[] numbers) throws IllegalArgumentException {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Mang khong duoc rong");
        }
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
