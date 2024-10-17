package Session2;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println("Numbers divisible by 3 and 5 between 1 and 100");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.printf("%d\t", i);
            }
        }
    }
}
