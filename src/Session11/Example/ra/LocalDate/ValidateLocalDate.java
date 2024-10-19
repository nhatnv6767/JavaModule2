package Session11.Example.ra.LocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidateLocalDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate birthDate = inputBirthdate(scanner);
        System.out.println("Ngay sinh cua ban la: " + birthDate);
    }

    public static LocalDate inputBirthdate(Scanner scanner) {

        System.out.print("Nhap vao ngay sinh cu ban(dd/MM/yyyy): ");
        do {
            try {
                return LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                System.err.println("Dinh dang ngay sinh khong dung. Vui long nhap lai");
            }
        } while (true);
    }
}
