package ExercisePlus.Ex2;

import java.util.Arrays;
import java.util.Scanner;

public class ProductImp {
    final static int exitMenu = 10;
    Product[] productArr = new Product[100];
    int count = 0;

    public static void main(String[] args) {
        // so luong san pham hien co trong mang
        Scanner scanner = new Scanner(System.in);
        ProductImp productImp = new ProductImp();
        productImp.productArr[0] = new Product("1234", "ten_san_pham_1", 1000000, 50000000, 6, "desc", true);
        productImp.productArr[1] = new Product("1235", "ten_san_pham_2", 100000, 50000000, 6, "desc", true);
        productImp.productArr[2] = new Product("1236", "ten_san_pham_3", 200000, 600000, 6, "desc", true);
        productImp.productArr[3] = new Product("1237", "ten_san_pham_4", 350888, 978645, 6, "desc", true);
        productImp.productArr[4] = new Product("1238", "ten_san_pham_5", 55000, 160000, 6, "desc", true);
        productImp.productArr[5] = new Product("1239", "ten_san_pham_6", 75000, 400000, 6, "desc", true);
        productImp.productArr[6] = new Product("1240", "ten_san_pham_7", 120000, 450500, 6, "desc", true);
        productImp.productArr[7] = new Product("1241", "ten_san_pham_8", 128900, 980999, 6, "desc", true);
        productImp.productArr[8] = new Product("1242", "ten_san_pham_9", 320000, 750000, 6, "desc", true);
        productImp.productArr[9] = new Product("1243", "ten_san_pham_10", 15000, 740000, 6, "desc", true);
        productImp.productArr[10] = new Product("1244", "ten_san_pham_11", 23000, 450000, 6, "desc", true);


        productImp.count = 11;


        int choice;
        do {
//            System.out.println("*********************MENU******************");
//            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
//            System.out.println("2. Hiển thị thông tin các sản phẩm");
//            System.out.println("3. Tính lợi nhuận các sản phẩm");
//            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
//            System.out.println("5. Thống kê các sản phẩm theo giá");
//            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
//            System.out.println("7. Nhập sản phẩm");
//            System.out.println("8. Bán sản phẩm");
//            System.out.println("9. Cập nhật trạng thái sản phẩm");
//            System.out.println("10. Thoát");
            productImp.showMenuChoice(productImp);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productImp.count = productImp.inputProductData(scanner, productImp);
                    break;
                case 2:
                    if (productImp.count == 0) {
                        System.out.println("Chưa có sản phẩm nào!");
                    } else {
                        for (int i = 0; i < productImp.count; i++) {
                            productImp.productArr[i].displayData();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Lợi nhuận của tất cả các sản phẩm đã được tính.");
                    for (int i = 0; i < productImp.count; i++) {
                        productImp.productArr[i].displayData();
                    }
                    break;
                case 4:
                    // sap xep cac san pham theo loi nhuan giam dan
//                    Arrays.sort(productImp.productArr, 0, productImp.count, (p1, p2) -> Double.compare(p2.getProfit(), p1.getProfit()));
                    Arrays.sort(productImp.productArr, 0, productImp.count, (p1, p2) -> Double.compare(p2.getProfit(), p1.getProfit()));
                    System.out.println("Đã sắp xếp sản phẩm theo lợi nhuận giảm dần.");
                    for (int i = 0; i < productImp.count; i++) {
                        productImp.productArr[i].displayData();
                    }
                    break;
                case 5:
                    productImp.countProductsByPriceRange(scanner, productImp);
                    break;
                case 6:
                    productImp.findProductByName(scanner, productImp);
                    break;
                case 7:
                    productImp.addProductQuantity(scanner, productImp);
                    break;
                case 8:
                    productImp.sellProduct(scanner, productImp);
                    break;
                case 9:
                    productImp.updateStatusProduct(scanner, productImp);
                    break;
                case 10:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");

            }

        } while (choice != exitMenu);
    }

    public void showMenuChoice(ProductImp productImp) {
        String[] options = {
                "1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)",
                "2. Hiển thị thông tin các sản phẩm",
                "3. Tính lợi nhuận các sản phẩm",
                "4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần",
                "5. Thống kê các sản phẩm theo giá",
                "6. Tìm các sản phẩm theo tên sản phẩm",
                "7. Nhập sản phẩm",
                "8. Bán sản phẩm",
                "9. Cập nhật trạng thái sản phẩm",
                "10. Thoát"
        };

        int longestLength = productImp.findLongestLength(options);
        int numberOfAsterisksRequired = longestLength + 6;

        System.out.println("*".repeat(numberOfAsterisksRequired + 2));

        // In các món ăn
        for (String select : options) {
            int paddingLeft = (numberOfAsterisksRequired - select.length() - 2) / 2;
            int paddingRight = numberOfAsterisksRequired - select.length() - 2 - paddingLeft;
            String oneLine = "* " + " ".repeat(paddingLeft) + select + " ".repeat(paddingRight) + " *";
            System.out.println(oneLine);
        }

        System.out.println("*".repeat(numberOfAsterisksRequired + 2));
    }

    public int findLongestLength(String[] mang) {
        int max = 0;
        for (String s : mang) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    private void updateStatusProduct(Scanner scanner, ProductImp productImp) {
        System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
        String updateProductId = scanner.nextLine();

        boolean productFoundForUpdate = false;
        for (int i = 0; i < productImp.count; i++) {
            if (productImp.productArr[i].getProductId().equalsIgnoreCase(updateProductId)) {
                productImp.productArr[i].setStatus(!productImp.productArr[i].isStatus());
                System.out.println("Đã cập nhật trạng thái sản phẩm thành công!");
                productImp.productArr[i].displayData();
                productFoundForUpdate = true;
                break;
            }
        }
        if (!productFoundForUpdate) {
            System.out.println("Không tìm thấy sản phẩm có mã: " + updateProductId);
        }
    }

    private void sellProduct(Scanner scanner, ProductImp productImp) {
        System.out.print("Nhập tên sản phẩm cần bán: ");
        String sellProductName = scanner.nextLine();
        System.out.print("Nhập số lượng cần bán: ");
        int sellQuantity = 0;
        boolean validQuantity;
        do {
            try {
                sellQuantity = Integer.parseInt(scanner.nextLine());
                if (sellQuantity <= 0) {
                    System.err.println("Số lượng phải lớn hơn 0.");
                    validQuantity = false;
                } else {
                    validQuantity = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");
                validQuantity = false;
            }
        } while (!validQuantity);
        boolean productFoundForSelling = false;
        for (int i = 0; i < productImp.count; i++) {
            if (productImp.productArr[i].getProductName().equalsIgnoreCase(sellProductName)) {
                if (productImp.productArr[i].getQuantity() >= sellQuantity) {
                    productImp.productArr[i].setQuantity(productImp.productArr[i].getQuantity() - sellQuantity);
                    System.out.println("Đã bán sản phẩm thành công!");
                    productImp.productArr[i].displayData();
                    productFoundForSelling = true;
                    break;
                } else {
                    System.out.println("Số lượng sản phẩm không đủ để bán.");
                    productFoundForSelling = true;
                    break;
                }
            }
        }
        if (!productFoundForSelling) {
            System.out.println("Không tìm thấy sản phẩm có tên: " + sellProductName);
        }
    }

    private void addProductQuantity(Scanner scanner, ProductImp productImp) {
        System.out.print("Nhập mã sản phẩm cần nhập thêm: ");
        String importProductId = scanner.nextLine();
        System.out.print("Nhập số lượng cần nhập thêm: ");
        int importQuantity = 0;
        boolean validQuantity = false;
        do {
            try {
                importQuantity = Integer.parseInt(scanner.nextLine());
                if (importQuantity <= 0) {
                    System.err.println("Số lượng phải lớn hơn 0.");
                    validQuantity = false;
                } else {
                    validQuantity = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");
                validQuantity = false;
            }
        } while (!validQuantity);

        boolean productFound = false;
        for (int i = 0; i < productImp.count; i++) {
            if (productImp.productArr[i].getProductId().equalsIgnoreCase(importProductId)) {
                productImp.productArr[i].setQuantity(productImp.productArr[i].getQuantity() + importQuantity);
                System.out.println("Đã nhập thêm sản phẩm thành công!");
                productImp.productArr[i].displayData();
                productFound = true;
                break;
            }
        }
        if (!productFound) {
            System.out.println("Không tìm thấy sản phẩm có mã: " + importProductId);
        }
    }

    private void findProductByName(Scanner scanner, ProductImp productImp) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < productImp.count; i++) {
            if (productImp.productArr[i].getProductName().contains(searchName)) {
                productImp.productArr[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm có tên: " + searchName);
        }
    }

    private void countProductsByPriceRange(Scanner scanner, ProductImp productImp) {
        // Thống kê các sản phẩm theo giá
        boolean isValidInput;
        double fromPrice = 0;
        double toPrice = 0;
        System.out.print("Nhập khoảng giá từ (fromPrice): ");
        do {
            try {
                fromPrice = Double.parseDouble(scanner.nextLine());
                if (fromPrice < 0) {
                    System.err.println("Giá nhập vào phải là 1 số lớn hơn 0");
                    isValidInput = false;
                } else {
                    isValidInput = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Phải nhập vào giá trị là số");
                isValidInput = false;
            }

        } while (!isValidInput);
        isValidInput = false;
        System.out.print("Nhập khoảng giá đến (toPrice): ");
        do {
            try {
                toPrice = Double.parseDouble(scanner.nextLine());
                if (toPrice < 0) {
                    System.err.println("Giá nhập vào phải là 1 số lớn hơn 0");
                    isValidInput = false;
                } else {
                    isValidInput = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Phải nhập vào giá trị là số");
                isValidInput = false;
            }
        } while (!isValidInput);


        int countInRange = 0;

        Product[] tempProductArr = new Product[productImp.count];
        int tempCount = 0;
        for (int i = 0; i < productImp.count; i++) {
            if (productImp.productArr[i].getExportPrice() >= fromPrice && productImp.productArr[i].getExportPrice() <= toPrice) {
                countInRange++;

                tempProductArr[tempCount] = productImp.productArr[i];
                tempCount++;
            }
        }

        System.out.println("Các sản phẩm có giá bán trong khoảng từ " + fromPrice + " đến " + toPrice + " là: ");
        for (int i = 0; i < tempCount; i++) {
            tempProductArr[i].displayData();
        }

        System.out.println("Số lượng sản phẩm có giá bán trong khoảng từ " + fromPrice + " đến " + toPrice + " là: " + countInRange);

    }

    private int inputProductData(Scanner scanner, ProductImp productImp) {
        int n = 0;
        boolean isValidInput = false;
        System.out.print("Nhập số lượng sản phẩm (n): ");
        do {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) {
                    System.err.println("Số lượng sản phẩm phải lớn hơn 0.");
                } else {
                    isValidInput = true;
                }

            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập một số nguyên.");
            }
        } while (!isValidInput);
        for (int i = 0; i < n; i++) {
            if (productImp.count < productImp.productArr.length) {
                productImp.productArr[count] = new Product();
                productImp.productArr[count].inputData(scanner, Arrays.copyOf(productImp.productArr, count));
//                productImp.productArr[count].inputData(scanner, productImp.productArr);
                productImp.count++;
            } else {
                System.err.println("Mảng sản phẩm đã đầy");
                break;
            }
        }
        return count;

    }


}
