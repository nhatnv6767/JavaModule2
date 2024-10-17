create database ex3;
use ex3;

CREATE TABLE Class (
                       classId INT PRIMARY KEY,
                       className VARCHAR(255),
                       startDate DATE,
                       status BIT
);

CREATE TABLE Student (
                         studentId INT PRIMARY KEY,
                         studentName VARCHAR(255),
                         address VARCHAR(255),
                         phone VARCHAR(20),
                         status BIT,
                         classId INT,
                         FOREIGN KEY (classId) REFERENCES Class(classId)
);

CREATE TABLE Subject (
                         subId INT PRIMARY KEY,
                         subName VARCHAR(255),
                         credit INT,
                         status BIT
);

CREATE TABLE Mark (
                      markId INT PRIMARY KEY,
                      subId INT,
                      studentId INT,
                      mark FLOAT,
                      examTime DATETIME,
                      FOREIGN KEY (subId) REFERENCES Subject(subId),
                      FOREIGN KEY (studentId) REFERENCES Student(studentId)
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

-- Hiển thị tất cả các thông tin môn học (bảng Subject) có credit lớn nhất
select *
from Subject
where credit = (SELECT MAX(credit) FROM Subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất
select *
from Subject s
         join Mark m on s.subId = m.subId
where m.mark = (select max(mark) from Mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select st.studentId, st.studentName, AVG(m.mark) as avgMark
from Student st
         join Mark m on st.studentId = m.studentId
group by st.studentId, st.studentName
order by avgMark desc ;



