package Session7.Exercise.Ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MaxElementInList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        int size = rand.nextInt(10) + 1;

        for (int i = 0; i < size; i++) {
            numbers.add(rand.nextInt(100) + 1);
        }

        System.out.println("List: " + numbers);

        System.out.println("Max in list: " + Collections.max(numbers));
    }
}
