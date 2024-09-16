package Session2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2_AnotherWay {
    private static final String[] DIGITS = {
            "không", "một", "hai", "ba", "bốn",
            "năm", "sáu", "bảy", "tám", "chín"
    };

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

        List<String> output = new ArrayList<>();
//        int iterations = (int) Math.ceil((double) num.length() / 3);
        for (int i = 0; i < num.length() / 3; i++) {
//            int startIndex = i * 3;
//            int endIndex = Math.min(startIndex + 3, num.length());
//            String group = num.substring(startIndex, endIndex);
//            System.out.println(group);

            // chuyen sang so
            String a = num.substring(i * 3, i * 3 + 1);
            String b = num.substring(i * 3 + 1, i * 3 + 2);
            String c = num.substring(i * 3 + 2, i * 3 + 3);

            output.addAll(readThree(a, b, c));
            output.add(UNITS[num.length() / 3 - 1 - i]);

//            System.out.println(readThree(a, b, c) + " " + UNITS[num.length() / 3 - 1 - i]);
        }
        System.out.println(String.join(" ", output));
    }

    public static List<String> readThree(String a, String b, String c) {
        List<String> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        result.add(c);
        return result;
    }

    public static List<String> readTwo(int b, int c, boolean hasHundred) {
        List<String> output = new ArrayList<>();
        switch (b) {
            case 0: {

                // neu co doc hang tram  va b = 0, c = 0
                // thi khong doc nua
                if (hasHundred && c == 0) {
                    break;
                }
                if (hasHundred) {
                    output.add("lẻ"); // vi du a07 doc la "a lẻ bảy"
                }
                output.add(DIGITS[c]);
                break;
            }
            case 1: {
                // truong hop so hang chuc la 10
                output.add("mười");
                if (c == 5) {
                    output.add("lăm");
                } else if (c != 0) {
                    output.add(DIGITS[c]);
                    // c == 0 khong xet vi da doc la muoi
                }
                break;
            }
            default: {
                output.add(DIGITS[b]);
                output.add("mươi");// b mươi
                if (c == 1) {
                    output.add("mốt");
                } else if (c == 4) {
                    output.add("tư");
                } else if (c == 5) {
                    output.add("lăm");
                } else if (c != 0) {
                    output.add(DIGITS[c]);
                    // khong doc c = 0 vi da doc "b mươi" roi
                }
                break;
            }

        }
        return output;
    }


}
