package Session2;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tuổi của bạn: ");
        int tuoi = scanner.nextInt();

        int giaVe = 7000;
        int tienPhaiTra;
        int loaiKhachHang;

        if (tuoi < 6 || tuoi > 60) {
            loaiKhachHang = 0;
        } else if (tuoi >= 6 && tuoi <= 18) {
            loaiKhachHang = 1;
        } else {
            loaiKhachHang = 2;
        }

        switch (loaiKhachHang) {
            case 0:
                tienPhaiTra = 0;
                break;
            case 1:
                tienPhaiTra = giaVe / 2;
                break;
            case 2:
                tienPhaiTra = giaVe;
                break;
            default:
                tienPhaiTra = -1;
                break;
        }

        if (tienPhaiTra != -1) {
            System.out.println("Số tiền bạn phải trả là: " + tienPhaiTra + " VND");
        } else {
            System.out.println("Lỗi: Tuổi không hợp lệ.");
        }

        scanner.close();
    }
}

// Khi nằm trên 1 miền giá trị thì sử dụng if else,
// trong trường hợp này sử duụng switch case thì sẽ có vô vàn switch case => không khả thi
