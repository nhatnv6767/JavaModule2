package Session7.Exercise.Ex4;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();

        // add student
        studentManagement.addStudent(new Student(1, "Trần Lả Lướt", 5.6));
        studentManagement.addStudent(new Student(2, "Dangrangto", 7.9));
        studentManagement.addStudent(new Student(3, "Nguyễn Băng Qua", 9.2));

        // hien thi danh sach tat ca sinh vien
        System.out.println("Danh sách sinh viên:");
        studentManagement.showAll();

        // xoa sinh vien
        studentManagement.removeStudent(2);
        System.out.println("\nDanh sach sinh vien sau khi xoa:");
        studentManagement.showAll();

        // tim kiem sinh vien
        Student student = studentManagement.findStudentById(1);
        System.out.println("\nSinh vien co mssv 1:" + student);

        // tinh diem trung binh
        double averageScore = studentManagement.getAverageScore();
        System.out.println("\nDiem trung binh cua tat ca sinh vien: " + String.format("%.2f", averageScore));

        // sap xep sinh vien theo diem
        studentManagement.sortByScore();
        System.out.println("\nDanh sach sinh vien sau khi sap xep theo diem");
        studentManagement.showAll();


    }
}
