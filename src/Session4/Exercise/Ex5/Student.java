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
        System.out.print("Nhập tuổi: ");
        this.tuoi = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        this.gioiTinh = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.diaChi = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.soDienThoai = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("Mã HS: " + maHS);
        System.out.println("Tên HS: " + tenHS);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Số điện thoại: " + soDienThoai);
        System.out.println("--------------------");
    }

    public String getMaHS() {
        return this.maHS;
    }
}
