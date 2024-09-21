package ExercisePlus.Ex1;

import java.util.*;

public class BookImp {
    final static int exitMenu = 9;

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("*********************MENU******************");
            System.out.println("1. Nhập thông tin n sách (n nhập từ bàn phím)");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sách (n): ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Book book = new Book();
                        book.inputData(scanner, bookList);
                        bookList.add(book);
                    }
                    break;
                case 2:
                    System.out.println("Lợi nhuận của tất cả các sách đã được tính khi nhập.");
                    break;
                case 3:
                    if (bookList.isEmpty()) {
                        System.out.println("Danh sách sách trống.");
                    } else {
                        for (Book book : bookList) {
                            book.displayData();
                        }
                    }
                    break;
                case 4:

                    Collections.sort(bookList, Comparator.comparingDouble(Book::getExportPrice));
                    System.out.println("Danh sách sách đã được sắp xếp theo giá bán tăng dần.");
                    for (Book book : bookList) {
                        book.displayData();
                    }
                    break;
                case 5:
                    Collections.sort(bookList, (book1, book2) -> Double.compare(book2.getInterest(), book1.getInterest()));
                    System.out.println("Danh sách sách đã được sắp xếp theo lợi nhuận giảm dần.");
                    for (Book book : bookList) {
                        book.displayData();
                    }
                    break;
                case 6:
                    System.out.print("Nhập tên sách cần tìm: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (Book book : bookList) {
                        if (book.getBookName().equalsIgnoreCase(searchName)) {
                            book.displayData();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sách có tên: " + searchName);
                    }
                    break;
                case 7:
                    Map<Integer, Integer> yearCount = new HashMap<>();
                    for (Book book : bookList) {
                        yearCount.put(book.getYear(), yearCount.getOrDefault(book.getYear(), 0) + 1);
                    }
                    System.out.println("Thống kê số lượng sách theo năm xuất bản:");
                    for (Map.Entry<Integer, Integer> entry : yearCount.entrySet()) {
                        System.out.println("Năm " + entry.getKey() + ": " + entry.getValue() + " cuốn.");
                    }
                    break;
                case 8:
                    Map<String, Integer> authorCount = new HashMap<>();
                    for (Book book : bookList) {
                        authorCount.put(book.getAuthor(), authorCount.getOrDefault(book.getAuthor(), 0) + 1);
                    }
                    System.out.println("Thống kê số lượng sách theo tên tác giả:");
                    for (Map.Entry<String, Integer> entry : authorCount.entrySet()) {
                        System.out.println("Tác giả " + entry.getKey() + ": " + entry.getValue() + " cuốn.");
                    }
                    break;
                case 9:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }

        } while (choice != exitMenu);
    }
}
