package Session3;

public class Ex7 {
    public static void main(String[] args) {
        String defaultString = "Xin chào các bạn!";
        String childString = "ác bạ";

        boolean hasChildString = defaultString.contains(childString);
        if (hasChildString) {
            System.out.println("Chuỗi gốc chứa chuỗi con.");
        } else {
            System.out.println("Chuỗi gốc không chứa chuỗi con.");
        }
    }
}
