package Session16.LibraryManagement.ra.entity;

import Session16.LibraryManagement.ra.Validation.Validator;

import java.util.Scanner;

public interface IBookManagement {
    void inputData(Scanner scanner, Validator validator);

    void displayData();
}
