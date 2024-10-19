package Session6.Example.abtractClass;

public abstract class AbstractClassDemo {
    //1. Gom cac thuoc tinh
    private int firstNumber;
    private String fullName;
    // 2. Constructor

    public AbstractClassDemo() {
    }

    public AbstractClassDemo(int firstNumber, String fullName) {
        this.firstNumber = firstNumber;
        this.fullName = fullName;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // 3. cac phuong thuc trien khai
    public void hello() {
        System.out.println("Hello");
    }

    //4 . cac phuong thuc truu tuong -> khong co phan trien khai ( khong co than)
    public abstract void inputData();

    public abstract void displayData();
}
