package Session8.Exercise.Ex5;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String input = scanner.nextLine();
        try {
            String reversedString = reverseString2(input);
            System.out.println("Reversed string: " + reversedString);
        } catch (IllegalArgumentException e) {
            System.err.println("Chuỗi không hợp lệ: " + e.getMessage());
        }
    }

    public static String reverseString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Chuỗi không hợp lệ");
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static String reverseString2(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Chuỗi không hợp lệ");
        }

        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        return new String(chars);
    }
}
