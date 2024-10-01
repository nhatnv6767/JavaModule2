package ExercisePlus.BTL1;

import java.util.Scanner;

public class Category implements IEntity {

    private int id;
    private String name;
    private boolean status;

    public Category() {
    }

    public Category(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void input(Scanner scanner) {

        do {
            System.out.print("Nhập mã thể loại (số nguyên >0): ");
            while (!scanner.hasNextInt()) {
                System.err.println("Mã thể loại phải là số nguyên. Vui lòng nhập lại.");
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine();
        } while (id <= 0);

        do {
            System.out.print("Nhập tên thể loại (6-30 ký tự): ");
            name = scanner.nextLine();
        } while (name.length() < 6 || name.length() > 30);

        System.out.print("Nhập trạng thái (true/false): ");
        do {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("true")) {
                status = true;
                break;
            } else if (input.equalsIgnoreCase("false")) {
                status = false;
                break;
            } else {
                System.err.println("Trạng thái phải là true hoặc false. Vui lòng nhập lại.");
            }

        } while (true);
    }

    @Override
    public void output() {
        System.out.println("Mã thể loại: " + id);
        System.out.println("Tên thể loại: " + name);
        System.out.println("Trạng thái: " + (status ? "Hoạt động" : "Không hoạt động"));
    }
}
