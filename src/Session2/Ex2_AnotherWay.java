package Session2;

import java.util.Scanner;

public class Ex2_AnotherWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập vào một số: ");

        String num = "4540204504";

        // tinh so luong so 0 can them vao
        int needZeroCount = num.length() % 3;
        if (needZeroCount != 0) {
            needZeroCount = 3 - needZeroCount;
        }

        // them so luong so 0 vao de % 3 == 0
        num = "0".repeat(needZeroCount) + num;

        System.out.println(num);
    }


}
