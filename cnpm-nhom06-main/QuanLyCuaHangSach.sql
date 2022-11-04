DROP DATABASE IF EXISTS `qlda`;
CREATE DATABASE `qlda`;
use `qlda`;
-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 14, 2019 lúc 05:07 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlda`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `username` varchar(50) NOT NULL,
  `pw` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`username`, `pw`) VALUES /*OK*/
('admin', 'admin');



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (/*OK*/
  `mahd` varchar(20) NOT NULL,
  `masp` varchar(20) NOT NULL,
  `dongia` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `thanhtien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`mahd`, `masp`, `dongia`, `soluong`, `thanhtien`) VALUES /*OK*/
('PN001', 'SP001', 55300, 1, 55300),/*OK*/
('PN001', 'SP002', 15900, 7, 111300),/*OK*/
('PN002', 'SP001', 55300, 6, 331800),/*OK*/
('PN002', 'SP002', 15900, 5, 79500),/*OK*/
('PN002', 'SP003', 931414, 2, 1862828),/*OK*/
('PN003', 'SP001', 55300, 10, 5530000),/*OK*/
('PN003', 'SP002', 15900, 105, 1669500),/*OK*/
('PN003', 'SP004', 76000, 20, 1520000),/*OK*/
('PN003', 'SP005', 79200, 20, 1584000),/*OK*/
('PN003', 'SP007', 55200, 20, 1104000),/*OK*/
('PN004', 'SP002', 15900, 20, 318000),/*OK*/
('PN004', 'SP004', 76000, 14, 1064000),/*OK*/
('PN004', 'SP006', 59000, 12, 708000),/*OK*/
('PN004', 'SP007', 55200, 78, 4305600);/*OK*/

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (/*OK*/
  `mahd` varchar(20) NOT NULL,
  `masp` varchar(20) NOT NULL,
  `dongia` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `maKhuyenmai` varchar(20) DEFAULT NULL,
  `thanhtien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`mahd`, `masp`, `dongia`, `soluong`, `maKhuyenmai`, `thanhtien`) VALUES
('HD001', 'SP001', 55300, 12, 'KM001', 464520),/*OK*/
('HD001', 'SP002', 15900, 12, 'KM001', 171720),/*OK*/
('HD001', 'SP003', 931414, 2, 'KM001', 931414),/*OK*/
('HD002', 'SP008', 64000, 10, 'KM004', 288000),/*OK*/
('HD003', 'SP009', 118000, 1, 'KM004', 94400);/*OK*/

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `mahd` varchar(20) NOT NULL,
  `manv` varchar(20) DEFAULT NULL,
  `mancc` varchar(20) DEFAULT NULL,
  `ngaynhap` varchar(10) DEFAULT NULL,
  `tongchi` int(11) DEFAULT NULL,
  `ghichu` varchar(100) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`mahd`, `manv`, `mancc`, `ngaynhap`, `tongchi`, `ghichu`) VALUES
('PN001', 'NV004', 'NXB001', '25/11/2021', 166600, ''),
('PN002', 'NV002', 'NXB003', '14/03/2021', 2274128, ''),
('PN003', 'NV004', 'NXB004', '25/11/2021', 11407500, ''),
('PN004', 'NV019', 'NXB006', '26/08/2021', 6395600, '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `mahd` varchar(20) NOT NULL,
  `manv` varchar(20) DEFAULT NULL,
  `makh` varchar(20) DEFAULT NULL,
  `ngayxuat` varchar(20) DEFAULT NULL,
  `tongchi` int(11) DEFAULT NULL,
  `ghichu` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`mahd`, `manv`, `makh`, `ngayxuat`, `tongchi`, `ghichu`) VALUES
('HD001', 'NV001', '0', '01/11/2021', 1567654, ''),
('HD002', 'NV001', '2', '06/11/2021', 288000, ''),
('HD003', 'NV001', '2', '06/11/2021', 94400, '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (/*OK*/
  `idkhachhang` int(11) NOT NULL,
  `tenkhachhang` varchar(50) CHARACTER SET utf8 NOT NULL,
  `gioitinh` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sdt` varchar(11) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`idkhachhang`, `tenkhachhang`, `gioitinh`, `diachi`, `sdt`) VALUES/*OK*/
