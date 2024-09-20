package Session4.Exercise.Ex7;

import java.util.Scanner;

public class Action {
    static int soLuongHocSinh;

    public static void main(String[] args) {
//        soLuongHocSinh = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên tối đa: ");
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
                "1. Hiển thị danh sách tất cả sinh viên",
                "2. Thêm mới sinh viên",
                "3. Sửa thông tin sinh viên dựa vào mã sinh viên",
                "4. Xóa sinh viên dựa vào mã sinh viên",
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
                System.out.println("==> 1. Hiển thị danh sách tất cả sinh viên");
//                System.out.println("--------------------");
                showListStudent(danhSach, soLuongHocSinh);
                break;
            case 2:
                System.out.println("==> 2. Thêm mới sinh viên");
                addStudent(danhSach, scanner, soLuongHocSinh);
                break;
            case 3:
                System.out.println("==> 3. Sửa thông tin sinh viên dựa vào mã sinh viên");
                editStudentInfo(danhSach, scanner, soLuongHocSinh);
                break;
            case 4:
                System.out.println("==> 4. Xóa sinh viên dựa vào mã sinh viên");
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
            System.out.println("Danh sách sinh viên trống.");
        } else {
            for (int i = 0; i < soLuongHocSinh; i++) {
                danhSach[i].displayData();
            }
        }
    }

    private static void addStudent(Student[] danhSach, Scanner scanner, int soLuongHocSinh) {
        if (soLuongHocSinh < danhSach.length) {
            danhSach[soLuongHocSinh] = new Student();
            System.out.println("Nhập thông tin sinh viên thứ: " + (soLuongHocSinh + 1));
            danhSach[soLuongHocSinh].inputData(scanner);
            System.out.println("Thêm sinh viên thành công");
            Action.soLuongHocSinh++;
        } else {
            System.out.println("Danh sách đã đầy, không thể thêm sinh viên mới");
        }
    }

    private static void editStudentInfo(Student[] danhSach, Scanner scanner, int soLuongHocSinh) {
        System.out.print("Mời nhập vào mã của sinh viên cần sửa: ");
        int studentCode = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < soLuongHocSinh; i++) {
            if (danhSach[i].getStudentId() == studentCode) {
                System.out.println("Nhập thông tin mới cho sinh viên (nhấn enter nếu như muốn giữ lại thông tin cũ): ");
                System.out.print("Nhập tên sinh viên mới: ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    danhSach[i].setStudentName(scanner.nextLine());
                }

                System.out.print("Nhập tuổi mới: ");
                String newAgeStr = scanner.nextLine();
                if (!newAgeStr.isEmpty()) {
                    try {
                        int newAge = Integer.parseInt(newAgeStr);
                        if (newAge >= 14 && newAge <= 60) {
                            danhSach[i].setAge(newAge);
                        } else {
                            System.out.println("Tuổi phải nằm trong khoảng từ 14 đến 60. Giữ nguyên tuổi cũ.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Tuổi không hợp lệ. Giữ nguyên tuổi cũ.");
                    }
                }

                System.out.print("Nhập giới tính mới (true: nam, false: nữ): ");
                String newSexStr = scanner.nextLine();
                if (!newSexStr.isEmpty()) {
                    try {
                        boolean newSex = Boolean.parseBoolean(newSexStr);
                        danhSach[i].setSex(newSex);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Giới tính không hợp lệ. Giữ nguyên giới tính cũ.");
                    }
                }

                System.out.print("Nhập địa chỉ mới: ");
                String newAddress = scanner.nextLine();
                if (!newAddress.isEmpty()) {
                    danhSach[i].setAddress(newAddress);
                }


                System.out.print("Nhập tên lớp mới: ");
                String newClassName = scanner.nextLine();
                if (!newClassName.isEmpty()) {
                    danhSach[i].setClassName(newClassName);
                }

                System.out.println("Sửa thông tin sinh viên thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có mã " + studentCode);

    }

    private static void deleteStudent(Student[] danhSach, Scanner scanner, int soLuongHocSinh) {
        System.out.println("Nhập mã sinh viên cần xoá: ");
        int selectStudentCode = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < soLuongHocSinh; i++) {
            if (danhSach[i].getStudentId() == selectStudentCode) {
                // dich chuyen cac phan tu sau vi tri i len 1 don vi
                for (int j = i; j < soLuongHocSinh - 1; j++) {
                    danhSach[j] = danhSach[j + 1];
                }
                danhSach[soLuongHocSinh - 1] = null;
                System.out.println("Xoá sinh viên thành công!!!!");
                Action.soLuongHocSinh--;
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có mã " + selectStudentCode);
    }
}
