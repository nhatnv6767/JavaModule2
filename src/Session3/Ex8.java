package Session3;

public class Ex8 {
    public static void main(String[] args) {
        String defaultText = "      Trung tâm luyện thi chất lượng cao        ";
        String afterRemoteWhiteSpace = removeExcessWhiteSpacing(defaultText);

        System.out.println("Chuỗi ban đầu: |" + defaultText + "|");
        System.out.println("Chuỗi sau khi loại bỏ khoảng trắng: |" + afterRemoteWhiteSpace + "|");

    }

    public static String removeExcessWhiteSpacing(String text) {
        if (text == null) {
            return null;
        }
        return text.trim();
    }
}
