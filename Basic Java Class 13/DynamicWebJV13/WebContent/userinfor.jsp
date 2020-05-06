<%@page import="basicWeb.model.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="editedUser" class="java.lang.Object" scope="request"></jsp:useBean>
<!-- Chỉ dịnh sử dụng UTF-8 cho request và response để truyền/ nhận dữ liệu dạng UNI-CODE -->
<%
	Person person = (Person) editedUser;
	//request.getAttribute("editedUser");
%>
<html>
<head>
<title>Câp nhật thông tin tài khoảnn</title>
<script src="./jquery.min.js"></script>
<meta charset="UTF-8">
<style>
td {
	padding: 2px 5px;
}

h1 {
	font-style: italic;
}

#password {
	background-color: yellow;
	padding-left: 10px;
}

.example {
	color: red;
}

.inputLabel {
	text-align: right;
	color: blue;
	text-transform: capitalize;
}

.inputLabel .batbuoc {
	color: red;
	font-weight: bolder;
}

body {
	background-color: lightblue;
}

.formBorder {
	max-width: 700px;
	width: auto;
	height: auto;
	max-height: 1000px;
	border-width: 2px;
	border-color: red;
	border-style: dotted dashed solid double;
	margin-top: 5px;
	margin-left: 10px;
	border-radius: 25px;
}

