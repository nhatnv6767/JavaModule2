package Session4.Exercise.Ex7;

/*
 * Thuộc tính:
 * - radius: kiểu double
 * */

import java.util.Scanner;

public class Student {
    private int studentId;
    private String studentName;
    private boolean sex;
    private String className;
    private int age;
    private String address;

    public Student() {
    }

    public Student(int studentId, String studentName, boolean sex, String className, int age, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.sex = sex;
        this.className = className;
        this.age = age;
        this.address = address;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        this.studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sinh viên: ");
        this.studentName = scanner.nextLine();


        boolean inputValid = false;
        do {
            System.out.print("Nhập tuổi: ");
            if (scanner.hasNextInt()) {
                int age = Integer.parseInt(scanner.nextLine());

                if (age >= 14 && age <= 60) {
                    this.age = age;
                    inputValid = true;
                } else {
                    System.out.println("Tuổi phải là số nguyên (nhỏ hơn hoặc bằng 60 và lớn hơn hoặc bằng 14)");
                }

            } else {
                System.out.println("Tuổi phải là số nguyên. Vui lòng nhập lại");
                scanner.nextLine();
            }
        } while (!inputValid);


        System.out.print("Nhập giới tính (true: nam, false: nữ): ");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Nhập địa chỉ: ");
        this.address = scanner.nextLine();
        System.out.print("Nhập tên lớp: ");
        this.className = scanner.nextLine();
    }

    public void displayData() {
        String[] lines = {
                "Mã HS: " + this.studentId,
                "Tên HS: " + this.studentName,
                "Tuổi: " + this.age,
                "Giới tính: " + (this.sex ? "Nam" : "Nữ"),
                "Địa chỉ: " + this.address,
                "Tên lớp: " + this.className
        };
        int longestLength = findLongestLength(lines);
        int totalLength = longestLength + 8;

        System.out.println("-".repeat(totalLength));

        for (String line : lines) {
            int paddingLeft = (totalLength - line.length() - 2) / 2;
            int paddingRight = totalLength - line.length() - 3 - paddingLeft;
            String oneLine = "| " + " ".repeat(paddingLeft) + line + " ".repeat(paddingRight) + " |";
            System.out.println(oneLine);
        }
        System.out.println("-".repeat(totalLength));
    }

    private static int findLongestLength(String[] mang) {
        int max = 0;
        for (String s : mang) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }
}
