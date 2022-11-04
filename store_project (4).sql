-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 11, 2021 lúc 06:05 PM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `store_project`
--

DELIMITER $$
--
-- Thủ tục
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertAccount` (IN `USERNAME` VARCHAR(50), IN `PASSWORD` VARCHAR(50))  BEGIN
	INSERT INTO users VALUES (USERNAME, PASSWORD);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `PASSWORD` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `PERMISSION` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`ID`, `USERNAME`, `PASSWORD`, `PERMISSION`) VALUES
(0, 'adminlachalame', 'admin123', 'admin'),
(1, 'nhanvien1', 'nhanvien123', 'Nhân viên'),
(2, 'nhanvien2', 'nhanvien12', 'Nhân viên'),
(3, 'fuckboiz123', '15122000', 'Khách hàng'),
(4, 'khachhang', 'khachhang1', 'Khách hàng'),
(5, 'khachhang2', '12345678', 'Khách hàng'),
(6, 'vinh1234', 'vinh123456', 'Nhân viên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `BILL_DATE` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `AMOUNT` int(11) DEFAULT NULL,
  `TOTAL` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`BILL_DATE`, `AMOUNT`, `TOTAL`) VALUES
('09/05/2021', 7, 139000000),
('10/05/2021', 18, 300000000),
('11/05/2021', 4, 90000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill_details`
--

