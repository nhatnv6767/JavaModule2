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
        // addAll(list): them danh sach list vao danh sach hien tai
        listStudent.addAll(listChild);
        // removeAll(list): xoa danh sach list trong danh sach hien tai
//        listStudent.removeAll(listChild);
        // clear(): xoa tat ca cac phan tu
//        listStudent.clear();
        // get(int index): lay phan tu theo chi so
        System.out.println("Ten sinh vien cua phan tu co chi so 2 trong danh sach: " + listStudent.get(2).getStudentName());

        // set(int index, Object o): de` doi tuong o vao chi so index
        listStudent.set(4, student3);

        // indexOf(Object o): lay chi so phan tu o o trong danh sach
        System.out.println("Chi so cua doi tuong SV003 trong danh sach " + listStudent.indexOf(student3));

        // subList(int begin, int end): cat chuoi tu chi so begin den end
        List<Student> listSub = listStudent.subList(0, 4);
        System.out.println("Danh sach sinh vien trong sublist");
        listSub.forEach(student -> {
            System.out.println(student);
        });
        System.out.println("\n");
        // forEach: duyet tat ca cac phan tu cua danh sach
        listStudent.forEach(student -> {
            System.out.println(student);
        });
    }
}
