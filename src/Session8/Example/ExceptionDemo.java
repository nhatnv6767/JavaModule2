package Session8.Example;

import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {

        // Xu ly ngoai le cho khoi lenh ben duoi voi try...catch
        Scanner scanner = new Scanner(System.in);
        System.out.println("CHuong trinh bat dau");
        try {
            System.out.println("Nhap so nguyen thu nhat:");
            int firstNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhap so nguyen thu hai:");
            int secondNumnber = Integer.parseInt(scanner.nextLine());
            // unchecked exception
            int div = firstNumber / secondNumnber;
            System.out.printf("Ket qua cua phep chia giua %d va %d la: %d\n", firstNumber, secondNumnber, div);
        } catch (Exception e) {
            System.out.println("Chuong trinh bi loi " + e.getMessage());
            System.out.println("Hay chay lai chuong trinh");
        } finally {
            System.out.println("Chuong trinh ket thuc.");
        }


        // checked exception
        //        Class.forName("");


    }
}
