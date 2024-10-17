package ExercisePlus.Collections.ra.presentation;

import ExercisePlus.Collections.ra.businessImp.Categories;
import ExercisePlus.Collections.ra.businessImp.Product;

import java.util.*;

public class ProductManagement {
    private List<Categories> categoriesList;
    private List<Product> productList;

    public ProductManagement(List<Categories> categoriesList, List<Product> productList) {
        this.categoriesList = categoriesList;
        this.productList = productList;
    }

    public void displayProductMenu() {
        Scanner scanner = new Scanner(System.in);

    }

    private void displayProductList() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        for (Product product : productList) {
            product.displayData();
            System.out.println("--------------------------------");
        }
    }

    private void addNewProduct(Scanner scanner) {
        Product newProduct = new Product();
        newProduct.inputData(scanner);

        // hien thi danh sach danh muc de nguoi dung chon
        System.out.println("Danh sách danh mục:");
        for (Categories category : categoriesList) {
            category.displayData();
            System.out.println("--------------------------------");
        }
        System.out.print("Nhập mã danh mục cho sản phẩm: ");
        int categoryId = Integer.parseInt(scanner.nextLine());
        newProduct.setCatalogId(categoryId);

        productList.add(newProduct);
        System.out.println("Thêm mới sản phẩm thành công.");
    }

    private void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String id = scanner.nextLine();
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                product.inputData(scanner);
                System.out.println("Cập nhật sản phẩm thành công.");
                return;
            }
        }
        System.err.printf("Sản phẩm %s không tồn tại.\n", id);
    }

    private void deleteProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String id = scanner.nextLine();
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                productList.remove(product);
                System.out.println("Xóa sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã " + id);
    }

    private void sortProductsByExportPriceAscending() {
        Collections.sort(productList, Comparator.comparingDouble(Product::getExportPrice));
        System.out.println("Sắp xếp sản phẩm theo giá bán tăng dần thành công!");
    }

    private void sortProductsByExportPriceDescending() {
        Collections.sort(productList, (p1, p2) -> Float.compare(p2.getImportPrice(), p1.getImportPrice()));
        System.out.println("Sắp xếp sản phẩm theo giá nhập giảm dần thành công!");
    }

    private void searchProductByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần tìm kiếm: ");
        String name = scanner.nextLine();
        List<Product> searchResults = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResults.add(product);
            }
        }
        if (searchResults.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào có tên \"" + name + "\"");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Product product : searchResults) {
                product.displayData();
                System.out.println("--------------------------------");
            }

        }

    }
}
