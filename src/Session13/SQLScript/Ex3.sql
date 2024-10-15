create database ShoppingManagement;
USE ShoppingManagement;

create table Customer(
                         cID int primary key auto_increment,
                         cName varchar(25),
                         cAge tinyint
);

create table Products(
                         pID int primary key auto_increment,
                         pName varchar(25),
                         pPrice int
);

create table Orders(
                       oID int primary key auto_increment,
                       cID int,
                       oDate DATETIME,
                       oTotalPrice int,
                       foreign key (cID) references Customer(cID)
);

create table OrderDetail(
                            oID int,
                            pID int,
                            odQTY int,
                            primary key (oID, pID),
                            foreign key (oID) references Orders(oID),
                            foreign key (pID) references Products(pID)
);

INSERT INTO Customer(cName, cAge) VALUES ("Minh Quan", 10), ("Ngoc Anh", 20), ("Hong Ha", 50);

INSERT INTO Products ( pName, pPrice) VALUES
                                          ('May Giat', 3),
                                          ('Tu Lanh', 5),
                                          ('Dieu Hoa', 7),
                                          ('Quat', 1),
                                          ('Bep Dien', 2);

INSERT INTO Orders ( cID, oDate, oTotalPrice) VALUES
                                                  ( 1, '2006-03-21', NULL),
                                                  ( 2, '2006-03-23', NULL),
                                                  ( 1, '2006-03-16', NULL);

INSERT INTO OrderDetail (oID, pID, odQTY) VALUES
                                              (1, 1, 3),
                                              (1, 3, 7),
                                              (1, 4, 2),
                                              (2, 1, 1),
                                              (3, 1, 8),
                                              (2, 5, 4),
                                              (2, 3, 3);