package ExercisePlus.Ex2;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status; // true: dang ban, false: khong ban

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
        this.profit = calProfit();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float calProfit() {
        return exportPrice - importPrice;
    }

    public void displayData() {
        System.out.println("-----------------------------");
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);
        System.out.println("Lợi nhuận: " + this.profit);
        System.out.println("Số lượng: " + this.quantity);
        System.out.println("Mô tả: " + this.descriptions);
        System.out.println("Trạng thái: " + (this.status ? "Đang bán" : "Không bán"));

        System.out.println("-----------------------------");
    }

    public void inputData(Scanner scanner, Product[] arrProduct) {
        boolean isValid;

        do{
            isValid = true;
            System.out.print("Nhập mã sản phẩm (4 ký tự): ");
            productId = scanner.nextLine();
            if(productId.length() != 4){
                isValid = false;
            }
        }

        // Calculate profit
        this.profit = calProfit();
    }
}
