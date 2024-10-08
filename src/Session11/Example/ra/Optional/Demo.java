package Session11.Example.ra.Optional;

import Session11.Example.ra.Stream.Student;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        Student student = getStudent1();
        if (student != null) {
            System.out.println("Ma sinh vien la: " + student.getStudentId());
        }

        Optional<Student> optStudent = Optional.ofNullable(student);
        if (optStudent.isPresent()) {
            System.out.println("Ma sinh vien la: " + student.getStudentId());
        }
    }

    public static Student getStudent1() {
        return null;
    }
}
