package ExercisePlus.Collections.ra.main;

import ExercisePlus.Collections.ra.businessImp.Categories;
import ExercisePlus.Collections.ra.businessImp.Product;
import ExercisePlus.Collections.ra.presentation.CategoriesManagement;
import ExercisePlus.Collections.ra.presentation.ProductManagement;

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
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("===> 1. Quản lý danh mục sản phẩm");
                    CategoriesManagement categoriesManagement = new CategoriesManagement(categoriesList, productsList);
                    categoriesManagement.displayCategoriesMenu();
                    break;
                case 2:
                    System.out.println("===> 2. Quản lý sản phẩm");
                    ProductManagement productsManagement = new ProductManagement(categoriesList, productsList);
                    productsManagement.displayProductMenu();
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
