package Session7.Example.Collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {

        Student student1 = new Student("SV001", "Nguyen Van A", 20);
        Student student2 = new Student("SV002", "Nguyen Van B", 22);
        Student student3 = new Student("SV003", "Nguyen Van C", 21);
        // {key, value}
        Map<Integer, Student> mapStudent = new HashMap<>();
        mapStudent.put(1, student1);
        mapStudent.put(2, student2);
        mapStudent.put(3, student3);

        // lay phan tu trong map
        System.out.println("Ten sinh vien 2: " + mapStudent.get(2).getStudentName());
        // xoa phan tu trong map
        mapStudent.remove(2);

        System.out.println(mapStudent);
    }
}
