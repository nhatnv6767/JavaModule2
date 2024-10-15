create database QuanLyKho;

use QuanLyKho;

create table VatTu(
                      maVT int primary key auto_increment,
                      tenVT varchar(255)
);

create table PhieuXuat(
                          soPX int primary key auto_increment,
                          ngayXuat date
);

create table PhieuNhap(
                          soPN int primary key auto_increment,
                          ngayNhap date
);

create table NhaCungCap(
                           maNCC int primary key auto_increment,
                           tenNCC varchar(255),
                           DiaChi text,
                           SoDienThoai varchar(20)
);

create table DonDatHang(
                           soDH int primary key auto_increment,
                           ngayDH date,
                           maNCC int,
                           foreign key (maNCC) references NhaCungCap(maNCC)
);

create table ChiTietDonDatHang(
                                  maVT int,
                                  soDH int,
                                  primary key (maVT, soDH),
                                  foreign key (maVT) references VatTu(maVT),
                                  foreign key (soDH) references DonDatHang(soDH)
);

create table PhieuXuatChiTiet(
                                 soPX int,
                                 maVT int,
                                 DonGiaXuat DECIMAL(10,2),
                                 SoLuongXuat int,
                                 primary key (soPX, maVT),
                                 foreign key (soPX) references PhieuXuat(soPX),
                                 foreign key (maVT) references VatTu(maVT)
);

create table PhieuNhapChiTiet(
                                 soPN int,
                                 maVT int,
                                 DonGiaNhap DECIMAL(10,2),
                                 SoLuongNhap int,
                                 primary key (soPN, maVT),
                                 foreign key (soPN) references PhieuNhap(soPN),
                                 foreign key (maVT) references VatTu(maVT)
);