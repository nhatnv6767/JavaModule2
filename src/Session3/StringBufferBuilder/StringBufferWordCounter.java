package Session3.StringBufferBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StringBufferWordCounter {
    public static void main(String[] args) {
        String fileName = "/Users/bhnone/Work/Coding/Java/Module2/src/Session3/StringBufferBuilder/document.txt";

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + fileName);
            return;
        }

        int countWords = countWordInFile(fileName);
        String[] parts = fileName.split("/");
        String fileNameWithoutPath = parts[parts.length - 1];
        if (countWords != -1) {
            System.out.println("Số từ trong file " + fileNameWithoutPath + " là: " + countWords);

            // tim tu xuat hien nhieu nhat
            String mostFrequentWord = findMosFrequentWord(fileName);
            int frequency = countWorldFrequency(fileName, mostFrequentWord);
            if (mostFrequentWord != null) {
                System.out.println("Từ xuất hiện nhiều nhất: " + mostFrequentWord);
                System.out.println("Số lần xuất hiện: " + frequency);
            } else {
                System.out.println("Không tìm thấy từ nào trong file.");
            }

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

            String[] eachWord = contextFile.toString().trim().split("[^\\p{L}\\p{N}]+");
            countWords = eachWord.length;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return countWords;
    }

    public static String findMosFrequentWord(String fileName) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("[^\\p{L}\\p{N}]+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        String mostFrequentWord = null;
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentWord = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        return mostFrequentWord;
    }

    public static int countWorldFrequency(String fileName, String word) {
        int frequency = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("[^\\p{L}\\p{N}]+");
                for (String w : words) {
                    if (w.equalsIgnoreCase(word)) {
                        frequency++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return frequency;
    }
}
