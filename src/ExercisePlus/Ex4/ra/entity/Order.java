package ExercisePlus.Ex4.ra.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Order {
    private static int nextOrderNumber = 1; // bien static de tao so phieu tu dong tang
    private String orderId;
    private int quantity;
    private String productId;
    private Date created;
    private int userCreatedId;
    private Date updated;
    private int userUpdatedId;
    private boolean orderType;
    private float price;
    private boolean orderStatus;

    public Order() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
        try {
            String yearMonth = dateFormat.format(new Date());
            this.orderId = (this.orderType ? "PN" : "PX") + "-" + yearMonth + "-" + String.format("%02d", nextOrderNumber++);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getOrderId() {
        return orderId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Số lượng phải lớn hơn 0. Vui lòng nhập lại.");
        }
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getUserCreatedId() {
        return userCreatedId;
    }

    public void setUserCreatedId(int userCreatedId) {
        this.userCreatedId = userCreatedId;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public int getUserUpdatedId() {
        return userUpdatedId;
    }

    public void setUserUpdatedId(int userUpdatedId) {
        this.userUpdatedId = userUpdatedId;
    }

    public boolean isOrderType() {
        return orderType;
    }

    public void setOrderType(boolean orderType) {
        this.orderType = orderType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Giá phải lớn hơn 0. Vui lòng nhập lại.");
        }
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void inputData(Product[] products, Employee[] employees) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        boolean isValid = false;
        do {
            System.out.print("Nhập loại phiếu (true-phiếu nhập, false-phiếu xuất): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("true")) {
                setOrderType(true);
                isValid = true;
            } else if (input.equalsIgnoreCase("false")) {
                setOrderType(false);
                isValid = true;
            } else {
                System.err.println("Vui lòng nhập 'true' hoặc 'false'. ");
                isValid = false;
            }
        } while (!isValid);

        do {
            System.out.print("Nhập mã sản phẩm: ");
            setProductId(scanner.nextLine());

            // kiem tra ma san pham co ton tai hay khong
            boolean productExists = false;
            for (Product product : products) {
                if (product != null && product.getProductId().equals(productId)) {
                    productExists = true;
                    break;
                }
            }
            if (!productExists) {
                System.out.println("Mã sản phẩm không tồn tại. Vui lòng nhập lại.");
                productId = null;
            }
        } while (productId == null);

        do {
            System.out.print("Nhập số lượng: ");
            setQuantity(Integer.parseInt(scanner.nextLine()));
        } while (quantity == 0);

        do {
            System.out.print("Nhập giá: ");
            setPrice(Float.parseFloat(scanner.nextLine()));
        } while (price == 0);

        do {
            System.out.print("Nhập mã nhân viên tạo phiếu: ");
            setUserCreatedId(Integer.parseInt(scanner.nextLine()));

            // Kiem tra ma nhan vien co ton tai hay khong
            boolean employeeExists = false;
            for (Employee employee : employees) {
                if (employee != null && employee.getEmpId() == userCreatedId) {
                    employeeExists = true;
                    break;
                }
            }
            if (!employeeExists) {
                System.out.println("Mã nhân viên không tồn tại. Vui lòng nhập lại.");
                userCreatedId = 0;
            }
        } while (userCreatedId == 0);

        setOrderStatus(true); // trang thai mac dinh la hoat dong
    }

    public void displayData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Mã phiếu: " + this.orderId);
        System.out.println("Loại phiếu: " + (this.orderType ? "Phiếu nhập" : "Phiếu xuất"));
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Số lượng: " + this.quantity);
        System.out.println("Giá: " + this.price);
        System.out.println("Ngày tạo: " + dateFormat.format(this.created));
        System.out.println("Người tạo: " + this.userCreatedId);
        if (this.updated != null) {
            System.out.println("Ngày cập nhật: " + dateFormat.format(this.updated));
            System.out.println("Người cập nhật: " + this.userUpdatedId);
        }
        System.out.println("Trạng thái: " + (this.orderStatus ? "Hoạt động" : "Bị hủy"));
    }
}
