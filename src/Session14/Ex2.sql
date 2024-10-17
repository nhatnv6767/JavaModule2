create database ex2;
use ex2;

CREATE TABLE Customer (
                          customerId INT PRIMARY KEY,
                          name VARCHAR(255),
                          age INT
);

CREATE TABLE Orders (
                        orderId INT PRIMARY KEY,
                        customerId INT,
                        orderDate DATE,
                        orderTotal DECIMAL,
                        FOREIGN KEY (customerId) REFERENCES Customer(customerId)
);

CREATE TABLE Products (
                          productId INT PRIMARY KEY,
                          productName VARCHAR(255),
                          productPrice DECIMAL
);

CREATE TABLE OrderDetail (
                             orderId INT,
                             productId INT,
                             quantity INT,
                             FOREIGN KEY (orderId) REFERENCES Orders(orderId),
                             FOREIGN KEY (productId) REFERENCES Products(productId)
);


INSERT INTO Customer (customerId, name, age) VALUES
                                                 (1, 'Minh Quan', 10),
                                                 (2, 'Ngoc Oanh', 20),
                                                 (3, 'Hong Ha', 50);


INSERT INTO Orders (orderId, customerId, orderDate, orderTotal) VALUES
                                                                    (1, 1, '2006-03-21', NULL),
                                                                    (2, 2, '2006-03-23', NULL),
                                                                    (3, 1, '2023-03-16', NULL);


INSERT INTO Products (productId, productName, productPrice) VALUES
                                                                (1, 'Máy giặt', 3),
                                                                (2, 'Tủ lạnh', 5),
                                                                (3, 'Điều hòa', 7),
                                                                (4, 'Quạt', 1),
                                                                (5, 'Bếp điện', 2);

INSERT INTO OrderDetail (orderId, productId, quantity) VALUES
                                                           (1, 1, 3),
                                                           (1, 3, 7),
                                                           (1, 4, 2),
                                                           (2, 1, 1),
                                                           (3, 1, 8),
                                                           (2, 5, 4),
                                                           (2, 3, 3);


-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select  c.name as CustomerName, p.productName as ProductName
from Customer c
         join Orders o on c.customerId = o.customerId
         join OrderDetail od on o.orderId = od.orderId
         join Products p on od.productId = p.productId;

-- nhung khach hang khong mua bat ky 1 san pham nao
select name
from Customer
where customerId not in (select customerId from Orders);

select c.name
from Customer c
         left join Orders o on c.customerId = o.customerId
where o.customerId is null;


/*
Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
Giá bán của từng loại được tính = quantity * productPrice)
*/
select o.orderId, o.orderDate, SUM(od.quantity * p.productPrice) as TotalPrice
from Orders o
         join OrderDetail od on o.orderId = od.orderId
         join Products p on od.productId = p.productId
group by o.orderId, o.orderDate;


