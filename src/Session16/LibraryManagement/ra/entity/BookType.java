package Session16.LibraryManagement.ra.entity;

import Session16.LibraryManagement.ra.Validation.Validator;

import java.util.Scanner;

public class BookType implements IBookManagement {

    private int typeId;
    private String typeName;
    private String description;
    private boolean isDeleted;

    public BookType() {
    }

    public BookType(int typeId, String typeName, String description, boolean isDeleted) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.description = description;
        this.isDeleted = isDeleted;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public void inputData(Scanner scanner, Validator bookTypeValidator) {
        setTypeName(bookTypeValidator.getNonEmptyStringInput(scanner, "Nhập tên loại sách: "));
        setDescription(bookTypeValidator.getNonEmptyStringInput(scanner, "Nhập mô tả: "));
    }

    @Override
    public void displayData() {
        System.out.println("Mã loại sách: " + this.typeId);
        System.out.println("Tên loại sách: " + this.typeName);
        System.out.println("Mô tả: " + this.description);
    }
}
