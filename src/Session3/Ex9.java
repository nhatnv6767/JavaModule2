package Session3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex9 {
    public static void main(String[] args) {
        String email = "abdsafsd@gmail..com";
        String password = "pass";

        boolean validEmail = checkEmail(email);
        boolean validPassword = checkPassword(password);

        if (validEmail) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }

        if (validPassword) {
            System.out.println("Password hợp lệ");
        } else {
            System.out.println("Password không hợp lệ");

        }
    }

    public static boolean checkEmail(String email) {
        String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean checkPassword(String password) {
        String regexPassword = "^\\S{6,}$";
        Pattern pattern = Pattern.compile(regexPassword);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
