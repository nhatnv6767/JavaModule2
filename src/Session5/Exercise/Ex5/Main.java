package Session5.Exercise.Ex5;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {5, 6, 3, 2, -1, 55, 6, 2, 14};
        double[] doubleArray = {3.14, 1.618, 2.718, 0.577, 1.414};

        int intMax = ArrayCalculator.maxOfArray(intArray);
        double doubleMax = ArrayCalculator.maxOfArray(doubleArray);
        int intMin = ArrayCalculator.minOfArray(intArray);
        double doubleMin = ArrayCalculator.minOfArray(doubleArray);

        System.out.println("Giá trị lớn nhất trong mảng số nguyên: " + intMax);
        System.out.println("Giá trị lớn nhất trong mảng số thực: " + doubleMax);
        System.out.println("Giá trị nhỏ nhất trong mảng số nguyên: " + intMin);
        System.out.println("Giá trị nhỏ nhất trong mảng số thực: " + doubleMin);
    }
}
