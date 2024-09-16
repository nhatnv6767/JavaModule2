package Session2;

import java.util.Scanner;

public class Ex2_AnotherWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập vào một số: ");


        String num = "4540204504";
        final String[] UNITS = {"đơn vị", "nghìn", "triệu", "tỷ"};

        // tinh so luong so 0 can them vao
        int needZeroCount = num.length() % 3;
        if (needZeroCount != 0) {
            needZeroCount = 3 - needZeroCount;
        }

        // them so luong so 0 vao de % 3 == 0
        num = "0".repeat(needZeroCount) + num;

        System.out.println(num);

        int iterations = (int) Math.ceil((double) num.length() / 3);
        for (int i = 0; i < iterations; i++) {
            int startIndex = i * 3;
            int endIndex = Math.min(startIndex + 3, num.length());
            String group = num.substring(startIndex, endIndex);
//            System.out.println(group);

            // chuyen sang so
            int a = Integer.parseInt(group.substring(0, 1));
            int b = Integer.parseInt(group.substring(1, 2));
            int c = Integer.parseInt(group.substring(2, 3));

            System.out.println(a + " " + b + " " + c + " " + UNITS[num.length() / 3 - 1 - i]);
        }
    }


}
