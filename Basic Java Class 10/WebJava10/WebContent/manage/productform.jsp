<%@page import="model.LoaiSanPham"%>
<%@page import="java.util.Map"%>
<%@page import="dao.DAOLoaiSanPham"%>
<%@page import="model.SanPham"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="product" class="model.SanPham" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		System.out.println(product.getTen() +"\t" + product.getId());
	%>
	<form action="./productAction" method="post" enctype="multipart/form-data">
		<table>
		<caption>Thêm sản phẩm</caption>
			<input type="hidden" name="iD" value="<%=(product.getId()<=0)?"":product.getId()%>">
			<tr>
				<td>Loại sản phẩm</td>
				<td>
					<select name="loaisanpham">
						<%
						DAOLoaiSanPham daoLSP = new DAOLoaiSanPham();
						Map<Integer, LoaiSanPham> lspMap = daoLSP.getAllLoaiSanPhams();
						LoaiSanPham lsp = null;
						for(Object key : lspMap.keySet()){
							lsp = lspMap.get(key);
						%>
							<option value="<%=lsp.getId()%>" <%=(product.getId() > 0 && (product.getLoai() == (Integer) key))? "selected=\"selected\"" : ""%>>
								<%=lsp.getTenloai() %>
							</option>
						<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>Tên sản phẩm</td>
				<td><input type="text" name="tensanpham" value="<%=(product.getId()<=0)?"":product.getTen()%>"></td>
			</tr>
			<tr>
				<td>Giá nhập</td>
				<td>
					<input type="text" name="gianhap" value="<%=(product.getId()<=0)?"":product.getGianhapve()%>">
				</td>
			</tr>
			<tr>
				<td>Giá bán</td>
				<td>
					<input type="text" name="giaban" value="<%=(product.getId()<=0)?"":product.getGiabanra()%>">
				</td>
			</tr>
			<tr>
				<td>Giảm giá</td>
				<td>
					<input type="text" name="giamgia" value="<%=(product.getId()<=0)?"":product.getGiamgia()%>">
				</td>
			</tr>
			<tr>
				<td>Ảnh</td>
				<td>
					<%
					if(product.getId() > 0 && product.getAnh() != null && product.getAnh().trim().length() > 0){%>
						<img src="../img/sanpham/<%=product.getAnh()%>" style="max-width: 150px;">
					<%
					}
					%>
					<br/>
					<input type="file" name="anh">
				</td>
			</tr>
			<tr>
				<td>Giới thiệu</td>
				<td>
					<input type="text" name="gioithieu" value="<%=(product.getId()<=0)?"":product.getGioithieu()%>">
				</td>
			</tr>
			<tr>
				<td>Hãng sản xuất</td>
				<td>
					<input type="text" name="hangsx" value="<%=(product.getId()<=0)?"":product.getHangsanxua()%>">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Thêm">
					<input type="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>