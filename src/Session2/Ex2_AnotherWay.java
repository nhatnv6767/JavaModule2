package Session2;

import java.util.Scanner;

public class Ex2_AnotherWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một số: ");
        long number = Long.parseLong(scanner.nextLine());
        System.out.println(convertNumberToWords(number));
    }

    public static String convertNumberToWords(long number) {
        if (number == 0) {
            return "không";
        }
        String[] units = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
        String[] teens = {"mười", "mười một", "mười hai", "mười ba", "mười bốn", "mười lăm", "mười sáu", "mười bảy", "mười tám", "mười chín"};
        String[] tens = {"", "mười", "hai mươi", "ba mươi", "bốn mươi", "năm mươi", "sáu mươi", "bảy mươi", "tám mươi", "chín mươi"};
        String[] thousans = {"", "nghìn", "triệu", "tỷ"};

        String words = "";
        int thousandIndex = 0;
        while (number > 0) {
            // lay 3 chu so
            long group = number % 1000;
            if (group > 0) {
                words = convertGroupToWords(group, units, teens, tens) + " " + thousans[thousandIndex] + " " + words;
            }
            number /= 1000;
            thousandIndex++;
        }
        return words.trim();
    }

    public static String convertGroupToWords(long group, String[] units, String[] teens, String[] tens) {
        int hundred = (int) (group / 100);
        int ten = (int) ((group % 100) / 10);
        int unit = (int) (group % 10);

        String words = "";
        // xu ly hang tramm
        if (hundred > 0) {
            words += units[hundred] + " trăm ";
            if (ten == 0 && unit == 0) {
                words += "lẻ ";
            }
        }

        if (ten > 0) {
            if (ten == 1) {
                words += teens[unit];
            } else {
                words += tens[ten];
                if (unit > 0) {
                    words += " " + units[unit];
                }
            }
        } else if (unit > 0) {
            words += units[unit];
        }


        return words.trim();
    }
}
