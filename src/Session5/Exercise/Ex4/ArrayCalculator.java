package Session5.Exercise.Ex4;

public class ArrayCalculator {
    public static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static double sumOfArray(double[] arr) {
        double sum = 0;
        for (double num : arr) {
            sum += num;
        }
        return sum;
    }
}
