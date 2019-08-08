SHOW DATABASES ;

USE javacb9 ;

SHOW TABLES ;

CREATE DATABASE javacb10;

DROP TABLE nhanvien;
DROP TABLE donhang;
DROP TABLE khachhang;

# TRUNCATE nhanvien;
# TRUNCATE donhang;
# TRUNCATE khachhang;


CREATE TABLE nhanvien (
	manv	INT(12) PRIMARY KEY AUTO_INCREMENT, 
	hoten	CHAR(200) NOT NULL,
	tendangnhap	CHAR(20) NOT NULL UNIQUE,
	matkhau	CHAR(255) NOT NULL,
	diachi	NVARCHAR(500) DEFAULT 'Không có thông tin', 
	dienthoai	CHAR(10) NULL,
	CONSTRAINT check_dienthoai CHECK (dienthoai LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')
);

CREATE TABLE khachhang (
	makh	INT(12) PRIMARY KEY AUTO_INCREMENT, 
	hoten	CHAR(200) NOT NULL,
	tendangnhap	CHAR(20) NOT NULL UNIQUE,
	matkhau	CHAR(255) NOT NULL,
	diachi	NVARCHAR(500) DEFAULT 'Không có thông tin', 
	dienthoai	CHAR(10) NULL,
	CONSTRAINT check_dienthoai CHECK (dienthoai LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')
);

SHOW TABLES ;

INSERT INTO nhanvien (hoten, tendangnhap, matkhau, dienthoai) VALUES (N'Nguyễn Văn A', 'admin', SHA2('123456', 512), '0123456789');
INSERT INTO nhanvien (hoten, tendangnhap, matkhau, dienthoai) VALUES (N'Nguyễn Văn B', 'manager', SHA2('123456', 512), '0123456789');

INSERT INTO khachhang (hoten, tendangnhap, matkhau, dienthoai) VALUES (N'Nguyễn Văn C', 'khachang1', SHA2('123456', 512), '0123456789');
INSERT INTO khachhang (hoten, tendangnhap, matkhau, dienthoai) VALUES (N'Nguyễn Văn D', 'khachang2', SHA2('123456', 512), '0123456789');
INSERT INTO khachhang (hoten, tendangnhap, matkhau, dienthoai) VALUES (N'Trần Văn E', 'khachang3', SHA2('123456', 512), '0123456789');

CREATE TABLE donhang(
	madh	INT(12) PRIMARY KEY AUTO_INCREMENT,
	ngaytao	DATE NOT NULL,
	diachi	VARCHAR(500) NOT NULL, 
	dienthoai	CHAR(10) NOT NULL, 
	tongtien	INT(12),
	makh	INT (12), 
	CONSTRAINT donhang_khachhang FOREIGN KEY (makh) REFERENCES khachhang(makh)
);

INSERT INTO donhang (ngaytao, diachi, dienthoai, tongtien, makh)
	VALUES (NOW(), 'Hoàng Đạo Thúy - Thanh Xuâ - Hà Nội', '0123654789', 1500000, 1);
INSERT INTO donhang (ngaytao, diachi, dienthoai, tongtien, makh)
	VALUES (NOW(), 'Hoàng Đạo Thúy - Thanh Xuâ - Hà Nội', '0258741369', 3500000, 2);

SELECT * FROM nhanvien ;
SELECT * FROM nhanvien WHERE tendangnhap = 'admin' AND matkhau = SHA2('123456', 512);

SELECT * FROM khachhang ;
SELECT * FROM khachhang WHERE tendangnhap = 'khachang1' AND matkhau = SHA2('123456', 512);

SELECT * FROM donhang;

SELECT kh.hoten AS 'Họ và tên', kh.diachi AS 'Địac chỉ', kh.dienthoai AS 'ĐT', dh.diachi AS 'Địa chỉ nhận', 
	dh.dienthoai AS 'ĐT người nhận', dh.tongtien, dh.ngaytao AS 'Ngày đặt hàng'
	
	FROM khachhang kh, donhang dh

	WHERE kh.makh = dh.makh;
	
SELECT * FROM khachhang WHERE hoten LIKE 'Trần%';
SELECT * FROM khachhang WHERE hoten LIKE '%Văn%';