package Session2;

public class Ex5 {
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố nhỏ hơn 100 là: ");
        for (int i = 2; i < 100; i++) {
            if (isPrime(i, (int) (Math.sqrt(i)))) {
                System.out.print(i + " ");
            }
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


// 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97