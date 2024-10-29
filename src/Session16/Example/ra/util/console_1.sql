create database EcommerceDB;
use EcommerceDB;

INSERT INTO Categories (category_name, catalog_description, catalog_status) VALUES
('Electronics', 'Electronic devices and gadgets', 1),
('Clothing', 'Fashion and apparel', 1),
('Home & Kitchen', 'Home appliances and kitchenware', 1),
('Books', 'Books of all genres', 1),
('Sports & Outdoors', 'Sports equipment and outdoor gear', 1);

INSERT INTO Product (product_id, product_name, product_price, product_title, product_description, catalog_id, product_status) VALUES
('P0001', 'Smartphone', 500.00, 'Latest Smartphone Model', 'High-performance smartphone with advanced features', 1, 1),
('P0002', 'Laptop', 1200.00, 'Powerful Laptop for Work and Play', 'Lightweight laptop with a long battery life', 1, 1),
('P0003', 'T-shirt', 20.00, 'Casual T-shirt for Everyday Wear', 'Comfortable and stylish T-shirt', 2, 1),
('P0004', 'Jeans', 50.00, 'Classic Denim Jeans', 'Durable and fashionable jeans', 2, 1),
('P0005', 'Refrigerator', 800.00, 'Large Capacity Refrigerator', 'Energy-efficient refrigerator with ample storage space', 3, 1),
('P0006', 'Microwave Oven', 150.00, 'Multi-functional Microwave Oven', 'Easy-to-use microwave oven with various cooking modes', 3, 1),
('P0007', 'Novel', 15.00, 'Bestselling Mystery Novel', 'Gripping thriller with unexpected twists', 4, 1),
('P0008', 'Textbook', 50.00, 'Comprehensive Textbook for Students', 'Essential textbook for academic studies', 4, 1),
('P0009', 'Basketball', 30.00, 'Durable Basketball for Outdoor Play', 'High-quality basketball for recreational use', 5, 1),
('P0010', 'Tent', 100.00, 'Waterproof Tent for Camping', 'Spacious and comfortable tent for outdoor adventures', 5, 1);



INSERT INTO Categories (category_name, catalog_description, catalog_status) VALUES
('Beauty & Personal Care', 'Cosmetics, skincare, and grooming products', 1),
('Toys & Games', 'Toys for children of all ages', 1),
('Health & Household', 'Healthcare and household essentials', 1),
('Jewelry', 'Fine jewelry and fashion accessories', 1),
('Pet Supplies', 'Food, toys, and accessories for pets', 1);


INSERT INTO Product (product_id, product_name, product_price, product_title, product_description, catalog_id, product_status) VALUES
('P0011', 'Lipstick', 15.00, 'Long-lasting Lipstick in Various Shades', 'Creamy and pigmented lipstick for a perfect pout', 6, 1),
('P0012', 'Face Cream', 30.00, 'Hydrating Face Cream for All Skin Types', 'Moisturizing cream for a radiant complexion', 6, 1),
('P0013', 'Board Game', 25.00, 'Fun Board Game for the Whole Family', 'Engaging board game for hours of entertainment', 7, 1),
('P0014', 'Stuffed Animal', 20.00, 'Soft and Cuddly Stuffed Animal', 'Plush toy for children of all ages', 7, 1),
('P0015', 'Pain Relief Medication', 10.00, 'Effective Pain Relief for Headaches and Body Aches', 'Over-the-counter pain reliever for fast relief', 8, 1),
('P0016', 'Hand Sanitizer', 5.00, 'Antibacterial Hand Sanitizer', 'Kills 99.9% of germs for on-the-go hygiene', 8, 1),
('P0017', 'Necklace', 100.00, 'Elegant Necklace with Pendant', 'Beautiful necklace for special occasions', 9, 1),
('P0018', 'Earrings', 50.00, 'Sparkling Earrings with Gemstones', 'Stylish earrings to complement any outfit', 9, 1),
('P0019', 'Dog Food', 40.00, 'Nutritious Dog Food for Adult Dogs', 'Balanced diet for healthy dogs', 10, 1),
('P0020', 'Cat Toy', 10.00, 'Interactive Cat Toy with Feathers', 'Fun toy to keep cats entertained', 10, 1);


create table Categories(
    category_id int primary key auto_increment,
    category_name varchar(100) not null unique ,
    catalog_description text,
    catalog_status bit
);

create table Product(
  product_id char(5) primary key ,
    product_name varchar(100) not null unique ,
    product_price float check ( product_price > 0 ),
    product_title varchar(200),
    product_description text,
    catalog_id int ,
    foreign key (catalog_id) references Categories(category_id),
    product_status bit
);


