package ExercisePlus.Ex4.ra.run;

import ExercisePlus.Ex4.ra.entity.Employee;
import ExercisePlus.Ex4.ra.entity.Order;
import ExercisePlus.Ex4.ra.entity.Product;

import java.util.Scanner;

public class StoreManagement {
    private Product[] products = new Product[100];
    private Employee[] employees = new Employee[100];
    private Order[] orders = new Order[100];
    private int productCount = 0, employeeCount = 0, orderCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StoreManagement storeManagement = new StoreManagement();
        int choice;
        do {
            storeManagement.displayMainMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println();
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ");

            }
        } while (choice != 6);

    }

    private void displayMainMenu() {
        System.out.println("*********************STORE MANAGEMENT*****************");
        System.out.println("1. Quản lý sản phẩm");
        System.out.println("2. Quản lý nhân viên");
        System.out.println("3. Quản lý phiếu nhập");
        System.out.println("4. Quản lý phiếu xuất ");
        System.out.println("5. Báo cáo thống kê ");
        System.out.println("6. Thoát");
        System.out.print("Chọn chức năng: ");
    }


    // menu quan ly san pham
    private void displayProductManagementMenu() {
        System.out.println("********************PRODUCT MANAGEMENT***************");
        System.out.println("1. Nhập thông tin các sản phẩm");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Cập nhật thông tin sản phẩm");
        System.out.println("4. Tìm kiếm sản phẩm theo tên");
        System.out.println("5. Cập nhật trạng thái sản phẩm");
        System.out.println("6. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private void inputProducts(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm cần nhập: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Product product = new Product();
            product.inputData();
            products[productCount++] = product;
        }
    }

    private void displayProducts() {
        if (productCount == 0) {
            System.out.println("Chưa có sản phẩm nào.");
            return;
        }

        for (int i = 0; i < productCount; i++) {
            products[i].displayData();
            System.out.println("-------------------------------");
        }
    }

    private void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String productId = scanner.nextLine();
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductId().equals(productId)) {
                products[i].inputData();
                System.out.println("Cập nhật thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã " + productId);
    }

    private void displayEmployeeManagementMenu() {
        System.out.println("*******************EMPLOYEE MANAGEMENT*************");
        System.out.println("1. Nhập thông tin nhân viên");
        System.out.println("2. Hiển thị thông tin nhân viên");
        System.out.println("3. Cập nhật thông tin nhân viên");
        System.out.println("4. Tìm nhân viên theo tên nhân viên ");
        System.out.println("5. Cập nhật trạng thái của nhân viên");
        System.out.println("6. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private void displayReceiptManagementMenu(boolean isReceipt) {
        String title = isReceipt ? "RECEIPT MANAGEMENT" : "BILL MANAGEMENT";
        System.out.println("*******************" + title + "***************");
        System.out.println("1. Nhập thông tin phiếu " + (isReceipt ? "nhập" : "xuất"));
        System.out.println("2. Hiển thị thông tin phiếu " + (isReceipt ? "nhập" : "xuất"));
        System.out.println("3. Cập nhật thông tin phiếu " + (isReceipt ? "nhập" : "xuất"));
        System.out.println("4. Tìm phiếu " + (isReceipt ? "nhập" : "xuất") + " từ ngày đến ngày");
        System.out.println("5. Tìm phiếu " + (isReceipt ? "nhập" : "xuất") + " theo người tạo");
        System.out.println("6. Tìm phiếu " + (isReceipt ? "nhập" : "xuất") + " theo người cập nhật");
        System.out.println("7. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private void displayReportManagementMenu() {
        System.out.println("*******************REPORT MANAGEMENT****************");
        System.out.println("1. Thống kê các sản phẩm nhập từ ngày đến ngày");
        System.out.println("2. Thống kê các sản phẩm xuất từ ngày đến ngày");
        System.out.println("3. Thống kê doanh thu từ ngày đến ngày (theo các phiếu xuất) ");
        System.out.println("4. Thống kê chi phí từ ngày đến ngày (theo các phiếu nhập) ");
        System.out.println("5. Thống kê phiếu thu theo các tháng");
        System.out.println("6. Thống kê chi phí theo các tháng");
        System.out.println("7. Thoát");
        System.out.print("Chọn chức năng: ");
    }
}
