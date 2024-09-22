package ExercisePlus.JAPAN;

import java.util.regex.Pattern;

public class Exercise {
    public static void main(String[] args) {
        String testSuccess = "Welcome to Viet Nam 2024";
        String testFailure = "wel_come$to=viet_nam";
        Exercise ex1 = new Exercise();
        System.out.println(ex1.checkAllowedChars(testSuccess));
        System.out.println(ex1.checkAllowedChars(testFailure));

    }

    public boolean checkAllowedChars(String str) {
        String regex = "^[a-zA-Z0-9\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
}
