package ExercisePlus.Collections.ra.businessImp;

import ExercisePlus.Collections.ra.business.IShop;

import java.util.Scanner;

public class Product implements IShop {

    private static int nextId = 1;
    private String id;
    private String name;
    private int catalogId;
    private float importPrice;
    private float exportPrice;
    private boolean status;

    public Product() {
        this.id = "P" + String.format("%03d", nextId++);
    }

    public Product(String name, int catalogId, float importPrice, float exportPrice, boolean status) {
        this.id = "P" + String.format("%03d", nextId++);
        this.name = name;
        this.catalogId = catalogId;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.status = status;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
        this.exportPrice = calExportPrice();
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public float calExportPrice() {
        return this.importPrice * RATE;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm: ");
        this.name = scanner.nextLine();
        this.catalogId = inputCategoryId(scanner);
        this.importPrice = inputImportPrice(scanner);
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

    public int inputCategoryId(Scanner scanner) {
        System.out.print("Nhập mã danh mục: ");
        do {
            try {
                int categoryId = Integer.parseInt(scanner.nextLine());
                if (categoryId > 0) {
                    return categoryId;
                } else {
                    System.err.println("Mã danh mục phải là số nguyên lớn hơn 0. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Mã danh mục không hợp lệ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi. Vui lòng thử lại." + e.getMessage());
            }
        } while (true);
    }

    public float inputImportPrice(Scanner scanner) {
        System.out.print("Nhập giá nhập: ");
        do {
            try {
                float importPrice = Float.parseFloat(scanner.nextLine());
                if (importPrice >= 0) {
                    return importPrice;
                } else {
                    System.err.println("Giá nhập không hợp lệ. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Giá nhập không hợp lệ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi. Vui lòng thử lại." + e.getMessage());
            }
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %s\n", this.id);
        System.out.printf("Tên sản phẩm: %s\n", this.name);
        System.out.printf("Mã danh mục: %d\n", this.catalogId);
        System.out.printf("Giá nhập: %.2f\n", this.importPrice);
        System.out.printf("Giá bán: %.2f\n", this.exportPrice);
        System.out.printf("Trạng thái: %s\n", this.status ? "Hoạt động" : "Không hoạt động");
    }
}
