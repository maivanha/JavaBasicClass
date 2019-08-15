<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	td {
		padding: 2px 5px;
	}
</style>
</head>
<body>
	<form action="./login" method="post" style="width: 90%; border: 1px solid black;">
		<table style="border-collapse: collapse;" border="1">
			<tr>
				<td>Tên đăng nhập:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Mật khẩu:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Bạn là:</td>
				<td>
					<input type="radio" name="role" value="client" checked="checked"> Khách <br/>
					<input type="radio" name="role" value="manager"> Quản trị <br/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Đăng nhập">
					<input type="reset" value="Nhập lại">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>