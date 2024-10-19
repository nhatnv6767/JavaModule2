package Session11.Example.ra.LocalDate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Demo {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println("Ngay hien tai: " + ld);
        LocalDate birthDateOfTeacher = LocalDate.of(1984, 4, 23);
        System.out.println("Sinh nhat giang vien: " + birthDateOfTeacher);

        LocalDate day = LocalDate.ofYearDay(2024, 100);
        System.out.println("Ngay thu 100 cua nam 2014: " + day);

        LocalTime timeNow = LocalTime.now();
        System.out.println("Gio hien tai: " + timeNow);


    }
}
