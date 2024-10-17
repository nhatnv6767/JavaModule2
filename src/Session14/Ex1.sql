create database EX1;
use EX1;

CREATE TABLE Class (
                       ClassId INT PRIMARY KEY,
                       ClassName VARCHAR(255),
                       StartDate DATE,
                       Status BIT
);

CREATE TABLE Student (
                         StudentId INT PRIMARY KEY,
                         StudentName VARCHAR(255),
                         Address VARCHAR(255),
                         Phone VARCHAR(20),
                         Status BIT,
                         ClassId INT,
                         FOREIGN KEY (ClassId) REFERENCES Class(ClassId)
);

CREATE TABLE Subject (
                         SubId INT PRIMARY KEY,
                         SubName VARCHAR(255),
                         Credit INT,
                         Status BIT
);

CREATE TABLE Mark (
                      MarkId INT PRIMARY KEY,
                      SubId INT,
                      StudentId INT,
                      Mark FLOAT,
                      ExamTime DATETIME,
                      FOREIGN KEY (SubId) REFERENCES Subject(SubId),
                      FOREIGN KEY (StudentId) REFERENCES Student(StudentId)
);

INSERT INTO Class (ClassId, ClassName, StartDate, Status) VALUES
                                                              (1, 'CNTT01', '2023-09-01', 1),
                                                              (2, 'CNTT02', '2023-12-15', 1),
                                                              (3, 'QTKD01', '2024-01-10', 1);

INSERT INTO Student (StudentId, StudentName, Address, Phone, Status, ClassId) VALUES
                                                                                  (1, 'hung', 'Ha Noi', '0123456789', 1, 1),
                                                                                  (2, 'hoa', 'Ha Noi', '0987654321', 1, 1),
                                                                                  (3, 'lan', 'HCM', '0123456788', 1, 2),
                                                                                  (4, 'nam', 'HCM', '0987654322', 1, 3),
                                                                                  (5, 'ha', 'Da Nang', '0123456787', 1, 2);

INSERT INTO Subject (SubId, SubName, Credit, Status) VALUES
                                                         (1, 'Toan', 3, 1),
                                                         (2, 'Ly', 4, 1),
                                                         (3, 'Hoa', 3, 1),
                                                         (4, 'Van', 2, 1),
                                                         (5, 'Anh', 4, 1);

INSERT INTO Mark (MarkId, SubId, StudentId, Mark, ExamTime) VALUES
                                                                (1, 1, 1, 8.5, '2024-01-15 08:00:00'),
                                                                (2, 2, 1, 7.0, '2024-01-16 08:00:00'),
                                                                (3, 1, 2, 9.0, '2024-01-15 08:00:00'),
                                                                (4, 3, 2, 6.5, '2024-01-17 08:00:00'),
                                                                (5, 4, 3, 7.5, '2024-01-18 08:00:00'),
                                                                (6, 5, 4, 8.0, '2024-01-19 08:00:00'),
                                                                (7, 2, 5, 9.5, '2024-01-16 08:00:00');

-- Hiển thị tất cả các sinh viên có tên bắt đầu bằng ký tự ‘h’
SELECT *
FROM Student
WHERE StudentName LIKE 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12
SELECT *
FROM Class
WHERE MONTH(StartDate) = 12;

-- Hiển thị tất cả các môn học có credit trong khoảng từ 3 đến 5
SELECT *
FROM Subject
WHERE Credit BETWEEN 3 AND 5;

-- Thay đổi mã lớp (classId) của sinh viên có tên là “hung” là 2
UPDATE Student
SET ClassId = 2
WHERE StudentName = 'hung';

-- Hiển thị các thông tin: studentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT st.StudentName, su.SubName, m.Mark
FROM Student st
         JOIN Mark m ON st.StudentId = m.StudentId
         JOIN Subject su ON m.SubId = su.SubId
ORDER BY m.Mark DESC, st.StudentName ASC;

