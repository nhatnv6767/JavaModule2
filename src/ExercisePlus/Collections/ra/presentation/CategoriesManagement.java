package ExercisePlus.Collections.ra.presentation;

import ExercisePlus.Collections.ra.businessImp.Categories;
import ExercisePlus.Collections.ra.businessImp.Product;

import java.util.List;
import java.util.Scanner;

public class CategoriesManagement {
    private List<Categories> categoriesList;
    private List<Product> productList;

    public CategoriesManagement(List<Categories> categoriesList, List<Product> productList) {
        this.categoriesList = categoriesList;
        this.productList = productList;
    }

    public void displayCategoriesMenu() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("********************CATEGORIES MENU********************\n" +
                    "1. Danh sách danh mục\n" +
                    "2. Thêm mới danh mục\n" +
                    "3. Cập nhật thông tin danh mục (Cập nhật theo mã)\n" +
                    "4. Xóa danh mục (Chỉ cho phép xóa danh mục chưa có sản phẩm)\n" +
                    "5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayCategoriesList();
                    break;
                case 2:
                    addNewCategory(scanner);
                    break;
                case 3:
                    updateCategory(scanner);
                    break;
                case 4:
                    deleteCategory(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }

    private void displayCategoriesList() {
        if (categoriesList.isEmpty()) {
            System.err.println("Danh sách danh mục trống.");
            return;
        }
        for (Categories category : categoriesList) {
            category.displayData();
            System.out.println("--------------------------------");
        }
    }

    private void addNewCategory(Scanner scanner) {
        Categories newCategory = new Categories();
        newCategory.inputData(scanner);
        categoriesList.add(newCategory);
        System.out.println("Thêm mới danh mục thành công.");
    }

    private void updateCategory(Scanner scanner) {
        System.out.print("Nhập mã danh mục cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Categories category : categoriesList) {
            if (category.getId() == id) {
                category.inputData(scanner);
                System.out.println("Cập nhật danh mục thành công.");
                return;
            }
        }
        System.err.printf("Danh mục %d không tồn tại.\n", id);
    }

    private void deleteCategory(Scanner scanner) {
        System.out.print("Nhập mã danh mục cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Categories category : categoriesList) {
            if (category.getId() == id) {
                if (isCategoryUsed(id)) {
                    System.err.println("Không thể xóa danh mục đã có sản phẩm!");
                    return;
                }
                categoriesList.remove(category);
                System.out.println("Xóa danh mục thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục có mã " + id);
    }

    private boolean isCategoryUsed(int categoryId) {
        for (Product product : productList) {
            if (product.getCatalogId() == categoryId) {
                return true;
            }
        }
        return false;
    }
}
