package ExercisePlus.Ex1;

import java.util.List;
import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float calculateInterest() {
        return exportPrice - importPrice;
    }

    public void inputData(Scanner scanner, List<Book> bookList) {
        boolean isValid;
        int count = 1;
        System.out.printf("------------Thông tin sách thứ %d --------------", count);
        do {
            isValid = true;
            System.out.print("Nhập mã sách (bắt đầu bằng 'B' và có 4 ký tự): ");
            this.bookId = scanner.nextLine();

            if (!this.bookId.startsWith("B") || this.bookId.length() != 4) {
                isValid = false;
                System.out.println("Mã sách không hợp lệ. Vui lòng nhập lại!");
            } else {
                for (Book existingBook : bookList) {
                    if (existingBook.getBookId().equalsIgnoreCase(this.bookId)) {
                        isValid = false;
                        System.out.println("Mã sách đã tồn tại. Vui lòng nhập lại");
                        break;
                    }
                }
            }


        } while (!isValid);

        do {
            isValid = true;
            System.out.print("Nhập tên sách: ");
            this.bookName = scanner.nextLine();
            for (Book existingBook : bookList) {
                if (existingBook.getBookName().equalsIgnoreCase(this.bookName)) {
                    isValid = false;
                    System.out.println("Tên sách đã tồn tại. Vui lòng nhập lại!");
                    break;
                }
            }
        } while (!isValid);

        do {
            System.out.print("Nhập giá nhập sách: ");
            this.importPrice = Float.parseFloat(scanner.nextLine());
            if (this.importPrice <= 0) {
                System.out.println("Giá nhập phải lớn hơn 0. Vui lòng nhập lại!");
            }
        } while (this.importPrice <= 0);

        do {
            System.out.print("Nhập giá xuất sách: ");
            this.exportPrice = Float.parseFloat(scanner.nextLine());
            if (this.exportPrice < this.importPrice * 1.3) {
                System.out.println("Giá xuất phải lớn hơn ít nhất 30% so với giá nhập. Vui lòng nhập lại!");
            }
        } while (this.exportPrice < this.importPrice * 1.3);

        do {
            System.out.print("Nhập tên tác giả (6-50 ký tự): ");
            this.author = scanner.nextLine();
            if (this.author.length() < 6 || this.author.length() > 50) {
                isValid = false;
                System.out.println("Tên tác giả không hợp lệ. Vui lòng nhập lại!");
            }
        } while (!isValid);

        do {
            System.out.print("Nhập năm xuất bản: ");
            this.year = Integer.parseInt(scanner.nextLine());
            if (this.year <= 2000) {
                System.out.println("Năm xuất bản phải sau năm 2000. Vui lòng nhập lại!");
            }
            count++;
        } while (this.year <= 2000);

        this.interest = calculateInterest();

    }


    public void displayData() {
        System.out.println("---------------------------------");
        System.out.println("Mã sách: " + this.bookId);
        System.out.println("Tên sách: " + this.bookName);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);
        System.out.println("Tác giả: " + this.author);
        System.out.println("Lợi nhuận: " + this.interest);
        System.out.println("Năm xuất bản: " + this.year);
        System.out.println("---------------------------------");
    }

}
