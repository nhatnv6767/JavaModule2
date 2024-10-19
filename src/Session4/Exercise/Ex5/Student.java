package Session4.Exercise.Ex5;

/*
 * Thuộc tính:
 * - radius: kiểu double
 * */

import java.util.Scanner;

public class Student {
    private String maHS;
    private String tenHS;
    private int tuoi;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;

    public Student() {
    }

    public Student(String maHS, String tenHS, int tuoi, String gioiTinh, String diaChi, String soDienThoai) {
        this.maHS = maHS;
        this.tenHS = tenHS;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getTenHS() {
        return tenHS;
    }

    public void setTenHS(String tenHS) {
        this.tenHS = tenHS;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã học sinh: ");
        this.maHS = scanner.nextLine();
        System.out.print("Nhập tên học sinh: ");
        this.tenHS = scanner.nextLine();


        boolean inputValid = false;
        do {
            System.out.print("Nhập tuổi: ");
            if (scanner.hasNextInt()) {
                this.tuoi = Integer.parseInt(scanner.nextLine());
                inputValid = true;
            } else {
                System.out.println("Tuổi phải là số nguyên. Vui lòng nhập lại");
                scanner.nextLine();
            }
        } while (!inputValid);


        System.out.print("Nhập giới tính: ");
        this.gioiTinh = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.diaChi = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.soDienThoai = scanner.nextLine();
    }

    public void displayData() {
        String[] lines = {
                "Mã HS: " + this.maHS,
                "Tên HS: " + this.tenHS,
                "Tuổi: " + this.tuoi,
                "Giới tiính: " + this.gioiTinh,
                "Địa chỉ: " + this.diaChi,
                "Số điện thoại: " + this.soDienThoai
        };
        int longestLength = findLongestLength(lines);
        int totalLength = longestLength + 8;

        System.out.println("-".repeat(totalLength));

        for (String line : lines) {
//            int padding = totalLength - line.length() - 2;
//            System.out.println("| " + line + " ".repeat(padding) + "|");


            int paddingLeft = (totalLength - line.length() - 2) / 2;
            int paddingRight = totalLength - line.length() - 3 - paddingLeft;
            String oneLine = "| " + " ".repeat(paddingLeft) + line + " ".repeat(paddingRight) + " |";
            System.out.println(oneLine);
        }
        System.out.println("-".repeat(totalLength));
    }

    private static int findLongestLength(String[] mang) {
        int max = 0;
        for (String s : mang) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public String getMaHS() {
        return this.maHS;
    }
}
