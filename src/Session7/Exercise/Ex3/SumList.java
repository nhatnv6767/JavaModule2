package Session7.Exercise.Ex3;

import java.util.ArrayList;
import java.util.List;

public class SumList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(99);

        System.out.println("List: " + numbers);

        final int[] sum = {0};
        numbers.forEach(number -> sum[0] += number);
        System.out.println("Sum of list: " + sum[0]);
    }

}
