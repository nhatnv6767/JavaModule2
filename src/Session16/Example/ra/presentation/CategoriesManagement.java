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
                    updateCategories(scanner);
                    break;
                case 4:
                    deleteCategories(scanner);
                    break;
                case 5:
                    statisticCategories(scanner);
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui long chon tu 1 den 6");
            }
        } while (isExit);
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

    public static void updateCategories(Scanner scanner) {
        System.out.println("Nhap vao ma danh muc can cap nhat");
        int catalogId = Integer.parseInt(scanner.nextLine());
        // lay thong tin danh muc can cap nhat tu database
        Categories catalogUpdate = CategoriesBussiness.findById(catalogId);
        if (catalogUpdate != null) {
            // cho phep sua du lieu tren catalogUpdate
            boolean isExist = true;
            do {
                System.out.println("1. Cap nhat ten danh muc");
                System.out.println("2. Cap nhat mo ta danh muc");
                System.out.println("3. Cap nhat trang thai danh muc");
                System.out.println("4. Thoat");
                System.out.println("Lua chon cua ban");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        catalogUpdate.setCatalogName(scanner.nextLine());
                        break;
                    case 2:
                        catalogUpdate.setDescription(scanner.nextLine());
                        break;
                    case 3:
                        catalogUpdate.setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 4:
                        isExist = false;
                        break;
                    default:
                        System.err.println("Vui long chon tu 1 den 4");

                }
            } while (isExist);
            // cap nhat du lieu vao database

            boolean result = CategoriesBussiness.update(catalogUpdate);
            if (result) {
                System.out.println("Cap nhat thanh cong");
            } else {
                System.err.println("Cap nhat that bai");
            }

        } else {
            System.err.println("Ma danh muc khong ton tai");
        }
    }

    public static void deleteCategories(Scanner scanner) {
        System.out.println("Nhap vao ma danh muc can xoa");
        int catalogId = Integer.parseInt(scanner.nextLine());
        Categories catalogDelete = CategoriesBussiness.findById(catalogId);

        if (catalogDelete != null) {
            boolean result = CategoriesBussiness.delete(catalogId);
            if (result) {
                System.out.println("Xoa thanh cong");
            }
            System.err.println("Xoa that bai");
        } else {
            System.err.println("Ma danh muc khong ton tai");
        }
    }

    public static void statisticCategories(Scanner scanner) {
        System.out.println("Nhap trang thai danh muc can thong ke: ");
        boolean catalogStatus = Boolean.parseBoolean(scanner.nextLine());
        int cntCategories = CategoriesBussiness.statisticCategories(catalogStatus);
        System.out.printf("Co %d danh muc co trang thai la %b\n", cntCategories, catalogStatus);
    }
}
