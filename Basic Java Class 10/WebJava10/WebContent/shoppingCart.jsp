<%@page import="java.util.HashMap"%>
<%@page import="servletAction.ShoppingCartAction"%>
<%@page import="model.SanPham"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	Object sObj = session.getAttribute(ShoppingCartAction.SHOPPING_CART);
	Map<Integer, SanPham> spMap = (sObj == null)?(new HashMap<Integer, SanPham>()):(Map<Integer, SanPham> )sObj;
	
	if(spMap.size() == 0){%>
		Chưa có sản phẩm trong giỏ hàng
	<%} else {%>
		<table border="1" style="border-collapse: collapse;"> 
			<tr>
				<th>Mã SP</th>
				<th>Mô tả</th>
				<th>Giá bán</th>
				<th>Giảm giá</th>
				<th>Số lượng</th>
				<th>Thành tiền</th>
			</tr>
			<%
			for(SanPham sp : spMap.values()){
			%>
				<tr>
					<td><%=sp.getId() %></td>
					<td><%=sp.getTen() %></td>	
					<td><%=sp.getGiabanra()%></td>	
					<td><%=sp.getGiamgia() %></td>	
					<td>
						<input type="text" value="<%=sp.getSoLuongMua() %>">
					</td>	
					<td><%=sp.getSoLuongMua() * sp.getGiabanra() * (1 - (double)sp.getGiamgia() / 100) %> VNĐ</td>					
				</tr>
			<%	
			}
			%>
		</table>
	<%}
	%>
	
	
</body>
</html>