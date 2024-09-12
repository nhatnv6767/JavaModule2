package Session1;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float tongDiem = 0;
        System.out.print("Nhập điểm Toán: ");
        float diem = Float.parseFloat(scanner.nextLine());
        tongDiem += diem;
        System.out.print("Nhập điểm Lý: ");
        diem = Float.parseFloat(scanner.nextLine());
        tongDiem += diem;
        System.out.print("Nhập điểm Hoá: ");
        diem = Float.parseFloat(scanner.nextLine());
        tongDiem += diem;

        System.out.printf("Trung bình cộng điểm 3 môn: %.2f", tongDiem / 3);

    }
}
