package Session4.Example;

import java.util.Arrays;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        // ClassName objectName = new Contractor(.....)

        Student student1 = new Student();
        Student student2 = new Student("SV002", "Tây Môn Khánh");
        Student student3 = new Student("SV003", "Phan Kim Liên", 20, true, "Hồ Chí Minh");
        Student student4 = new Student();
        student4.getFavoriteBooks()[0] = "Phan Kim Liên";


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter age student");
        student2.setAge(Integer.parseInt(scanner.nextLine()));


        // in thong tin sinh vien
        System.out.println("Thông tin sinh viên");
        student1.displayData();
        student2.displayData();
        student3.displayData();
        student4.displayData();
        //

        String[] clearBook = student4.getFavoriteBooks();
//        clearBook
//        clearBook[0] = null;

        System.out.println("Sinh vien 4: " + Arrays.toString(clearBook));
    }
}
