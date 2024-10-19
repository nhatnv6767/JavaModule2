/*

Xây dựng bảng Book_Type gồm các thông tin sau:
book_type_id int, PK, Auto_increment
book_type_name varchar(100), not null, unique
book_type_descriptions text
book_type_status bit
Xây dựng bảng Books gồm các thông tin sau:
book_id char(4) PK,
book_name varchar(200) not null, unique
book_price float, check(price>0),
created date,
book_content text not null,
publisher varchar(150) not null,
no_of_pages int not null,
author varchar(100),
book_type_id int not null, FK (Book_type)
book_status bit
Thêm mỗi bảng 10 dữ liệu
Xây dựng các procedure sau:4.1. Cho phép lấy tất cả các loại sách có trạng thái là 14.2. Cho phép thêm mới 1 loại sách4.3. Cho phép cập nhật thông tin loại sách4.4. Cho phép xóa loại sách theo mã loại sách:
Nếu loại sách chưa chứa giá trị sách thì cho xóa sách và trả về kết quả là 1 (if-else mysql)
Nếu loại sách đã chứa sách thì không cho xóa và trả về kết quả là 04.5. Cho phép lấy tất cả sách: gồm thông tin sách, tên loại sách4.6. Cho phép thêm mới sách4.7. Cho phép cập nhật sách theo mã sách4.8. Cho phép xóa sách theo mã sách4.9. Thống kê số lượng sách theo loại sách
*/

use Procedure_pre;

create table book_type(
                          book_type_id int primary key auto_increment,
                          book_type_name varchar(100) not null unique,
                          book_type_descriptions text,
                          book_type_status bit
);

create table books(
                      book_id char(4) primary key ,
                      book_name varchar(200) not null unique ,
                      book_price float check (book_price > 0),
                      created_date DATE,
                      book_content TEXT not null ,
                      publisher varchar(150) not null,
                      no_of_pages int not null,
                      author varchar(100),
                      book_type_id int not null,
                      book_status bit,
                      foreign key (book_type_id) references book_type(book_type_id)
);


INSERT INTO book_type (book_type_name, book_type_descriptions, book_type_status) VALUES
                                                                                     ('Tiểu tuyết', 'Truyn hư cấu', 1),
                                                                                     ('Khoa học viễn tưởng', 'Truyn về tương lai', 1),
                                                                                     ('Trinh thám', 'Truyn điều tra phá án', 1),
                                                                                     ('Kinh dị', 'Truyn rùng rợn', 1),
                                                                                     ('Lãn mạn', 'Truyn tình cảm', 1),
                                                                                     ('Lịch sử', 'Sách về lịchh sử', 1),
                                                                                     ('Tâm lý học', 'Sách về tâm lý con người', 1),
                                                                                     ('Kỹ năng sống', 'Sách hướng dẫn kỹ năng', 1),
                                                                                     ('Nấu ăn', 'Sách dạy nấu ăn', 1),
                                                                                     ('Du lịch', 'Sách hướng dẫn du lịch', 1);

INSERT INTO books (book_id, book_name, book_price, created_date, book_content, publisher, no_of_pages, author, book_type_id, book_status) VALUES
                                                                                                                                              ('B001', 'Kim Bình Mai', 200000, '2022-01-01', 'Nội dung sách...', 'NXB Văn học', 1200, 'Lev Tolstoy', 1, 1),
                                                                                                                                              ('B002', 'Dune', 150000, '2023-05-10', 'Nội dung sách...', 'NXB Trẻ', 800, 'Frank Herbert', 2, 1),
                                                                                                                                              ('B003', 'Sherlock Holmes', 100000, '2023-09-15', 'Nội dung sách...', 'NXB Kim Đồng', 500, 'Arthur Conan Doyle', 3, 1),
                                                                                                                                              ('B004', 'Dracula', 80000, '2023-10-20', 'Nội dung sách...', 'NXB Phụ nữ', 400, 'Bram Stoker', 4, 1),
                                                                                                                                              ('B005', 'Tây môn khánh', 120000, '2022-07-05', 'Nội dung sách...', 'NXB Tổng hợp TP.HCM', 600, 'Jane Austen', 5, 1),
                                                                                                                                              ('B006', 'Sapiens: Lược sử loài người', 180000, '2023-02-14', 'Nội dung sách...', 'NXB Tri thức', 700, 'Yuval Noah Harari', 6, 1),
                                                                                                                                              ('B007', 'Nghĩ nhanh và chậm', 250000, '2022-11-22', 'Nội dung sách...', 'NXB Thế giới', 900, 'Daniel Kahneman', 7, 1),
                                                                                                                                              ('B008', 'Hồng lâu mộng', 100000, '2021-08-08', 'Nội dung sách...', 'NXB Thanh niên', 300, 'Dale Carnegie', 8, 1),
                                                                                                                                              ('B009', 'Nấu ăn ngon mỗi ngày', 70000, '2020-06-30', 'Nội dung sách...', 'NXB Lao động', 200, 'Nhiều tác giả', 9, 1),
                                                                                                                                              ('B010', 'Du lịch Bt cứ đâu', 90000, '2024-03-15', 'Nội dung sách...', 'NXB Thể thao và Du lịch', 350, 'Vũ Minh Tuấn', 10, 1);



