package Session4.Exercise.Ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Action {

    static int soLuongHocSinh;

    public static void main(String[] args) {
//        soLuongHocSinh = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng học sinh tối đa: ");
        int maxHocSinh = Integer.parseInt(scanner.nextLine());
        Student[] danhSachHocSinh = new Student[maxHocSinh];
        int select;
        do {
            showMenuChoice();
            System.out.print("Nhập lựa chọn của bạn: ");
            select = Integer.parseInt(scanner.nextLine());
            processSelection(select, scanner, danhSachHocSinh, soLuongHocSinh);
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

    public static void processSelection(int select, Scanner scanner, Student[] danhSach, int soLuongHocSinh) {
        switch (select) {
            case 1:
                System.out.println("==> 1. Hiển thị danh sách tất cả học sinh");
//                System.out.println("--------------------");
                showListStudent(danhSach, soLuongHocSinh);
                break;
            case 2:
                System.out.println("==> 2. Thêm mới học sinh");
                addStudent(danhSach, scanner, soLuongHocSinh);
                break;
            case 3:
                System.out.println("==> 3. Sửa thông tin học sinh dựa vào mã học sinh");
                editStudentInfo(danhSach, scanner, soLuongHocSinh);
                break;
            case 4:
                System.out.println("==> 4. Xóa học sinh dựa vào mã học sinh");
                deleteStudent(danhSach, scanner, soLuongHocSinh);
                break;
            case 5:
                System.out.println("==> 5. Thoát chương trình....");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    private static void showListStudent(Student[] danhSach, int soLuongHocSinh) {
        if (soLuongHocSinh == 0) {
            System.out.println("Danh sách học sinh trống.");
        } else {
            for (int i = 0; i < soLuongHocSinh; i++) {
                danhSach[i].displayData();
            }
        }
    }

    private static void addStudent(Student[] danhSach, Scanner scanner, int soLuongHocSinh) {
        if (soLuongHocSinh < danhSach.length) {
            danhSach[soLuongHocSinh] = new Student();
            System.out.println("Nhập thông tin học sinh thứ: " + (soLuongHocSinh + 1));
            danhSach[soLuongHocSinh].inputData(scanner);
            System.out.println("Thêm học sinh thành công");
            Action.soLuongHocSinh++;
        } else {
            System.out.println("Danh sách đã đầy, không thể thêm học sinh mới");
        }
    }

    private static void editStudentInfo(Student[] danhSach, Scanner scanner, int soLuongHocSinh) {
        System.out.print("Mời nhập vào mã của học sinh cần sửa: ");
        String studentCode = scanner.nextLine();
        for (int i = 0; i < soLuongHocSinh; i++) {
            if (danhSach[i].getMaHS().equals(studentCode)) {
                System.out.println("Nhập thông tin mới cho học sinh: ");
                danhSach[i].inputData(scanner);
                System.out.println("Sửa thông tin học sinh thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có mã " + studentCode);

    }

    private static void deleteStudent(Student[] danhSach, Scanner scanner, int soLuongHocSinh) {
        System.out.println("Nhập mã học sinh cần xoá: ");
        String selectStudentCode = scanner.nextLine();
        for (int i = 0; i < soLuongHocSinh; i++) {
            if (danhSach[i].getMaHS().equals(selectStudentCode)) {
                // dich chuyen cac phan tu sau vi tri i len 1 don vi
                for (int j = i; j < soLuongHocSinh - 1; j++) {
                    danhSach[j] = danhSach[j + 1];
                }
                danhSach[soLuongHocSinh - 1] = null;
                System.out.println("Xoá học sinh thành công!!!!");
                Action.soLuongHocSinh--;
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có mã " + selectStudentCode);
    }
}
