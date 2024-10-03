package Session7.Example.Generic;

public class MethodGeneric {
    public <T> void printElementOfArray(T[] arr) {
        System.out.print("Cac phan tu trong mang la: ");
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println("");
    }
}
