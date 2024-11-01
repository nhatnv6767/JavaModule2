package Session16.LibraryManagement.ra.Validation;

import Session16.LibraryManagement.ra.DAO.BookTypeBusiness;

import java.util.Scanner;

public class BookValidator {
    private BookTypeBusiness bookTypeBusiness;

    public BookValidator(BookTypeBusiness bookTypeBusiness) {
        this.bookTypeBusiness = bookTypeBusiness;
    }

    public String getNonEmptyStringInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Không được để trống");
            }
        } while (input.isEmpty());
        return input;
    }

    public int getPositiveIntInput(Scanner scanner, String prompt) {
        int input;
        do {
            System.out.print(prompt);
            input = getIntInput(scanner);
            if (input <= 0) {
                System.err.println("Giá trị phải là số nguyên lớn hơn 0");
            }
        } while (input <= 0);
        return input;
    }

    public double getPositiveDoubleInput(Scanner scanner, String prompt) {
        double input;
        do {
            System.out.print(prompt);
            input = getDoubleInput(scanner);
            if (input <= 0) {
                System.err.println("Giá trị phải là số thực lớn hơn 0");
            }
        } while (input <= 0);
        return input;
    }

    public int getValidTypeId(Scanner scanner, String prompt) {
        int typeId;
        do {
            System.out.print(prompt);
            typeId = getIntInput(scanner);
            if (bookTypeBusiness.get(typeId) == null) {
                System.err.println("Mã loại sách không tồn tại");
            }
        } while (bookTypeBusiness.get(typeId) == null);
        return typeId;
    }

    private int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên");
            }
        }
    }

    private double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số thực");
            }
        }
    }
}
