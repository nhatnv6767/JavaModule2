package Session5.Exercise.Ex4;

public class Main {
    public static void main(String[] args) {
        int[] intArr = {1, 4, 56, 4, 5, 3, 44, -9};
        double[] doubleArr = {1.2, 3.5, 5, 7, 66.745, 5, -6};

        int intSum = ArrayCalculator.sumOfArray(intArr);
        double doubleSum = ArrayCalculator.sumOfArray(doubleArr);

        System.out.println("Tổng mảng int: " + intSum);
        System.out.println("Tổng mảng double: " + doubleSum);

    }
}
