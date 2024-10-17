package Session2;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double canhA, canhB, canhC;
        do {
            System.out.print("Nhập vào độ dài cạnh A: ");
            canhA = scanner.nextDouble();

            System.out.print("Nhập vào độ dài cạnh B: ");
            canhB = scanner.nextDouble();

            System.out.print("Nhập vào độ dài cạnh C: ");
            canhC = scanner.nextDouble();

            if (laTamGiac(canhA, canhB, canhC)) {
                double chuVi = tinhChuVi(canhA, canhB, canhC);
                double dienTich = tinhDienTich(canhA, canhB, canhC);
                System.out.println("Đây là 1 tam giác hợp lệ");
                System.out.println("Chu vi: " + chuVi);
                System.out.println("Diện tích: " + dienTich);
                break;
            } else {
                System.out.println("Đây không phải là 1 tam giác hợp lệ, nhập lại");
            }
        } while (true);
    }

    public static boolean laTamGiac(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static double tinhChuVi(double a, double b, double c) {
        return a + b + c;
    }

    public static double tinhDienTich(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
