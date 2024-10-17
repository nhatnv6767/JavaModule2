package ExercisePlus.JAPAN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_2 {
    public static void main(String[] args) {

        String text = "hello_world_trice";

        Pattern pattern = Pattern.compile("^[a-z]+(_[a-z]+)+$");
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());
    }
}

//Pattern pattern = Pattern.compile("^[a-z]+(_[a-z]+)+$");
//Pattern pattern = Pattern.compile("^[a-z]+(_[a-z]+)+$");