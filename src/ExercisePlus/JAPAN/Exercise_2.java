package ExercisePlus.JAPAN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_2 {
    public static void main(String[] args) {
        String text = "go with me and do something";

        Pattern pattern = Pattern.compile("\\b[^g\\s]\\w*g\\w*[^g\\s]\\b");
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());
    }
}
