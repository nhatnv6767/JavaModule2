package Session6.Example.Exercise.Practise;

import java.util.Scanner;

public class Employee implements IEmployee {
    private String id;
    private String name;
    private int year;
    private float rate;
    private float commission;
    private float salary;
    private boolean status;

    public Employee() {
    }

    public Employee(String id, String name, int year, float rate, float commission, boolean status) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.commission = commission;
        this.status = status;
        calSalary();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
        calSalary();
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
        calSalary();
    }

    public float getSalary() {
        return salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void calSalary() {
        salary = (float) (rate * BASIC_SALARY + commission);
    }

    @Override
    public void inputData(Scanner scanner, Employee[] employees, int count) {
        boolean isDuplicateId;
        do {
            System.out.print("Nhập mã nhân viên: ");
            id = scanner.nextLine();
            isDuplicateId = checkDuplicateId(id, employees, count);
            if (isDuplicateId) {
                System.err.println("Mã nhân viên đã tồn tại. Vui lòng nhập lại.");
            }
        } while (isDuplicateId);

        do {
            System.out.print("Nhập tên nhân viên (6-50 ký tự): ");
            name = scanner.nextLine();
        } while (name.length() < 6 || name.length() > 50);

        do {
            System.out.print("Nhập năm sinh (phải trước năm 2002 và lớn hơn 1980): ");
            while (!scanner.hasNextInt()) {
                System.err.println("Năm sinh phải là số nguyên. Vui lòng nhập lại.");
                scanner.next();
            }
            year = Integer.parseInt(scanner.nextLine());
        } while (year >= 2002 || year <= 1980);

        do {
            System.out.print("Nhập hệ số lương (phải lớn hơn 0): ");
            while (!scanner.hasNextFloat()) {
                System.err.println("Hệ số lương phải là số. Vui lòng nhập lại.");
                scanner.next(); // Đọc bỏ dữ liệu không hợp lệ
            }
            rate = scanner.nextFloat();
            scanner.nextLine();
        } while (rate <= 0);

        // Nhập hoa hồng (commission)
        do {
            System.out.print("Nhập hoa hồng: ");
            while (!scanner.hasNextFloat()) {
                System.err.println("Hoa hồng phải là số. Vui lòng nhập lại.");
                scanner.next(); // Đọc bỏ dữ liệu không hợp lệ
            }
            commission = scanner.nextFloat();
            scanner.nextLine();
        } while (commission < 0);

        boolean validStatus = false;
        do {
            System.out.print("Nhập trạng thái (true/false): ");
            if (scanner.hasNextBoolean()) {
                status = scanner.nextBoolean();
                validStatus = true; // Danh dau trang thai la hop le
            } else {
                System.err.println("Trạng thái phải là true hoặc false. Vui lòng nhập lại.");
                scanner.next(); // doc bo du lieu khong hop le
            }
            scanner.nextLine(); // doc bo dong moi
        } while (!validStatus);

        // Tính toán lương
        calSalary();
    }

    @Override
    public void displayData() {
        System.out.println("Mã nhân viên: " + id);
        System.out.println("Tên nhân viên: " + name);
        System.out.println("Năm sinh: " + year);
        System.out.println("Hệ số lương: " + rate);
        System.out.println("Hoa hồng: " + commission);
        System.out.println("Lương: " + salary);
        System.out.println("Trạng thái: " + (status ? "Đang làm việc" : "Nghỉ việc"));
    }

    private boolean checkDuplicateId(String id, Employee[] employees, int count) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false; // khong trung
    }
}
