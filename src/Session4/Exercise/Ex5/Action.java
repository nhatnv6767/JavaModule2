package Session4.Exercise.Ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Action {
    public static void main(String[] args) {
        List<Student> danhSachHocSinh = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int luaChon;
        do {
            hienThiMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = Integer.parseInt(scanner.nextLine());
            xuLyLuaChon(luaChon, scanner, danhSachHocSinh);
        } while (luaChon != 5);
    }

    public static void hienThiMenu() {
        String[] options = {
                "1. Hiển thị danh sách tất cả học sinh",
                "2. Thêm mới học sinh",
                "3. Sửa thông tin học sinh dựa vào mã học sinh",
                "4. Xóa học sinh dựa vào mã học sinh",
                "5. Thoát"
        };

        int doDaiLonNhat = timDoDaiLonNhat(options);
        int soDauSaoCanThiet = doDaiLonNhat + 6;

        System.out.println("*".repeat(soDauSaoCanThiet + 2));

        // In các món ăn
        for (String select : options) {
            int paddingTrai = (soDauSaoCanThiet - select.length() - 2) / 2;
            int paddingPhai = soDauSaoCanThiet - select.length() - 2 - paddingTrai;
            String dong = "* " + " ".repeat(paddingTrai) + select + " ".repeat(paddingPhai) + " *";
            System.out.println(dong);
        }

        System.out.println("*".repeat(soDauSaoCanThiet + 2));
    }

    public static int timDoDaiLonNhat(String[] mang) {
        int max = 0;
        for (String s : mang) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public static void xuLyLuaChon(int luaChon, Scanner scanner, List<Student> danhSachHocSinh) {
        switch (luaChon) {
            case 1:
                System.out.println("==> 1. Hiển thị danh sách tất cả học sinh");
                hienThiDanhSachHocSinh(danhSachHocSinh);
                break;
            case 2:
                System.out.println("==> 2. Thêm mới học sinh");
                themHocSinh(danhSachHocSinh, scanner);
                break;
            case 3:
                System.out.println("==> 3. Sửa thông tin học sinh dựa vào mã học sinh");
                suaThongTinHocSinh(danhSachHocSinh, scanner);
                break;
            case 4:
                System.out.println("==> 4. Xóa học sinh dựa vào mã học sinh");
//                optionDividedByThree(scanner);
                break;
            case 5:
                System.out.println("==> 5. Thoát chương trình....");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    private static void hienThiDanhSachHocSinh(List<Student> danhSach) {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách học sinh trống.");
        } else {
            for (Student hocSinh : danhSach) {
                hocSinh.displayData();
            }
        }
    }

    private static void themHocSinh(List<Student> danhSach, Scanner scanner) {
        Student hocSinhMoi = new Student();
        hocSinhMoi.inputData(scanner);
        danhSach.add(hocSinhMoi);
        System.out.println("Thêm học sinh thành công");
    }

    private static void suaThongTinHocSinh(List<Student> danhSach, Scanner scanner) {
        System.out.print("Mời nhập vào mã của học sinh cần sửa: ");
        String maHS = scanner.nextLine();
        for (Student hocSinh : danhSach) {
            if (hocSinh.getMaHS().equals(maHS)) {
                System.out.println("Nhập thông tin mới cho học sinh: ");
                hocSinh.inputData(scanner);
                System.out.println("Sửa thông tin học sinh thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có mã " + maHS);

    }
}
