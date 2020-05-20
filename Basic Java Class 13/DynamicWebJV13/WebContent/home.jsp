<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="basicWeb.model.Person"%>

<jsp:useBean id="userList" class="java.util.ArrayList" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<fmt:setLocale value="${seletedLang}"/>
		<fmt:setBundle basename="message" var="lang"/>
		<title><fmt:message bundle="${lang}" key="home.title" /></title>
		<meta charset="UTF-8">
		<style>
			.grid-container{
				display: grid;
				grid-template-areas:
					'menu menu menu header header header header header header header'
					'menu menu menu main main main main main right right'
					'footer footer footer footer footer footer footer footer right right'
					'author author author author author author author author author author';
				grid-gap: 5px;
				background-color: lightblue;
				padding: 5px;
			}
			
			.grid-container > div {
				text-align: center;
				font-size: 24px;
				background-color: lightgray;
			}
			
			.gridHeader{grid-area: header;}
			.leftMenu{grid-area: menu;}
			.gridBody{grid-area: main;}
			.rightMenu{grid-area: right;}
			.gridFooter{grid-area: footer;}
			.gridAuthor{grid-area: author;}
			
			h1{background-color: green; color: red; font-style: italic; font-size: 32px;}
			p{background-color: green; color: red; font-style: italic; font-size: 32px;}
			
			.tblHeader{
				font-style: tahoma; color: #FF895F; font-size: 24px; 
				font-weight:bolder; padding: 5px;}
			.cell{
				font-style: tahoma; color: black; font-size: 16px;padding: 2px}
		</style>
	</head>
	
	<body>
		<!-- <script type="text/javascript">
			alert('Hello world;');
		</script> -->
		
		<div class="grid-container">
			<div class="gridHeader">
				<h1>Header</h1>
				<div style="border: 1px solid red; margin: 5px; padding: 5px;">
					<a href="changeLanguage?lang=vi_VN">Tiếng Việt</a>
					<a href="changeLanguage?lang=en_US" 
						style="padding-left: 10px; 
							border-left: 1px solid black">English</a>
				</div>
			</div>
			<div class="leftMenu">Left Menu</div>
			<div class="gridBody">
				<h1><fmt:message key="customer.title.cusList" bundle="${lang}"/></h1>
				<p style="font-style: calibri; background-color: gray; 
							color: blue; text-decoration: underline;
							max-width: 1000px;" align="center">
					Danh sách thông tin chi tiết các khách hàng đã đăng ký tài khoản trên hệ thống
					cùng với các giao dịch mua hãng thực hiện
				</p>
				<div style="float: left; width: 100%; border: 1px solid blue;">
					<div style="float: left; width: 35%; border: 1px solid red; 
								margin: 5px; padding: 5px;">
						Nhóm khách hàng
						<hr>
						<table border="1" style="border-collapse: collapse;">
							<tr>
								<th class="tblHeader">STT</th>
								<th class="tblHeader">Tên nhóm</th>
								<th class="tblHeader">Mô tả ngắn</th>
								<th class="tblHeader">#</th>
							</tr>
							<tr>
								<td class="cell">1</td>
								<td class="cell">Doanh nghiệp</td>
								<td class="cell">Mô tả ngắn</td>
								<td class="cell">#</td>
							</tr>
							<tr>
								<td class="cell">1</td>
								<td class="cell">Bán buôn</td>
								<td class="cell">Mô tả ngắn</td>
								<td class="cell">#</td>
							</tr>
							<tr>
								<td class="cell">1</td>
								<td class="cell">Bán lẻ</td>
								<td class="cell">Mô tả ngắn</td>
								<td class="cell">#</td>
							</tr>
						</table>
					</div>
					<div style="float: left; width: 60%; border: 1px solid red;
								margin: 5px; padding: 5px;">
						
						<a href="./PersonController?userId=0">Thêm mới</a>
						
						<table border="1" style="border-collapse: collapse;">
							<tr>
								<th class="tblHeader">STT</th>
								<th class="tblHeader">Họ tên</th>
								<th class="tblHeader">avatar</th>
								<th class="tblHeader">Số ĐT</th>
								<th class="tblHeader">Địa chỉ</th>
								<th class="tblHeader">#</th>
							</tr>
							<%
							Person per;
							for(Object obj : userList){
								per = (Person) obj;
							%>
							<tr>
								<td class="cell"><%= per.getPersonId() %></td>
								<td class="cell"><%= per.getLastName() + " " + per.getFirstName() %></td>
								<td class="cell">
									<img alt="anh dai dien" src="./imgs/<%=per.getAvatar()%>"
									width=100>
								</td>
								<td class="cell"><%= per.getPhone() %></td>
								<td class="cell"><%= per.getAddress() %></td>
								<td class="cell">
									<a href="./PersonController?userId=<%=per.getPersonId()%>">Edit</a>
								</td>
							</tr>
							<%
							} %>
						</table>
					</div>
				</div>
				<span style="clear: both;"></span>
				<div style="font-family: Arial, font-weight: italic; text-decoration: underline;
					color: green; background-code: orange; font-size: 32px; text-align: center;
					width: 1200px;">
					Spring Web MVC framework cung cấp kiến trúc Model-View-Controller (MVC) 
					và các thành phần sẵn sàng có thể được sử dụng để phát triển các ứng dụng 
					web linh hoạt và ít bị phụ thuộc. MVC parttern cho kết quả tách biệt 
					các khía cạnh khác nhau của ứng dụng (logic đầu vào, logic nghiệp vụ và 
					logic UI), đồng thời cung cấp một khớp nối lỏng lẻo giữa các yếu tố này.
				</div>
			</div>
			<div class="rightMenu">Right Menu</div>
			<div class="gridFooter">Footer</div>
			<div class="gridAuthor">Author</div>
		</div>
	</body>
</html>