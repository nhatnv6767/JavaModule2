package ExercisePlus.Collections.ra.main;

import ExercisePlus.Collections.ra.businessImp.Categories;
import ExercisePlus.Collections.ra.businessImp.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Categories> categoriesList = new ArrayList<>();
        List<Product> productsList = new ArrayList<>();
        do {
            System.out.println("********************SHOP MENU*********************\n" +
                    "1. Quản lý danh mục sản phẩm\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            boolean isValidInput = false;
            int choice = 0;
            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1 || choice == 2 || choice == 3) {
                        isValidInput = true;
                    } else {
                        isValidInput = false;
                    }
                } catch (NumberFormatException e) {
                    scanner.next();
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn lại <catch>");
                    isValidInput = false;
                }
            } while (!isValidInput);

            switch (choice) {
                case 1:
                    System.out.println("===> 1. Quản lý danh mục sản phẩm");
                    break;
                case 2:
                    System.out.println("===> 2. Quản lý sản phẩm");
                    break;
                case 3:
                    System.err.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (true);
    }
}
