package Session8.Example;

import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) throws Exception {

        // Xu ly ngoai le cho khoi lenh ben duoi voi try...catch
        Scanner scanner = new Scanner(System.in);
//        System.out.println("CHuong trinh bat dau");
//        try {
////            System.out.println("Nhap so nguyen thu nhat:");
////            int firstNumber = Integer.parseInt(scanner.nextLine());
////            System.out.println("Nhap so nguyen thu hai:");
////            int secondNumnber = Integer.parseInt(scanner.nextLine());
////            // unchecked exception
////            int div = firstNumber / secondNumnber;
////            System.out.printf("Ket qua cua phep chia giua %d va %d la: %d\n", firstNumber, secondNumnber, div);
//        } catch (NumberFormatException e) {
//            System.err.println("Loi dinh dang du lieu dau vao, moi ban chay lai chuong trinh");
//        } catch (ArithmeticException ex) {
//            System.err.println("Loi chia cho 0, moi ban chay lai chuong trinh");
//        } finally {
//            System.out.println("Chuong trinh ket thuc.");
//        }


        // checked exception
        //        Class.forName("");

        int result = divTwoNumber(8, 0);
        System.out.println("Ket qua 2 so " + result);


    }

    public static int divTwoNumber(int firstNumber, int secondNumber) throws Exception {
        // su dung throw de nem ngoai le cac truong hop cu the
//        if (secondNumber == 0) {
//            // nem 1 doi tuong ngoai le de xu ly
//            throw new ArithmeticException("Loi chia 0 trong phep chia");
//        }
        int result = firstNumber / secondNumber;
        return result;
    }
}
