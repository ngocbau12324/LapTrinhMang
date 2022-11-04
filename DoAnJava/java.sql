-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2021 at 06:45 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `id_hoa_don` int(5) UNSIGNED NOT NULL,
  `id_san_pham` int(5) UNSIGNED NOT NULL,
  `so_luong` int(10) NOT NULL,
  `don_gia` int(10) NOT NULL,
  `thanh_tien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`id_hoa_don`, `id_san_pham`, `so_luong`, `don_gia`, `thanh_tien`) VALUES
(4, 5, 1, 39950000, 39950000),
(5, 1, 1, 4490000, 4490000),
(5, 1, 1, 4490000, 4490000),
(6, 8, 1, 9890000, 9890000),
(7, 4, 1, 3990000, 3990000),
(8, 6, 1, 29400000, 29400000),
(9, 6, 1, 29400000, 29400000),
(10, 8, 1, 9890000, 9890000),
(11, 4, 1, 3990000, 3990000),
(12, 6, 1, 29400000, 29400000),
(13, 6, 1, 29400000, 29400000),
(14, 8, 1, 9890000, 9890000),
(15, 4, 2, 3990000, 7980000),
(16, 6, 1, 29400000, 29400000),
(17, 6, 1, 29400000, 29400000),
(18, 6, 1, 29400000, 29400000),
(19, 8, 1, 9890000, 9890000),
(20, 7, 1, 8200000, 8200000),
(21, 8, 1, 9890000, 9890000),
(22, 7, 1, 8200000, 8200000),
(23, 7, 1, 8200000, 8200000),
(23, 1, 1, 4490000, 4490000),
(24, 8, 2, 9890000, 19780000),
(24, 7, 1, 8200000, 8200000),
(25, 5, 1, 39950000, 39950000),
(25, 6, 1, 29400000, 29400000),
(26, 8, 2, 9890000, 19780000),
(26, 1, 2, 4490000, 8980000),
(27, 7, 3, 8200000, 24600000),
(27, 4, 3, 3990000, 11970000),
(28, 7, 1, 8200000, 8200000),
(28, 4, 3, 3990000, 11970000),
(29, 8, 9, 9890000, 89010000),
(29, 7, 9, 8200000, 73800000),
(30, 7, 1, 8200000, 8200000),
(30, 5, 1, 39950000, 39950000),
(31, 7, 1, 8200000, 8200000),
(31, 5, 2, 39950000, 79900000),
(32, 2, 1, 14500000, 14500000),
(32, 4, 1, 3990000, 3990000),
(32, 7, 1, 8200000, 8200000),
(33, 7, 1, 8200000, 8200000);

-- --------------------------------------------------------

--
-- Table structure for table `chitietkhuyenmai`
--

CREATE TABLE `chitietkhuyenmai` (
  `id_ctkm` int(5) UNSIGNED NOT NULL,
  `id_san_pham` int(5) UNSIGNED NOT NULL,
  `pham_tram_km` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `id_phieu_nhap` int(5) UNSIGNED NOT NULL,
  `id_san_pham` int(5) UNSIGNED NOT NULL,
  `so_luong` int(10) NOT NULL,
  `don_gia` int(10) NOT NULL,
  `thanh_tien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chuongtrinhkhuyenmai`
--

CREATE TABLE `chuongtrinhkhuyenmai` (
  `id` int(5) UNSIGNED NOT NULL,
  `ten` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `phan_tram` int(2) NOT NULL,
  `ngay_bd` date NOT NULL,
  `ngay_kt` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chuongtrinhkhuyenmai`
--

