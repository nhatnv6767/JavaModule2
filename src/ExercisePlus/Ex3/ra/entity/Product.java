package ExercisePlus.Ex3.ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, Date created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int index, Categories[] arrCategories) {
        System.out.print("Nhập mã sản phẩm (C/S/A + 3 ký tự): ");
        String regexCheck = "^[CSA][a-zA-Z0-9]{3}$";
        do {
            this.productId = scanner.nextLine();
            if (!this.productId.matches(regexCheck)) {
                System.err.print("Mã sản phẩm không hợp lệ. Vui lòng nhập lại: ");
            } else if (isProductIdExists(arrProduct, index, this.productId)) {
                System.err.print("Mã sản phẩm đã tồn tại. Vui lòng nhập lại: ");
                this.productId = null;
            }
        } while (this.productId == null || !this.productId.matches(regexCheck));

        System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
        do {
            this.productName = scanner.nextLine();
            if (this.productName.length() < 10 || this.productName.length() > 50) {
                System.err.print("Tên sản phẩm không hợp lệ. Vui lòng nhập lại: ");
            } else if (isProductNameExists(arrProduct, index, this.productName)) {
                System.err.print("Tên sản phẩm đã tồn tại. Vui lòng nhập lại: ");
                this.productName = null;
            }
        } while (this.productName == null || this.productName.length() < 10 || this.productName.length() > 50);

        System.out.print("Nhập giá sản phẩm (lớn hơn 0): ");

        do {
            this.price = Float.parseFloat(scanner.nextLine());
            if (this.price <= 0) {
                System.err.print("Giá sản phẩm không hợp lệ. Vui lòng nhập lại: ");
            }
        } while (this.price <= 0);

        System.out.print("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine();

        System.out.print("Nhập ngày nhập sản phẩm (dd/MM/yyyy): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        do {
            try {
                this.created = dateFormat.parse(scanner.nextLine());
                break;
            } catch (ParseException e) {
                System.err.print("Định dạng ngày không hợp lệ. Vui lòng nhập lại (dd/MM/yyyy): ");
            }
        } while (true);

        System.out.println("Chọn danh mục sản phẩm:");
        displayCategoryMenu(arrCategories);
        do {
            this.catalogId = Integer.parseInt(scanner.nextLine());
            if (!isValidCatalogId(arrCategories, this.catalogId)) {
                System.err.print("Mã danh mục không hợp lệ. Vui lòng chọn lại: ");
            }
        } while (!isValidCatalogId(arrCategories, this.catalogId));
        System.out.println("Chọn trạng thái sản phẩm:");
        System.out.println("0. Đang bán");
        System.out.println("1. Hết hàng");
        System.out.println("2. Không bán");
        do {
            this.productStatus = Integer.parseInt(scanner.nextLine());
            if (this.productStatus < 0 || this.productStatus > 2) {
                System.err.print("Trạng thái sản phẩm không hợp lệ. Vui lòng chọn lại: ");
            }
        } while (this.productStatus < 0 || this.productStatus > 2);
    }

    public void displayData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Giá: " + this.price);
        System.out.println("Mô tả: " + this.description);
        System.out.println("Ngày nhập: " + dateFormat.format(this.created));
        System.out.println("Mã danh mục: " + this.catalogId);

        String status = "";
        switch (this.productStatus) {
            case 0:
                status = "Đang bán";
                break;
            case 1:
                status = "Hết hàng";
                break;
            case 2:
                status = "Không bán";
                break;
        }
        System.out.println("Trạng thái: " + status);
    }

    private boolean isProductIdExists(Product[] arrProduct, int index, String productId) {
        for (int i = 0; i < index; i++) {
            if (arrProduct[i] != null && arrProduct[i].getProductId().equalsIgnoreCase(productId)) {
                return true;
            }
        }
        return false;
    }

    private boolean isProductNameExists(Product[] arrProduct, int index, String productName) {
        for (int i = 0; i < index; i++) {
            if (arrProduct[i] != null && arrProduct[i].getProductName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    private void displayCategoryMenu(Categories[] arrCategories) {
        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories[i] != null) {
                System.out.println(arrCategories[i].getCatalogId() + ". " + arrCategories[i].getCatalogName());
            }
        }
    }

    public boolean isValidCatalogId(Categories[] arrCategories, int catalogId) {
        for (Categories arrCategory : arrCategories) {
            if (arrCategory != null && arrCategory.getCatalogId() == catalogId) {
                return true;
            }
        }
        return false;
    }
}
