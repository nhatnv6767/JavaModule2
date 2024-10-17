package Session11.Example;

public class Demo {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        Demo02 demo02 = new Demo02();
        System.out.println("Tong 2 so 5 va 7: " + demo01.sumTwoNumbers(5, 7));

        System.out.println("Hieu 2 so 10 va 3: " + StaticMethod.minusTwoNumbers(10, 3));
    }
}
