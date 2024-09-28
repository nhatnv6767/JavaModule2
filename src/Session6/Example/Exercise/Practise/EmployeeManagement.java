package Session6.Example.Exercise.Practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
//        String[] sampleNames = {"Nguyễn Văn A", "Trần Thị B", "Lê Văn C", "Phạm Thị D", "Hoàng Văn E", "Vũ Thị F", "Đỗ Văn G", "Phan Thị H", "Ngô Văn I", "Dương Thị J",
//                "Trịnh Văn K", "Bùi Thị L", "Hồ Văn M", "Ngọc Thị N", "Lý Văn O", "Tạ Thị P", "Đặng Văn Q", "Cao Thị R", "Trần Văn S", "Nguyễn Thị T"};
//        int[] sampleYears = {1990, 1995, 1988, 1992, 1997, 1985, 1993, 1998, 1987, 1991,
//                1994, 1989, 1996, 1986, 1999, 1984, 1992, 1995, 1988, 1993};
//        float[] sampleRates = {1.2f, 1.5f, 1.0f, 1.3f, 1.6f, 0.9f, 1.1f, 1.4f, 0.8f, 1.2f,
//                1.3f, 1.0f, 1.5f, 0.7f, 1.7f, 0.6f, 1.3f, 1.4f, 1.1f, 1.2f};
        float[] sampleCommissions = {500000, 300000, 200000, 400000, 600000, 100000, 350000, 550000, 0, 250000,
                450000, 150000, 300000, 50000, 700000, 0, 400000, 500000, 300000, 350000};
