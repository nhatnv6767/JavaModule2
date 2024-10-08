package Session11.Example.ra.lambda;

public class Demo {
    public static void main(String[] args) {
        // khoi tao doi tuong tu functional interface
        // cach 1
        IFunctionalInterface if1 = new IFunctionalInterface() {
            @Override
            public int addTwoNumbers(int firstNumber, int secondNumber) {
                int total = firstNumber + secondNumber;
                return total;
            }
        };

        System.out.println("Tong 5 va 10: " + if1.addTwoNumbers(5, 10));
        // cach 2
        IFunctionalInterface if2 = (firstNumber, secondNumber) -> {
            int total = firstNumber + secondNumber;
            return total;
        };

        // cach 3
        IFunctionalInterface if3 = (firstNumber, secondNumber) -> firstNumber + secondNumber;
        System.out.println("Tong 5 va 10: " + if3.addTwoNumbers(5, 10));
    }
}
