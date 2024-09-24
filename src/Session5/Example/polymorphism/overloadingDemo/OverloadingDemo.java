package Session5.Example.polymorphism.overloadingDemo;

public class OverloadingDemo {
    // C1: thay doi so luong tham so
    public int addTwoNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int addTwoNumbers(int firstNumber, int secondNumber, int thirdNumber) {
        return firstNumber + secondNumber + thirdNumber;
    }

    // C2: thay doi thu tu tham so
    public void test(int number, String name) {

    }

    public void test(String name, int number) {

    }

    // C3: thay doi kieu du lieu cua tham so
    public float addTwoNumbers(float firstNumber, float secondNumber) {
        return firstNumber + secondNumber;
    }


}
