<%@page import="model.KhachHang"%>
<%@page import="java.util.List"%>
<%@page import="dao.DAOKhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
		padding: 2px 5px;
	}
</style>
</head>
<body>
	<button style="margin: 5px;"> Thêm mới</button>
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th>STT</th>
			<th>Họ tên</th>
			<th>Tên đăng nhập</th>
			<th>Địa chỉ</th>
			<th>Điện thoại</th>
			<th>#</th>
		</tr>
		<%
		DAOKhachHang daoKH = new DAOKhachHang();
		List<KhachHang> khList = daoKH.getAllKhachHang();
		if(khList != null && khList.size() > 0){
			int count = 0;
			for(KhachHang kh : khList){
		%>
				<tr>
					<td><%=++count %></td>
					<td><%= kh.getHoTen()%></td>
					<td><%= kh.getTenDangNhap()%></td>
					<td><%= kh.getDiaChi()%></td>
					<td><%= kh.getDienThoai()%></td>
					<td>
						[Edit]
						[Delete]
					</td>
				</tr>
		<%	
			}
		} else {%>
			<tr>
				<td colspan="6">
					Không có dữ liệu
				</td>
			</tr>
		<%	
		}
		%>
	</table>
</body>
</html>