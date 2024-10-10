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
            System.out.println("Ma sinh vien la, chinh xac " + student.getStudentId());
        }

        optStudent.ifPresent(student1 -> System.out.println("Ten sinh vien la: " + student1.getStudentName()));
        Student student2 = getStudent1();//
//        Optional<Student> optStudent2 = Optional.of().orElse(new Student());

    }

    public static Student getStudent1() {
        return new Student("SV003", "Tthien", 20);
    }

    public static Optional<Student> getStudent2() {
        return Optional.ofNullable(null);
    }
}
