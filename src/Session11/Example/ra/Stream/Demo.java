package Session11.Example.ra.Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Student student1 = new Student("SV001", "Nguyen Tran Trung A", 22);
        Student student2 = new Student("SV002", "Nguyen Tran Trung B", 17);
        Student student3 = new Student("SV003", "Nguyen Tran Trung C", 18);
        Student student4 = new Student("SV004", "Nguyen Tran Trung D", 21);
        Student student5 = new Student("SV005", "Nguyen Tran Trung E", 21);
        Student student6 = new Student("SV006", "Nguyen Tran Trung F", 21);
        Student student7 = new Student("SV007", "Nguyen Tran Trung G", 24);
        Student student8 = new Student("SV008", "Nguyen Tran Trung H", 27);
        Student student9 = new Student("SV009", "Nguyen Tran Trung T", 24);

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
        System.out.println("1. In ra cac sinh vien co tuoi lon hon 20");
        /*
        B1: chuyen sang Stream: Su dung phuong thuc stream()
        B2: thuc hien cac thao tac trung gian
        B3: thuc hien cac thao tac dau cuoi
        * */

        listStudent.stream().filter(student -> student.getAge() > 20).forEach(System.out::println);

        System.out.println("2. In ra 2 sinh vien dau tien");
        listStudent.stream().limit(2).forEach(System.out::println);

        System.out.println("3. In ra 2 sinh vien bat dau tu sinh vien thu 3");
        listStudent.stream().skip(2).limit(2).forEach(System.out::println);

        System.out.println("4. In ra tat ca tuoi sinh vien voi gia tri * 2");
        listStudent.stream().map(student -> student.getAge() * 2).forEach(System.out::println);

        System.out.println("5. In ra cac sinh vien duoc sap xep theo tuoi tang dan");
        listStudent.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
        System.out.println("6. In ra cac sinh vien duoc sap xep theo tuoi giam dan");
        listStudent.stream().sorted(Comparator.comparing(Student::getAge).reversed()).forEach(System.out::println);
        System.out.println("7. Sap xep cac sinh vien theo tuoi tang dan, nhung sinh vien bang tuoi thi sap xep theo ten giam dan");
        listStudent.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Comparator.comparing(Student::getStudentName).reversed())).forEach(System.out::println);

        System.out.println("8. Tao ra 1 danh sach sinh vien gom nhung sinh vien co tuoi nho hon 20");
        // chuyen stream qua collector,
        List<Student> listStudentUnder20 = listStudent.stream().filter(student -> student.getAge() < 20).toList();
        listStudentUnder20.forEach(System.out::println);
        System.out.println("9. Kiem tra trong danh sach sinh vien co sinh vien nao lon hon 21 tuoi hay khong");
        boolean check = listStudent.stream().anyMatch(student -> student.getAge() > 21);
        System.out.println(check);
        System.out.println("10. Kiem tra trong danh sach tat ca sinh vien co lon hon hoac bang 18 tuoi khong");
        System.out.println(listStudent.stream().allMatch(student -> student.getAge() >= 18));

        System.out.println("11. In ra so sinh vien co tuoi lon hon hoac bang 22");
        System.out.println(listStudent.stream().filter(student -> student.getAge() >= 22).count());

        System.out.println("12. Tuoi lon nhat " + listStudent.stream().max(Comparator.comparing(Student::getAge)));
        System.out.println("12. Tuoi nho nhat " + listStudent.stream().min(Comparator.comparing(Student::getAge)));

        System.out.println("14. Thong ke cac sinh vien theo tuoi");
        IntSummaryStatistics iss = listStudent.stream().mapToInt(Student::getAge).summaryStatistics();
        System.out.println(iss);
        System.out.println("14.1 - Tuoi trung binh: " + iss.getAverage());
        System.out.println("15. Su dung reducer tinh tong tuoi cac sinh vien");
        int sumAge = listStudent.stream().reduce(0, (total, student) -> total + student.getAge(), Integer::sum);
        System.out.println(" = " + sumAge);


//        System.out.println("THONG TIN CAC SINH VIEN:");
        // ket hop reference method va bieu thuc lambda
//        listStudent.forEach(student -> System.out.println(student));
//        listStudent.forEach(System.out::println);
    }
}
