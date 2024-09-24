package ExercisePlus.Ex4.ra.run;

import ExercisePlus.Ex4.ra.entity.Employee;
import ExercisePlus.Ex4.ra.entity.Order;
import ExercisePlus.Ex4.ra.entity.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StoreManagement {
    private void createSampleProducts() {
        products[productCount++] = new Product("P001", "Sản phẩm A", "Nhà sản xuất X", getRandomTrueFalse());
        products[productCount++] = new Product("P002", "Sản phẩm B", "Nhà sản xuất Y", getRandomTrueFalse());
        products[productCount++] = new Product("P003", "Sản phẩm C", "Nhà sản xuất Z", getRandomTrueFalse());
        products[productCount++] = new Product("P004", "Sản phẩm D", "Nhà sản xuất X", getRandomTrueFalse());
        products[productCount++] = new Product("P005", "Sản phẩm E", "Nhà sản xuất Y", getRandomTrueFalse());
        products[productCount++] = new Product("P006", "Sản phẩm F", "Nhà sản xuất Z", getRandomTrueFalse());
        products[productCount++] = new Product("P007", "Sản phẩm G", "Nhà sản xuất X", getRandomTrueFalse());
        products[productCount++] = new Product("P008", "Sản phẩm H", "Nhà sản xuất Y", getRandomTrueFalse());
        products[productCount++] = new Product("P009", "Sản phẩm I", "Nhà sản xuất Z", getRandomTrueFalse());
        products[productCount++] = new Product("P010", "Sản phẩm J", "Nhà sản xuất X", getRandomTrueFalse());


        products[productCount++] = new Product("P011", "Sản phẩm K", "Nhà sản xuất Y", getRandomTrueFalse());
        products[productCount++] = new Product("P012", "Sản phẩm L", "Nhà sản xuất Z", getRandomTrueFalse());
        products[productCount++] = new Product("P013", "Sản phẩm M", "Nhà sản xuất X", getRandomTrueFalse());
        products[productCount++] = new Product("P014", "Sản phẩm N", "Nhà sản xuất Y", getRandomTrueFalse());
        products[productCount++] = new Product("P015", "Sản phẩm O", "Nhà sản xuất Z", getRandomTrueFalse());
        products[productCount++] = new Product("P016", "Sản phẩm P", "Nhà sản xuất X", getRandomTrueFalse());
        products[productCount++] = new Product("P017", "Sản phẩm Q", "Nhà sản xuất Y", getRandomTrueFalse());
        products[productCount++] = new Product("P018", "Sản phẩm R", "Nhà sản xuất Z", getRandomTrueFalse());
        products[productCount++] = new Product("P019", "Sản phẩm S", "Nhà sản xuất X", getRandomTrueFalse());
        products[productCount++] = new Product("P020", "Sản phẩm T", "Nhà sản xuất Y", getRandomTrueFalse());

        products[productCount++] = new Product("P021", "Sản phẩm U", "Nhà sản xuất Z", getRandomTrueFalse());
        products[productCount++] = new Product("P022", "Sản phẩm V", "Nhà sản xuất X", getRandomTrueFalse());
        products[productCount++] = new Product("P023", "Sản phẩm W", "Nhà sản xuất Y", getRandomTrueFalse());
        products[productCount++] = new Product("P024", "Sản phẩm X", "Nhà sản xuất Z", getRandomTrueFalse());
        products[productCount++] = new Product("P025", "Sản phẩm Y", "Nhà sản xuất X", getRandomTrueFalse());
        products[productCount++] = new Product("P026", "Sản phẩm Z", "Nhà sản xuất Y", getRandomTrueFalse());
        products[productCount++] = new Product("P027", "Sản phẩm AA", "Nhà sản xuất Z", getRandomTrueFalse());
        products[productCount++] = new Product("P028", "Sản phẩm BB", "Nhà sản xuất X", getRandomTrueFalse());
        products[productCount++] = new Product("P029", "Sản phẩm CC", "Nhà sản xuất Y", getRandomTrueFalse());
        products[productCount++] = new Product("P030", "Sản phẩm DD", "Nhà sản xuất Z", getRandomTrueFalse());
    }

    // Hàm tạo dữ liệu mẫu cho nhân viên
    private void createSampleEmployees() {
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0901234567", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0939876543", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0898888888", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0887777777", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0916666666", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0945555555", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0964444444", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0973333333", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0982222222", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0861111111", getRandomEmail(), getRandomNumber(0, 2));


        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0123456789", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0987654321", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0112233445", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0556677889", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0998877665", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0332211009", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0774433221", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0665544332", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0889900112", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0223311440", getRandomEmail(), getRandomNumber(0, 2));

        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0445522663", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0778833991", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0116644772", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0559933881", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0227755664", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0880011336", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0334422557", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0661188990", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0992200334", getRandomEmail(), getRandomNumber(0, 2));
        employees[employeeCount++] = new Employee(getRandomVietnameseName(), getRandomNumber(1990, 2004), "0447711225", getRandomEmail(), getRandomNumber(0, 2));
    }

    private void createSampleOrders() {
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P001", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P003", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P005", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P007", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P002", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());

        orders[orderCount++] = new Order(getRandomTrueFalse(), "P004", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P006", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P009", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P008", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P010", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());


        orders[orderCount++] = new Order(getRandomTrueFalse(), "P011", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P013", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P015", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P017", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P012", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());

        orders[orderCount++] = new Order(getRandomTrueFalse(), "P014", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P016", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P019", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P018", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P020", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());

        orders[orderCount++] = new Order(getRandomTrueFalse(), "P021", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P023", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P025", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P027", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P022", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());

        orders[orderCount++] = new Order(getRandomTrueFalse(), "P024", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P026", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P029", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P028", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());
        orders[orderCount++] = new Order(getRandomTrueFalse(), "P030", getRandomNumber(1, 300), getRandomFloat(), getRandomNumber(1, 10), getRandomTrueFalse(), getRandomDate());

    }

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


    private Float getRandomFloat() {
        Random rand = new Random();
        float randomFloat = rand.nextFloat();
        // random from 300.000 -> 900.000
        return 300000 + randomFloat * (900000 - 300000);
    }

    private boolean getRandomTrueFalse() {
        return Math.random() < 0.5;
    }

    private int getRandomNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Giá trị min phải nhỏ hơn hoặc bằng max");
        }
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    private Date getRandomDate() {
        Date currentDate = new Date();

        // tao calendar va thiet lap ngay hien tai
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // tao 1 so ngau hien tu 0 - 90 (Khoang 3 thang)
        Random random = new Random();
        int randomDays = random.nextInt(91);

        // tru di so ngay ngau nhien
        calendar.add(Calendar.DAY_OF_YEAR, -randomDays);
        return calendar.getTime();
    }

    private String getRandomVietnameseName() {
        String[] firstNames = {"Nguyễn", "Trần", "Lê", "Phạm", "Hoàng", "Phan", "Vũ", "Võ", "Đặng", "Bùi"};
        String[] middleNames = {"Văn", "Thị", "Đức", "Hữu", "Ngọc", "Minh", "Hoàng", "Xuân", "Thu", "Hải"};
        String[] lastNames = {"Anh", "Bình", "Chi", "Dũng", "Giang", "Hạnh", "Hòa", "Hương", "Khánh", "Linh"};

        Random rand = new Random();
        String firstName = firstNames[rand.nextInt(firstNames.length)];
        String middleName = middleNames[rand.nextInt(middleNames.length)];
        String lastName = lastNames[rand.nextInt(lastNames.length)];
        return firstName + " " + middleName + " " + lastName;
    }

    private String getRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

        Random rand = new Random();
        int userNameLength = rand.nextInt(10) + 5; // ten nguoi dung tu 5 den 14 ky tu
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < userNameLength; i++) {
            username.append(characters.charAt(rand.nextInt(characters.length())));
        }
        // chon ngau nhien ten mien
        String domain = domains[rand.nextInt(domains.length)];
        return username.toString() + "@" + domain;
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
                    reportProductsImportedByDateRange(scanner);
                    break;
                case 2:
                    reportProductsExportedByDateRange(scanner);
                    break;
                case 3:
                    reportRevenueByDateRange(scanner);
                    break;
                case 4:
                    reportExpensesByDateRange(scanner);
                    break;
                case 5:
                    reportRevenueByMonth();
                    break;
                case 6:
                    reportExpensesByMonth();
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

    //1. Thống kê các sản phẩm nhập từ ngày đến ngày
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
                        if (products[j].getProductId().equals(order.getProductId())) {
                            productIndex = j;
                            break;
                        }
                    }
                    if (productIndex != -1) {
                        productQuantities[productIndex] += order.getQuantity();
                    }
                }
            }

            System.out.println("Thống kê sản phẩm nhập từ " + dateFormat.format(startDate) + " đến " + dateFormat.format(endDate) + " là: ");
            for (int i = 0; i < productCount; i++) {
                if (productQuantities[i] > 0) {
                    System.out.println("- " + products[i].getProductName() + ": " + productQuantities[i]);
                }
            }
        } catch (ParseException e) {
            System.err.println("Định dạng ngày không hợp lệ.");
        }
    }


    //2. Thống kê các sản phẩm xuất từ ngày đến ngày
    private void reportProductsExportedByDateRange(Scanner scanner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
            Date startDate = dateFormat.parse(scanner.nextLine());
            System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
            Date endDate = dateFormat.parse(scanner.nextLine());

            // tao 1 mang de luu tru so luong xuat cua tung san pham
            int[] productQuantities = new int[productCount];
            for (int i = 0; i < orderCount; i++) {
                Order order = orders[i];
                // true: nhap
                if (!order.isOrderType()
                        && order.getCreated().compareTo(startDate) >= 0
                        && order.getCreated().compareTo(endDate) <= 0) {
                    // tim vi tri cua san pham trong mang products
                    int productIndex = -1;
                    for (int j = 0; j < productCount; j++) {
                        if (products[j].getProductId().equals(order.getProductId())) {
                            productIndex = j;
                            break;
                        }
                    }
                    if (productIndex != -1) {
                        productQuantities[productIndex] += order.getQuantity();
                    }
                }
            }

            System.out.println("Thống kê sản phẩm nhập từ " + dateFormat.format(startDate) + " đến " + dateFormat.format(endDate) + " là: ");
            System.out.println("- " + "Tên sản phẩm" + ": " + "Số lượng");
            for (int i = 0; i < productCount; i++) {
                if (productQuantities[i] > 0) {
                    System.out.println("- " + products[i].getProductName() + ": " + productQuantities[i]);
                }
            }
        } catch (ParseException e) {
            System.err.println("Định dạng ngày không hợp lệ.");
        }
    }

    // 3. Thống kê doanh thu từ ngày đến ngày (theo các phiếu xuất)
    private void reportRevenueByDateRange(Scanner scanner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
            Date startDate = dateFormat.parse(scanner.nextLine());
            System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
            Date endDate = dateFormat.parse(scanner.nextLine());

            float totalRevenue = 0;
            for (int i = 0; i < orderCount; i++) {
                Order order = orders[i];
                if (!order.isOrderType()
                        && order.getCreated().compareTo(startDate) >= 0
                        && order.getCreated().compareTo(endDate) <= 0
                ) {
                    totalRevenue += order.getQuantity() * order.getPrice();
                }
            }
            System.out.println("Tổng doanh thu từ " + dateFormat.format(startDate) + " đến " + dateFormat.format(endDate) + " là: " + totalRevenue);
        } catch (ParseException e) {
            System.err.println("Định dạng ngày không hợp lệ (\"yyyy-MM-dd\")");
        }
    }

    //4. Thống kê chi phí từ ngày đến ngày (theo các phiếu nhập)
    private void reportExpensesByDateRange(Scanner scanner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
            Date startDate = dateFormat.parse(scanner.nextLine());
            System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
            Date endDate = dateFormat.parse(scanner.nextLine());

            float totalExpenses = 0;
            for (int i = 0; i < orderCount; i++) {
                Order order = orders[i];
                if (order.isOrderType()
                        && order.getCreated().compareTo(startDate) >= 0
                        && order.getCreated().compareTo(endDate) <= 0
                ) {
                    totalExpenses += order.getQuantity() * order.getPrice();
                }
            }
            System.out.println("Tổng doanh thu từ " + dateFormat.format(startDate) + " đến " + dateFormat.format(endDate) + " là: " + totalExpenses);
        } catch (ParseException e) {
            System.err.println("Định dạng ngày không hợp lệ (\"yyyy-MM-dd\")");
        }
    }

    // 5. Thống kê phiếu thu theo các tháng
    private void reportRevenueByMonth() {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM/yyyy");
        // su dung hashmap de luu tong doanh thu cho moi thang
        Map<String, Float> revenueByMonth = new HashMap<>();
        for (int i = 0; i < orderCount; i++) {
            Order order = orders[i];
            // phieu xuat
            if (!order.isOrderType()) {
                try {
                    String monthYear = monthFormat.format(order.getCreated());
                    float revenue = order.getQuantity() + order.getPrice();

                    // cong don doanh thu vao thang tuong ung
                    revenueByMonth.put(monthYear, revenueByMonth.getOrDefault(monthYear, 0.0f) + revenue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // hien thi ket qua
        System.out.println("Thống kê doanh thu theo tháng: ");
        for (Map.Entry<String, Float> entry : revenueByMonth.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

    // 6. Thống kê chi phí theo các tháng

    private void reportExpensesByMonth() {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM/yyyy");
        // su dung hashmap de luu tong doanh thu cho moi thang
        Map<String, Float> expensesByMonth = new HashMap<>();
        for (int i = 0; i < orderCount; i++) {
            Order order = orders[i];
            // phieu nhap
            if (order.isOrderType()) {
                try {
                    String monthYear = monthFormat.format(order.getCreated());
                    float expense = order.getQuantity() + order.getPrice();

                    // cong don doanh thu vao thang tuong ung
                    expensesByMonth.put(monthYear, expensesByMonth.getOrDefault(monthYear, 0.0f) + expense);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // hien thi ket qua
        System.out.println("Thống kê chi phí theo tháng: ");
        for (Map.Entry<String, Float> entry : expensesByMonth.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

}
