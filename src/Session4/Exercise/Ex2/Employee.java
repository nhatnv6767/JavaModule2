package Session4.Exercise.Ex2;

/*
 * Thuộc tính:
 * - radius: kiểu double
 * */

import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private int age;
    private String gen;
    private double rate;
    private double salary;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, int age, String gen, double rate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gen = gen;
        this.rate = rate;
        calSalary();
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã nhân viên: ");
        this.employeeId = scanner.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        this.employeeName = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập giới tính: ");
        this.gen = scanner.nextLine();
        System.out.print("Nhập hệ số lương: ");
        this.rate = Double.parseDouble(scanner.nextLine());

        calSalary();
    }

    public void displayData() {
        System.out.println("Mã nhân viên: " + employeeId);
        System.out.println("Tên nhân viên: " + employeeName);
        System.out.println("Tuổi: " + age);
        System.out.println("Giới tính: " + gen);
        System.out.println("Hệ số lương: " + rate);
        System.out.println("Lương: " + salary);

    }

    public void calSalary() {
        salary = rate * 1300000;
    }
}
