use Demo;
select * from Categories;
select * from Products;

-- lay ra tat ca cac san pham co ma danh muc la 1, 2, 7
-- cach 1: su dung join de lien ket 2 bang

select p.*, c.cat_name
from Products p join Categories c on p.cat_id = c.cat_id
where c.cat_id in (1, 2, 7);

-- lay ra tat ca cac san pham co ten danh muc la danh muc 1, danh muc 2, danh muc 7
-- cach 1: su dung join de lien ket 2 bang
-- cach 2: truy van long: ket qua cua cau lenh truy van nay la dau vao
-- cua cau lenh truy van khac
-- B1: tao 1 cau truy van lay ra cac ma danh muc co ten la Dm1, dm2, dm7
-- B2: tao 1 cau truy van lay thong tin cac san pham co ma danh muc thuoc ket quqa cua cau lenh 1

select *
from Products p
where p.cat_id in (
    select c.cat_id
    from Categories c
    where c.cat_name in ("Danh muc 1", "danh muc 2", "danh muc 7"));


/*
 Procedure == method of java: khi tao procedure (build)
 thi procedure se duoc luu vao bo nho cua db, khi goi procedure thi khong phai build lai


 CREATE PROCEDURE

 ket qua cua cau lenh truy van thi mac dinh tra ra 1 doi tuong resultSet
*/

-- 1. Xay dung 1 procedure cho phep lay thong tin tat ca cac san pham

DELIMITER &&
CREATE PROCEDURE find_all_product()
BEGIN
    -- block statements: thuc hien chuc nang cua procedure
select * from Products;
end &&
DELIMITER &&;

-- goi procedure de chay
call find_all_product();

-- 2. xay dung procedure cho phep lay ra so luong san pham trong 1 danh muc

delimiter &&
create procedure get_cnt_product_by_cat_id(
    cat_id_in int, -- tham so vao cua procedure
    OUT cnt_product int
)

begin
    set cnt_product = (SELECT COUNT(p.product_id) from Products p where p.cat_id = cat_id_in);
end &&
delimiter &&;

# declare @cnt_product int;
call get_cnt_product_by_cat_id(1,@cnt_product );

-- 3. xay dung procedure cho phep lay ten danh muc theo ma danh muc
delimiter &&
create procedure find_name_by_cat_id(
    cat_id_in int,
    OUT cat_name_out varchar(100)
)
begin
    set cat_name_out = (select c.cat_name from Categories c where c.cat_id = cat_id_in);
end &&
delimiter &&;

call find_name_by_cat_id(2, @name);
select @name;


-- 4. xay dung procedure cho phep them moi 1 danh muc

delimiter &&
create procedure add_categories(
    name_in varchar(100),
    des_in text,
    status_in bit
)
begin
insert into Categories(cat_name, cat_description, cat_status) values (name_in, des_in, status_in);
end &&

delimiter &&;

call add_categories("Danh muc test proc", "Mo ta danh muc test", 1);

-- 5. xay dung procedure cho phep cap nhat 1 danh muc theo ma danh muc

delimiter &&
create procedure update_category(
    id_in int,
    name_in varchar(100),
    des_in text,
    status_in bit
)
begin
update Categories
set cat_name = name_in, cat_description = des_in, cat_status = status_in where cat_id = id_in;

end &&

DELIMITER &&;

call update_category(10, "Danh muc test","mo ta des", 0);

-- 6 xay dung procedure cho phep xoa danh muc theo ma danh muc

DELIMITER &&
create procedure delete_categories(id_in int)
begin
delete from Categories where cat_id = id_in;
end &&
delimiter &&;

call delete_category(9);


1. Xay dung bang Book_type gom cac thong tin sau:
- book_type_id int, PK, Auto_increment
- book_type_name varchar(100), not null, unique
- book_type_descriptions text,
- book_type_status bit

2. Xay dung bang Books gom cac thong tin sau:
- book_id char(4) PK,
- book_name varchar(200) not null, unique
- book_price float, check(price>0),
- created date,
- book_content text not null,
- publisher varchar(150) not null,
- no_of_pages int not null,
- author varchar(100),
- book_type_id int not null, FK (Book_type)
- book_status bit

3. Them moi bang 10 du lieu
4. xay dung cac procedure sau:
    4.1 Cho phep lay tat ca cac loai sach co trang thai la 1
    4.2 cho phep them moi 1 loai sach
    4.3 cho phep cap nhat thong tin loai sach
    4.4 cho phep xoa loai sach theo ma loai sach
        4.4.1 Neu loai sach chua chua gia tri sach thi cho xoa sach va tra ve ket qua la 1 (if - else trong mysql)
        4.4.2 Neu loai sach da chua sach thi khong cho xoa va tra ve ket qua la 0
    4.5 cho phep lay tat ca sach: gom thong tin sach, ten loai sach
    4.6 cho phep them moi sach
    4.7 cho phep cap nhat sach theo ma sach
    4.8 cho phep xoa sach theo ma sach
    4.9 thong ke so luong sach theo loai sach (loai sach 1 co 10 quyen, loai sach ... co bao nhieu quyen... )


