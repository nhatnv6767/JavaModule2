package Session16.CataProdManagement.ra.presentation;

import java.util.Scanner;

public class EcommerceShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("********** ECOMMERCE SHOP ****************");
            System.out.println("1. Quan ly danh muc");
            System.out.println("2. Quan ly san pham");
            System.out.println("3. Thoat");
            System.out.println("Lua chon cua ban");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CategoriesManagement.displayMenuCategories(scanner);
                    break;
                case 2:
                    ProductManagement.displayMenuProduct(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui long chon tu 1 den 3");
            }
        } while (true);
    }
}