INSERT INTO `chuongtrinhkhuyenmai` (`id`, `ten`, `phan_tram`, `ngay_bd`, `ngay_kt`) VALUES
(1, 'Quốc tế thiếu nhi(1/6)', 2, '2021-01-29', '2021-01-02'),
(2, 'SIEU SALE 5 THANG 5', 5, '2021-01-01', '2021-01-01'),
(3, 'SALE CUỐI THÁNG 5', 1, '2021-01-20', '2021-01-31'),
(4, 'ADGEGW222', 0, '2021-05-01', '2021-06-01');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `id` int(5) UNSIGNED NOT NULL,
  `id_nhan_vien` int(5) UNSIGNED DEFAULT NULL,
  `id_khuyen_mai` int(5) UNSIGNED DEFAULT NULL,
  `ngay_xuat` timestamp NOT NULL DEFAULT current_timestamp(),
  `id_khach_hang` int(5) UNSIGNED DEFAULT NULL,
  `tong_giam_gia` int(10) NOT NULL,
  `tong_tien_con_lai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`id`, `id_nhan_vien`, `id_khuyen_mai`, `ngay_xuat`, `id_khach_hang`, `tong_giam_gia`, `tong_tien_con_lai`) VALUES
(1, 1, 1, '2021-05-17 17:00:00', 2, 0, 39950000),
(2, 1, 1, '2021-05-17 17:00:00', 2, 0, 9890000),
(3, 1, 1, '2021-05-18 10:44:04', 2, 0, 14900000),
(4, 1, 1, '2021-05-18 10:54:12', 2, 0, 39950000),
(5, 1, 1, '2021-05-18 10:55:13', 9, 0, 4490000),
(6, 1, 1, '2021-05-18 10:57:22', 6, 0, 26290000),
(7, 1, 1, '2021-05-18 11:00:16', 6, 0, 83890000),
(8, 1, 1, '2021-05-18 11:02:14', 2, 0, 29400000),
(9, 1, 1, '2021-05-18 11:03:46', 2, 0, 29400000),
(10, 1, 1, '2021-05-18 11:04:50', 2, 0, 9890000),
(11, 1, 1, '2021-05-18 11:08:43', 2, 0, 20390000),
(12, 1, 1, '2021-05-18 11:13:07', 2, 0, 29400000),
(13, 1, 1, '2021-05-18 11:14:14', 2, 0, 29400000),
(14, 1, 1, '2021-05-18 11:14:33', 2, 0, 13880000),
(15, 1, 1, '2021-05-18 11:15:51', 2, 0, 16180000),
(16, 1, 1, '2021-05-18 11:20:10', 2, 0, 44300000),
(17, 1, 1, '2021-05-18 11:21:37', 2, 0, 29400000),
(18, 1, 1, '2021-05-18 11:22:08', 2, 0, 33390000),
(19, 1, 1, '2021-05-18 11:23:39', 2, 0, 39290000),
(20, 1, 1, '2021-05-18 11:26:11', 2, 0, 37600000),
(21, 1, 1, '2021-05-18 11:43:48', 2, 0, 18090000),
(22, 1, 1, '2021-05-18 11:44:22', 3, 0, 48150000),
(23, 1, 1, '2021-05-18 11:49:38', 2, 0, 12690000),
(24, 1, 1, '2021-05-18 11:50:28', 2, 0, 27980000),
(25, 1, 1, '2021-05-18 11:52:58', 2, 0, 69350000),
(26, 1, 1, '2021-05-18 11:53:48', 2, 0, 28760000),
(27, 1, 1, '2021-05-18 11:55:32', 2, 0, 36570000),
(28, 2, 1, '2021-05-18 17:26:08', 6, 0, 20170000),
(29, 2, 1, '2021-05-18 17:27:31', 2, 0, 162810000),
(30, 1, 1, '2021-05-18 18:39:12', 2, 2, 48150000),
(31, 1, 1, '2021-05-18 18:45:36', 2, 1762000, 86338000),
(32, 1, 1, '2021-05-18 18:48:04', 2, 533800, 26156200),
(33, 1, 2, '2021-05-18 19:04:43', 2, 410000, 7790000);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `id` int(5) UNSIGNED NOT NULL,
  `ho` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_sinh` date NOT NULL,
  `dia_chi` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(191) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`id`, `ho`, `ten`, `ngay_sinh`, `dia_chi`, `phone`, `email`) VALUES
(2, 'Bùi', 'Tấn Âu', '2001-03-08', 'Quận 12', '0785456222', 'aubui@gmail.com'),
(3, 'Nguyễn', 'Cường', '2001-04-03', 'Quận 8', '0981239010', 'cuongpro@gmail.com'),
(4, 'Nguyễn', 'Anh', '2003-12-03', 'Quận 9', '0949333939', 'anhtran@gmail.com'),
(5, 'Nguyễn', 'Văn Chương', '1999-02-20', 'Bình Dương', '0234325352', 'chuongvan@gmail.com'),
(6, 'Nguyễn', 'Ngọc Báu', '2001-01-30', 'Quận 8', '0969295720', 'ngocbau2051tqk@gmail.com'),
(7, 'Nguyễn', 'Minh Tâm', '2003-01-04', 'Quận 2', '0912905380', 'tamnguyen@gmail.com'),
(8, 'Trần', 'Bảo', '1998-05-03', 'Đồng Nai', '0932877290', 'baotran@gmail.com'),
(9, 'Phạm', 'Nga', '2000-06-03', 'Bình Dương', '0981899231', 'phamnga@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `id` int(11) UNSIGNED NOT NULL,
  `ten_nha_cc` varchar(191) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`id`, `ten_nha_cc`) VALUES
