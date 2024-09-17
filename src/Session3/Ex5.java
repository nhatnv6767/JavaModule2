package Session3;

import java.util.Arrays;
import java.util.Random;

public class Ex5 {
    public static void main(String[] args) {

        Random rand = new Random();

        // random 10 - 40
        int sizeArr = rand.nextInt(31) + 10;

        int[] arr = new int[sizeArr];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }

        int minValue = findMin(arr);
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        System.out.println("Min value = " + minValue);
    }

    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
//            throw new IllegalArgumentException("Mảng không hợp lệ");
            System.err.println("Mảng không hợp lệ");
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
