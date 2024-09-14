package Session2;

public class Ex6 {
    public static void main(String[] args) {
        System.out.println("20 số nguyên tố đầu tiên là:");
        int count = 0;
        int number = 2;
        while (count < 20) {
            if (isPrime(number, (int) Math.sqrt(number))) {
                System.out.print(number + " ");
                count++;
            }
            number++;
        }
    }

    public static boolean isPrime(int n, int i) {
        if (n < 2) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        if (n % i == 0) {
            return false;
        }
        return isPrime(n, i - 1);
    }
}