(0, 'Hiệu sách Nhã Nam', 'Nam', '59 Đỗ Quang', '0903244248'),
(1, 'Nguyễn Quang', 'Nam', '27 Trần Phú', '02345671'),
(2, 'Nguyễn Thị Bình', 'Nữ', '29 Trần Phụ', '0945678'),
(3, 'Phạm Anh Tuấn', 'Nam', '99 An Dương Vương', '012345678'),
(4, 'Lê Phước', 'Nam', '28 An Dương Vương', '012345667'),
(5, 'Lê Bảo', 'Nam', '28 Nguyễn Chí Thanh', '012345688');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (/*OK*/
  `ma` varchar(20) NOT NULL,
  `ngaybd` varchar(20) DEFAULT NULL,
  `ngaykt` varchar(20) DEFAULT NULL,
  `mota` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`ma`, `ngaybd`, `ngaykt`, `mota`) VALUES/*OK*/
('KM001', '01/11/2021', '31/1/2022', 'Khuyến mãi xả hàng'),/*OK*/
('KM002', '05/11/2021', '31/1/2022', 'Giảm giá Tết'),/*OK*/
('KM003', '06/11/2021', '31/1/2022', 'Giảm giá nhân ngày giáng sinh'),/*OK*/
('KM004', '06/11/2021', '31/1/2022', 'Giảm giá cuối năm');/*OK*/

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (/*OK*/
  `ma` varchar(20) NOT NULL,
  `ten` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` varchar(20) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`ma`, `ten`, `diachi`) VALUES/*OK*/
('NXB001', 'NXB Kim Đồng', 'Hà Nội'),/*OK*/
('NXB002', 'NXB Tổng Hợp TPHCM', 'TP.HCM'),/*OK*/
('NXB003', 'NXB Chính trị quốc gia sự thật', 'TP.HCM'),/*OK*/
('NXB004', 'NXB Văn Học', 'Hà Nội'),/*OK*/
('NXB005', 'NXB Hà Nội', 'Hà Nội'),/*OK*/
('NXB006', 'NXB Trẻ', 'TP.HCM'),/*OK*/
('NXB007', 'NXB Hội Nhà Văn', 'TP.HCM');/*OK*/

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (/*OK*/
  `ma` varchar(20) CHARACTER SET utf8 NOT NULL,
  `ho` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `ten` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `ca` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `ngaysinh` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `gioitinh` tinyint(4) DEFAULT NULL,
  `luong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`ma`, `ho`, `ten`, `ca`, `ngaysinh`, `gioitinh`, `luong`) VALUES/*OK*/
