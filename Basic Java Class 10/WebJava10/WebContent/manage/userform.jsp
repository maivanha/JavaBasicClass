<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>Thông tin khách hàng</title>

<script type="text/javascript" src="../js/jquery.min.js"></script>

<style type="text/css">
	td{
		padding: 2px 5px;
		text-align: right;
	}
	input {
		float: left;
		margin-left: 10px;
	}
	caption{
		font-weight: bold;
		font-size: 26px;
		text-align: center;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		//alert('JQuery is running');
		$("input").focus(function(){
			this.style.backgroundColor = "yellow";
		});
		$("input").blur(function(){
			this.style.backgroundColor = "white";
		});
		$("#fullname").change(function(){
			this.value = this.value.toUpperCase();
			//document.getElementById("tblCaption").style.display="none";
			//$("#tblCaption").hide(2000);
			//$("#tblCaption").toggle(2500);
			//$("#tblCaption").slideUp(2500);
			$("#tblCaption").slideToggle(2500);
		});
		$("#reset").click(function(){
			//document.getElementById("tblCaption").style.display="block";
			//$("#tblCaption").show(2000);
			//$("#tblCaption").toggle(2500);
			//$("#tblCaption").slideDown(2500);
			$("#tblCaption").slideToggle(2500);
		});
		$("button").mouseenter(function(){
			this.style.backgroundColor = "Yellow";
		});
		$("button").mouseleave(function(){
			this.style.backgroundColor = "White";
		});
		$("#submit").click(function(){
			$("#tblCaption").css("position", "absolute");
			$("#tblCaption").animate({left: "300px", top: "250px"});
			$("#tblCaption").css("border", "2px solid red").css("padding", "5px");
		});
		
	});
</script>

</head>
<body>
	<form action="#" method="post" style="border: 1px solid black; margin: 5px;">
		<table border="1" style="border-collapse: collapse;margin: 5px;">
			<caption id="tblCaption">Thông tin khách hàng</caption>
			<tr>
				<td>Họ tên:</td>
				<td><input type="text" id="fullname" name="fullname" ></td> <!-- onchange="upperCaseFunction(this)" -->
			</tr>
			<tr>
				<td>Tên đăng nhập:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Mật khẩu:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Nhắc lại mật khẩu:</td>
				<td><input type="password" name="repassword"></td>
			</tr>
			<tr>
				<td>Số ĐT:</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>Địa chỉ:</td>
				<td>
					<input type="text" name="address" style="width: 550px;">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<!-- onclick="save()"  onmouseover="overfunction(this)" onmouseout="outFunction(this)" -->
					<button id="submit" style="" >Lưu</button>
					
					<!-- onmouseover="overfunction(this)" onmouseout="outFunction(this)" -->
					<button id="reset" >Nhập lại</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>