package Session6.Example.Exercise.Practise;

import java.util.Scanner;

public class EmployeeManagement {
    public static Employee[] employees = new Employee[100];
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagement employeeManagement = new EmployeeManagement();
        employeeManagement.createSampleData();
        employeeManagement.run(scanner);
    }

    private void createSampleData() {
        if (count + 20 > employees.length) {
            System.err.println("Không đủ chỗ trống để tạo dữ liệu sample.");
            return;
        }

        String[] sampleIds = {"NV001", "NV002", "NV003", "NV004", "NV005", "NV006", "NV007", "NV008", "NV009", "NV010",
                "NV011", "NV012", "NV013", "NV014", "NV015", "NV016", "NV017", "NV018", "NV019", "NV020"};
        String[] sampleNames = {"Nguyễn Văn A", "Trần Thị B", "Lê Văn C", "Phạm Thị D", "Hoàng Văn E", "Vũ Thị F", "Đỗ Văn G", "Phan Thị H", "Ngô Văn I", "Dương Thị J",
                "Trịnh Văn K", "Bùi Thị L", "Hồ Văn M", "Ngọc Thị N", "Lý Văn O", "Tạ Thị P", "Đặng Văn Q", "Cao Thị R", "Trần Văn S", "Nguyễn Thị T"};
        int[] sampleYears = {1990, 1995, 1988, 1992, 1997, 1985, 1993, 1998, 1987, 1991,
                1994, 1989, 1996, 1986, 1999, 1984, 1992, 1995, 1988, 1993};
        float[] sampleRates = {1.2f, 1.5f, 1.0f, 1.3f, 1.6f, 0.9f, 1.1f, 1.4f, 0.8f, 1.2f,
                1.3f, 1.0f, 1.5f, 0.7f, 1.7f, 0.6f, 1.3f, 1.4f, 1.1f, 1.2f};
        float[] sampleCommissions = {500000, 300000, 200000, 400000, 600000, 100000, 350000, 550000, 0, 250000,
                450000, 150000, 300000, 50000, 700000, 0, 400000, 500000, 300000, 350000};
        boolean[] sampleStatuses = {true, false, true, true, false, true, false, true, true, false,
                true, true, false, true, false, false, true, true, false, true};

        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee(sampleIds[i], sampleNames[i], sampleYears[i], sampleRates[i], sampleCommissions[i], sampleStatuses[i]);
            employees[count] = employee;
            count++;
        }

        System.out.println("Đã tạo 20 dữ liệu mẫu thành công!");
    }

    private void run(Scanner scanner) {
        int choice;
        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputEmployees(scanner);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Đã tính lương cho các nhân viên:");
                    displayEmployees();
                    break;
                case 4:
                    findEmployeeByName(scanner);
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    System.err.println("Thoát chương trình.");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 8);
    }

    private void displayMenu() {
        System.out.println("********************MENU*********************");
        System.out.println("1. Nhập thông tin cho n nhân viên\n" +
                "2. Hiển thị thông tin nhân viên\n" +
                "3. Tính lương cho các nhân viên\n" +
                "4. Tìm kiếm nhân viên theo tên nhân viên\n" +
                "5. Cập nhật thông tin nhân viên\n" +
                "6. Xóa nhân viên theo mã nhân viên\n" +
                "7. Sắp xếp nhân viên theo lương tăng dần\n" +
                "8. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private void inputEmployees(Scanner scanner) {
        int n;
        do {
            System.out.print("Nhập số lượng nhân viên muốn nhập: ");
            while (!scanner.hasNextInt()) {
                System.err.println("Số lượng nhân viên phải là số nguyên. Vui lòng nhập lại.");
                scanner.next();
            }
            n = scanner.nextInt();
            scanner.nextLine();
        } while (n <= 0 || count + n > employees.length);

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            Employee employee = new Employee();
            employee.inputData(scanner, employees, count);
            employees[count] = employee;
            count++;
        }
    }

    private void displayEmployees() {
        if (count == 0) {
            System.err.println("Không có nhân viên nào để hiển thị.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Thông tin nhân viên thứ " + (i + 1) + ":");
            employees[i].displayData();
            System.out.println("---------------------------");
        }
    }


    private void findEmployeeByName(Scanner scanner) {
        System.out.print("Nhập tên nhân viên cần tìm: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        int foundCount = 0;
        for (int i = 0; i < count; i++) {
            if (employees[i].getName().toLowerCase().contains(searchName.toLowerCase())) {
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy nhân viên nào có tên chứa '" + searchName + "'.");
        } else {
            System.out.println("\nThông tin nhân viên tìm thấy:");
            for (int i = 0; i < foundCount; i++) {
                employees[i].displayData();
            }
        }
    }
}
