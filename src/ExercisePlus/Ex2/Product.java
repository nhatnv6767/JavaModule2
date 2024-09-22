package ExercisePlus.Ex2;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double importPrice;
    private double exportPrice;
    private double profit;
    private int quantity;
    private String descriptions;
    private boolean status; // true: dang ban, false: khong ban

    public Product() {
    }

    public Product(String productId, String productName, double importPrice, double exportPrice, int quantity, String descriptions, boolean status) {
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

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
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

    public double calProfit() {
        return (exportPrice - importPrice) * this.quantity;
    }

    public void displayData() {

        String[] lines = {
                "Mã sản phẩm: " + this.productId,
                "Tên sản phẩm: " + this.productName,
                "Giá nhập: " + String.format("%.2f", this.importPrice),
                "Giá xuất: " + String.format("%.2f", this.exportPrice),
                "Số lượng: " + this.quantity,
                "Lợi nhuận: " + String.format("%.2f", this.profit = calProfit()),
                "Mô tả: " + this.descriptions,
                "Trạng thái: " + (this.status ? "Đang bán" : "Không bán")
        };

        int longestLength = findLongestLength(lines);
        int totalLength = longestLength + 8;

        System.out.println("-".repeat(totalLength));

        for (String line : lines) {
            int paddingLeft = (totalLength - line.length() - 2) / 2;
            int paddingRight = totalLength - line.length() - 3 - paddingLeft;
            String oneLine = "| " + " ".repeat(paddingLeft) + line + " ".repeat(paddingRight) + " |";
            System.out.println(oneLine);
        }

        System.out.println("-".repeat(totalLength));
    }

    private int findLongestLength(String[] mang) {
        int max = 0;
        for (String s : mang) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public void inputData(Scanner scanner, Product[] arrProduct) {

        this.productId = inputProductId(scanner, arrProduct);
        this.productName = inputProductName(scanner, arrProduct);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.quantity = inputQuantity(scanner);
        System.out.print("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();
        this.status = inputStatus(scanner);

        // Calculate profit
        this.profit = calProfit();
    }

    public String inputProductId(Scanner scanner, Product[] arrProduct) {
        System.out.print("Nhập mã sản phẩm (4 ký tự): ");
        do {
            this.productId = scanner.nextLine();
            if (this.productId.length() != 4) {
                System.err.println("Mã sản phẩm không đúng định dạng. Vui lòng nhập lại");
            } else {
                boolean isDuplicate = false;
                for (Product existingProduct : arrProduct) {
                    if (existingProduct != null && existingProduct.getProductId().equalsIgnoreCase(this.productId)) {
                        System.err.println("Mã sản phẩm đã tồn tại. Vui lòng nhập lại!");
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    return this.productId;
                }
            }

        } while (true);
    }

    public String inputProductName(Scanner scanner, Product[] arrProduct) {
        System.out.print("Nhập tên sản phẩm (6-50 ký tự): ");
        do {
            this.productName = scanner.nextLine();
            if (this.productName.length() < 6 || productName.length() > 50) {
                System.err.println("Tên sản phẩm phải có từ 6 đến 50 ký tự. Vui lòng nhập lại!");
            } else {
                boolean isDuplicate = false;
                for (Product exitstingProduct : arrProduct) {
                    if (exitstingProduct != null && exitstingProduct.getProductName().equalsIgnoreCase(this.productName)) {
                        System.err.println("Tên sản phẩm đã tồn tại. Vui lòng nhập lại!");
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    return this.productName;
                }
            }

        } while (true);
    }

    public Double inputImportPrice(Scanner scanner) {
        System.out.print("Nhập giá nhập sản phẩm: ");
        do {
            try {
                this.importPrice = Double.parseDouble(scanner.nextLine());
                if (importPrice <= 0) {
                    System.err.println("Giá nhập phải lớn hơn 0.");
                } else {
                    return this.importPrice;
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập giá trị là số");
            }

        } while (true);
    }

    public Double inputExportPrice(Scanner scanner) {
        System.out.print("Nhập giá xuất sản phẩm: ");
        do {
            try {
                this.exportPrice = Double.parseDouble(scanner.nextLine());
                if (this.exportPrice < this.importPrice * 1.2) {
                    System.err.println("Giá xuất phải lớn hơn ít nhất 20% so với giá nhập.");
                } else {
                    return this.exportPrice;
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập giá trị là số");
            }
        } while (true);
    }

    public Integer inputQuantity(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm: ");
        do {
            try {
                this.quantity = Integer.parseInt(scanner.nextLine());
                if (this.quantity <= 0) {
                    System.err.println("Số lượng phải lớn hơn 0.");
                } else {
                    return this.quantity;
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập một số nguyên.");
            }
        } while (true);
    }

    public boolean inputStatus(Scanner scanner) {
        System.out.print("Nhập trạng thái sản phẩm (true/false): ");
        do {
            String statusInput = scanner.nextLine().trim().toLowerCase();
            if (statusInput.equals("true")) {
                return this.status = true;
            } else if (statusInput.equals("false")) {
                return this.status = false;
            } else {
                System.err.println("Trạng thái không hợp lệ. Vui lòng nhập 'true' hoặc 'false'.");
            }
        } while (true);
    }
}