DELIMITER &&
create procedure get_all_active_book_types()
begin
select * from book_type where book_type_status = 1;
end &&
delimiter &&;

delimiter &&
create procedure add_new_book_type(
    book_type_name_in varchar(100),
    book_type_descriptions_in text,
    book_type_status_in bit
)

begin
insert into book_type(book_type_name, book_type_descriptions, book_type_status) VALUES (book_type_name_in, book_type_descriptions_in, book_type_status_in);
end &&

delimiter &&;

call add_new_book_type("Kiếm hiệp", "Sách về kiếm hiệp", 1);

delimiter &&
create procedure update_book_type(
    book_type_id_in int,
    new_book_type_name varchar(100),
    new_book_type_descriptions text,
    new_book_type_status bit
)
begin
update book_type
set
    book_type_name = new_book_type_name,
    book_type_descriptions = new_book_type_descriptions,
    book_type_status = new_book_type_status
where book_type_id = book_type_id_in;
end &&
delimiter &&;

call update_book_type(12, "Kiếm hiệp Edit", "Sách về kiếm hiệp Edit", false);



DELIMITER &&
create procedure delete_book_type(
    book_type_id_in int,
    out result int
)
begin
    declare book_count int;
select count(*) into book_count from books where book_type_id = book_type_id_in;
if book_count = 0 then
delete from book_type where book_type_id = book_type_id_in;
set result = 1; -- da xoa thanh cong khi khong co sach
else
        set result = 0;

end if;
end &&
delimiter &&;

call delete_book_type(3, @result);
select @result;


delimiter &&
create procedure get_all_books()
begin
select b.*
from books b join book_type bt on b.book_type_id = bt.book_type_id;
end &&
delimiter &&;


delimiter &&
create procedure add_new_book(
    book_id_in char(4),
    book_name_in varchar(200),
    book_price_in float,
    created_date_in DATE,
    book_content_in text,
    publisher_in varchar(150),
    no_of_pages_in int,
    author_in varchar(100),
    book_type_id_in int,
    book_status_in bit
)

begin
insert into books(book_id, book_name, book_price, created_date, book_content, publisher, no_of_pages, author, book_type_id, book_status) values (book_id_in, book_name_in, book_price_in, created_date_in, book_content_in, publisher_in, no_of_pages_in, author_in, book_type_id_in, book_status_in);
end &&

delimiter &&;



DELIMITER &&

CREATE PROCEDURE UpdateBook(
     bookId CHAR(4),
     newBookName VARCHAR(200),
     newBookPrice FLOAT,
     newCreatedDate DATE,
     newBookContent TEXT,
     newPublisher VARCHAR(150),
     newNoOfPages INT,
     newAuthor VARCHAR(100),
     newBookTypeId INT,
     newBookStatus BIT
)
BEGIN
UPDATE books
SET
    book_name = newBookName,
    book_price = newBookPrice,
    created_date = newCreatedDate,
    book_content = newBookContent,
    publisher = newPublisher,
    no_of_pages = newNoOfPages,
    author = newAuthor,
    book_type_id = newBookTypeId,
    book_status = newBookStatus
WHERE book_id = bookId;
END &&

DELIMITER &&;


-- 4.8 Xóa sách theo mã sách

delimiter &&
create procedure delete_book(book_id_in char(4))
begin
delete from books where book_id = book_id_in;
end &&
delimiter &&;


-- 4.9 Thống kê số lượng sách theo loại sách

delimiter &&
drop procedure if exists count_books_by_type;
create procedure count_books_by_type()
begin
select bt.book_type_name, count(b.book_type_id) as so_luong_sach
from book_type bt
         left join books b on bt.book_type_id = b.book_type_id
group by bt.book_type_name;
end &&
delimiter &&;


