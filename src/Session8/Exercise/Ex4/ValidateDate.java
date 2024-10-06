package Session8.Exercise.Ex4;

import java.util.Scanner;

public class ValidateDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày tháng năm (dd/mm/yyyy): ");
        String dayMonthYear = scanner.nextLine();

        try {
            String[] parts = dayMonthYear.split("/");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Định dạng ngày tháng năm không hợp lệ.");
            }
            int day = Integer.parseInt(parts[0]);
            
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            validateDate(day, month, year);
            System.out.println("Ngày tháng năm hợp lệ.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void validateDate(int day, int month, int year) throws IllegalArgumentException {
        if (year < 0 || year > 2024) {
            throw new IllegalArgumentException("Năm không hợp lệ");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Tháng không hợp lệ");
        }
        int daysInMonth = findDayInMonth(month, year);
        if (day < 1 || day > daysInMonth) {
            throw new IllegalArgumentException("Ngày không hợp lệ");
        }

    }

    public static int findDayInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isNamNhuan(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;

        }
    }

    // check nam nhuan
    public static boolean isNamNhuan(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
