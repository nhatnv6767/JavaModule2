package Session16.Example.ra.presentation;

import Session16.Example.ra.bussiness.CategoriesBussiness;
import Session16.Example.ra.entity.Categories;

import java.util.List;
import java.util.Scanner;

public class CategoriesManagement {
    public static void displayMenuCategories(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("******** CATEGORIES MENU ****************");
            System.out.println("1. Danh sach danh muc");
            System.out.println("2. Them moi danh muc");
            System.out.println("3. Cap nhat danh muc");
            System.out.println("4. Xoa danh muc");
            System.out.println("5. Thong ke danh muc theo ma danh muc");
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban:");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayListCategories();
                    break;
                case 2:
                    createCategories(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui long chon tu 1 den 6");
            }
        } while (!isExit);
    }

    public static void displayListCategories() {
        List<Categories> listCategories = CategoriesBussiness.findAll();
        listCategories.forEach(System.out::println);
    }

    public static void createCategories(Scanner scanner) {
        Categories catalogNew = new Categories();
        System.out.println("Nhap vao ten danh muc: ");
        catalogNew.setCatalogName(scanner.nextLine());
        System.out.println("Nhap vao mo ta: ");
        catalogNew.setDescription(scanner.nextLine());
        System.out.println("Nhap vao trang thai (true/false): ");
        catalogNew.setStatus(Boolean.parseBoolean(scanner.nextLine()));

        boolean result = CategoriesBussiness.save(catalogNew);
        if (result) {
            System.out.println("Them moi thanh cong");
        } else {
            System.err.println("Them moi khong thanh cong");
        }
    }
}
