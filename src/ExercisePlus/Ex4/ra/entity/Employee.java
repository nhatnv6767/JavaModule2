package ExercisePlus.Ex4.ra.entity;

import java.util.Scanner;

public class Employee {
    private static int nextEmpId = 1;// bien static de tu dong tang ma nhan vien
    private int empId;
    private String empName;
    private int birthYear;
    private String phone;
    private String email;
    private int empStatus;

    public Employee() {
        this.empId = nextEmpId++; // gan ma nv va tang bien static
    }

    public Employee(String empName, int birthYear, String phone, String email, int empStatus) {
        this.empId = nextEmpId++; // gan ma nv va tang
        this.empName = empName;
        this.birthYear = birthYear;
        this.phone = phone;
        this.email = email;
        this.empStatus = empStatus;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName, Scanner scanner) {
        boolean isValid = false;
        while (!isValid) {
            if (empName.length() >= 10 && empName.length() <= 50) {
                this.empName = empName;
                isValid = true;
            } else {
                System.err.println("Tên nhân viên phải có độ dài từ 10 đến 50 ký tự. Vui lòng nhập lại.");
                empName = scanner.nextLine();
            }
        }
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        int currentYear = java.time.Year.now().getValue();
        if (birthYear < currentYear && birthYear > 1900) {
            this.birthYear = birthYear;
        } else {
            System.out.println("Năm sinh phải nhỏ hơn năm hiện tại và lớn hơn 1900. Vui lòng nhập lại.");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone.matches("^(090|093|089|088|091|094|096|097|098|086)\\d{7}$")) { // regex fake
            this.phone = phone;
        } else {
            System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            this.email = email;
        } else {
            System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
        }
    }

    public int getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(int empStatus) {
        if (empStatus >= 0 && empStatus <= 2) {
            this.empStatus = empStatus;
        } else {
            System.out.println("Trạng thái nhân viên không hợp lệ (chỉ có thể mang giá trị 0, 1, 2). Vui lòng nhập lại.");
        }
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập tên nhân viên (10-50 ký tự): ");
            setEmpName(scanner.nextLine(), scanner);
        } while (empName == null);

        do {
            System.out.print("Nhập năm sinh (4 ký tự): ");
            try {
                int year = Integer.parseInt(scanner.nextLine());
                setBirthYear(year);
            } catch (NumberFormatException e) {
                System.err.println("Năm sinh phải là số nguyên.");
            }
        } while (birthYear == 0);

        do {
            System.out.print("Nhập số điện thoại: ");
            setPhone(scanner.nextLine());
        } while (phone == null);

        do {
            System.out.print("Nhập email: ");
            setEmail(scanner.nextLine());
        } while (email == null);

        do {
            System.out.print("Nhập trạng thái nhân viên (0-Đang làm việc, 1-Nghỉ việc, 2-Nghỉ chế độ): ");
            try {
                int status = Integer.parseInt(scanner.nextLine());
                setEmpStatus(status);
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập vào không đúng");
            }
        } while (empStatus == -1);
    }

    public void displayData() {
        System.out.println("Mã nhân viên: " + empId);
        System.out.println("Tên nhân viên: " + empName);
        System.out.println("Năm sinh: " + birthYear);
        System.out.println("Số điện thoại: " + phone);
        System.out.println("Email: " + email);
        String statusText = "";
        switch (empStatus) {
            case 0:
                statusText = "Đang làm việc";
                break;
            case 1:
                statusText = "Nghỉ việc";
                break;
            case 2:
                statusText = "Nghỉ chế độ";
                break;
        }
        System.out.println("Trạng thái: " + statusText);
    }
}
