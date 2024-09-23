package ExercisePlus.Ex3.ra.run;

import ExercisePlus.Ex3.ra.entity.Categories;
import ExercisePlus.Ex3.ra.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Categories[] arrCategories = new Categories[100];
        Product[] arrProducts = new Product[100];
        int categoryIndex = 0;
        int productIndex = 0;

        ShopManagement shopManagement = new ShopManagement();
        // menu chinh
        while (true) {
            shopManagement.displayShopMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    shopManagement.handleCategoryMenu(scanner, arrCategories, categoryIndex, arrProducts);
                    break;
                case 2:
                    shopManagement.handleProductMenu(scanner, arrProducts, productIndex, arrCategories);
                    break;
                case 3:
                    System.err.println("Kết thúc chương trình.");
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ.");

            }
        }
    }

    private void displayShopMenu() {
        System.out.println("******************SHOP MENU*******************");
        System.out.println("1. Quản lý danh mục sản phẩm");
        System.out.println("2. Quản lý sản phẩm");
        System.out.println("3. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }


    // MENU PRODUCT
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

    private void handleProductMenu(Scanner scanner, Product[] arrProduct, int productIndex, Categories[] arrCategories) {
        while (true) {
            displayProductMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("===> 1. Nhập thông tin các sản phẩm");
                    inputProducts(scanner, arrProduct, productIndex, arrCategories);
                    productIndex++;
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

    // MENU CATEGORIES
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

    private void handleCategoryMenu(Scanner scanner, Categories[] arrCategories, int categoryIndex, Product[] arrProduct) {
        while (true) {
            displayCategoryMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("===> 1. Nhập thông tin các danh mục");
                    inputCategories(scanner, arrCategories, categoryIndex);
                    categoryIndex = getNextAvailableCategoryIndex(arrCategories);// chuyen ve vi tri index phu hop
                    break;
                case 2:
                    System.out.println("===> 2. Hiển thị thông tin các danh mục");
                    displayCategories(arrCategories);
                    break;
                case 3:
                    System.out.println("===> 3. Cập nhật thông tin danh mục");
                    updateCategory(scanner, arrCategories);
                    break;
                case 4:
                    System.out.println("===> 4. Xóa danh mục");
                    deleteCategory(scanner, arrCategories, arrProduct);
                    break;
                case 5:
                    System.out.println("===> 5. Cập nhật trạng thái danh mục");
                    updateCategoryStatus(scanner, arrCategories);
                    break;
                case 6:
                    System.err.println("===> 6. Thoát");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void inputCategories(Scanner scanner, Categories[] arrCategories, int categoryIndex) {
        System.out.print("Nhập số lượng danh mục cần nhập: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            if (categoryIndex < arrCategories.length) {
                System.out.println("Nhập thông tin danh mục thứ " + (i + 1) + ":");
                Categories category = new Categories();
                category.inputData(scanner, arrCategories, categoryIndex);
                arrCategories[categoryIndex] = category;
                categoryIndex++;
            } else {
                System.out.println("Đã đạt giới hạn số lượng danh mục.");
                break;
            }
        }
    }

    private void displayCategories(Categories[] arrCategories) {
        if (isCategoryArrayEmpty(arrCategories)) {
            System.out.println("Không có danh mục nào.");
            return;
        }

        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories[i] != null) {
                System.out.println("Thông tin danh mục thứ " + (i + 1) + ":");
                arrCategories[i].displayData();
                System.out.println("----------------------");
            }
        }
    }

    // cap nhat thong tin danh muc
    private void updateCategory(Scanner scanner, Categories[] arrCategories) {
        System.out.print("Nhập mã danh mục cần cập nhật: ");
        int categoryId = Integer.parseInt(scanner.nextLine());
        int index = findCategoryIndexById(arrCategories, categoryId);
        if (index != -1) {
            arrCategories[index].displayData();
            System.out.println("Nhập thông tin mới cho danh mục");
            arrCategories[index].inputData(scanner, arrCategories, index);
            System.out.println("Cập nhật danh mục thành công");
        } else {
            System.err.println("Không tìm thấy danh mục có mã " + categoryId);
        }
    }

    private void deleteCategory(Scanner scanner, Categories[] arrCategories, Product[] arrProduct) {
        System.out.print("Nhập mã danh mục cần xóa: ");
        int categoryId = Integer.parseInt(scanner.nextLine());
        int index = findCategoryIndexById(arrCategories, categoryId);
        if (index != -1) {
            arrCategories[index].displayData();
            if (!isCategoryContainProduct(arrCategories[index], arrProduct)) {
                arrCategories[index] = null;
                System.out.println("Xóa danh mục thành công!");
            } else {
                System.err.println("Không thể xóa danh mục vì danh mục này chứa sản phẩm.");
            }
        } else {
            System.err.println("Không tìm thấy danh mục có mã " + categoryId);
        }
    }

    private void updateCategoryStatus(Scanner scanner, Categories[] arrCategories) {
        System.out.print("Nhập mã danh mục cần cập nhật trạng thái: ");
        int categoryId = Integer.parseInt(scanner.nextLine());
        int index = findCategoryIndexById(arrCategories, categoryId);
        if (index != -1) {
            arrCategories[index].displayData();
            arrCategories[index].setCatalogStatus(!arrCategories[index].isCatalogStatus());
            System.out.println("Cập nhật trạng thái danh mục thành công!");
        } else {
            System.err.println("Không tìm thấy danh mục có mã " + categoryId);
        }
    }

    // tim chi so cua danh muc theo ma danh muc
    private int findCategoryIndexById(Categories[] arrCategories, int categoryId) {
        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories[i] != null && arrCategories[i].getCatalogId() == categoryId) {
                return i;
            }
        }
        return -1;
    }

    // kiem tra xem danh muc co chua san pham khong
    private boolean isCategoryContainProduct(Categories category, Product[] arrProduct) {
        for (Product product : arrProduct) {
            if (product != null && product.getCatalogId() == category.getCatalogId()) {
                return true;
            }
        }
        return false;
    }

    // tim chi so kha dung tiep theo trong mang danh muc
    private int getNextAvailableCategoryIndex(Categories[] arrCategories) {
        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories[i] == null) {
                return i;
            }
        }
        return -1; // Mang da day
    }

    private boolean isCategoryArrayEmpty(Categories[] arrCategories) {
        for (Categories category : arrCategories) {
            if (category != null) {
                return false;
            }
        }
        return true;
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
    private void displayProducts(Product[] arrProduct, int productIndex) {
        if (productIndex == 0) {
            System.out.println("Không có sản phẩm nào.");
            return;
        }
        for (int i = 0; i < productIndex; i++) {
            System.out.println("Thông tin sản phẩm thứ " + (i + 1) + ":");
            arrProduct[i].displayData();
            System.out.println("----------------------");
        }
    }

}
