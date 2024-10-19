package ExercisePlus.Ex3.ra.entity;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner, Categories[] arrCategories, int index) {
        System.out.print("Nhập tên danh mục: ");
        this.catalogName = scanner.nextLine();

        // kiem tra trung lap ten danh muc
        boolean isDuplicate = false;
        for (int i = 0; i < index; i++) {
            if (arrCategories[i] != null && arrCategories[i].getCatalogName().equalsIgnoreCase(this.catalogName)) {
                isDuplicate = true;
                break;
            }
        }

        while (this.catalogName.length() > 50 || isDuplicate) {
            if (this.catalogName.length() > 50) {
                System.out.println("Tên danh mục không được vượt quá 50 ký tự. Vui lòng nhập lại!");
            } else {
                System.out.println("Tên danh mục đã tồn tại. Vui lòng nhập lại!");
            }
            System.out.print("Nhập tên danh mục: ");
            this.catalogName = scanner.nextLine();
            isDuplicate = false;
            for (int i = 0; i < index; i++) {
                if (arrCategories[i] != null && arrCategories[i].getCatalogName().equalsIgnoreCase(this.catalogName)) {
                    isDuplicate = true;
                    break;
                }
            }
        }

        System.out.print("Nhập mô tả danh mục: ");
        this.descriptions = scanner.nextLine();

        System.out.print("Nhập trạng thái danh mục (true/false): ");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());

        if (index == 0) {
            this.catalogId = 1;
        } else {
            this.catalogId = arrCategories[index - 1].getCatalogId() + 1;
        }
    }

    public void displayData() {
        System.out.println("Mã danh mục: " + this.catalogId);
        System.out.println("Tên danh mục: " + this.catalogName);
        System.out.println("Mô tả: " + this.descriptions);
        System.out.println("Trạng thái: " + (this.catalogStatus ? "Hoạt động" : "Không hoạt động"));
        System.out.println("----------------------");
    }

}
