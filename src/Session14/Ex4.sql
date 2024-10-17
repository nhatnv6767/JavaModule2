use QuanLyKho;

INSERT INTO VatTu(tenVT) VALUES
                             ('CPU Intel Core i5'),
                             ('RAM DDR4 8GB'),
                             ('Ổ cứng SSD 500GB'),
                             ('Màn hình LCD 24 inch'),
                             ('Chuột không dây'),
                             ('Bàn phím cơ');

INSERT INTO PhieuXuat(ngayXuat) VALUES
                                    ('2024-01-15'),
                                    ('2024-02-10'),
                                    ('2024-02-25'),
                                    ('2024-03-10');


INSERT INTO PhieuNhap(ngayNhap) VALUES
                                    ('2024-01-10'),
                                    ('2024-02-05'),
                                    ('2024-03-01');

INSERT INTO NhaCungCap(tenNCC, DiaChi, SoDienThoai) VALUES
                                                        ('Công ty A', 'Hà Nội', '0123456789'),
                                                        ('Công ty B', 'Hồ Chí Minh', '0987654321'),
                                                        ('Công ty C', 'Đà Nẵng', '0123456788');


INSERT INTO DonDatHang(ngayDH, maNCC) VALUES
                                          ('2024-01-05', 1),
                                          ('2024-02-12', 2),
                                          ('2024-02-18', 1),
                                          ('2024-03-05', 3);


INSERT INTO ChiTietDonDatHang(maVT, soDH) VALUES
                                              (1, 1),
                                              (2, 1),
                                              (3, 2),
                                              (1, 3),
                                              (4, 3),
                                              (5, 4),
                                              (6, 4);

INSERT INTO PhieuXuatChiTiet(soPX, maVT, DonGiaXuat, SoLuongXuat) VALUES
                                                                      (1, 1, 5000000, 10),
                                                                      (1, 2, 1000000, 20),
                                                                      (2, 3, 2000000, 15),
                                                                      (3, 1, 5200000, 5),
                                                                      (3, 4, 3000000, 10);


INSERT INTO PhieuNhapChiTiet(soPN, maVT, DonGiaNhap, SoLuongNhap) VALUES
                                                                      (1, 1, 4500000, 15),
                                                                      (1, 2, 900000, 30),
                                                                      (2, 3, 1800000, 20),
                                                                      (3, 4, 2800000, 15);


-- Tìm danh sách vật tư bán chạy nhất

select vt.tenVT, SUM(pxct.SoLuongXuat) as TongSoLuongXuat
from VatTu vt
         join PhieuXuatChiTiet pxct on vt.maVT = pxct.maVT
group by vt.tenVT
order by TongSoLuongXuat DESC limit 1;

-- Tìm danh sách vật tư có trong kho nhiều nhất
select vt.tenVT, (sum(pnct.SoLuongNhap) - sum(pxct.SoLuongXuat)) as SoLuongTon
from VatTu vt
         left join PhieuNhapChiTiet pnct on vt.maVT = pnct.maVT
         left join PhieuXuatChiTiet pxct on vt.maVT = pxct.maVT
group by vt.tenVT
order by SoLuongTon DESC
    limit 1;

-- Tìm ra danh sách nhà cung cấp có đơn hàng từ ngày 12/2/2024 đến 22/2/2024
select ncc.tenNCC, ddh.ngayDH
from NhaCungCap ncc
         join DonDatHang ddh on ncc.maNCC = ddh.maNCC
where ddh.ngayDH between "2024-02-12" and "2024-02-22";

-- Tìm ra danh sách vật tư được mua ở nhà cung cấp từ ngày 11/1/2024 đến 22/2/2024

select vt.tenVT, ddh.ngayDH
from VatTu vt
         join ChiTietDonDatHang ctddh on vt.maVT = ctddh.maVT
         join DonDatHang ddh on ctddh.soDH = ddh.soDH
where ddh.ngayDH between "2024-01-11" and "2024-02-22";
