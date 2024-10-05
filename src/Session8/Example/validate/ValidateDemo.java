package Session8.Example.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ValidateDemo {
    public static void main(String[] args) {
        /*
        Nhap vao va hien thi thong tin sinh vien:
        1. Ma sinh vien
        2. Ten sinh vien
        3. Tuoi sinh vien phai la so nguyen va co gia tri lon hon hoac bang 18
        4. Diem trung binh sinh vien phai la so thuc (float) va co gia tri lon hon hoac bang 0 be hon hoac bang 10
        5. Ngay sinh sinh vien phai co kieu du lieu la Date va co dinh dang dd/MM/yyyy
        * */
        Scanner scanner = new Scanner(System.in);
        String studentId = inputStudentId(scanner);
        String studentName = inputStudentName(scanner);
        int age = inputStudentAge(scanner);
        float avgMark = inputAvgMark(scanner);
        Date birthDate = inputBirthDate(scanner);
    }

    public static String inputStudentId(Scanner scanner) {
        System.out.println("Nhap vao ma sinh vien: ");
        return scanner.nextLine();
    }

    public static String inputStudentName(Scanner scanner) {
        System.out.println("Nhap vao ten sinh vien: ");
        return scanner.nextLine();
    }

    public static int inputStudentAge(Scanner scanner) {
        System.out.println("Nhap vao tuoi sinh vien: ");
        // tuoi co kieu du lieu la so nguyen
        do {
            try {
                int age = Integer.parseInt(scanner.nextLine());
                if (age >= 18) {
                    return age;
                } else {
                    System.err.println("Tuoi phai lon hon 18");
                }
            } catch (NumberFormatException e) {
                System.err.println("Tuoi sinh vien phai la so nguyen, vui long nhap lai");
            } catch (Exception e) {
                System.err.println("Co loi khong xac dinh" + e.getMessage());
            }
        } while (true);
    }

    public static float inputAvgMark(Scanner scanner) {
        System.out.println("Nhap vao diem trung binh sinh vien:");
        do {
            try {
                float avgMark = Float.parseFloat(scanner.nextLine());
                if (avgMark >= 0 && avgMark <= 10) {
                    return avgMark;
                } else {
                    System.err.println("Diem trung binh nam trong khoang 0 den 10");
                }
            } catch (NumberFormatException e) {
                System.err.println("Diem trung binh sinh vien la so thuc, vui long nhap lai");
            } catch (Exception e) {
                System.err.println("Da co loi khong xac dinh" + e.getMessage());
            }
        } while (true);
    }

    public static Date inputBirthDate(Scanner scanner) {
        System.out.print("Nhap vao ngay sinh sinh vien: dd/mm/yyyy");
        do {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
                Date birthDate = sdf.parse(scanner.nextLine());
                return birthDate;
            } catch (ParseException e) {
                System.err.println("Khong dung dinh dang");
            } catch (Exception e) {
                System.err.println("Da co loi khong xac dinh" + e.getMessage());
            }
        } while (true);
    }
}
