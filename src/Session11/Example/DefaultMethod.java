package Session11.Example;

public interface DefaultMethod {
    void test();

    // Default method: phuong thuc thuc thi trong interface
    default int sumTwoNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
