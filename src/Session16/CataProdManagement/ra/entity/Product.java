package Session16.CataProdManagement.ra.entity;

public class Product {
    private String productId;
    private String productName;
    private float productPrice;
    private String productTitle;
    private String productDescription;
    private int catalogId;
    private boolean productStatus;

    public Product() {
    }

    public Product(String product_id, String product_name, float product_price, String product_title, String product_description, int catalog_id, boolean product_status) {
        this.productId = product_id;
        this.productName = product_name;
        this.productPrice = product_price;
        this.productTitle = product_title;
        this.productDescription = product_description;
        this.catalogId = catalog_id;
        this.productStatus = product_status;
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

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "\n\tproduct_id='" + productId + '\'' +
                ",\n\tproduct_name='" + productName + '\'' +
                ",\n\tproduct_price=" + productPrice +
                ",\n\tproduct_title='" + productTitle + '\'' +
                ",\n\tproduct_description='" + productDescription + '\'' +
                ",\n\tcatalog_id=" + catalogId +
                ",\n\tproduct_status=" + productStatus +
                "\n}";
    }
}
