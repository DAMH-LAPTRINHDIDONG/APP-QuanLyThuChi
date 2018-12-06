-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 06, 2018 lúc 03:49 AM
-- Phiên bản máy phục vụ: 10.1.36-MariaDB
-- Phiên bản PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qltc`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaitaikhoan`
--

CREATE TABLE `loaitaikhoan` (
  `idloaitk` int(11) NOT NULL,
  `tentk` varchar(50) NOT NULL,
  `icon` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaitaikhoan`
--

INSERT INTO `loaitaikhoan` (`idloaitk`, `tentk`, `icon`) VALUES
(1, 'Tiền mặt', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/purse.png?alt=media&token=59fc0cd5-cc2d-42be-ad3d-e875dc066014'),
(2, 'Tài khoản ngân hàng', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/bankacc.png?alt=media&token=a14357cc-c74c-4b56-8fcf-b600f1a0937c'),
(3, 'Thẻ tín dụng', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/credit.png?alt=media&token=d1ff5cce-d5c7-4f4f-93a0-e29eab0a19df'),
(4, 'Khác', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/khac.png?alt=media&token=2d8f7cc5-6813-4ebb-b4a6-6554f5b9fa22');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mucchicha`
--

CREATE TABLE `mucchicha` (
  `idmucchicha` int(11) NOT NULL,
  `tenmucchicha` varchar(50) NOT NULL,
  `ghichu` varchar(200) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `mucchicha`
--

INSERT INTO `mucchicha` (`idmucchicha`, `tenmucchicha`, `ghichu`, `image`) VALUES
(1, 'Ăn uống', '', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/food.png?alt=media&token=6b5fb096-2afc-4c82-acdb-cdaf13e90adf'),
(2, 'Con cái', '', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/kid.png?alt=media&token=41429759-25e1-4fbc-90bd-745c88194a45'),
(3, 'Dịch vụ sinh hoạt', '', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/sinhhoat.png?alt=media&token=8e63c88c-6d83-48cc-aa2d-a23df4da890b'),
(4, 'Đi lại', '', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/travel.png?alt=media&token=ae1e15a6-c8e9-4eeb-8352-9cf624a118bb'),
(5, 'Hưởng thụ', '', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/relax.png?alt=media&token=4b71c5eb-2239-4f0a-8375-c0190bbe605f'),
(6, 'Trang phục', '', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/clothes.png?alt=media&token=cd1f4cdc-389f-4474-841b-4f795acab407');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mucchicon`
--

CREATE TABLE `mucchicon` (
  `idmucchicon` int(11) NOT NULL,
  `tenmucchicon` varchar(50) NOT NULL,
  `idmucchicha` int(11) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `mucchicon`
--

INSERT INTO `mucchicon` (`idmucchicon`, `tenmucchicon`, `idmucchicha`, `image`) VALUES
(1, 'Ăn tiệm', 1, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/antiem.png?alt=media&token=906e3631-447f-4aee-8452-1583f85eb9f8'),
(2, 'Cafe', 1, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/coffe.png?alt=media&token=1e650246-fb44-44f4-b53b-4668cbae4d08'),
(3, 'Đi chợ/Siêu thị', 1, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/shopping.png?alt=media&token=3c25a513-f619-4802-a972-df0a593bf49d'),
(4, 'Đồ chơi', 2, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/toy.png?alt=media&token=182958f3-d6a3-4d9d-8a87-a5e7cbfce0fd'),
(5, 'Học phí', 2, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/shoolfee.png?alt=media&token=e4f3bb04-69fa-4113-b33d-4f753f1a0a15'),
(6, 'Sách vở', 2, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/book.png?alt=media&token=ff61f12b-b4f2-4c59-b24a-25678dd9c00e'),
(7, 'Tiền tiêu vặt', 2, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/wallet.png?alt=media&token=4e65bdae-1490-4f7d-8e36-fc927a44099a'),
(8, 'Du lich', 3, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/travel.png?alt=media&token=ae1e15a6-c8e9-4eeb-8352-9cf624a118bb'),
(9, 'Dien', 4, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/dien.png?alt=media&token=54ed9050-7588-404b-839c-5ab3108e4abd');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mucthu`
--

CREATE TABLE `mucthu` (
  `idmucthu` int(11) NOT NULL,
  `tenmucthu` varchar(100) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `mucthu`
--

INSERT INTO `mucthu` (`idmucthu`, `tenmucthu`, `image`) VALUES
(1, 'Được cho/tặng', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/gift.png?alt=media&token=55c4863a-7182-4fa6-83c4-919a8eeadcac'),
(2, 'Khác', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/another.png?alt=media&token=52b754f1-e007-4423-b6df-9aa0a844bc21'),
(3, 'Lãi tiết kiệm', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/pervent.png?alt=media&token=9970f433-8c20-4161-86ba-b76c681e0382'),
(4, 'Tiền lãi', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/interest.png?alt=media&token=3b6fc738-cf2f-4e79-92ec-f352377bb539'),
(5, 'Lương', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/salary.png?alt=media&token=82199a96-a79a-4091-9d69-6824a486a991'),
(6, 'Thưởng', 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/award.png?alt=media&token=2e7e21bc-2826-4d5e-8774-59a0897bf4d2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `iduser` int(11) NOT NULL,
  `user` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuchi`
--

CREATE TABLE `phieuchi` (
  `idphieuchi` int(11) NOT NULL,
  `tien` int(11) NOT NULL,
  `ngaylap` date NOT NULL,
  `ghichu` varchar(200) NOT NULL,
  `idtaikhoan` int(11) NOT NULL,
  `idmucchi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `phieuchi`
--

INSERT INTO `phieuchi` (`idphieuchi`, `tien`, `ngaylap`, `ghichu`, `idtaikhoan`, `idmucchi`) VALUES
(18, 50000, '2018-10-22', '', 22, 1),
(23, 0, '2018-10-02', '', 23, 4),
(24, 100000, '2018-10-02', '', 23, 4),
(25, 2100000, '2018-10-02', '', 22, 1),
(26, 10000, '2018-10-12', '', 25, 4),
(27, 0, '1970-01-01', '', 26, 1),
(28, 1000, '2018-10-23', '', 22, 1),
(29, 5000, '2018-10-03', '', 26, 2),
(30, 50000, '2018-04-20', '', 22, 1),
(31, 50000, '2018-04-20', '', 22, 1),
(32, 50000, '2018-04-20', '', 22, 1),
(33, 50000, '2018-04-20', '', 1, 1),
(34, 50000, '2018-04-20', '', 1, 1),
(35, 50000, '2018-04-20', '', 1, 1),
(36, 0, '1970-01-01', '', 0, 0),
(37, 50000, '2018-04-20', '', 1, 1),
(38, 50000, '2018-04-20', '', 1, 1),
(39, 50000, '2018-04-20', '', 1, 1),
(40, 50000, '2018-04-20', '', 1, 1),
(41, 50000, '2018-04-20', '', 1, 1),
(42, 50000, '2018-04-20', '', 30, 1),
(43, 1000000, '2018-10-25', '', 24, 8),
(44, 10000000, '2018-10-25', '', 22, 9),
(45, 5000000, '2018-10-25', '', 22, 4),
(46, 500000, '2018-10-29', '', 25, 4),
(47, 1000000, '2018-10-29', '', 32, 8);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuthu`
--

CREATE TABLE `phieuthu` (
  `idphieuthu` int(11) NOT NULL,
  `tien` int(11) NOT NULL,
  `ngaylap` date NOT NULL,
  `ghichu` varchar(200) NOT NULL,
  `idtaikhoan` int(11) NOT NULL,
  `idmucthu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `phieuthu`
--

INSERT INTO `phieuthu` (`idphieuthu`, `tien`, `ngaylap`, `ghichu`, `idtaikhoan`, `idmucthu`) VALUES
(1, 5000, '1970-01-01', '', 22, 0),
(2, 5000, '1970-01-01', '', 22, 1),
(3, 5000, '1970-01-01', '', 22, 1),
(4, 5000, '1970-01-01', '', 22, 1),
(5, 5000, '1970-01-01', '', 22, 1),
(6, 500000, '2018-10-24', '', 26, 1),
(7, 500000, '2018-10-25', '', 25, 2),
(8, 50000000, '2018-10-29', '', 24, 3),
(9, 5000000, '2018-10-29', '', 32, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `idtk` int(11) NOT NULL,
  `tentk` varchar(50) NOT NULL,
  `sodubd` int(11) NOT NULL,
  `soduht` int(11) NOT NULL,
  `trangthai` tinyint(1) NOT NULL,
  `idtiente` int(11) NOT NULL,
  `idloaitk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`idtk`, `tentk`, `sodubd`, `soduht`, `trangthai`, `idtiente`, `idloaitk`) VALUES
(22, 'Test', 100000, -15115000, 0, 1, 1),
(23, 'khoa', 10000, -90000, 0, 1, 1),
(24, 'Dương Dương', 25000000, 74000000, 0, 1, 3),
(25, 'Thanh Khoa', 200000, 190000, 0, 1, 1),
(26, '1111c', 10000, 500000, 0, 1, 2),
(27, '2222', 500000, 500000, 0, 1, 2),
(28, '3333', 20000, 20000, 0, 2, 1),
(29, '44444', 50000, 50000, 0, 1, 3),
(30, '5555', 30000, 25000, 0, 1, 4),
(31, '9', 70, 70, 0, 1, 2),
(32, 'demo', 0, 4000000, 0, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tiente`
--

CREATE TABLE `tiente` (
  `id` int(11) NOT NULL,
  `kyhieu` varchar(5) NOT NULL,
  `tentiente` varchar(50) NOT NULL,
  `tigia` double NOT NULL,
  `hinh` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `tiente`
--

INSERT INTO `tiente` (`id`, `kyhieu`, `tentiente`, `tigia`, `hinh`) VALUES
(1, 'VND', 'Vietnamese Dong', 1, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/vietnam.png?alt=media&token=2442983d-433e-4740-ad6e-98dcf4c82ac8'),
(2, 'USD', 'United States Dollar', 0.000043, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/america.png?alt=media&token=d0d97b8e-09f8-446f-b84f-b423f7d4a0d6'),
(3, 'JPY', 'Japanese Yen', 0.004831, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/japan.png?alt=media&token=961f43b5-feba-4910-9f4f-a1932160c62e'),
(4, 'CNY', 'Chinese Yuan', 0.000298, 'https://firebasestorage.googleapis.com/v0/b/qlthuchi-54680.appspot.com/o/china.png?alt=media&token=a1a808be-7f26-45f2-b0e3-54be24ddd8f1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `loaitaikhoan`
--
ALTER TABLE `loaitaikhoan`
  ADD PRIMARY KEY (`idloaitk`);

--
-- Chỉ mục cho bảng `mucchicha`
--
ALTER TABLE `mucchicha`
  ADD PRIMARY KEY (`idmucchicha`);

--
-- Chỉ mục cho bảng `mucchicon`
--
ALTER TABLE `mucchicon`
  ADD PRIMARY KEY (`idmucchicon`);

--
-- Chỉ mục cho bảng `mucthu`
--
ALTER TABLE `mucthu`
  ADD PRIMARY KEY (`idmucthu`);

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`iduser`);

--
-- Chỉ mục cho bảng `phieuchi`
--
ALTER TABLE `phieuchi`
  ADD PRIMARY KEY (`idphieuchi`);

--
-- Chỉ mục cho bảng `phieuthu`
--
ALTER TABLE `phieuthu`
  ADD PRIMARY KEY (`idphieuthu`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`idtk`);

--
-- Chỉ mục cho bảng `tiente`
--
ALTER TABLE `tiente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `loaitaikhoan`
--
ALTER TABLE `loaitaikhoan`
  MODIFY `idloaitk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `mucchicha`
--
ALTER TABLE `mucchicha`
  MODIFY `idmucchicha` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `mucchicon`
--
ALTER TABLE `mucchicon`
  MODIFY `idmucchicon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `mucthu`
--
ALTER TABLE `mucthu`
  MODIFY `idmucthu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `phieuchi`
--
ALTER TABLE `phieuchi`
  MODIFY `idphieuchi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT cho bảng `phieuthu`
--
ALTER TABLE `phieuthu`
  MODIFY `idphieuthu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `idtk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT cho bảng `tiente`
--
ALTER TABLE `tiente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
