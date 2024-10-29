package Session16.Example.ra.presentation;

import Session16.Example.ra.bussiness.ProductBussiness;
import Session16.Example.ra.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static void displayMenuProduct(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("******** PRODUCT MENU ****************");
            System.out.println("1. Danh sach san pham");
            System.out.println("2. Them moi san pham");
            System.out.println("3. Cap nhat san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("5. Tim kiem san pham theo ten san pham hoac tieu de san pham");
            System.out.println("6. Thong ke so san pham theo khoang gia a -> b");
            System.out.println("7. Sap xep san pham theo gia tang dan");
            System.out.println("8. Thong ke cac san pham theo danh muc");
            System.out.println("9. Quay lai");
            System.out.print("Lua chon cua ban:");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayListProducts();
                    break;
                case 2:
                    createProduct(scanner);
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    deleteProduct(scanner);
                    break;
                case 5:
                    searchProduct(scanner);
                    break;
                case 6:
                    statisticProductByPrice(scanner);
                    break;
                case 7:
                    sortProductByPrice();
                    break;
                case 8:
                    statisticProductByCategory(scanner);
                    break;
                case 9:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui long chon tu 1 den 8");
            }
        } while (isExit);
    }

    public static void displayListProducts() {
        List<Product> listProducts = ProductBussiness.findAll();
        listProducts.forEach(System.out::println);
    }

    public static void createProduct(Scanner scanner) {
        Product productNew = new Product();
        System.out.println("Nhap vao ma san pham: ");
        productNew.setProductId(scanner.nextLine());
        System.out.println("Nhap vao ten san pham: ");
        productNew.setProductName(scanner.nextLine());
        System.out.println("Nhap vao gia san pham: ");
        productNew.setProductPrice(Float.parseFloat(scanner.nextLine()));
        System.out.println("Nhap vao tieu de san pham: ");
        productNew.setProductTitle(scanner.nextLine());
        System.out.println("Nhap vao mo ta san pham: ");
        productNew.setProductDescription(scanner.nextLine());
        System.out.println("Nhap vao ma danh muc: ");
        productNew.setCatalogId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhap vao trang thai (true/false): ");
        productNew.setProductStatus(Boolean.parseBoolean(scanner.nextLine()));

        boolean result = ProductBussiness.save(productNew);
        if (result) {
            System.out.println("Them moi thanh cong");
        } else {
            System.err.println("Them moi khong thanh cong");
        }
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("Nhap vao ma san pham can cap nhat");
        String productId = scanner.nextLine();
        Product productUpdate = ProductBussiness.findById(productId);
        if (productUpdate != null) {
            boolean isExist = true;
            do {
                System.out.println("1. Cap nhat ten san pham");
                System.out.println("2. Cap nhat gia san pham");
                System.out.println("3. Cap nhat tieu de san pham");
                System.out.println("4. Cap nhat mo ta san pham");
                System.out.println("5. Cap nhat ma danh muc");
                System.out.println("6. Cap nhat trang thai san pham");
                System.out.println("7. Thoat");
                System.out.print("Lua chon cua ban: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        productUpdate.setProductName(scanner.nextLine());
                        break;
                    case 2:
                        productUpdate.setProductPrice(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 3:
                        productUpdate.setProductTitle(scanner.nextLine());
                        break;
                    case 4:
                        productUpdate.setProductDescription(scanner.nextLine());
                        break;
                    case 5:
                        productUpdate.setCatalogId(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 6:
                        productUpdate.setProductStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 7:
                        isExist = false;
                        break;
                    default:
                        System.err.println("Vui long chon tu 1 den 7");
                }
            } while (isExist);

            boolean result = ProductBussiness.update(productUpdate);
            if (result) {
                System.out.println("Cap nhat thanh cong");
            } else {
                System.err.println("Cap nhat that bai");
            }
        } else {
            System.err.println("Ma san pham khong ton tai");
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.printf("Nhap vao ma san pham can xoa: ");
        String productId = scanner.nextLine();
        Product productDelete = ProductBussiness.findById(productId);
        if (productDelete != null) {
            boolean result = ProductBussiness.delete(productId);
            if (result) {
                System.out.println("Xoa thanh cong");
            } else {
                System.err.println("Xoa that bai");
            }
        } else {
            System.err.println("Ma san pham khong ton tai");
        }
    }

    public static void searchProduct(Scanner scanner) {
        System.out.printf("Nhap vao ten san pham hoac tieu de san pham can tim: ");
        String searchTerm = scanner.nextLine();
        List<Product> findProduct = ProductBussiness.searchProduct(searchTerm);
        findProduct.forEach(System.out::println);
    }

    public static void statisticProductByPrice(Scanner scanner) {
        System.out.printf("Nhap vao khoang gia a: ");
        float priceFrom = Float.parseFloat(scanner.nextLine());
        System.out.printf("Nhap vao khoang gia b: ");
        float priceTo = Float.parseFloat(scanner.nextLine());
        int cntProduct = ProductBussiness.statisticProductByPrice(priceFrom, priceTo);
        System.out.printf("Co %d san pham co gia tu %f den %f\n", cntProduct, priceFrom, priceTo);
    }

    public static void sortProductByPrice() {
        List<Product> listProducts = ProductBussiness.sortProductByPrice();
        listProducts.forEach(System.out::println);
    }

    public static void statisticProductByCategory(Scanner scanner) {
        System.out.printf("Nhap vao ma danh muc can thong ke: ");
        int catalogId = Integer.parseInt(scanner.nextLine());
        int cntProduct = ProductBussiness.statisticProductByCategory(catalogId);
        System.out.printf("Co %d san pham co ma danh muc la %d\n", cntProduct, catalogId);
    }

}
