package Session2;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tuổi của bạn: ");
        int tuoi = scanner.nextInt();

        int giaVe = 7000;
        int tienPhaiTra = 0;

        if (tuoi < 6 || tuoi > 60) {
            tienPhaiTra = 0;
        } else if (tuoi >= 6 && tuoi <= 18) {
            tienPhaiTra = giaVe / 2;
        } else {
            tienPhaiTra = giaVe;
        }

        System.out.println("Số tiền bạn phải trả là: " + tienPhaiTra + " VND");

        scanner.close();
    }
}

// Khi nằm trên 1 miền giá trị thì sử dụng if else,
// trong trường hợp này sử duụng switch case thì sẽ có vô vàn switch case => không khả thi