CREATE TABLE `bill_details` (
  `BILL_DATE` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `BILL_DETAILS_CODE` int(11) NOT NULL,
  `CUSTOMER_CODE` int(50) DEFAULT NULL,
  `PRODUCT_CODE` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `EMPLOYEE_CODE` int(50) DEFAULT NULL,
  `AMOUNT` int(11) DEFAULT NULL,
  `PRICE` int(11) DEFAULT NULL,
  `TOTAL` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `bill_details`
--

INSERT INTO `bill_details` (`BILL_DATE`, `BILL_DETAILS_CODE`, `CUSTOMER_CODE`, `PRODUCT_CODE`, `EMPLOYEE_CODE`, `AMOUNT`, `PRICE`, `TOTAL`) VALUES
('09/05/2021', 1, 1, '1', 1, 1, 4000000, 4000000),
('09/05/2021', 2, 1, '10', 1, 1, 30000000, 30000000),
('09/05/2021', 3, 1, '1', 1, 3, 15000000, 45000000),
('10/05/2021', 1, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 2, 1, '12', 1, 1, 30000000, 30000000),
('10/05/2021', 3, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 4, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 5, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 6, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 7, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 8, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 9, 1, '1', 1, 1, 15000000, 15000000),
('09/05/2021', 4, 1, '10', 1, 1, 30000000, 30000000),
('09/05/2021', 5, 1, '10', 0, 1, 30000000, 30000000),
('10/05/2021', 10, 3, '10', 3, 1, 30000000, 30000000),
('10/05/2021', 11, 1, '1', 0, 1, 15000000, 15000000),
('10/05/2021', 12, 3, '1', 0, 1, 15000000, 15000000),
('10/05/2021', 13, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 14, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 15, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 16, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 17, 1, '1', 1, 1, 15000000, 15000000),
('10/05/2021', 18, 1, '1', 1, 1, 15000000, 15000000),
('11/05/2021', 1, 3, '1', 0, 2, 15000000, 30000000),
('11/05/2021', 2, 3, '10', 0, 1, 30000000, 30000000),
('11/05/2021', 3, 1, '10', 3, 1, 30000000, 30000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `CART_CODE` int(11) NOT NULL,
  `USER_CODE` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `PRODUCT_CODE` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `PRODUCT_NAME` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `AMOUNT` int(11) DEFAULT NULL,
  `PRICE` int(11) DEFAULT NULL,
  `TOTAL` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `cart`
--

INSERT INTO `cart` (`CART_CODE`, `USER_CODE`, `PRODUCT_CODE`, `PRODUCT_NAME`, `AMOUNT`, `PRICE`, `TOTAL`) VALUES
(25, '2', '1', 'Iphone 11', 1, 15000000, 1335000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `ACCOUNT_ID` int(11) NOT NULL,
  `EMPLOYEE_CODE` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `EMPLOYEE_NAME` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `ADDRESS` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `NUMBER_PHONE` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `BIRTHDAY` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`ACCOUNT_ID`, `EMPLOYEE_CODE`, `EMPLOYEE_NAME`, `ADDRESS`, `NUMBER_PHONE`, `BIRTHDAY`) VALUES
(1, '1', 'Lê Cát', 'Thành phố Hồ Chí Minh', '0924714551', '15/12/2000'),
(2, '2', 'Huỳnh Lê Quốc Bảo', 'Thành phố Hồ Chí Minh', '099999', '01/01/2001'),
(6, '3', 'Nguyễn Phùng Vinh', 'Đồng Nai', '0924714552', '18/09/2001');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `enter_coupon`
--

CREATE TABLE `enter_coupon` (
  `COUPON_DATE` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `AMOUNT` int(11) NOT NULL,
  `TOTAL` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `enter_coupon`
--

INSERT INTO `enter_coupon` (`COUPON_DATE`, `AMOUNT`, `TOTAL`) VALUES
('09/05/2021', 1, 100),
('10/05/2021', 2, 20),
('11/05/2021', 2, 240);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `enter_coupon_details`
--

CREATE TABLE `enter_coupon_details` (
  `COUPON_DATE` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `COUPON_CODE_DETAILS` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `PRODUCT_CODE` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `SUPPLIER_CODE` int(11) DEFAULT NULL,
  `EMPLOYEE_CODE` int(11) DEFAULT NULL,
  `PRICE` int(11) DEFAULT NULL,
  `IMPORT_PRICE` int(11) DEFAULT NULL,
  `AMOUNT` int(11) DEFAULT NULL,
  `TOTAL` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `enter_coupon_details`
--

INSERT INTO `enter_coupon_details` (`COUPON_DATE`, `COUPON_CODE_DETAILS`, `PRODUCT_CODE`, `SUPPLIER_CODE`, `EMPLOYEE_CODE`, `PRICE`, `IMPORT_PRICE`, `AMOUNT`, `TOTAL`) VALUES
('09/05/2021', '1', '1', 2, 0, 190, 100, 1, 100),
('10/05/2021', '1', '1', 2, 0, 11, 10, 1, 10),
('10/05/2021', '2', '1', 2, 0, 11, 10, 1, 10),
('11/05/2021', '1', '1', 1, 0, 189, 120, 1, 120),
('11/05/2021', '2', '2', 1, 0, 237, 120, 1, 120);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `PRODUCT_CODE` varchar(255) NOT NULL,
  `PRODUCT_NAME` varchar(255) NOT NULL,
  `PRODUCER_NAME` varchar(255) NOT NULL,
  `SUPPLIER_NAME` varchar(255) NOT NULL,
  `AMOUNT` int(10) NOT NULL,
  `IMPORT_PRICE` int(10) NOT NULL,
  `PRICE` int(10) NOT NULL,
  `IMAGE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`PRODUCT_CODE`, `PRODUCT_NAME`, `PRODUCER_NAME`, `SUPPLIER_NAME`, `AMOUNT`, `IMPORT_PRICE`, `PRICE`, `IMAGE`) VALUES
('1', 'Iphone 11', 'Iphone', 'Iphone', 98, 10000000, 15000000, 'Image\\\\Product\\\\iphone11.png'),
('10', 'Oppo Reno 4', 'Oppo', 'Oppo', 198, 10000000, 30000000, 'Image\\\\Product\\\\oppo4.png'),
('11', 'Oppo Reno 5', 'Oppo', 'Oppo', 200, 10000000, 30000000, 'Image\\\\Product\\\\oppo5.png'),
('12', 'Vivo 5', 'Vivo', 'Vivo', 200, 10000000, 30000000, 'Image\\\\Product\\\\vivo5.png'),
('13', 'Vivo 21', 'Vivo', 'Vivo', 200, 10000000, 30000000, 'Image\\\\Product\\\\vivo21.png'),
('14', 'Xiaomi 11', 'Xiaomi', 'Xiaomi', 200, 10000000, 30000000, 'Image\\\\Product\\\\xiaomi11.png'),
('15', 'Xiaomi 9T', 'Xiaomi', 'Xiaomi', 200, 10000000, 30000000, 'Image\\\\Product\\\\xiaomi9T.png'),
('2', 'Iphone 11 Pro Max', 'Iphone', 'Iphone', 50, 8000000, 20000000, 'Image\\\\Product\\\\iphone11promax.png'),
('3', 'Iphone 12', 'Iphone', 'Iphone', 100, 10000000, 30000000, 'Image\\\\Product\\\\iphone12.png'),
('4', 'Iphone 12 Pro Max', 'Iphone', 'Iphone', 500, 10000000, 50000000, 'Image\\\\Product\\\\iphone12promax.png'),
('5', 'Samsung Galaxy A32s', 'Samsung', 'Samsung', 200, 10000000, 15000000, 'Image\\\\Product\\\\samsunggalaxya32s.png'),
('6', 'Xiaomi 12', 'Xiaomi', 'Xiaomi', 200, 5000000, 7000000, 'Image\\\\Product\\\\xiaomi12.png'),
('7', 'Samsung Galaxy Ford Z', 'Xiaomi', 'Samsung', 200, 10000000, 30000000, 'Image\\\\Product\\\\samsungZ.png'),
('8', 'Samsung Galaxy Note 21s', 'Samsung', 'Samsung', 200, 10000000, 30000000, 'Image\\\\Product\\\\samsung21.png'),
('9', 'Samsung Galaxy S20', 'Samsung', 'Xiaomi', 200, 10000000, 30000000, 'D:\\Users\\ASUS\\eclipse-workspace\\App bán hàng\\Image\\Product\\samsungnote20.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
--

CREATE TABLE `supplier` (
  `SUPPLIER_CODE` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `SUPPLIER_NAME` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `ADDRESS` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `NUMBER_PHONE` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`SUPPLIER_CODE`, `SUPPLIER_NAME`, `ADDRESS`, `NUMBER_PHONE`) VALUES
('1', 'Xiaomi', 'China', '0924714551'),
('2', 'Iphone', 'America', '099999'),
('3', 'Samsung', 'America', '0912987563'),
('4', 'Vivo', 'China', '0902323342'),
('5', 'Oppo', 'China', '0902323342'),
('6', 'Realme', 'China', '0902323342');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `ACCOUNT_ID` int(11) NOT NULL,
  `USER_CODE` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `USER_NAME` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `USER_NUMBERPHONE` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `USER_ADDRESS` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`ACCOUNT_ID`, `USER_CODE`, `USER_NAME`, `USER_NUMBERPHONE`, `USER_ADDRESS`) VALUES
(3, '1', 'Đạo đẹp trai', '09093925', 'Bình Thạnh'),
(4, '2', 'Bảo fuck boiz', '09324324', 'Quận 11'),
(5, '3', 'Cát fuckboizz', '0924714551', 'Quận 7');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`BILL_DATE`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`CART_CODE`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EMPLOYEE_CODE`);

--
-- Chỉ mục cho bảng `enter_coupon`
--
ALTER TABLE `enter_coupon`
  ADD PRIMARY KEY (`COUPON_DATE`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`PRODUCT_CODE`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SUPPLIER_CODE`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`USER_CODE`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `CART_CODE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
