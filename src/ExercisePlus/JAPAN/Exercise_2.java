package ExercisePlus.JAPAN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_2 {
    public static void main(String[] args) {
        String text = "present tasion";

        Pattern pattern = Pattern.compile("^[p.*\\s]+$");
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());
    }
}
