package ExercisePlus.Collections.ra.businessImp;

import ExercisePlus.Collections.ra.business.IShop;

import java.util.Scanner;

public class Categories implements IShop {

    private static int nextId = 1;
    private int id;
    private String name;
    private String description;
    private boolean status;

    public Categories() {
        this.id = nextId++;
    }

    public Categories(String name, String description, boolean status) {
        this.id = nextId++;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên danh mục: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        this.description = scanner.nextLine();
        this.status = inputStatus(scanner);
    }

    private boolean inputStatus(Scanner scanner) {
        System.out.print("Nhập trạng thái (true - Hoạt động, false - Không hoạt động): ");
        boolean isValidInput = false;
        boolean status = false;
        do {
            try {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("true")) {
                    status = true;
                    isValidInput = true;
                } else if (input.equalsIgnoreCase("false")) {
                    status = false;
                    isValidInput = false;
                } else {
                    System.err.println("Đầu vào không hợp lệ. Vui lòng nhập 'true' hoặc 'false'.");
                }

            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi. Vui lòng thử lại." + e.getMessage());
                scanner.next();// xoa bo dem scanner

            }
        } while (!isValidInput);
        return status;
    }

    @Override
    public void displayData() {
        System.out.printf("Mã danh mục: %d\n", this.id);
        System.out.printf("Tên danh mục: %s\n", this.name);
        System.out.printf("Mô tả: %s\n", this.description);
        System.out.printf("Trạng thái: %s\n", this.status ? "Hoạt động" : "Không hoạt động");
    }
}
