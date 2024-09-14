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
        int soDauSaoCanThiet = doDaiLonNhat + 4; // Cộng thêm 4 cho 2 dấu cách và 2 dấu * ở hai bên

        // In dòng đầu tiên
        System.out.println("*".repeat(soDauSaoCanThiet));

        // In các món ăn
        for (String mon : monAn) {
            int padding = (soDauSaoCanThiet - mon.length() - 2) / 2; // Tính padding để căn giữa
            String dong = "* " + " ".repeat(padding) + mon + " ".repeat(padding) + " *";
            // Đảm bảo số lượng dấu cách là chẵn để căn giữa hoàn hảo
            if (dong.length() < soDauSaoCanThiet) {
                dong += " ";
            }
            System.out.println(dong);
        }

        // In dòng cuối cùng
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