# PROCEDURE CATEGORIES

DELIMITER &&

CREATE PROCEDURE find_all_categories()
begin
    select * from Categories;
end &&

DELIMITER &&;

DELIMITER &&

CREATE PROCEDURE create_categories(
    cat_name_in varchar(100),
    cat_des_in text,
    cat_status_in bit
)
begin
    insert into Categories(category_name, catalog_description, catalog_status) values (cat_name_in, cat_des_in, cat_status_in);
end &&

DELIMITER &&;


DELIMITER &&
CREATE PROCEDURE update_categories(
    cat_id_in int,
    cat_name_in varchar(100),
    cat_des_in text,
    cat_status_in bit
)
begin
    update Categories set category_name = cat_name_in,
                          catalog_description = cat_des_in,
                          catalog_status = cat_status_in
    where category_id = cat_id_in;
end &&

DELIMITER &&;



DELIMITER &&
CREATE PROCEDURE delete_categories(
    cat_id_in int
)
begin
    delete  from Categories where category_id = cat_id_in;
end &&

DELIMITER &&;



DELIMITER &&
CREATE PROCEDURE statictic_categories(
    cat_status_in int,
    OUT cnt_catalog int
)
begin
    set cnt_catalog = (select count(c.category_id) from Categories c where c.catalog_status = cat_status_in);
end &&

DELIMITER &&;


DELIMITER &&

CREATE PROCEDURE find_categories_by_id(
    cat_id_in int
)
begin
    select * from Categories c where c.category_id = cat_id_in;
end &&

DELIMITER &&;

# PROCEDURE PRODUCT

DELIMITER &&

CREATE PROCEDURE find_all_product()
BEGIN
    SELECT * FROM Product;
END &&

CREATE PROCEDURE create_product(
    product_id_in CHAR(5),
    product_name_in VARCHAR(100),
    product_price_in FLOAT,
    product_title_in VARCHAR(200),
    product_description_in TEXT,
    catalog_id_in INT,
    product_status_in BIT
)
BEGIN
    INSERT INTO Product (product_id, product_name, product_price, product_title, product_description, catalog_id, product_status)
    VALUES (product_id_in, product_name_in, product_price_in, product_title_in, product_description_in, catalog_id_in, product_status_in);
END &&

CREATE PROCEDURE find_product_by_id(
    product_id_in CHAR(5)
)
BEGIN
    SELECT * FROM Product WHERE product_id = product_id_in;
END &&

CREATE PROCEDURE update_product(
    product_id_in CHAR(5),
    product_name_in VARCHAR(100),
    product_price_in FLOAT,
    product_title_in VARCHAR(200),
    product_description_in TEXT,
    catalog_id_in INT,
    product_status_in BIT
)
BEGIN
    UPDATE Product
    SET product_name = product_name_in,
        product_price = product_price_in,
        product_title = product_title_in,
        product_description = product_description_in,
        catalog_id = catalog_id_in,
        product_status = product_status_in
    WHERE product_id = product_id_in;
END &&

CREATE PROCEDURE delete_product(
    product_id_in CHAR(5)
)
BEGIN
    DELETE FROM Product WHERE product_id = product_id_in;
END &&

CREATE PROCEDURE statictic_product(
    product_status_in BIT,
    OUT cnt_product INT
)
BEGIN
    SELECT COUNT(*) INTO cnt_product FROM Product WHERE product_status = product_status_in;
END &&

DELIMITER ;



DELIMITER &&

CREATE PROCEDURE search_product(
    search_term VARCHAR(200)
)
BEGIN
    SELECT * FROM Product
    WHERE product_name LIKE CONCAT('%', search_term, '%')
       OR product_title LIKE CONCAT('%', search_term, '%');
END &&

CREATE PROCEDURE statistic_product_by_price(
    price_from FLOAT,
    price_to FLOAT,
    OUT cnt_product INT
)
BEGIN
    SELECT COUNT(*) INTO cnt_product
    FROM Product
    WHERE product_price >= price_from AND product_price <= price_to;
END &&

CREATE PROCEDURE sort_product_by_price()
BEGIN
    SELECT * FROM Product ORDER BY product_price ASC;
END &&

CREATE PROCEDURE statistic_product_by_category(
    catalog_id_in INT,
    OUT cnt_product INT
)
BEGIN
    SELECT COUNT(*) INTO cnt_product
    FROM Product
    WHERE catalog_id = catalog_id_in;
END &&

DELIMITER ;