(1, 'Casper'),
(2, 'Samsung'),
(3, 'LG'),
(4, 'Sony'),
(5, 'TCL'),
(6, 'Mobell'),
(7, 'Asanzo'),
(8, 'FFALCON'),
(9, 'Nagakawa'),
(10, 'Akito'),
(11, 'Inverter'),
(12, 'Gree'),
(13, 'Kangaroo');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `id` int(5) UNSIGNED NOT NULL,
  `ho` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `gioi_tinh` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_sinh` date NOT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `dia_chi` varchar(191) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`id`, `ho`, `ten`, `gioi_tinh`, `ngay_sinh`, `phone`, `dia_chi`) VALUES
(1, 'Văn', 'Thành', 'Nữ', '2000-01-02', '0932898324', 'Bình Dương'),
(2, 'Văn', 'Thành', 'Nữ', '2000-01-02', '0932898324', 'Bình Dương'),
(3, 'Văn', 'Thành', 'Nữ', '2000-01-02', '0932898324', 'Bình Dương');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `id` int(5) UNSIGNED NOT NULL,
  `id_nhan_vien` int(5) UNSIGNED NOT NULL,
  `id_nha_cc` int(5) UNSIGNED NOT NULL,
  `tong_tien` int(11) NOT NULL,
  `ngay_nhap` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(5) UNSIGNED NOT NULL,
  `ten_san_pham` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `don_gia` int(9) NOT NULL,
  `so_luong` int(3) NOT NULL,
  `bao_hanh` int(1) NOT NULL,
  `id_the_loai` int(5) UNSIGNED NOT NULL,
  `id_nha_cc` int(5) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `ten_san_pham`, `don_gia`, `so_luong`, `bao_hanh`, `id_the_loai`, `id_nha_cc`) VALUES
(1, 'Casper Smart TV 32HX6200', 4490000, 50, 3, 2, 1),
(2, 'Smart Tivi QLED Samsung 4K 55 inch QA55Q60T', 14500000, 50, 1, 2, 2),
(3, 'Sony Android TV 43X8500H', 14900000, 50, 1, 2, 4),
(4, 'Smart Tivi FFalcon 32 inch 32SF1', 3990000, 50, 1, 2, 8),
(5, 'Samsung Smart TV QLED QA75Q60T', 39950000, 50, 1, 2, 2),
(6, 'LG Smart TV NanoCell 75NANO79TND', 29400000, 50, 1, 2, 3),
(7, 'Máy lạnh Midea Inverter 1.5 HP MSAFA-13CRDN8', 8200000, 50, 1, 8, 11),
(8, 'Máy lạnh Akito Inverter 1.5 HP AIC-12ST', 9890000, 50, 1, 8, 10),
(10, 'BAUS', 980000, 50, 1, 7, 10);

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

CREATE TABLE `theloai` (
  `id` int(10) UNSIGNED NOT NULL,
  `ten_the_loai` varchar(191) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`id`, `ten_the_loai`) VALUES
(1, 'Máy Giặt'),
(2, 'TiVi'),
(3, 'Tủ Lạnh'),
(4, 'Âm Thanh'),
(5, 'Máy Quạt'),
(6, 'Máy Lọc Nước'),
(7, 'Đèn Điện'),
(8, 'Máy Lạnh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD KEY `id_hoa_don` (`id_hoa_don`),
  ADD KEY `id_san_pham` (`id_san_pham`);

--
-- Indexes for table `chitietkhuyenmai`
--
ALTER TABLE `chitietkhuyenmai`
  ADD KEY `id_ctkm` (`id_ctkm`),
  ADD KEY `chitietkhuyenmai_ibfk_2` (`id_san_pham`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD KEY `id_phieu_nhap` (`id_phieu_nhap`),
  ADD KEY `id_san_pham` (`id_san_pham`);

--
-- Indexes for table `chuongtrinhkhuyenmai`
--
ALTER TABLE `chuongtrinhkhuyenmai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_khach_hang` (`id_khach_hang`),
  ADD KEY `id_khuyen_mai` (`id_khuyen_mai`),
  ADD KEY `id_nhan_vien` (`id_nhan_vien`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_nhan_vien` (`id_nhan_vien`),
  ADD KEY `id_nha_cc` (`id_nha_cc`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_the_loai` (`id_the_loai`),
  ADD KEY `id_nha_cc` (`id_nha_cc`);

--
-- Indexes for table `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chuongtrinhkhuyenmai`
--
ALTER TABLE `chuongtrinhkhuyenmai`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `theloai`
--
ALTER TABLE `theloai`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`id_hoa_don`) REFERENCES `hoadon` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`id_san_pham`) REFERENCES `sanpham` (`id`);

--
-- Constraints for table `chitietkhuyenmai`
--
ALTER TABLE `chitietkhuyenmai`
  ADD CONSTRAINT `chitietkhuyenmai_ibfk_1` FOREIGN KEY (`id_ctkm`) REFERENCES `chuongtrinhkhuyenmai` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietkhuyenmai_ibfk_2` FOREIGN KEY (`id_san_pham`) REFERENCES `sanpham` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`id_phieu_nhap`) REFERENCES `phieunhap` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`id_san_pham`) REFERENCES `sanpham` (`id`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`id_khach_hang`) REFERENCES `khachhang` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`id_khuyen_mai`) REFERENCES `chuongtrinhkhuyenmai` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`id_nhan_vien`) REFERENCES `nhanvien` (`id`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`id_nhan_vien`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`id_nha_cc`) REFERENCES `nhacungcap` (`id`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`id_the_loai`) REFERENCES `theloai` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sanpham_ibfk_2` FOREIGN KEY (`id_nha_cc`) REFERENCES `nhacungcap` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
