package ExercisePlus.BTL1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    public static ArrayList<Category> categories = new ArrayList<>();
    public static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            library.displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("===> 1. Quản lý Thể loại ");
                    library.manageCategories(scanner);
                    break;
                case 2:
                    System.out.println("===> 2. Quản lý Sách");
                    library.manageBooks(scanner);
                    break;
                case 3:
                    System.err.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");

            }
        } while (choice != 3);
    }

    public void displayMainMenu() {
        System.out.println("===== QUẢN LÝ THƯ VIỆN =====\n" +
                "1. Quản lý Thể loại\n" +
                "2. Quản lý Sách\n" +
                "3. Thoát");
        System.out.print("\nLựa chọn của bạn: ");
    }

    public void manageCategories(Scanner scanner) {
        int choice;

        do {
            displayCategoryMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("======> 1. Thêm mới thể loại");
                    addNewCategory(scanner);
                    break;
                case 2:
                    System.out.println("======> 2. Hiển thị danh sách theo tênA–Z");
                    displayCategoriesByNameAZ();
                    break;
                case 3:
                    System.out.println("======> 3. Thống kê thể loại và số sách có trong mỗi thể loại");
                    break;
                case 4:
                    System.out.println("======> 4. Cập nhật thể loại");
                    break;
                case 5:
                    System.out.println("======> 5. Xóa thể loại");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }

    public void displayCategoryMenu() {
        System.out.println("===== QUẢN LÝ THỂ LOẠI =====\n" +
                "1. Thêm mới thể loại\n" +
                "2. Hiển thị danh sách theo tênA–Z\n" +
                "3. Thống kê thể loại và số sách có trong mỗi thể loại\n" +
                "4. Cập nhật thể loại\n" +
                "5. Xóa thể loại\n" +
                "6. Quay lại");
        System.out.print("\nLựa chọn của bạn: ");
    }

    private void manageBooks(Scanner scanner) {
        int choice;

        do {
            displayBookMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("======> 1. Thêm mới sách");
                    break;
                case 2:
                    System.out.println("======> 2. Cập nhật thông tin sách");
                    break;
                case 3:
                    System.out.println("======> 3. Xóa sách");
                    break;
                case 4:
                    System.out.println("======> 4. Tìm kiếm sách");
                    break;
                case 5:
                    System.out.println("======> 5. Hiển thị danh sách sách theo nhóm thể loại");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }

    public void displayBookMenu() {
        System.out.println("===== QUẢN LÝ SÁCH =====\n" +
                "1. Thêm mới sách\n" +
                "2. Cập nhật thông tin sách\n" +
                "3. Xóa sách\n" +
                "4. Tìm kiếm sách\n" +
                "5. Hiển thị danh sách sách theo nhóm thể loại\n" +
                "6. Quay lại");
        System.out.print("\nLựa chọn của bạn: ");
    }


    // all functions
    // add new category
    private void addNewCategory(Scanner scanner) {
        Category newCategory = new Category();
        newCategory.input(scanner);

        if (!isCategoryIdUnique(newCategory.getId()) || !isCategoryNameUnique(newCategory.getName())) {
            System.err.println("Mã thể loại hoặc tên thể loại đã tồn tại. Thêm mới không thành công.");
            return;
        }

        categories.add(newCategory);
        saveCategoriesToFile();
        System.out.println("Thêm mới thể loại thành công.");
    }

    private boolean isCategoryIdUnique(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return false;
            }
        }
        return true;
    }

    private boolean isCategoryNameUnique(String name) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    private void saveCategoriesToFile() {
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + "/src/ExercisePlus/BTL1/categories.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Category category : categories) {
                writer.write(category.getId() + "," + category.getName() + "," + category.isStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu dữ liệu vào file: " + e.getMessage());
        }
    }

    // display categories A-Z
    private void displayCategoriesByNameAZ() {
        if (categories.isEmpty()) {
            System.out.println("Danh sách thể loại trống.");
            return;
        }

        categories.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        System.out.println("Danh sách thể loại theo tên (A-Z):");
        for (Category category : categories) {
            category.output();
            System.out.println("--------------------");
        }
    }

}
