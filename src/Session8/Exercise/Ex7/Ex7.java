package Session8.Exercise.Ex7;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String input = scanner.nextLine();
        try {
            long intNumber = changeString(input);
            System.out.println("Chuỗi số nguyên sau khi chuyển: " + intNumber);
        } catch (IllegalArgumentException e) {
            System.err.println("Get error: " + e.getMessage());
        }
    }

    public static long changeString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String must not be null");
        }
        StringBuilder intNumber = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                intNumber.append(c);
            } else {
                intNumber.append('0');
            }
        }
        return Long.parseLong(intNumber.toString());
    }
}