.formBorder .formHeader {
	background-image: url("./imgs/leaf.gif");
	text-decoration: underline;
	text-transform: uppercase;
	font-size: 24px;
	height: 80px;
	border: 1px solid black;
	line-height: 80px;
	border-radius: 35px;
}
</style>
<link rel="stylesheet" type="text/css" href="./css/mystyle.css" />
</head>
<body>
	<script>
		$(document).ready(function() {
			$("#cancelButton").click(function() {
				$("p").hide();
				alert('run click on button');
			});

			$(".formHeader").click(function() {
				alert('run action on formHeader');
				$("#cancelButton").hide();
			});
		});

		function onfocusFunction(element) {
			element.style.background = "yellow";
		}

		function onblurFunction(element) {
			element.style.background = "white";
		}

		function onchangeFunction(element) {
			element.value = element.value.toUpperCase();
		}

		function changeImage(element) {
			var avatar = document.getElementById('avatar');
			avatar.src = element.value;
		}

		function submitFunction(button) {
			var gioiTinh = "";
			var categories = "";

			var inputs = document.getElementsByTagName("input");
			errorMessage = "";
			//alert(inputs[5].type + "-" + inputs[5].getAttribute('batbuoc') + "-'" + inputs[5].value + "'")
			for (i = 0; i < inputs.length; i++) {
				input = inputs[i];
				if (input.getAttribute('batbuoc') == 'true') {
					if (input.value.length == 0) {
						errorMessage += input.getAttribute('inputName')
								+ " báº¯t buá»c pháº£i nháº­p;"
						input.style.background = "red";
					}
				}

				if (input.type == 'checkbox' && input.checked == true) {
					categories += input.value + ";"
				}

				if (input.type == 'radio' && input.checked == true) {
					gioiTinh = input.value;
				}
			}
			if (categories.length < 1)
				errorMessage += "Báº¡n cáº§n chá»n má»t sáº£n pháº©m Æ°a thÃ­ch;";
			if (gioiTinh.length < 1)
				errorMessage += "Báº¡n cáº§n chá»n giá»i tÃ­nh;";

			if (errorMessage.length > 1)
				alert(errorMessage);
			else {
				var confirm = window.confirm("Báº¡n ÄÃ£ chá»n:" + categories);
				if (confirm) {
					mesage = document.personForm.firstName.value;
					alert(mesage);
				}
			}
		}
	</script>
	<div class="formBorder">
		<p class="example formHeader">Nhập thông tin người dùng</p>
		<h1
			style="color: blue; border: 1px solid red; padding: 5px; margin: 10px; text-align: center; text-shadow: 2px 2px 5px black;">
			Cập nhật thông tin tài khoản</h1>
		<form action="./PersonController" method="post"
			style="border: 1px solid blue;" name="personForm">
			<table border="1" style="border-collapse: collapse">
				<input type="hidden" name="personId"
					value="<%=person.getPersonId()%>" />
				<tr>
					<td class="example inputLabel">
						<div class="batbuoc">Firstname:</div>
					</td>
					<td><input batbuoc="true" inputName="Tên"
						onchange="onchangeFunction(this)" onfocus="onfocusFunction(this)"
						onblur="onblurFunction(this)" style="background-color: yellow;"
						size="50" type="text" name="firstName"
						value="<%=person.getFirstName()%>" /></td>
				</tr>
				<tr>
					<td class="inputLabel">
						<div class="batbuoc">LastName:</div>
					</td>
					<td><input batbuoc="true" inputName="Họ"
						onchange="onchangeFunction(this)" onfocus="onfocusFunction(this)"
						onblur="onblurFunction(this)" type="text"
						name="lastName" 
						value="<%=person.getLastName()%>"/></td>
				</tr>
				<tr>
					<td class="example inputLabel">BirthDay:</td>
					<td><input onfocus="onfocusFunction(this)"
						onblur="onblurFunction(this)" type="date" name="birthday" /></td>
				</tr>
				<tr>
					<td class="example inputLabel">username:</td>
					<td><input batbuoc="true" inputName="Tên đăng nhập"
						onfocus="onfocusFunction(this)" onblur="onblurFunction(this)"
						type="text" name="username" value="<%=person.getUsername()%>" /></td>
				</tr>
				<tr>
					<td class="inputLabel">
						<div class="batbuoc">PassWord:</div>
					</td>
					<td><input batbuoc="true" inputName="Mật khẩu"
						value="<%=person.getPassword()%>" onfocus="onfocusFunction(this)"
						onblur="onblurFunction(this)" id="password" maxlength="20"
						size="22" type="password" name="passWord" /></td>
				</tr>
				<tr>
					<td class="inputLabel">Avatar:</td>
					<td><input type="file" name="avatar" style="float: righ;" />
						<img style="float: left;" id="avatar" src="./imgs/image6.png"
						width="220"> <span style="clear: both;" /> (*) <select
						onchange="changeImage(this)">
							<option value="./imgs/image1.png">image 1</option>
							<option value="./imgs/image2.jpg">image 2</option>
							<option value="./imgs/image3.jpg">image 3</option>
							<option value="./imgs/image4.png">image 4</option>
							<option value="./imgs/image5.jpg">image 5</option>
							<option value="./imgs/image6.png">image 6</option>
					</select></td>
				</tr>
				<tr>
					<td class="inputLabel">Tỉnh/ Thành phố:</td>
					<td><input type="text" name="city"
						value="<%= person.getCity() %>"></td>
				</tr>
				<!-- <tr>
					<td class="inputLabel">Tỉnh/ Thành phố:</td>
					<td><select name="testCity">
							<option value="Hà Nội">Hà NỘi/option>
							<option value="CT02">TP Hồ Chí Minh</option>
							<option value="CT03">Đà Nẵng</option>
							<option value="CT04">Huế¿</option>
					</select></td>
				</tr> -->
				<tr>
					<td class="inputLabel">Address:</td>
					<td><textarea name="address" cols="50" rows="5"><%=person.getAddress()%></textarea>
					</td>
				</tr>
				<tr>
					<td class="inputLabel">Giới tính:</td>
					<td><input type="radio" name="gioiTinh" selected='true'
						value="0">Nam</input> <input type="radio" name="gioiTinh"
						value="1">Nữ</input> <input type="radio" name="gioiTinh" value="2">Giới
						tính khác</input></td>
				</tr>
				<tr>
					<td class="inputLabel">Loại sản phẩm quan tâm:</td>
					<td><input type="checkbox" name="categories" value="01">Smart
						Phone</input> <input type="checkbox" name="categories" value="02">Laptop</input>
						<input type="checkbox" name="categories" value="03">MÃ¡y
						tÃ­nh bÃ n</input> <input type="checkbox" name="categories"
						value="Äiá»n thoáº¡i cá»">Äiá»n thoáº¡i cá»</input></td>
				</tr>
				<tr>
					<td class="inputLabel">Mầu yêu thích:</td>
					<td><input type="color" name="color" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="reset"
						value="Nhập lại" /> <input type="submit" value="Lưu" /> <!-- <button onclick="submitFunction(this)">Lưu Button</button> -->
						<button id="cancelButton">Thoát</button></td>
				</tr>
			</table>
		</form>

		<p>Doan van ba muon an di</p>

		<canvas id="myCanvas" width="400" height="200"
			style="border: 4px solid red;">
				Hiá»n thá» Äá» há»a canvas
			</canvas>
	</div>
	<script>
		var c = document.getElementById("myCanvas");
		var ctx = c.getContext("2d");
		ctx.moveTo(0, 0);
		ctx.lineTo(200, 100);
		ctx.stroke();

		ctx.font = "30px Arial";
		ctx.strokeText("Hello", 210, 120);
		/*
		var c = tinhTong();
		document.write("c = tinhTong(10, 20) = " + c);
		 */
	</script>
</body>
</html>