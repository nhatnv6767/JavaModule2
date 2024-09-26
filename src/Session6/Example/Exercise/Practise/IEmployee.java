package Session6.Example.Exercise.Practise;

import java.util.Scanner;

public interface IEmployee {
    double BASIC_SALARY = 1300000;

    void inputData(Scanner scanner, Employee[] employees, int count);

    void displayData();
}
