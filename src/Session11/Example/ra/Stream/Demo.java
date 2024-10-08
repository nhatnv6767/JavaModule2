package Session11.Example.ra.Stream;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Student student1 = new Student("SV001", "Nguyen Tran Trung A", 22);
        Student student2 = new Student("SV002", "Nguyen Tran Trung 1", 17);
        Student student3 = new Student("SV003", "Nguyen Tran Trung 2", 18);
        Student student4 = new Student("SV004", "Nguyen Tran Trung 3", 21);
        Student student5 = new Student("SV005", "Nguyen Tran Trung 4", 25);
        Student student6 = new Student("SV006", "Nguyen Tran Trung 5", 19);
        Student student7 = new Student("SV007", "Nguyen Tran Trung 67", 24);
        Student student8 = new Student("SV008", "Nguyen Tran Trung 8", 27);
        Student student9 = new Student("SV009", "Nguyen Tran Trung 9", 24);

        List<Student> listStudent = new ArrayList<>();
        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);
        listStudent.add(student4);
        listStudent.add(student5);
        listStudent.add(student6);
        listStudent.add(student7);
        listStudent.add(student8);
        listStudent.add(student9);

        System.out.println("THONG TIN CAC SINH VIEN:");
        // ket hop reference method va bieu thuc lambda
//        listStudent.forEach(student -> System.out.println(student));
        listStudent.forEach(System.out::println);
    }
}
