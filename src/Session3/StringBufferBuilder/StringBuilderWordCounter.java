package Session3.StringBufferBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StringBuilderWordCounter {
    public static void main(String[] args) {
        String fileName = "/Users/bhnone/Work/Coding/Java/Module2/src/Session3/StringBufferBuilder/document.txt";

        File file = new File(fileName);
        String[] parts = fileName.split("/");
        String fileNameWithoutPath = parts[parts.length - 1];
        if (!file.exists()) {
            System.out.println("File does not exist" + fileNameWithoutPath);
        }
        int countWords = countWordInFile(fileName);
        System.out.println(countWords);
    }

    public static int countWordInFile(String fileName) {
        StringBuilder contextFile = new StringBuilder();
        int countWords = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                contextFile.append(line).append(" ");
            }
            String[] eachWord = contextFile.toString().trim().split("[^\\p{L}\\p{N}]+");
            countWords = eachWord.length;

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return countWords;
    }
}
