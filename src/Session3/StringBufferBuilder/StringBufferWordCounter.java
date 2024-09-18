package Session3.StringBufferBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StringBufferWordCounter {
    public static void main(String[] args) {
        String fileName = "/Users/bhnone/Work/Coding/Java/Module2/src/Session3/StringBufferBuilder/document.txt";

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + fileName);
            return;
        }

        int countWords = countWordInFile(fileName);
        if (countWords != -1) {
            System.out.println("Số từ trong file " + fileName + " là: " + countWords);
        } else {
            System.out.println("Xảy ra lỗi khi đọc file.");
        }
    }

    public static int countWordInFile(String fileName) {
        StringBuffer contextFile = new StringBuffer();
        int countWords = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // con truong hop tu o cuoi dong
                contextFile.append(line).append(" ");
            }

            String[] eachWord = contextFile.toString().trim().split("\\s+");
            countWords = eachWord.length;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return countWords;
    }
}
