package ExercisePlus.BTL1;

import java.time.Year;
import java.util.Scanner;

public class Book implements IEntity {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String description;
    private int categoryId;

    public Book() {
    }

    public Book(String id, String title, String author, String publisher, int year, String description, int categoryId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.description = description;
        this.categoryId = categoryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    private boolean isValidCategoryId(int categoryId) {
        for (Category category : Library.categories) {
            if (category.getId() == categoryId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void input(Scanner scanner) {
        do {
            System.out.print("Nhập mã sách (bắt đầu bằng 'B', 4 ký tự): ");
            id = scanner.nextLine();
        } while (!id.matches("^B\\w{3}$"));

        do {
            System.out.print("Nhập tiêu đề sách (6-50 ký tự): ");
            title = scanner.nextLine();
        } while (title.length() < 6 || title.length() > 50);

        System.out.print("Nhập tên tác giả: ");
        author = scanner.nextLine();

        System.out.print("Nhập nhà xuất bản: ");
        publisher = scanner.nextLine();

        int currentYear = Year.now().getValue();

        do {
            System.out.print("Nhập năm xuất bản (từ 1970 đến " + currentYear + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Năm xuất bản phải là số nguyên. Vui lòng nhập lại.");
                scanner.next();
            }
            year = scanner.nextInt();
            scanner.nextLine();
        } while (year < 1970 || year > currentYear);

        System.out.print("Nhập mô tả sách: ");
        description = scanner.nextLine();

        do {
            System.out.print("Nhập mã thể loại sách: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Mã thể loại phải là số nguyên. Vui lòng nhập lại.");
                scanner.next();
            }
            categoryId = scanner.nextInt();
            scanner.nextLine();

            if (!isValidCategoryId(categoryId)) {
                System.out.println("Mã thể loại không tồn tại. Vui lòng nhập lại.");
            }
        } while (!isValidCategoryId(categoryId));
    }

    private String getCategoryNameById(int categoryId) {
        for (Category category : Library.categories) {
            if (category.getId() == categoryId) {
                return category.getName();
            }
        }
        return "Không xác định";
    }

    @Override
    public void output() {
        String categoryName = getCategoryNameById(categoryId);
        System.out.println("Mã sách: " + id);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("NXB: " + publisher);
        System.out.println("Năm xuất bản: " + year);
        System.out.println("Thể loại: " + categoryName);
        System.out.println("Mô tả: " + description);
    }
}
