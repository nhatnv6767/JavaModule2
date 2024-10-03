package Session7.Example.CollectionSort;

import Session7.Example.Collection.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSort {
    /*
     * 2 cach sap xep trong collection: Comparable Interface va Comparator Interface
     * 1. Su dung Comparaable de sap xep
     *  B1: Lop sap xep phai ke thua Comparaable
     *  B2: Trien khai phuong thuc compareTo va cai dat sap xep
     *  B3: Su dung phuong thuc sort cua Collection de sap xep
     *
     * 2. Su dung Comparator de sap xep
     *  B1: Dung phuojng thuc sort cua Collection de sap xep theo doi tuong Comparator
     *  B2: Trien khai phuong thuc compare cua COmparator va cai dat sap xep
     * */
    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<Student>();
        Student student1 = new Student("SV001", "Nguyen Van A", 20);
        Student student2 = new Student("SV002", "Nguyen Van B", 22);
        Student student3 = new Student("SV003", "Nguyen Van C", 21);
        Student student4 = new Student("SV004", "Nguyen Van D", 18);
        Student student5 = new Student("SV005", "Nguyen Van F", 19);

        // add(obj): them 1 doi tuong vao cuoi danh sach
        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);
        listStudent.add(student4);
        listStudent.add(student5);
        // sap xep danh sach sinh vien theo tuoi tang dan
//        Collections.sort(listStudent);

        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("Danh sach sinh vien sap xep theo tuoi tang dan: ");
        listStudent.forEach(student -> {
            System.out.println(student);
        });

        // sap xep sinh vien theo ten giam dan
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -o1.getStudentName().compareTo(o2.getStudentName());
            }
        });
        System.out.println("Danh sach sinh vien sap xep theo ten giam dan: ");
        listStudent.forEach(student -> {
            System.out.println(student);
        });

    }
}
