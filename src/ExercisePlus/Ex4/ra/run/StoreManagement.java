package ExercisePlus.Ex4.ra.run;

import ExercisePlus.Ex4.ra.entity.Employee;
import ExercisePlus.Ex4.ra.entity.Order;
import ExercisePlus.Ex4.ra.entity.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StoreManagement {
    private Product[] products = new Product[100];
    private Employee[] employees = new Employee[100];
    private Order[] orders = new Order[100];
    private int productCount = 0, employeeCount = 0, orderCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StoreManagement storeManagement = new StoreManagement();

        // du lieu test nhanh
        storeManagement.createSampleProducts();
        storeManagement.createSampleEmployees();
        storeManagement.createSampleOrders();

        int choice;
        do {
            storeManagement.displayMainMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    storeManagement.productManagement(scanner);
                    break;
                case 2:
                    storeManagement.employeeManagement(scanner);
                    break;
                case 3:
                    storeManagement.receiptManagement(true, scanner);
                    break;
                case 4:
                    storeManagement.receiptManagement(false, scanner);
                    break;
                case 5:
                    storeManagement.reportManagement(scanner);
                    break;
                case 6:
                    System.err.println("Thoát chương trình...");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ");

            }
        } while (choice != 6);

    }

    private void createSampleProducts() {
        products[productCount++] = new Product("P001", "Sản phẩm A", "Nhà sản xuất X", true);
        products[productCount++] = new Product("P002", "Sản phẩm B", "Nhà sản xuất Y", false);
        products[productCount++] = new Product("P003", "Sản phẩm C", "Nhà sản xuất Z", true);
        products[productCount++] = new Product("P004", "Sản phẩm D", "Nhà sản xuất X", true);
        products[productCount++] = new Product("P005", "Sản phẩm E", "Nhà sản xuất Y", true);
        products[productCount++] = new Product("P006", "Sản phẩm F", "Nhà sản xuất Z", false);
        products[productCount++] = new Product("P007", "Sản phẩm G", "Nhà sản xuất X", true);
        products[productCount++] = new Product("P008", "Sản phẩm H", "Nhà sản xuất Y", false);
        products[productCount++] = new Product("P009", "Sản phẩm I", "Nhà sản xuất Z", true);
        products[productCount++] = new Product("P010", "Sản phẩm J", "Nhà sản xuất X", true);
    }

    // Hàm tạo dữ liệu mẫu cho nhân viên
    private void createSampleEmployees() {
        employees[employeeCount++] = new Employee("Nguyễn Văn A", 1990, "0901234567", "a@gmail.com", 0);
        employees[employeeCount++] = new Employee("Trần Thị B", 1995, "0939876543", "b@gmail.com", 1);
        employees[employeeCount++] = new Employee("Lê Văn C", 1985, "0898888888", "c@gmail.com", 0);
        employees[employeeCount++] = new Employee("Phạm Thị D", 1992, "0887777777", "d@gmail.com", 2);
        employees[employeeCount++] = new Employee("Hoàng Văn E", 1988, "0916666666", "e@gmail.com", 0);
        employees[employeeCount++] = new Employee("Vũ Thị F", 1997, "0945555555", "f@gmail.com", 1);
        employees[employeeCount++] = new Employee("Đỗ Văn G", 1980, "0964444444", "g@gmail.com", 0);
        employees[employeeCount++] = new Employee("Ngô Thị H", 1993, "0973333333", "h@gmail.com", 2);
        employees[employeeCount++] = new Employee("Dương Văn I", 1986, "0982222222", "i@gmail.com", 0);
        employees[employeeCount++] = new Employee("Trịnh Thị K", 1991, "0861111111", "k@gmail.com", 1);
    }

    private void createSampleOrders() {
        orders[orderCount++] = new Order(true, "P001", 10, 100.0f, 1, true);
        orders[orderCount++] = new Order(false, "P003", 5, 150.0f, 3, true);
        orders[orderCount++] = new Order(true, "P005", 8, 80.0f, 2, false);
        orders[orderCount++] = new Order(false, "P007", 3, 200.0f, 1, true);
        orders[orderCount++] = new Order(true, "P002", 12, 50.0f, 4, false);

        orders[orderCount++] = new Order(false, "P004", 7, 120.0f, 2, true);
        orders[orderCount++] = new Order(true, "P006", 20, 40.0f, 3, false);
        orders[orderCount++] = new Order(false, "P009", 1, 300.0f, 5, true);
        orders[orderCount++] = new Order(true, "P008", 6, 75.0f, 1, true);
        orders[orderCount++] = new Order(false, "P010", 4, 180.0f, 4, false);
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

    private void productManagement(Scanner scanner) {
        int choice;
        do {
            displayProductManagementMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {

                case 1:
                    inputProducts(scanner);
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    searchProductByName(scanner);
                    break;
                case 5:
                    updateProductStatus(scanner);
                    break;
                case 6:
                    System.err.println("Quay lại menu");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 6);
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
                Product productToUpdate = products[i];
                productToUpdate.displayData();
                System.out.println("-------------------------------");

                // UPDATE
                System.out.print("Nhập tên sản phẩm mới (ấn Enter để bỏ qua): ");
                String newProductName = scanner.nextLine();
                if (!newProductName.isEmpty()) {
                    productToUpdate.setProductName(newProductName);
                }

                System.out.print("Nhập nhà sản xuất mới (ấn Enter để bỏ qua): ");
                String newManufacturer = scanner.nextLine();
                if (!newManufacturer.isEmpty()) {
                    productToUpdate.setManufacturer(newManufacturer);
                }

                System.out.print("Nhập trạng thái mới (0-hoạt động, 1-không hoạt động, ấn Enter để bỏ qua): ");

                while (true) {
                    String newStatusStr = scanner.nextLine();
                    if (!newStatusStr.isEmpty()) {
                        try {
                            int newStatus = Integer.parseInt(newStatusStr);
                            if (newStatus == 0 || newStatus == 1) {
                                productToUpdate.setProductStatus(newStatus == 0);
                                break;
                            } else {
                                System.err.println("Trạng thái không hợp lệ.");
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Vui lòng nhập vào số 0 hoặc 1");
                        }
                    } else {
                        break;
                    }
                }

                System.out.println("Cập nhật thành công");
                System.out.println("Thông tin sản phẩm hiện tại:");
                productToUpdate.displayData();
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã " + productId);
    }

    private void searchProductByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String productName = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductName().contains(productName)) {
                products[i].displayData();
                System.out.println("---------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm có tên chứa '" + productName + "'");
        }
    }

    private void updateProductStatus(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
        String productId = scanner.nextLine();

        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductId().equals(productId)) {
                Product productToUpdate = products[i];
                productToUpdate.displayData();
                System.out.println("-------------------------------");
                System.out.print("Bạn có muốn thay đổi trạng thái sản phẩm không? (y/n): ");
                boolean isValid = false;
                do {
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("y")) {
                        productToUpdate.setProductStatus(!productToUpdate.isProductStatus());
                        System.out.println("Cập nhật trạng thái thành công.");
                        System.out.println("Thông tin sản phẩm hiện tại:");
                        productToUpdate.displayData();
                        isValid = true;
                    } else {
                        isValid = true;
                        return;
                    }
                } while (!isValid);

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

    private void employeeManagement(Scanner scanner) {
        int choice;
        do {
            displayEmployeeManagementMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputEmployee(scanner);
                    break;
                case 2:
                    displayEmployee();
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    searchEmployeeByName(scanner);
                    break;
                case 5:
                    updateEmployeeStatus(scanner);
                    break;
                case 6:
                    System.err.println("Quay lại menu");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 6);
    }

    private void inputEmployee(Scanner scanner) {
        System.out.print("Nhập số lượng nhân viên cần nhập: ");
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n > 0) {
                    break;
                } else {
                    System.err.println("Số lượng nhân viên phải là số nguyên dương");
                }
            } catch (NumberFormatException e) {
                System.err.println("Số lượng nhân viên phải là số nguyên");
            }
        }
        for (int i = 0; i < n; i++) {
            Employee employee = new Employee();
            employee.inputData();
            employees[employeeCount++] = employee;
        }
    }

    private void displayEmployee() {
        if (employeeCount == 0) {
            System.err.println("Chưa có nhân viên nào.");
            return;
        }
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayData();
            System.out.println("----------------------------");
        }
    }

    private void updateEmployee(Scanner scanner) {
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        int employeeId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmpId() == employeeId) {
                Employee employeeToUpdate = employees[i];
                employeeToUpdate.displayData();
                System.out.println("-------------------------------");

                System.out.print("Nhập tên (mới) cho nhân viên (ấn Enter để bỏ qua): ");
                String newEmpName = scanner.nextLine();
                if (!newEmpName.isEmpty()) {
                    employeeToUpdate.setEmpName(newEmpName, scanner);
                }
                System.out.print("Nhập năm sinh (mới) cho nhân viên (ấn Enter để bỏ qua): ");
                int currentYear = java.time.Year.now().getValue();
                String newBirthYearStr = scanner.nextLine();
                if (!newBirthYearStr.isEmpty()) {
                    int newBirthYear = Integer.parseInt(newBirthYearStr);
                    if (newBirthYear < currentYear && newBirthYear > 1900) {
                        employeeToUpdate.setBirthYear(newBirthYear);
                    } else {
                        System.out.println("Năm sinh phải nhỏ hơn năm hiện tại và lớn hơn 1900. Vui lòng nhập lại.");
                    }
                }

                System.out.print("Nhập sdt (mới) cho nhân viên (ấn Enter để bỏ qua): ");
                String newTel = scanner.nextLine();
                if (!newTel.isEmpty()) {
                    if (newTel.matches("0[0-9]{9}")) {
                        employeeToUpdate.setPhone(newTel);
                    } else {
                        System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
                    }
                }

                System.out.print("Nhập email (mới) cho nhân viên (ấn Enter để bỏ qua): ");
                String newEmail = scanner.nextLine();
                if (!newEmail.isEmpty()) {
                    if (newEmail.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                        employeeToUpdate.setEmail(newEmail);
                    } else {
                        System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
                    }
                }
                System.out.print("Nhập trạng thái (mới) cho nhân viên (0-Đang làm việc, 1-Nghỉ việc, 2-Nghỉ chế độ --- ấn Enter để bỏ qua): ");
                String newStatusStr = scanner.nextLine();
                if (!newStatusStr.isEmpty()) {
                    int newStatus = Integer.parseInt(newStatusStr);
                    employeeToUpdate.setEmpStatus(newStatus);
                }
                System.out.println("Cập nhật thành công");
                return;
            }
        }
    }

    private void searchEmployeeByName(Scanner scanner) {
        System.out.print("Nhập tên nhân viên cần tìm: ");
        String empName = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmpName().contains(empName)) {
                employees[i].displayData();
                System.out.println("--------------------");
                found = true;
            }
        }
        if (!found) {
            System.err.println("Không tìm thấy nhân viên tên là " + empName);
        }
    }

    private void updateEmployeeStatus(Scanner scanner) {
        System.out.print("Nhập mã nhân viên cần cập nhật trạng thái: ");
        int empId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmpId() == empId) {
                System.out.println("Thông tin nhân viên có id " + empId + " là:");
                employees[i].displayData();
                System.out.println("--------------------------");
                System.out.println("Nhập trạng thái mới (0-Đang làm việc, 1-Nghỉ việc, 2-Nghỉ chế độ): ");
                int status = Integer.parseInt(scanner.nextLine());
                if (status >= 0 && status <= 2) {
                    employees[i].setEmpStatus(status);
                    System.out.println("Cập nhật trạng thái thành công");
                    System.out.println("Thông tin sau khi cập nhật:");
                    employees[i].displayData();
                    System.out.println("--------------------------");
                } else {
                    System.err.println("Trạng thái nhập vào không hợp lệ");
                }
                return;
            }
        }

        System.out.println("Không tìm thấy nhân viên có mã: " + empId);
    }

    private void receiptManagement(boolean isReceipt, Scanner scanner) {
        int choice;
        do {
            displayReceiptManagementMenu(isReceipt);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputOrders(isReceipt, scanner);
                    break;
                case 2:
                    displayOrders(isReceipt);
                    break;
                case 3:
                    updateOrder(isReceipt, scanner);
                    break;
                case 4:
                    if (isReceipt) {
                        searchReceiptsByDateRange(scanner);
                    } else {
                        searchBillsByDateRange(scanner);
                    }
                    break;
                case 5:
                    searchOrdersByCreator(isReceipt, scanner);
                    break;
                case 6:
                    searchOrdersByUpdater(isReceipt, scanner);
                    break;
                case 7:
                    System.err.println("Thoát quản lý phiếu " + (isReceipt ? "nhập" : "xuất") + ".");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 7);
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

    private void inputOrders(boolean isReceipt, Scanner scanner) {
        System.out.print("Nhập số lượng phiếu " + (isReceipt ? "nhập" : "xuất") + " cần nhập: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Order order = new Order();
            order.setOrderType(isReceipt);
            order.inputData(products, employees);
            orders[orderCount++] = order;
        }
    }

    private void displayOrders(boolean isReceipt) {
        if (orderCount == 0) {
            System.out.println("Chưa có phiếu " + (isReceipt ? "nhập" : "xuất") + " nào.");
            return;
        }
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].isOrderType() == isReceipt) {
                orders[i].displayData();
                System.out.println("----------------------------");
            }
        }
    }

    private void updateOrder(boolean isReceipt, Scanner scanner) {
        System.out.print("Nhập mã phiếu " + (isReceipt ? "nhập" : "xuất") + " cần cập nhật: ");
        String orderId = scanner.nextLine();

        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getOrderId().equals(orderId) && orders[i].isOrderType() == isReceipt) {
                orders[i].inputData(products, employees);
                orders[i].setUpdated(new Date());
                // chua de update user id making update
                System.out.println("Cập nhật thành công.");
                return;
            }
        }
        System.out.print("Không tìm thấy phiếu " + (isReceipt ? "nhập" : "xuất") + " có id:  " + orderId);
    }

    private void searchReceiptsByDateRange(Scanner scanner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
            Date startDate = dateFormat.parse(scanner.nextLine());
            System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
            Date endDate = dateFormat.parse(scanner.nextLine());

            boolean found = false;
            for (int i = 0; i < orderCount; i++) {
                // true: phieu nhap
                if (orders[i].isOrderType()
                        && orders[i].getCreated().compareTo(startDate) >= 0
                        && orders[i].getCreated().compareTo(endDate) <= 0
                ) {
                    orders[i].displayData();
                    System.out.println("--------------------------------");
                    found = true;
                }
            }
            if (!found) {
                System.out.print("Không tìm thấy phiếu nhập trong khoảng từ" + (dateFormat.format(startDate)) + " đến " + (dateFormat.format(endDate)));
            }

        } catch (ParseException e) {
            System.err.println("Định dạng ngày không hợp lệ");
        }

    }

    private void searchBillsByDateRange(Scanner scanner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
            Date startDate = dateFormat.parse(scanner.nextLine());
            System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
            Date endDate = dateFormat.parse(scanner.nextLine());

            boolean found = false;
            for (int i = 0; i < orderCount; i++) {
                // false: phieu xuất
                if (!orders[i].isOrderType()
                        && orders[i].getCreated().compareTo(startDate) >= 0
                        && orders[i].getCreated().compareTo(endDate) <= 0
                ) {
                    orders[i].displayData();
                    System.out.println("--------------------------------");
                    found = true;
                }
            }
            if (!found) {
                System.out.print("Không tìm thấy phiếu xuất trong khoảng từ" + (dateFormat.format(startDate)) + " đến " + (dateFormat.format(endDate)));
            }

        } catch (ParseException e) {
            System.err.println("Định dạng ngày không hợp lệ");
        }

    }

    // tim kiem phieu nhap/xuat theo nguoi tao
    private void searchOrdersByCreator(boolean isReceipt, Scanner scanner) {
        System.out.print("Nhập mã nhân viên tạo phiếu: ");
        int userCreatedId = Integer.parseInt(scanner.nextLine());

        boolean found = false;
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].isOrderType() == isReceipt && orders[i].getUserCreatedId() == userCreatedId) {
                orders[i].displayData();
                System.out.println("-----------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy phiếu " + (isReceipt ? "nhập" : "xuất") + " được tạo bởi nhân viên có mã " + userCreatedId);
        }
    }

    // tim kiem phieu nhap/xuat theo nguoi cap nhat
    private void searchOrdersByUpdater(boolean isReceipt, Scanner scanner) {
        System.out.print("Nhập mã nhân viên tạo phiếu: ");
        int userUpdaterId = Integer.parseInt(scanner.nextLine());

        boolean found = false;
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].isOrderType() == isReceipt && orders[i].getUserCreatedId() == userUpdaterId) {
                orders[i].displayData();
                System.out.println("-----------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy phiếu " + (isReceipt ? "nhập" : "xuất") + " được cập nhật bởi nhân viên có mã " + userUpdaterId);
        }
    }

    private void reportManagement(Scanner scanner) {
        int choice;
        do {
            displayReportManagementMenu();
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
                    break;
                case 7:
                    System.err.println("Thoát báo cáo thống kê.");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 7);
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

    private void reportProductsImportedByDateRange(Scanner scanner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
            Date startDate = dateFormat.parse(scanner.nextLine());
            System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
            Date endDate = dateFormat.parse(scanner.nextLine());

            // tao 1 mang de luu tru so luong nhap cua tung san pham
            int[] productQuantities = new int[productCount];
            for (int i = 0; i < orderCount; i++) {
                Order order = orders[i];
                // true: nhap
                if (order.isOrderType()
                        && order.getCreated().compareTo(startDate) >= 0
                        && order.getCreated().compareTo(endDate) <= 0) {
                    // tim vi tri cua san pham trong mang products
                    int productIndex = -1;
                    for (int j = 0; j < productCount; j++) {

                    }
                }
            }
        } catch (ParseException e) {
            System.err.println("Định dạng ngày không hợp lệ.");
        }
    }

}
