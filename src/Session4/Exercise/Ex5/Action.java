package Session4.Exercise.Ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Action {
    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int select;
        do {
            showMenuChoice();
            System.out.print("Nhập lựa chọn của bạn: ");
            select = Integer.parseInt(scanner.nextLine());
            processSelection(select, scanner, listStudent);
        } while (select != 5);
    }

    public static void showMenuChoice() {
        String[] options = {
                "1. Hiển thị danh sách tất cả học sinh",
                "2. Thêm mới học sinh",
                "3. Sửa thông tin học sinh dựa vào mã học sinh",
                "4. Xóa học sinh dựa vào mã học sinh",
                "5. Thoát"
        };

        int longestLength = findLongestLength(options);
        int numberOfAsterisksRequired = longestLength + 6;

        System.out.println("*".repeat(numberOfAsterisksRequired + 2));

        // In các món ăn
        for (String select : options) {
            int paddingLeft = (numberOfAsterisksRequired - select.length() - 2) / 2;
            int paddingRight = numberOfAsterisksRequired - select.length() - 2 - paddingLeft;
            String oneLine = "* " + " ".repeat(paddingLeft) + select + " ".repeat(paddingRight) + " *";
            System.out.println(oneLine);
        }

        System.out.println("*".repeat(numberOfAsterisksRequired + 2));
    }

    public static int findLongestLength(String[] mang) {
        int max = 0;
        for (String s : mang) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public static void processSelection(int select, Scanner scanner, List<Student> listStudent) {
        switch (select) {
            case 1:
                System.out.println("==> 1. Hiển thị danh sách tất cả học sinh");
                showListStudent(listStudent);
                break;
            case 2:
                System.out.println("==> 2. Thêm mới học sinh");
                addStudent(listStudent, scanner);
                break;
            case 3:
                System.out.println("==> 3. Sửa thông tin học sinh dựa vào mã học sinh");
                editStudentInfo(listStudent, scanner);
                break;
            case 4:
                System.out.println("==> 4. Xóa học sinh dựa vào mã học sinh");
                deleteStudent(listStudent, scanner);
                break;
            case 5:
                System.out.println("==> 5. Thoát chương trình....");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    private static void showListStudent(List<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("Danh sách học sinh trống.");
        } else {
            for (Student student : listStudent) {
                student.displayData();
            }
        }
    }

    private static void addStudent(List<Student> listStudent, Scanner scanner) {
        Student newStudent = new Student();
        int lengthListStudent = listStudent.size();
        System.out.println("Nhập thông tin học sinh thứ: " + ++lengthListStudent);
        newStudent.inputData(scanner);
        listStudent.add(newStudent);
        System.out.println("Thêm học sinh thành công");
    }

    private static void editStudentInfo(List<Student> listStudent, Scanner scanner) {
        System.out.print("Mời nhập vào mã của học sinh cần sửa: ");
        String studentCode = scanner.nextLine();
        for (Student student : listStudent) {
            if (student.getMaHS().equals(studentCode)) {
                System.out.println("Nhập thông tin mới cho học sinh: ");
                student.inputData(scanner);
                System.out.println("Sửa thông tin học sinh thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có mã " + studentCode);

    }

    private static void deleteStudent(List<Student> listStudent, Scanner scanner) {
        System.out.println("Nhập mã học sinh cần xoá: ");
        String selectStudentCode = scanner.nextLine();
        for (Student student : listStudent) {
            if (student.getMaHS().equals(selectStudentCode)) {
                listStudent.remove(student);
                System.out.println("Xoá học sinh thành công!!!!");
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có mã " + selectStudentCode);
    }
}
