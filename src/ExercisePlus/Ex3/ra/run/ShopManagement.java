package ExercisePlus.Ex3.ra.run;

import ExercisePlus.Ex3.ra.entity.Categories;
import ExercisePlus.Ex3.ra.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {

    }

    private void displayShopMenu() {
        System.out.println("******************SHOP MENU*******************");
        System.out.println("1. Quản lý danh mục sản phẩm");
        System.out.println("2. Quản lý sản phẩm");
        System.out.println("3. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private void displayCategoryMenu() {
        System.out.println("********************CATEGORIES MENU***********");
        System.out.println("1. Nhập thông tin các danh mục");
        System.out.println("2. Hiển thị thông tin các danh mục");
        System.out.println("3. Cập nhật thông tin danh mục");
        System.out.println("4. Xóa danh mục");
        System.out.println("5. Cập nhật trạng thái danh mục");
        System.out.println("6. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private void displayProductMenu() {
        System.out.println("*******************PRODUCT MANAGEMENT*****************");
        System.out.println("1. Nhập thông tin các sản phẩm");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Sắp xếp các sản phẩm theo giá");
        System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
        System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
        System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
        System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
        System.out.println("8. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private void handleCategoryMenu(Scanner scanner, Categories[] arrCategories, int categoryIndex) {
        while (true) {
            displayCategoryMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("===> 1. Nhập thông tin các danh mục");
                    break;
                case 2:
                    System.out.println("===> 2. Hiển thị thông tin các danh mục");
                    break;
                case 3:
                    System.out.println("===> 3. Cập nhật thông tin danh mục");
                    break;
                case 4:
                    System.out.println("===> 4. Xóa danh mục");
                    break;
                case 5:
                    System.out.println("===> 5. Cập nhật trạng thái danh mục");
                    break;
                case 6:
                    System.out.println("===> 6. Thoát");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void handleProductMenu(Scanner scanner, Product[] arrProduct, int productIndex, Categories[] arrCategories) {
        while (true) {
            displayProductMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("===> 1. Nhập thông tin các sản phẩm");
                    break;
                case 2:
                    System.out.println("===> 2. Hiển thị thông tin các sản phẩm");
                    break;
                case 3:
                    System.out.println("===> 3. Sắp xếp các sản phẩm theo giá");
                    break;
                case 4:
                    System.out.println("===> 4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
                    break;
                case 5:
                    System.out.println("===> 5. Xóa sản phẩm theo mã sản phẩm");
                    break;
                case 6:
                    System.out.println("===> 6. Tìm kiếm các sản phẩm theo tên sản phẩm");
                    break;
                case 7:
                    System.out.println("===> 7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
                    break;
                case 8:
                    System.out.println("===> 8. Thoát");
                    return;// quay lai menu chinh
                default:
                    System.err.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    // nhap nhieu san pham
    private void inputProducts(Scanner scanner, Product[] arrProduct, int productIndex, Categories[] arrCategories) {
        System.out.print("Nhập số lượng sản phẩm cần nhập: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
            Product product = new Product();
            product.inputData(scanner, arrProduct, productIndex, arrCategories);
            arrProduct[productIndex] = product;
            productIndex++;
        }
    }

    // hien thi thong tin cac san pham

}
