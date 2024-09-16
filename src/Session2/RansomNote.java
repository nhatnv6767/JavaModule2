package Session2;

import java.util.HashMap;

public class RansomNote {
    public static boolean canAccept(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        boolean result = canAccept("aaaa", "aaaabfds");
        System.out.println(result);
    }
}
