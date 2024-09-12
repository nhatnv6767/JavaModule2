package ra;

public class HelloWord {
    public static void main(String[] args) {
        System.out.println("Hello Word");
        float number = 5.7f;
        int totalNumber = addTwoNumbers(5, 7);
        int[] arrInt = {3, 5, 7};
    }

    public static int addTwoNumbers(int firstNumber, int secondNumber) {
        int sumNumbers = firstNumber + secondNumber;
        return sumNumbers;
    }
}
