package Session5.Example.inheritance;

import java.util.Scanner;

public class Student extends Person {
    // thua huong tat ca thuoc tinh, contructor, phuong thuc cua lop Person
    // co cac thuoc tinh, contructor, phuong thuc cua rieng no
    private String studentId;
    private float avgMark;

    public Student() {
    }

    public Student(String name, int age, boolean sex, String address, String studentId, float avgMark) {
        super(name, age, sex, address);// goi den constructor cua lop cha
        this.studentId = studentId;
        this.avgMark = avgMark;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public void inputStudent(Scanner scanner) {
        super.inputData(scanner);
        System.out.print("Nhập vào mã sinh viên: ");
        this.studentId = scanner.nextLine();
        System.out.print("Điểm trung bình: ");
        this.avgMark = Float.parseFloat(scanner.nextLine());
    }

    public void displayData() {
        super.displayData();
        System.out.println("STUDENT ID: " + this.studentId);
        System.out.println("STUDENT AVG MARK: " + this.avgMark);
    }
}
