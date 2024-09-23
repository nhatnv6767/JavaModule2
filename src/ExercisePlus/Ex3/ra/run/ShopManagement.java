package ExercisePlus.Ex3.ra.run;

import ExercisePlus.Ex3.ra.entity.Categories;
import ExercisePlus.Ex3.ra.entity.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Categories[] arrCategories = new Categories[100];
        Product[] arrProducts = new Product[100];

        // not for test - dung cho nhap lieu bang tay
//        int categoryIndex = 0;
//        int productIndex = 0;

        ShopManagement shopManagement = new ShopManagement();

        int categoryIndex = 10;
        int productIndex = 10;
        // testing crawl data
        shopManagement.initDataForTesting(arrCategories, arrProducts, new int[]{categoryIndex}, new int[]{productIndex});
        // menu chinh
        while (true) {
            shopManagement.displayShopMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    shopManagement.handleCategoryMenu(scanner, arrCategories, categoryIndex, arrProducts);
                    break;
                case 2:
                    shopManagement.handleProductMenu(scanner, arrProducts, productIndex, arrCategories);
                    break;
                case 3:
                    System.err.println("Kết thúc chương trình.");
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ.");

            }
        }
    }

    private void initDataForTesting(Categories[] arrCategories, Product[] arrProduct, int[] categoryIndex, int[] productIndex) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Hardcode du lieu cho arrCategories
        arrCategories[0] = new Categories(1, "Cà phê", "Các loại cà phê", true);
        arrCategories[1] = new Categories(2, "Trà sữa", "Các loại trà sữa", true);
        arrCategories[2] = new Categories(3, "Sinh tố", "Các loại sinh tố", true);
        arrCategories[3] = new Categories(4, "Nước ép", "Các loại nước ép", true);
        arrCategories[4] = new Categories(5, "Đồ ăn nhanh", "Các món ăn nhanh", true);
        arrCategories[5] = new Categories(6, "Bánh ngọt", "Các loại bánh ngọt", true);
        arrCategories[6] = new Categories(7, "Kem", "Các loại kem", true);
        arrCategories[7] = new Categories(8, "Đồ uống khác", "Các loại đồ uống khác", true);
        arrCategories[8] = new Categories(9, "Cà phê đá xay", "Cà phê đá xay", true);
        arrCategories[9] = new Categories(10, "Trà trái cây", "Trà trái cây", true);

        categoryIndex[0] = 10;

        // Hardcode du lieu cho arrProduct
        try {
            arrProduct[0] = new Product("C001", "Cà phê đen đá", 25000, "Cà phê đen truyền thống", dateFormat.parse("20/09/2023"), 1, 0);
            arrProduct[1] = new Product("C002", "Cà phê sữa đá", 30000, "Cà phê sữa đậm đà", dateFormat.parse("15/08/2023"), 1, 0);
            arrProduct[2] = new Product("T001", "Trà sữa truyền thống", 35000, "Trà sữa thơm ngon", dateFormat.parse("12/07/2023"), 2, 0);
            arrProduct[3] = new Product("T002", "Trà sữa matcha", 40000, "Trà sữa matcha đặc biệt", dateFormat.parse("05/06/2023"), 2, 0);
            arrProduct[4] = new Product("S001", "Sinh tố bơ", 45000, "Sinh tố bơ béo ngậy", dateFormat.parse("28/05/2023"), 3, 0);
            arrProduct[5] = new Product("S002", "Sinh tố dâu", 40000, "Sinh tố dâu tươi mát", dateFormat.parse("10/04/2023"), 3, 0);
            arrProduct[6] = new Product("A001", "Hamburger bò", 50000, "Hamburger bò phô mai", dateFormat.parse("02/03/2023"), 5, 0);
            arrProduct[7] = new Product("A002", "Gà rán", 40000, "Gà rán giòn tan", dateFormat.parse("18/02/2023"), 5, 0);
            arrProduct[8] = new Product("B001", "Bánh tiramisu", 30000, "Bánh tiramisu cổ điển", dateFormat.parse("08/01/2023"), 6, 0);
            arrProduct[9] = new Product("K001", "Kem ốc quế", 15000, "Kem ốc quế socola", dateFormat.parse("25/12/2022"), 7, 0);

            productIndex[0] = 10;
        } catch (ParseException e) {
            System.err.println("Lỗi khi phân tích ngày tháng: " + e.getMessage());
        }
    }


    private void displayShopMenu() {
        System.out.println("******************SHOP MENU*******************");
        System.out.println("1. Quản lý danh mục sản phẩm");
        System.out.println("2. Quản lý sản phẩm");
        System.out.println("3. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }


    // MENU PRODUCT
    private void displayProductMenu() {
        System.out.println("*******************PRODUCT MANAGEMENT*****************");
        System.out.println("1. Nhập thông tin các sản phẩm");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Sắp xếp các sản phẩm theo giá");
        System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
        System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
        System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
        System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
        System.out.println("8. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private void handleProductMenu(Scanner scanner, Product[] arrProduct, int productIndex, Categories[] arrCategories) {
        while (true) {
            displayProductMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("===> 1. Nhập thông tin các sản phẩm");
                    inputProducts(scanner, arrProduct, productIndex, arrCategories);
                    productIndex = getNextAvailableProductIndex(arrProduct);
                    break;
                case 2:
                    System.out.println("===> 2. Hiển thị thông tin các sản phẩm");
                    displayProducts(arrProduct);
                    break;
                case 3:
                    System.out.println("===> 3. Sắp xếp các sản phẩm theo giá");
                    sortProductByPrice(arrProduct, productIndex);
                    displayProducts(arrProduct);
                    break;
                case 4:
                    System.out.println("===> 4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
                    updateProduct(scanner, arrProduct, arrCategories);
                    break;
                case 5:
                    System.out.println("===> 5. Xóa sản phẩm theo mã sản phẩm");
                    deleteProduct(scanner, arrProduct);
                    productIndex = getNextAvailableProductIndex(arrProduct);
                    break;
                case 6:
                    System.out.println("===> 6. Tìm kiếm các sản phẩm theo tên sản phẩm");
                    searchProductsByName(scanner, arrProduct, productIndex);
                    break;
                case 7:
                    System.out.println("===> 7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
                    searchProductsByPriceRange(scanner, arrProduct);
                    break;
                case 8:
                    System.out.println("===> 8. Thoát");
                    return;// quay lai menu chinh
                default:
                    System.err.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    // MENU CATEGORIES
    private void displayCategoryMenu() {
        System.out.println("********************CATEGORIES MENU***********");
        System.out.println("1. Nhập thông tin các danh mục");
        System.out.println("2. Hiển thị thông tin các danh mục");
        System.out.println("3. Cập nhật thông tin danh mục");
        System.out.println("4. Xóa danh mục");
        System.out.println("5. Cập nhật trạng thái danh mục");
        System.out.println("6. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private void handleCategoryMenu(Scanner scanner, Categories[] arrCategories, int categoryIndex, Product[] arrProduct) {
        while (true) {
            displayCategoryMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("===> 1. Nhập thông tin các danh mục");
                    inputCategories(scanner, arrCategories, categoryIndex);
                    categoryIndex = getNextAvailableCategoryIndex(arrCategories);// chuyen ve vi tri index phu hop
                    break;
                case 2:
                    System.out.println("===> 2. Hiển thị thông tin các danh mục");
                    displayCategories(arrCategories);
                    break;
                case 3:
                    System.out.println("===> 3. Cập nhật thông tin danh mục");
                    updateCategory(scanner, arrCategories);
                    break;
                case 4:
                    System.out.println("===> 4. Xóa danh mục");
                    deleteCategory(scanner, arrCategories, arrProduct);
                    break;
                case 5:
                    System.out.println("===> 5. Cập nhật trạng thái danh mục");
                    updateCategoryStatus(scanner, arrCategories);
                    break;
                case 6:
                    System.err.println("===> 6. Thoát");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void inputCategories(Scanner scanner, Categories[] arrCategories, int categoryIndex) {
        System.out.print("Nhập số lượng danh mục cần nhập: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            if (categoryIndex < arrCategories.length) {
                System.out.println("Nhập thông tin danh mục thứ " + (i + 1) + ":");
                Categories category = new Categories();
                category.inputData(scanner, arrCategories, categoryIndex);
                arrCategories[categoryIndex] = category;
                categoryIndex++;
            } else {
                System.out.println("Đã đạt giới hạn số lượng danh mục.");
                break;
            }
        }
    }

    private void displayCategories(Categories[] arrCategories) {
        if (isCategoryArrayEmpty(arrCategories)) {
            System.out.println("Không có danh mục nào.");
            return;
        }

        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories[i] != null) {
                System.out.println("Thông tin danh mục thứ " + (i + 1) + ":");
                arrCategories[i].displayData();
                System.out.println("----------------------");
            }
        }
    }

    // cap nhat thong tin danh muc
    private void updateCategory(Scanner scanner, Categories[] arrCategories) {
        System.out.print("Nhập mã danh mục cần cập nhật: ");
        int categoryId = Integer.parseInt(scanner.nextLine());
        int index = findCategoryIndexById(arrCategories, categoryId);
        if (index != -1) {
            Categories category = arrCategories[index];
            category.displayData();
            System.out.println("Nhập thông tin mới cho danh mục (nhấn Enter nếu như muốn giữ nguyên giá trị cũ):");

            System.out.print("Tên danh mục hiện tại: " + (category.getCatalogName()) + " - Nhập tên mới: ");
            String newName = scanner.nextLine().strip();
            if (!newName.isEmpty()) {
                // Kiem tra trung lap ten danh muc (tru cai danh muc dang cap nhat)
                boolean isDuplicate = false;
                for (int i = 0; i < arrCategories.length; i++) {
                    if (arrCategories[i] != null && i != index && arrCategories[i].getCatalogName().equalsIgnoreCase(newName)) {
                        isDuplicate = true;
                        break;
                    }
                }

                while (newName.length() > 50 || isDuplicate) {
                    if (newName.length() > 50) {
                        System.err.println("Tên danh mục không được vượt quá 50 ký tự. Vui lòng nhập lại!");
                    } else {
                        System.err.println("Tên danh mục đã tồn tại. Vui lòng nhập lại!");
                    }
                    System.out.print("Nhập tên danh mục mới: ");
                    newName = scanner.nextLine().strip();
                    isDuplicate = false;
                    for (int i = 0; i < arrCategories.length; i++) {
                        if (arrCategories[i] != null && i != index && arrCategories[i].getCatalogName().equalsIgnoreCase(newName)) {
                            isDuplicate = true;
                            break;
                        }
                    }
                }
                category.setCatalogName(newName);
            }

            System.out.print("Mô tả danh mục hiện tại: " + (category.getDescriptions()) + " - Nhập mô tả mới: ");
            String newDescription = scanner.nextLine().strip();
            if (!newDescription.isEmpty()) {
                category.setDescriptions(newDescription);
            }

            System.out.print("Trạng thái danh mục hiện tại: " + (category.isCatalogStatus() ? "Hoạt động" : "Không hoạt động") + " - Nhập trạng thái mới (true/false): ");
            String newStatus = scanner.nextLine().strip();
            if (!newStatus.isEmpty()) {
                category.setCatalogStatus(newStatus.equalsIgnoreCase("true"));
            }

//            arrCategories[index].inputData(scanner, arrCategories, index);
            System.out.println("Cập nhật danh mục thành công");
        } else {
            System.err.println("Không tìm thấy danh mục có mã " + categoryId);
        }
    }

    private void deleteCategory(Scanner scanner, Categories[] arrCategories, Product[] arrProduct) {
        System.out.print("Nhập mã danh mục cần xóa: ");
        int categoryId = Integer.parseInt(scanner.nextLine());
        int index = findCategoryIndexById(arrCategories, categoryId);
        if (index != -1) {
            arrCategories[index].displayData();
            if (!isCategoryContainProduct(arrCategories[index], arrProduct)) {
                arrCategories[index] = null;
                System.out.println("Xóa danh mục thành công!");
            } else {
                System.err.println("Không thể xóa danh mục vì danh mục này chứa sản phẩm.");
            }
        } else {
            System.err.println("Không tìm thấy danh mục có mã " + categoryId);
        }
    }

    private void updateCategoryStatus(Scanner scanner, Categories[] arrCategories) {
        System.out.print("Nhập mã danh mục cần cập nhật trạng thái: ");
        int categoryId = Integer.parseInt(scanner.nextLine());
        int index = findCategoryIndexById(arrCategories, categoryId);
        if (index != -1) {
            arrCategories[index].setCatalogStatus(!arrCategories[index].isCatalogStatus());
            arrCategories[index].displayData();
            System.out.println("Cập nhật trạng thái danh mục thành công!");
        } else {
            System.err.println("Không tìm thấy danh mục có mã " + categoryId);
        }
    }

    // tim chi so cua danh muc theo ma danh muc
    private int findCategoryIndexById(Categories[] arrCategories, int categoryId) {
        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories[i] != null && arrCategories[i].getCatalogId() == categoryId) {
                return i;
            }
        }
        return -1;
    }

    // kiem tra xem danh muc co chua san pham khong
    private boolean isCategoryContainProduct(Categories category, Product[] arrProduct) {
        for (Product product : arrProduct) {
            if (product != null && product.getCatalogId() == category.getCatalogId()) {
                return true;
            }
        }
        return false;
    }

    // tim chi so kha dung tiep theo trong mang danh muc
    private int getNextAvailableCategoryIndex(Categories[] arrCategories) {
        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories[i] == null) {
                return i;
            }
        }
        return -1; // Mang da day
    }

    private boolean isCategoryArrayEmpty(Categories[] arrCategories) {
        for (Categories category : arrCategories) {
            if (category != null) {
                return false;
            }
        }
        return true;
    }

    // nhap nhieu san pham
    private void inputProducts(Scanner scanner, Product[] arrProduct, int productIndex, Categories[] arrCategories) {
        System.out.print("Nhập số lượng sản phẩm cần nhập: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
            Product product = new Product();
            product.inputData(scanner, arrProduct, productIndex, arrCategories);
            arrProduct[productIndex] = product;
            productIndex++;
        }
    }

    // hien thi thong tin cac san pham
    private void displayProducts(Product[] arrProduct) {
//        if (productIndex == 0) {
//            System.out.println("Không có sản phẩm nào.");
//            return;
//        }

        if (isProductArrayEmpty(arrProduct)) {
            System.out.println("Không có sản phẩm nào.");
            return;
        }
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] != null) {
                System.out.println("Thông tin sản phẩm thứ " + (i + 1) + ":");
                arrProduct[i].displayData();
                System.out.println("----------------------");
            }
        }
    }

    private void updateProduct(Scanner scanner, Product[] arrProduct, Categories[] arrCategories) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String productId = scanner.nextLine();
        int index = findProductIndexById(arrProduct, productId);
        if (index != -1) {
            Product product = arrProduct[index];
            product.displayData();
            System.out.println("Nhập thông tin mới cho sản phẩm (nhấn Enter để giữ nguyên):");

            System.out.print("Tên sản phẩm hiện tại: " + (product.getProductName()) + " - Nhập tên mới: ");
            String newName = scanner.nextLine().strip();
            if (!newName.isEmpty()) {
                boolean isDuplicate = false;
                for (int i = 0; i < arrProduct.length; i++) {
                    if (arrProduct[i] != null && i != index && arrProduct[i].getProductName().equalsIgnoreCase(newName)) {
                        isDuplicate = true;
                        break;
                    }
                }

                while (newName.length() < 10 || newName.length() > 50 || isDuplicate) {
                    if (newName.length() < 10 || newName.length() > 50) {
                        System.err.println("Tên sản phẩm không hợp lệ. Vui lòng nhập lại (10-50 ký tự): ");
                    } else {
                        System.err.println("Tên sản phẩm đã tồn tại. Vui lòng nhập lại!");
                    }
                    System.out.print("Nhập tên sản phẩm mới: ");
                    newName = scanner.nextLine().strip();
                    isDuplicate = false;
                    for (int i = 0; i < arrProduct.length; i++) {
                        if (arrProduct[i] != null && i != index && arrProduct[i].getProductName().equalsIgnoreCase(newName)) {
                            isDuplicate = true;
                            break;
                        }
                    }
                }
                product.setProductName(newName);
            }

            // gia san pham
            System.out.print("Giá sản phẩm hiện tại: " + (product.getPrice()) + " - Nhập giá mới: ");
            String newPriceStr = scanner.nextLine().strip();
            if (!newPriceStr.isEmpty()) {
                float newPrice = Float.parseFloat(newPriceStr);
                while (newPrice <= 0) {
                    System.err.print("Giá sản phẩm không hợp lệ. Vui lòng nhập lại (lớn hơn 0): ");
                    newPriceStr = scanner.nextLine().strip();
                    newPrice = Float.parseFloat(newPriceStr);
                }
                product.setPrice(newPrice);
            }

            // cap nhat mo ta
            System.out.print("Mô tả sản phẩm hiện tại: " + (product.getDescription()) + " - Nhập mô tả mới: ");
            String newDescription = scanner.nextLine().strip();
            if (!newDescription.isEmpty()) {
                product.setDescription(newDescription);
            }

            // cap nhat ngay nhap san pham
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Ngày nhập sản phẩm hiện tại: " + (dateFormat.format(product.getCreated())) + " - Nhập ngày mới (dd/MM/yyyy): ");
            String newCreatedStr = scanner.nextLine().strip();
            if (!newCreatedStr.isEmpty()) {
                try {
                    Date newCreated = dateFormat.parse(newCreatedStr);
                    product.setCreated(newCreated);
                } catch (ParseException e) {
                    System.err.println("Định dạng ngày không hợp lệ.");
                }
            }

            // cap nhat danh muc san pham
            System.out.print("Danh mục sản phẩm hiện tại: " + (product.getCatalogId()) + " - Nhập danh mục mới: ");
            displayCategories(arrCategories);
            String newCatalogIdStr = scanner.nextLine().strip();
            if (!newCatalogIdStr.isEmpty()) {
                int newCatalogId = Integer.parseInt(newCatalogIdStr);
                if (product.isValidCatalogId(arrCategories, newCatalogId)) {
                    product.setCatalogId(newCatalogId);
                } else {
                    System.err.println("Mã danh mục không hợp lệ.");
                }
            }

            // Cap nhat trang thai san pham
            System.out.print("Trạng thái sản phẩm hiện tại: " + (product.getProductStatus()) + " - Nhập trạng thái mới (0-2): ");
            String newSatusStr = scanner.nextLine().strip();
            if (!newSatusStr.isEmpty()) {
                int newStatus = Integer.parseInt(newSatusStr);
                if (newStatus >= 0 && newStatus <= 2) {
                    product.setProductStatus(newStatus);
                } else {
                    System.err.println("Trạng thái sản phẩm không hợp lệ.");
                }
            }

            System.out.println("Cập nhật sản phẩm thành công!");
        } else {
            System.err.println("Không tìm thấy sản phẩm có mã " + productId);
        }

    }

    private void sortProductByPrice(Product[] arrProduct, int productIndex) {
        for (int i = 0; i < productIndex - 1; i++) {
            for (int j = i + 1; j < productIndex; j++) {
                if (arrProduct[i] != null && arrProduct[j] != null && arrProduct[i].getPrice() > arrProduct[j].getPrice()) {
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp sản phẩm theo giá thành công!");
    }

    private void deleteProduct(Scanner scanner, Product[] arrProduct) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String productId = scanner.nextLine();
        int index = findProductIndexById(arrProduct, productId);
        if (index != -1) {
            // dich chuyen cac phan tu phia sau len de lap day cho trong
            for (int i = index; i < arrProduct.length - 1; i++) {
                arrProduct[i] = arrProduct[i + 1];
            }
            arrProduct[arrProduct.length - 1] = null; // xoa phan tu cuoi cung
        } else {
            System.err.println("Không tìm thấy sản phẩm có mã " + productId);
        }
    }

    private void searchProductsByName(Scanner scanner, Product[] arrProduct, int productIndex) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] != null && arrProduct[i].getProductName().toLowerCase().contains(searchName.toLowerCase())) {
                arrProduct[i].displayData();
                System.out.println("----------------------");
                found = true;
            }
        }
        if (!found) {
            System.err.println("Không tìm thấy sản phẩm nào có tên chứa '" + searchName + "'");
        }
    }

    private void searchProductsByPriceRange(Scanner scanner, Product[] arrProduct) {
        System.out.print("Nhập giá tối thiểu: ");
        float minPrice = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập giá tối đa: ");
        float maxPrice = Float.parseFloat(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] != null && arrProduct[i].getPrice() >= minPrice && arrProduct[i].getPrice() <= maxPrice) {
                arrProduct[i].displayData();
                System.out.println("----------------------");
                found = true;
            }
        }

        if (!found) {
            System.err.println("Không tìm thấy sản phẩm nào trong khoảng giá từ " + minPrice + " đến " + maxPrice);
        }
    }

    private int findProductIndexById(Product[] arrProduct, String productId) {
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] != null && arrProduct[i].getProductId().equalsIgnoreCase(productId)) {
                return i;
            }
        }
        return -1;
    }

    private int getNextAvailableProductIndex(Product[] arrProduct) {
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] == null) {
                return i;
            }
        }
        return -1; // Mang da day
    }

    private boolean isProductArrayEmpty(Product[] arrProduct) {
        for (Product product : arrProduct) {
            if (product != null) {
                return false;
            }
        }
        return true;
    }

}
