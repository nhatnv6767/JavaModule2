package Session8.Exercise.Ex6;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray;
        System.out.println("Nhập các phần tử của mảng, cách nhau bởi dấu cách:");
        String input = scanner.nextLine();
        inputArray = input.split(" ");
        try {
            int sum = sumArrayInteger(inputArray);
            System.out.println("Tổng các phần tử trong mảng là: " + sum);
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }

    public static int sumArrayInteger(String[] arr) {
        int sum = 0;
        for (String str : arr) {
            try {
                int num = Integer.parseInt(str);
                sum += num;
            } catch (NumberFormatException e) {
                System.err.println("Phần tử '" + str + "' không phải là số nguyên. Bỏ qua phần tử này.");
            }
        }
        return sum;
    }
}
