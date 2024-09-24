package ExercisePlus.Ex4.ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private String manufacturer;
    private boolean productStatus;

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        if (productId.matches("[A-Z][a-zA-Z0-9]{3}")) {
            this.productId = productId;
        } else {
            System.err.println("\nMã sản phẩm không hợp lệ. Vui lòng nhập lại.");
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName.length() > 0) {
            this.productName = productName;
        } else {
            System.out.println("\nTên sản phẩm không hợp lệ. Vui lòng nhập lại.");
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm (4 ký tự, bắt đầu bằng chữ hoa): ");
        do {
            setProductId(scanner.nextLine());
        } while (productId == null);

        System.out.print("Nhập tên sản phẩm: ");
        do {
            setProductName(scanner.nextLine());
        } while (productName == null);

        System.out.print("Nhập nhà sản xuất: ");
        setManufacturer(scanner.nextLine());
        System.out.print("Nhập trạng thái sản phẩm (0-hoạt động, 1-không hoạt động): ");
        while (true) {

            try {
                int status = Integer.parseInt(scanner.nextLine());
                if (status == 0 || status == 1) {
                    setProductStatus(status == 0);
                    break;
                } else {
                    System.err.println("\nTrạng thái không hợp lệ. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.err.println("\nVui lòng nhập vào số 0 hoặc 1");
            }
        }

    }

    public void displayData() {
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Nhà sản xuất: " + this.manufacturer);
        System.out.println("Trạng thái: " + (this.productStatus ? "Hoạt động" : "Không hoạt động"));
    }
}
