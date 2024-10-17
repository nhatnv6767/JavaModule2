select * from Categories;
select * from Products;

-- 1. Them 1 ban ghi day du thong tin vao bang Product
insert into Products values ("P0005", "San pham 5", 100, "Des 5", 1, 1);
insert into Products values ("P0006", "San pham 6",200, "Des 5", 1, 1);

-- 2. Them 1 ban ghi gom ma san pham, ten san pham, gia san pham, danh muc san pham vao bang Product
insert into Products(pro_id, pro_name, cat_id, pro_price) values ("P0007", "San pham 7", 1, 50);
-- 3. Them 3 san pham vao bang Product
insert into Products values ("P0008", "San pham 8", 50, "Des 8", 1, 1),
                            ("P0009", "San pham 9", 50, "Des 9", 2, 1),
                            ("P0010", "San pham 10", 50, "Des 10", 4, 1);

-- 4. Cap nhat tat ca cac trang thai san pham thanh 1
update Products set pro_status = 1;

-- 5. cap nhat san pham thanh ten san pham test, gia la 100 voi nhung san pham co ma la P0001
update Products set pro_name = "San pham test", pro_price = 100 where pro_id = "P0001";

-- 6. Xoa san pham co ten la san pham 10
DELETE from Products where pro_name = "SAN PHAM 10";

-- 7. Chi dung menh de select de truy van du lieu
select current_date();

-- 8. lay tat ca du lieu bang product
select * from Products; -- khong toi uu trong cau truy van
select p.pro_id, p.pro_name, p.pro_price, p.pro_description, p.cat_id, p.pro_status
from Products p;

-- 9. lay thong tin san pham gom ma san pham, ten san pham, gia san pham
select p.pro_id, p.pro_name, p.pro_price
from Products p;

-- 10. lay ra gia lon nhat, nho nhat, tong gia, trung binh gia cac san pham trong product
select max(p.pro_price) as "Gia lon nhat", min(p.pro_price) as "Gia nho nhat",sum(p.pro_price) as "Tong gia", avg(p.pro_price) as "Trung binh"
from Products p;

-- 11. lay ra du lieu gom ma san pham - ten san pham, gia san pham
select concat(p.pro_id, p.pro_name), p.pro_price + 10
from Products p;

-- 12. thong ke cac ma danh muc co trong bang product
select distinct p.cat_id
from Products p;


-- 13. lay thong tin san pham gom: ma san pham, ten san pham, gia, ten danh muc
select p.pro_id, p.pro_name, p.pro_price,p.cat_id, c.cat_name
from Products p inner join Categories c on p.cat_id = c.cat_id;

-- 14. lay thong tin: ma danh muc, ma san pham, gia, so luong, ma hoa don, ten nguoi dung
select c.cat_id, p.pro_id, p.pro_price, od.quantity, o.order_id, u.user_name
from Categories c join Products p on c.cat_id = p.cat_id
                  join order_details od on p.pro_id = od.pro_id
                  join orders o on od.order_id = o.order_id
                  join users u on o.user_id = u.user_id;


-- 15. lay tat ca thong tin san pham gom ca thong tin danh muc
select *
from Products p inner join Categories c on p.cat_id = c.cat_id;
select *
from Products p right join Categories c on p.cat_id = c.cat_id;

-- 16. lay tat ca cac san pham co gia lon hon hoac bang 100
select *
from Products p where p.pro_price >= 100;

-- 17. lay tat ca cac san pham co gia trong khoang tu 50 den 150
select *
from Products p
where p.pro_price >= 50 and p.pro_price <=150;

-- 18. lay cac san pham co gia hoac la 50 hoac 100 hoac 200
select *
from Products p
where p.pro_price in (50, 100, 200);

-- 19. lay thong tin san pham co ten san pham la san pham 9
select *
from Products p
where p.pro_name like "san pham 9";

-- 20. lay thong tin cac san pham bat dau la san
select *
from Products p
where p.pro_name like "san%";

-- 21. lay thong tin san pham co ky tu thu 3 ba n
select *
from Products p
where p.pro_name like "__n%";

-- 22. tinh trung binh gia cua cac san pham theo danh muc
select p.cat_id,c.cat_name, p.pro_status, avg(p.pro_price)
from Products p join Categories c on p.cat_id = c.cat_id
group by p.cat_id, c.cat_name, p.pro_status;

select p.pro_status, avg(p.pro_price)
from Products p join Categories c on p.cat_id = c.cat_id
group by p.pro_status;

-- 23. lay ra thong tin cac nhom theo ma danh muc co gia trung binh lon hon hoac bang 80
select p.cat_id, avg(p.pro_price)
from Products p
group by p.cat_id
having avg(p.pro_price)>=50;

-- 24. sap xep cac san pham theo gia tang dan
select *
from Products p
order by p.pro_price;

-- 25. sap xep cac san pham theo gia tang dan, cac san pham co gia bang nhau thi sap xep theo ten giam dan

select *
from Products p
order by p.pro_price asc, p.pro_name desc ;

-- 26. lay 5 san pham dau tien trong bang product
select *
from Products p
    limit 5;

-- 27. lay 3 san pham tu vi tri thu 2
select *
from Products p
    limit 3 offset 2;
