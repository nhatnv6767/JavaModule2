package Session3;

import org.w3c.dom.Document;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.Scanner;


public class Example {
    public static void main(String[] args) {
//        int numbers[] = {1, 2, 3, 4, 5, 6};
//        for (int num : numbers) {
//            System.out.print(num);
//        }
//        System.out.println(numbers[7]);

        int[] requiredArray = new int[10];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.printf("numbers[%d] = ", i + 1);
            requiredArray[i] = Integer.parseInt(scanner.nextLine());
        }

        int sum = 0;
        System.out.println("List of even numbers:");
        for (int num : requiredArray) {
            if (num % 2 == 0) {
                System.out.printf("%d\t", num);
                sum += num;
            }
        }
        System.out.printf("\nSum Even numbers = %d", sum);
    }
}
