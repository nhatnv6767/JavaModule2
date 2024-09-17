package Session2;

import java.util.Scanner;

public class Ex7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            hienThiMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = Integer.parseInt(scanner.nextLine());
            xuLyLuaChon(luaChon, scanner);
        } while (luaChon != 0);

        scanner.close();
    }

    public static void hienThiMenu() {
        String[] options = {
                "1. Kiểm tra tính chẵn lẻ của 1 số",
                "2. Kiểm tra số nguyên tố",
                "3. Kiểm tra một số có chia hết cho 3 không",
                "0. Thoát"
        };

        int doDaiLonNhat = timDoDaiLonNhat(options);
        int soDauSaoCanThiet = doDaiLonNhat + 6;

        System.out.println("*".repeat(soDauSaoCanThiet));

        // In các món ăn
        for (String select : options) {
            int paddingTrai = (soDauSaoCanThiet - select.length() - 2) / 2;
            int paddingPhai = soDauSaoCanThiet - select.length() - 2 - paddingTrai;
            String dong = "* " + " ".repeat(paddingTrai) + select + " ".repeat(paddingPhai) + " *";
            System.out.println(dong);
        }

        System.out.println("*".repeat(soDauSaoCanThiet));
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

    public static void xuLyLuaChon(int luaChon, Scanner scanner) {
        switch (luaChon) {
            case 1:
                System.out.println("==> 1. Kiểm tra tính chẵn lẻ của 1 số");
                kiemTraChanLe(scanner);
                break;
            case 2:
                System.out.println("==> 2. Kiểm tra số nguyên tố");
                optionPrime(scanner);
                break;
            case 3:
                System.out.println("==> 3. Kiểm tra một số có chia hết cho 3 không");
                optionDividedByThree(scanner);
                break;
            case 0:
                System.out.println("==> 0. Thoát chương trình....");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    public static void kiemTraChanLe(Scanner scanner) {
        System.out.print("Nhập vào 1 số: ");
        int so = Integer.parseInt(scanner.nextLine());
        if (so % 2 == 0) {
            System.out.printf("%d la so chan\n", so);
        } else {
            System.out.printf("%d la so le\n", so);
        }
    }

    public static void optionPrime(Scanner scanner) {
        System.out.print("Nhập vào 1 số nguyên: ");
        int number = Integer.parseInt(scanner.nextLine());
        if (isPrime(number, (int) Math.sqrt(number))) {
            System.out.printf("%d là số nguyên tố\n", number);
        } else {
            System.out.printf("%d không là số nguyên tố\n", number);
        }
    }

    public static boolean isPrime(int n, int i) {
        if (n < 2) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        if (n % i == 0) {
            return false;
        }
        return isPrime(n, i - 1);
    }

    public static void optionDividedByThree(Scanner scanner) {
        System.out.print("Nhập vào 1 số nguyên: ");
        int number = Integer.parseInt(scanner.nextLine());
        if (number % 3 == 0) {
            System.out.printf("%d chia hết cho 3\n", number);

        } else {
            System.out.printf("%d không chia hết cho 3\n", number);
        }
    }
}
