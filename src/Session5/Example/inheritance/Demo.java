package Session5.Example.inheritance;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        student.inputStudent(scanner);
        student.displayData();
    }
}
