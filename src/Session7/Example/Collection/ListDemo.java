package Session7.Example.Collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // khai bao 1 danh sach tu list interface va lop trien khai ArrayList
        List<Student> listStudent = new ArrayList<>();

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

        // size(): so phan tu cua danh sach
        System.out.println("So phan tu cua danh sach: " + listStudent.size());
        // isEmpty(): kiem tra danh sach co phan tu chua
        System.out.println("Kiem tra danh sach co phan tu chua: " + listStudent.isEmpty());
        // remove(obj): xoa 1 phan tu trong danh sach
        listStudent.remove(student3);
        // containAll(listChild): boolean - Kiem tra danh sach con co trong danh sach cha (hien tai) hay khong
        List<Student> listChild = new ArrayList<>();
        listChild.add(student1);
        listChild.add(student2);
        System.out.println("Danh sach listChild co trong listStudent khong: " + listStudent.containsAll(listChild));

        // forEach: duyet tat ca cac phan tu cua danh sach
        listStudent.forEach(student -> {
            System.out.println(student);
        });
    }
}
