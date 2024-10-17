CREATE DATABASE QuanLyBanHang;

USE QuanLyBanHang;

create table Customer(
                         cID int primary key auto_increment,
                         cName varchar(255) not null ,
                         cAge int
);

create table Product(
                        pID int primary key auto_increment,
                        pName varchar(255) not null ,
                        pPrice decimal(10,2) not null
);

create table `Order`(
                        oID int primary key auto_increment,
                        cID int,
                        oDate date not null,
                        oTotalPrice decimal(10,2),
                        foreign key (cID) references Customer(cID)
);

create table OrderDetail(
                            oID int,
                            pID int,
                            odQTY int not null,
                            primary key (oID, pID),
                            foreign key (oID) references `Order`(oID),
                            foreign key (pID) references Product(pID)
);