//        boolean[] sampleStatuses = {true, false, true, true, false, true, false, true, true, false,
//                true, true, false, true, false, false, true, true, false, true};

        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee(sampleIds[i], getRandomVietnameseName(), getRandomNumber(1985, 2005), getRandomFloat(), sampleCommissions[i], getRandomTrueFalse());
            employees[count] = employee;
            count++;
        }

        System.out.println("Đã tạo 20 dữ liệu mẫu thành công!");
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

    private int getRandomNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Giá trị min phải nhỏ hơn hoặc bằng max");
        }
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    private Float getRandomFloat() {
        Random rand = new Random();
        float randomFloat = rand.nextFloat();
        // random from 300.000 -> 900.000
        return 0.5f + randomFloat * (7.0f - 0.5f);
    }

    private boolean getRandomTrueFalse() {
        return Math.random() < 0.5;
    }

    private void run(Scanner scanner) {
        int choice = -1;
        do {
            displayMenu();
            try {
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
                        updateEmployee(scanner);
                        break;
                    case 6:
                        deleteEmployee(scanner);
                        break;
                    case 7:
                        sortEmployeesBySalary();
                        break;
                    case 8:
                        System.err.println("Thoát chương trình.");
                        break;
                    default:
                        System.err.println("Lựa chọn không hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lựa chọn không hợp lệ. Vui lòng nhập một số nguyên.");
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
        String searchName = scanner.nextLine().toLowerCase();

        List<Employee> foundEmployees = new ArrayList<>(); // Danh sach luu nhan vien tim thay
        for (int i = 0; i < count; i++) {
            if (employees[i] != null && employees[i].getName().toLowerCase().contains(searchName)) {
                foundEmployees.add(employees[i]);
            }
        }

        if (foundEmployees.isEmpty()) {
            System.out.println("Không tìm thấy nhân viên nào có tên chứa '" + searchName + "'.");
        } else {
            System.out.println("\nCó " + foundEmployees.size() + " nhân viên phù hợp được tìm thấy:");
            for (Employee employee : foundEmployees) {
                employee.displayData();
                System.out.println("---------------------------");
            }
        }

    }

    private void updateEmployee(Scanner scanner) {
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        String idToUpdate = scanner.nextLine();

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getId().equalsIgnoreCase(idToUpdate)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.err.println("Không tìm thấy nhân viên có mã '" + idToUpdate + "'.");
            return;
        }

        Employee employeeToUpdate = employees[index];
        System.out.println("Thông tin nhân viên cần cập nhật: ");
        employeeToUpdate.displayData();
        System.out.println("----------------------------------");
        int updateChoice = -1;

        do {
            displayUpdateMenu();
            try {
                updateChoice = Integer.parseInt(scanner.nextLine());

                switch (updateChoice) {
                    case 1:
                        updateName(scanner, employeeToUpdate);
                        break;
                    case 2:
                        updateYear(scanner, employeeToUpdate);
                        break;
                    case 3:
                        updateRate(scanner, employeeToUpdate);
                        break;
                    case 4:
                        updateCommission(scanner, employeeToUpdate);
                        break;
                    case 5:
                        updateStatus(scanner, employeeToUpdate);
                        break;
                    case 0:
                        System.err.println("Thoát khỏi chức năng cập nhật.");
                        break;
                    default:
                        System.err.println("Lựa chọn không hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lựa chọn không hợp lệ. Vui lòng nhập một số nguyên.");
            }
        } while (updateChoice != 0);
    }

    private void displayUpdateMenu() {
        System.out.println("\nChọn thông tin cần cập nhật:");
        System.out.println("1. Tên nhân viên");
        System.out.println("2. Năm sinh");
        System.out.println("3. Hệ số lương");
        System.out.println("4. Hoa hồng");
        System.out.println("5. Trạng thái");
        System.out.println("0. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private void updateName(Scanner scanner, Employee employeeToUpdate) {
        do {
            System.out.print("Nhập tên nhân viên mới (6-50 ký tự): ");
            String newName = scanner.nextLine();
            if (newName.length() >= 6 && newName.length() <= 50) {
                employeeToUpdate.setName(newName);
                System.out.println("Cập nhật tên thành công!");
                break;
            } else {
                System.err.println("Tên không hợp lệ. Vui lòng nhập lại.");
            }
        } while (true);
    }

    private void updateYear(Scanner scanner, Employee employeeToUpdate) {
        do {
            System.out.print("Nhập năm sinh mới (phải trước năm 2002): ");
            while (!scanner.hasNextInt()) {
                System.err.println("Năm sinh phải là số nguyên. Vui lòng nhập lại.");
                scanner.next();
            }
            int newYear = scanner.nextInt();
            scanner.nextLine();
            if (newYear < 2002) {
                employeeToUpdate.setYear(newYear);
                System.out.println("Cập nhật năm sinh thành công!");
                break;
            } else {
                System.err.println("Năm sinh không hợp lệ. Vui lòng nhập lại.");
            }
        } while (true);
    }

    private void updateRate(Scanner scanner, Employee employeeToUpdate) {
        do {
            System.out.print("Nhập hệ số lương mới (phải lớn hơn 0): ");
            while (!scanner.hasNextFloat()) {
                System.err.println("Hệ số lương phải là số. Vui lòng nhập lại.");
                scanner.next();
            }
            float newRate = scanner.nextFloat();
            scanner.nextLine();
            if (newRate > 0) {
                employeeToUpdate.setRate(newRate);
                System.out.println("Cập nhật hệ số lương thành công!");
                break;
            } else {
                System.err.println("Hệ số lương không hợp lệ. Vui lòng nhập lại.");
            }
        } while (true);
    }

    private void updateCommission(Scanner scanner, Employee employeeToUpdate) {
        do {
            System.out.print("Nhập hoa hồng mới: ");
            while (!scanner.hasNextFloat()) {
                System.err.println("Hoa hồng phải là số. Vui lòng nhập lại.");
                scanner.next();
            }
            float newCommission = scanner.nextFloat();
            scanner.nextLine();
            if (newCommission >= 0) {
                employeeToUpdate.setCommission(newCommission);
                System.out.println("Cập nhật hoa hồng thành công!");
                break;
            } else {
                System.err.println("Hoa hồng không hợp lệ. Vui lòng nhập lại.");
            }
        } while (true);
    }

    private void updateStatus(Scanner scanner, Employee employeeToUpdate) {
        boolean validStatus = false;
        do {
            System.out.print("Nhập trạng thái mới (true/false): ");
            if (scanner.hasNextBoolean()) {
                boolean newStatus = scanner.nextBoolean();
                employeeToUpdate.setStatus(newStatus);
                validStatus = true;
                System.out.println("Cập nhật trạng thái thành công!");
            } else {
                System.err.println("Trạng thái phải là true hoặc false. Vui lòng nhập lại.");
                scanner.next();
            }
            scanner.nextLine();
        } while (!validStatus);
    }


    // DELETE AN EMPLOYEE

    private void deleteEmployee(Scanner scanner) {
        if (count == 0) {
            System.err.println("Không có nhân viên nào để xóa.");
            return;
        }

        System.out.print("Nhập mã nhân viên cần xóa: ");
        String idToDelete = scanner.nextLine();

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getId().equalsIgnoreCase(idToDelete)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.err.println("Không tìm thấy nhân viên có mã '" + idToDelete + "'.");
            return;
        }

        System.out.print("Bạn có chắc chắn muốn xóa nhân viên này (y/n)? ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            // Don cac phan tu phia sau len
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[count - 1] = null; // xoa phan tu cuoi
            count--;
            System.out.println("Đã xóa nhân viên thành công!");
        } else {
            System.out.println("Đã hủy thao tác xóa.");
        }
    }

    private void sortEmployeesBySalary() {
        if (count == 0) {
            System.err.println("Không có nhân viên nào để sắp xếp.");
            return;
        }

        // bubble sort
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (employees[j].getSalary() > employees[j + 1].getSalary()) {
                    Employee temp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp nhân viên theo lương tăng dần!");
        System.out.println("Thông tin nhân viên sau khi sắp xếp lương tăng dần:");
        for (Employee employee : employees) {
            if (employee != null) {
                employee.displayData();
                System.out.println("----------------------");
            }
        }


    }
}
