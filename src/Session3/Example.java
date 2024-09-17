package Session3;

import org.w3c.dom.Document;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.Scanner;


public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

    }
}
