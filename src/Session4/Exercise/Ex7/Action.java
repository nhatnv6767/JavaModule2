package Session4.Exercise.Ex7;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class Action {
    static int soLuongHocSinh;
    final static int exitSelect = 6;

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
        } while (select != exitSelect);
    }

    public static void showMenuChoice() {
        String[] options = {
                "1. Hiển thị danh sách tất cả sinh viên",
                "2. Thêm mới sinh viên (bằng tay)",
                "3. Thêm mới sinh viên (bằng file)",
                "4. Sửa thông tin sinh viên dựa vào mã sinh viên",
                "5. Xóa sinh viên dựa vào mã sinh viên",
                "6. Thoát"
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
                System.out.println("==> 2. Thêm mới sinh viên (bằng tay)");
                addStudent(danhSach, scanner, soLuongHocSinh);
                break;
            case 3:
                System.out.println("==> 3. Thêm mới sinh viên (bằng file)");
                addStudentFromFile(danhSach, soLuongHocSinh);
                break;
            case 4:
                System.out.println("==> 4. Sửa thông tin sinh viên dựa vào mã sinh viên");
                editStudentInfo(danhSach, scanner, soLuongHocSinh);
                break;
            case 5:
                System.out.println("==> 5. Xóa sinh viên dựa vào mã sinh viên");
                deleteStudent(danhSach, scanner, soLuongHocSinh);
                break;
            case 6:
                System.out.println("==> 6. Thoát chương trình....");
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
            danhSach[soLuongHocSinh].setStudentList(danhSach, soLuongHocSinh);
            System.out.println("Nhập thông tin sinh viên thứ: " + (soLuongHocSinh + 1));
            danhSach[soLuongHocSinh].inputData(scanner);
            System.out.println("Thêm sinh viên thành công");
            Action.soLuongHocSinh++;
        } else {
            System.out.println("Danh sách đã đầy, không thể thêm sinh viên mới");
        }
    }

    private static void addStudentFromFile(Student[] danhSach, Integer soLuongHocSinh) {
        if (soLuongHocSinh < danhSach.length) {
            try (BufferedReader br = new BufferedReader(new FileReader("/Users/bhnone/Work/Coding/Java/Module2/src/Session4/Exercise/Ex7/student.json"))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                JSONArray jsonArray = new JSONArray(sb.toString());

                for (int j = 0; j < jsonArray.length(); j++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(j);

                    int studentId = jsonObject.getInt("studentCode");
                    String studentName = jsonObject.getString("studentName");
                    int age = jsonObject.getInt("age");
                    boolean sex = jsonObject.getString("sex").equalsIgnoreCase("Nam");
                    String address = jsonObject.getString("address");
                    String className = jsonObject.getString("className");

                    // kiem tra ma sinh vien da ton tai hay chua

                    danhSach[soLuongHocSinh] = new Student(studentId, studentName, sex, className, age, address);
                    soLuongHocSinh++;
                    Action.soLuongHocSinh = soLuongHocSinh;

                    if (soLuongHocSinh >= danhSach.length) {
                        System.out.println("Danh sách đã đầy, không thể thêm sinh viên mới.");
                        break;
                    }
                }

                System.out.println("Thêm sinh viên từ file thành công!");
            } catch (IOException e) {
                System.out.println("Lỗi khi đọc file JSON: " + e.getMessage());
            }
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
                boolean validAge = false;
                do {
                    String newAgeStr = scanner.nextLine();
                    if (!newAgeStr.isEmpty()) {
                        try {
                            int newAge = Integer.parseInt(newAgeStr);
                            if (newAge >= 14 && newAge <= 60) {
                                danhSach[i].setAge(newAge);
                                validAge = true;
                            } else {
                                System.out.println("Tuổi phải nằm trong khoảng từ 14 đến 60. Giữ nguyên tuổi cũ.");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Tuổi không hợp lệ. Tuổi phải là số nguyên.");
                        }
                    }
                } while (!validAge);

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
        showListStudent(danhSach, soLuongHocSinh);
        System.out.println("Nhập mã sinh viên của sinh viên cần xoá: ");
        int selectStudentCode = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < soLuongHocSinh; i++) {
            if (danhSach[i].getStudentId() == selectStudentCode) {
                // dich chuyen cac phan tu sau vi tri i len 1 don vi

                System.out.println("Thông tin sinh viên cần xóa:");
                danhSach[i].displayData();
                System.out.print("Bạn có chắc chắn muốn xóa sinh viên này? (yes/no): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    // dich chuyen cac phan tu sau vi tri i len 1 don vi
                    for (int j = i; j < soLuongHocSinh - 1; j++) {
                        danhSach[j] = danhSach[j + 1];
                    }
                    danhSach[soLuongHocSinh - 1] = null;
                    soLuongHocSinh--;
                    Action.soLuongHocSinh = soLuongHocSinh;
                    showListStudent(danhSach, soLuongHocSinh);
                    System.out.println("Xoá sinh viên thành công!!");
                } else {
                    System.out.println("Đã hủy thao tác xóa.");
                }
                return;


            }
        }
        System.out.println("Không tìm thấy sinh viên có mã " + selectStudentCode);
    }
}
