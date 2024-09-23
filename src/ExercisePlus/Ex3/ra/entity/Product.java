package ExercisePlus.Ex3.ra.entity;

import java.util.Date;

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

    private boolean isValidCatalogId(Categories[] arrCategories, int catalogId) {
        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories[i] != null && arrCategories[i].getCatalogId() == catalogId) {
                return true;
            }
        }
        return false;
    }
}
