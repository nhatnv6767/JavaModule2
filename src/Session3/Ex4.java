package Session3;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số hàng của mảng 2 chiều: ");
        int row = scanner.nextInt();
        System.out.print("Nhập số cột của mảng 2 chiều: ");
        int column = scanner.nextInt();

        double[][] matrix = new double[row][column];
        setMatrix(matrix, scanner);

        double maxValue = matrix[0][0];
        int rowOfMaxValue = 0, columnOfMaxValue = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                    rowOfMaxValue = i;
                    columnOfMaxValue = j;
                }
            }
        }

        System.out.println("Mảng 2 chiều đã nhập: ");
        getMatrix(matrix);

        System.out.println("Phần tử lớn nhất trong mảng 2 chiều là: " + maxValue);
        System.out.println("Toạ độ của phần tử lớn nhất: Hàng " + (rowOfMaxValue + 1) + ", Cột " + (columnOfMaxValue + 1));
    }

    public static void setMatrix(double[][] matrix, Scanner scanner) {
        System.out.println("Nhập các phần tử của mảng 2 chiều:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Phần tử tại hàng " + (i + 1) + ", cột " + (j + 1) + ": ");
                matrix[i][j] = scanner.nextDouble();
            }
        }
    }

    public static void getMatrix(double[][] maTran) {
        for (double[] row : maTran) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
