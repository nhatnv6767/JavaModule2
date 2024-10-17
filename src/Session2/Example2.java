package Session2;

import java.util.Scanner;

public class Example2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            hienThiMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            xuLyLuaChon(luaChon);
        } while (luaChon != 6);

        scanner.close();
    }

    public static void hienThiMenu() {
        String[] monAn = {
                "1. Phở bò Kobe",
                "2. Phở gà Việt Nam",
                "3. Xôi trứng thịt",
                "4. Bánh mì Pate",
                "5. Mỳ tôm không người lái",
                "6. Thoát"
        };

        int doDaiLonNhat = timDoDaiLonNhat(monAn);
        int soDauSaoCanThiet = doDaiLonNhat + 4;

        System.out.println("*".repeat(soDauSaoCanThiet));

        // In các món ăn
        for (String mon : monAn) {
            int paddingTrai = (soDauSaoCanThiet - mon.length() - 2) / 2;
            int paddingPhai = soDauSaoCanThiet - mon.length() - 2 - paddingTrai;
            String dong = "* " + " ".repeat(paddingTrai) + mon + " ".repeat(paddingPhai) + " *";
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

    public static void xuLyLuaChon(int luaChon) {
        switch (luaChon) {
            case 1:
                System.out.println("Bạn đã chọn Phở bò Kobe. Đang chuẩn bị...");
                break;
            case 2:
                System.out.println("Bạn đã chọn Phở gà Việt Nam. Đang chuẩn bị...");
                break;
            case 3:
                System.out.println("Bạn đã chọn Xôi trứng thịt. Đang chuẩn bị...");
                break;
            case 4:
                System.out.println("Bạn đã chọn Bánh mì Pate. Đang chuẩn bị...");
                break;
            case 5:
                System.out.println("Bạn đã chọn Mỳ tôm không người lái. Đang chuẩn bị...");
                break;
            case 6:
                System.out.println("Thoát chương trình. Hẹn gặp lại!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }
}
