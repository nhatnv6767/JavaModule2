package Session4.Example;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private String address;
    private String[] favoriteBooks;

    public Student() {
        favoriteBooks = new String[3];
    }

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Student(String studentId, String studentName, int age, boolean sex, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public Student(String studentId, String studentName, String[] favoriteBooks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.favoriteBooks = favoriteBooks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getFavoriteBooks() {
        return favoriteBooks;
    }

    public void setFavoriteBooks(String[] favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }

    // Methods the hien hanh vi cua doi tuong
    public void helloTeacher() {
        System.out.println("Em chào thầy ạ !!!!");
    }

    public int addTwoNumber(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên:");
        this.studentId = scanner.nextLine();
        System.out.println("Nhập vào tên sinh viên:");
        this.studentName = scanner.nextLine();
        System.out.println("Nhập vào tuổi sinh viên:");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào giới tính sinh viên:");
        this.sex = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Nhập vào địa chỉ sinh viên:");
        this.address = scanner.nextLine();


    }

    public void displayData() {
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d\n", this.studentId, this.studentName, this.age);

        System.out.printf("Giới tính: %s - Địa chỉ: %s\n", this.sex ? "Nam" : "Nữ", this.address);

//        System.out.printf("FavoriteBook: %s", (Object) this.favoriteBooks);

    }


}
