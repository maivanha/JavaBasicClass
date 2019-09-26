<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="model.SanPham"%>
<%@ page import="java.util.List"%>
<jsp:useBean id="spList" class="java.util.ArrayList" scope="request"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Danh sách sản phẩm
<table	border="1" style="border-collapse: collapse;">
	<tr>
		<th>Mã SP</th>
		<th>Loại</th>
		<th>Tên</th>
		<th>Ảnh</th>
		<th>Giới thiệu</th>
		<th>Giá nhập</th>
		<th>Giá bán</th>
		<th>Giảm giá</th>
		<th>Hãng SX</th>
		<th></th>
	</tr>
	<%
	if(spList != null && spList.size() > 0){
		SanPham sp = null;
		for(Object obj : spList){
			sp = (SanPham) obj;%>
			<tr>
				<td><%= sp.getId()%></td>
				<td><%= sp.getLoai()%></td>
				<td><%= sp.getTen()%></td>
				<td><%= sp.getAnh()%></td>
				<td><%= sp.getGioithieu()%></td>
				<td><fmt:formatNumber value="<%= sp.getGianhapve()%>" type="currency"/></td>
				<td><fmt:formatNumber value="<%= sp.getGiabanra()%>" type="currency"/></td>
				<td><fmt:formatNumber value="<%= sp.getGiamgia()%>"  type = "NUMBER"/></td>
				<td><%= sp.getHangsanxua()%></td>
				<td><a href="./productAction?id=<%=sp.getId()%>">Sửa</a></td>	
			</tr>
	<%
		}
	} else {%>
		<tr>
			<td colspan="9">Chưa có sản phẩm</td>
		</tr>
	<%}
	%>
</table>
<a href="productform.jsp">Thêm sản phẩm</a>
</body>
</html>