('NV001', 'Bùi Thị', 'Xuân', 'Tối Thứ 6', '29/06/2001', 0, 1000000),/*OK*/
('NV002', 'Nguyễn Hải', 'Minh', 'Tối Thứ 2', '22/09/2001', 0, 90000),/*OK*/
('NV003', 'Lê Tấn', 'Đạt', 'Tối Thứ 3', '10/07/2001', 1, 1200000),/*OK*/
('NV004', 'Trương Minh', 'Hải', 'Sáng Chủ nhật', '26/01/2001', 0, 950000),/*OK*/
('NV005', 'Phạm Anh', 'Tuấn', 'Tối Thứ 4', '08/11/2000', 1, 850000),/*OK*/
('NV006', 'Võ Ngọc Thanh', 'Thảo', 'Chiều Thứ 2', '30/01/2001', 0, 1500000),/*OK*/
('NV007', 'Vũ Ngọc Thanh', 'Thanh', 'Chiều Thứ 2', '01/01/2001', 0, 1700000),/*OK*/
('NV008', 'Lê Bảo', 'Lâm', 'Sáng Thứ 7', '04/04/2001', 1, 1600000),/*OK*/
('NV009', 'Lê Gia', 'Bảo', 'Sáng Thứ 7', '27/10/2001', 1, 1350000),/*OK*/
('NV010', 'Trần Sang', 'Hiết', 'Chiều Thứ 2', '27/10/2001', 1, 1850000),/*OK*/
('NV011', 'Nguyễn', 'An', 'Chiều Thứ 4', '14/11/2001', 1, 1750000);/*OK*/

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `ma` varchar(20) NOT NULL,
  `loai` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ten` varchar(70) CHARACTER SET utf8 DEFAULT NULL,
  `dongia` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `ghichu` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`ma`, `loai`, `ten`, `dongia`, `soluong`, `ghichu`) VALUES
('SP001', 'Văn học Việt Nam', 'Việt Bắc', 55300, 100, NULL),
('SP002', 'Văn học nước ngoài', 'Người kép già', 15900, 320, NULL),
('SP003', 'Sách Văn hóa xã hội – Lịch sử - Tôn giáo', 'Ho Chi Minh on Revolution: Selected Writings, 1920-66 by Ho Chi Minh', 931414, 40, NULL),
('SP004', 'Sách Giáo trình', 'Thanh Toán Quốc Tế', 76000, 109, NULL),
('SP005', 'Sách học ngoại ngữ', 'Cách Học 10 Ngoại Ngữ Nhanh Nhất', 79200, 443, NULL),
('SP006', 'Tâm lý - Kĩ năng sống', 'Đắc nhân tâm', 59000, 132, ' '),
('SP007', 'Văn học nước ngoài', 'Nhà giả kim', 55200, 132, ' '),
('SP008', 'Sách thiếu nhi', 'Tôi là Bê Tô', 64000, 132, ' '),
('SP009', 'Tiểu sử - Hồi ký', 'Nhắm mắt nhìn sao', 118000, 343, '  ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtinkhuyenmai`
--

CREATE TABLE `thongtinkhuyenmai` (
  `makm` varchar(20) NOT NULL,
  `masp` varchar(20) NOT NULL,
  `giamgia` varchar(20) DEFAULT NULL,
  `qua` varchar(70) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `thongtinkhuyenmai`
--

INSERT INTO `thongtinkhuyenmai` (`makm`, `masp`, `giamgia`, `qua`) VALUES/*OK*/
('KM001', 'SP001', '30', 'Việt Bắc'),/*OK*/
('KM001', 'SP002', '10', 'Người kép già'),/*OK*/
('KM002', 'SP003', '50', 'Ho Chi Minh on Revolution: Selected Writings, 1920-66 by Ho Chi Minh'),/*OK*/
('KM002', 'SP004', '55', 'Thanh Toán Quốc Tế'),/*OK*/
('KM003', 'SP005', '45', 'Cách Học 10 Ngoại Ngữ Nhanh Nhất'),/*OK*/
('KM003', 'SP006', '34', 'Đắc nhân tâm'),/*OK*/
('KM003', 'SP007', '55', 'Nhà giả kim'),/*OK*/
('KM004', 'SP008', '55', 'Tôi là Bê Tô'),/*OK*/
('KM004', 'SP009', '20', 'Nhắm mắt nhìn sao');/*OK*/

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);



--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`mahd`,`masp`);

--
-- Chỉ mục cho bảng `chitiethoadonxuat`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`mahd`,`masp`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`mahd`);

--
-- Chỉ mục cho bảng `hoadonxuat`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahd`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`ma`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`ma`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`ma`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`ma`);

--
-- Chỉ mục cho bảng `thongtinkhuyenmai`
--
ALTER TABLE `thongtinkhuyenmai`
  ADD PRIMARY KEY (`makm`,`masp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
