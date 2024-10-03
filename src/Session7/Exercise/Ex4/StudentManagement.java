package Session7.Exercise.Ex4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManagement {
    private List<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    public void showAll() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
        } else {
            students.forEach(System.out::println);
        }
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(int studentId) {
        this.students.removeIf(student -> student.getStudentId() == studentId);
    }

    public Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        System.out.println("Không tìm thấy sinh viên");
        return null;
    }

    public double getAverageScore() {
        if (students.isEmpty()) {
            return 0;
        }
        double totalScore = 0;
        for (Student student : students) {
            totalScore += student.getAverageScore();
        }
        return totalScore / students.size();
    }

    public void sortByScore() {
        students.sort(Comparator.comparingDouble(Student::getAverageScore));
    }


}
