package Session6.Example.abtractClass;

public class Demo extends AbstractClass {
    @Override
    public int addTwoNumber(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public void inputData() {
        System.out.println("Nhập dữ lệu cho đối tượng:");
    }

    @Override
    public void displayData() {
        System.out.println("Hiển thị dữ liệu cho đối tượng:");
    }
}
