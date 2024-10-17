package Session7.Exercise.Ex2;

import java.util.ArrayList;
import java.util.List;

public class LongWords {
    public static void main(String[] args) {
        String sample = "Viết chương trình để tạo ra một danh sách (List) chứa các chuỗi từ một String cho sẵn và in ra các chuỗi có độ dài lớn hơn 3 ký tự";
        String[] words = sample.split(" ");

        List<String> longWords = new ArrayList<>();

        for (String word : words) {
            if (word.length() > 3) {
                longWords.add(word);
            }
        }

        System.out.println("Sample String: " + sample);
        System.out.println("Cac tu co do dai lon hon 3: " + longWords);
    }
}
