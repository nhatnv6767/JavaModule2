package Session5.Example.studentManagement;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;

    public Student() {
    }

    public Student(String studentId, String studentName, int age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
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


    public void inputData(Scanner scanner) {

    }

    public int inputStudentId(Scanner scanner) {
        System.out.print("Nhập vào mã sinh viên: ");
        do {
            String studentId = scanner.nextLine();
            boolean isExist = false;
            for (int i = 0; i < StudentManagement.currentIndex; i++) {
                if (StudentManagement.arrStudent[i].studentId.equals(studentId)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.err.println("Mã sinh viên đã tồn tại");
            } else {
                return studentId;
            }
        } while (true);
    }

    public void displayData() {

    }
}
