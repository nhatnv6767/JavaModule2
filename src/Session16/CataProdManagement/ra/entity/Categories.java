package Session16.CataProdManagement.ra.entity;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String description;
    private boolean status;

    public Categories(int catalogId, String catalogName, String description, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
        this.status = status;
    }

    public Categories() {
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
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
    public String toString() {
        return "Categories{" +
                "\n\tcatalogId=" + catalogId +
                ",\n\tcatalogName='" + catalogName + '\'' +
                ",\n\tdescription='" + description + '\'' +
                ",\n\tstatus=" + status +
                "\n}";
    }
}
