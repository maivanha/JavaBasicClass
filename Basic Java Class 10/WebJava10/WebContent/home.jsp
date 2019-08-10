<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
/* if(session.getAttribute("user") == null )
	response.sendRedirect("./login.jsp"); */
%>

<html>
<head>
	<title>Insert title here</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="./bootstrap/bootstrap.min.css">
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<script type="text/javascript" src="./bootstrap/popper.min.js"></script>
	<script type="text/javascript" src="./bootstrap/bootstrap.min.js"></script>
	
	<style type="text/css">
		.showPopup {
			position: absolute;
		}
		
		.closePopup {
			position: relative;
		}
	
		.gridContainer{
			display: grid;
			grid-template-areas:
				'header header header header header header'
				'lmenu navi navi navi navi navi'
				'lmenu main main main main rmenu'
				'footer footer footer footer footer rmenu';
			padding: 5px;
		}
		
		.head{grid-area: header; min-height: 75px;}
		.leftmenu{grid-area: lmenu}
		.rmenu{grid-area: rmenu}
		.navigation{grid-area: navi; min-height: 50px;}
		.mainconten{grid-area: main; min-height: 200px;}
		.foot{grid-area: footer; min-height: 50px;}
		
		div{
			border: 1px solid blue;
		}
	</style>
	
	<script type="text/javascript">
	function changeHTML(){
		var mContent = document.getElementById('mainContent');
		mContent.innerHTML = "<b>Thay doi gia tri cua Main Content</b>";
		mContent.style.border = "1px solid red";
		mContent.style.padding = "5px";
		mContent.style.margin = "10px";
	}
	</script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#openPopup").click(function(){
				$("#popupWindow").addClass("showPopup");
				$("#popupWindow").show();
				$("#popupWindow").animate({left: "200px", top: "200px"});
				$("#popupWindow").css("background-color", "white");
				$("#popupWindow").css("z-index", "500");
				$("#popupContent").load("./userform.html");
			});
			
			$("#closePopup").click(function(){
				$("#popupWindow").hide(1500);
				//$("#popupWindow").removeClass("showPopup");
			});
		});
	</script>
</head>
<body>
	<div class="container">
		<h1>Hello Bootstrap</h1>
		<p>Example</p>
		
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
			<a class="navbar-brand" href="#">
				<img alt="Logo" src="./img/A team is.jpg" height="40">
			</a>
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="#">Trang chủ</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Danh sách sản phẩm</a>
				</li>
				
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="adminFunctions" 
						data-toggle="dropdown" href="#">Quản trị</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Danh mục sản phẩm</a>
						<a class="dropdown-item" href="#">Danh mục Loại sản phẩm</a>
						<a class="dropdown-item" href="#">Danh sách người dùng</a>
					</div>
				</li>
				
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" 
						id="orderManagement" data-toggle="dropdown" >Quản lý Đơn hàng</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Đơn hàng mới</a>
						<a class="dropdown-item" href="#">Đơn hàng đã thanh toán</a>
						<a class="dropdown-item" href="#">Đơn hàng gửi trả</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="orders"
						data-toggle="dropdown" href="#">Báo cáo</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Báo cáo nhập</a>
						<a class="dropdown-item" href="#">Báo cáo tồn</a>
						<a class="dropdown-item" href="#">Báo cáo đơn hàng</a>
					</div>
				</li>
			</ul>
			
			<form class="form-inline" action="#">
				<div class="iput-group">
					<div class="input-group-prepend">
						<span class="input-group-text">Search</span>
					</div>
				</div>
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<%
			if(session.getAttribute("user") != null){
			%>
				<ul class="navbar-nav">
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" id="orders"
							data-toggle="dropdown" href="#">
							Xin chào <%=session.getAttribute("user") %>
						</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Thông tin người dùng</a>
							<a class="dropdown-item" href="#">Danh sách đơn hàng</a>
							<a class="dropdown-item" href="#">Đăng xuất</a>
						</div>
					</li>
				</ul>
			<%
			} else {
			%>
				<ul class="navbar-nav">
					<li class="nav-item">
						<a class="nav-link" href="./login.jsp">Đăng nhập</a>
					</li>
				</ul>
			<%
			}%>
		</nav>
		
		<div class="alert alert-success alert-dismissible fade show">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			Thông báo cho người dùng
		</div>
		
		<button type="button" class="btn btn-success btn-md disable">Open Alert</button>
		<button type="button" class="btn btn-outline-success btn-md active">Open Alert</button>
		
		<div class="row">
			<div class="col-sm-4">Column 1</div>
			<div class="col-sm-4">Column 2</div>
			<div class="col-sm-4">Column 3</div>
		</div>
		<div class="row">
			<div class="col-sm-3">Column 1</div>
			<div class="col-sm-3">Column 2</div>
			<div class="col-sm-3">Column 3</div>
			<div class="col-sm-3">Column 4</div>
		</div>
		<div>
			<table class="table  table-striped">
				<tr>
					<th>Mã SP</th>
					<th>Tên Sản phẩm</th>
					<th>Ảnh sản phẩm</th>
					<th>Giới thiệu</th>
					<th>Giá bán</th>
				</tr>
				<tr>
					<td>SP01</td>
					<td>Nokia 1200</td>
					<td>
						<img src="./img/young programmer vs nomarl child.jpg" 
							class="rounded" style="max-height: 200px;"/>
					</td>
					<td>
						<a href="vnexpress.net">Link</a>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>SP02</td>
					<td>iPhone 5SE</td>
					<td>
						<img src="./img/young programmer vs nomarl child.jpg" 
							class="rounded-circle mx-auto d-block" style="max-height: 200px;"/>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>SP03</td>
					<td>iPhone 6</td>
					<td>
						<img src="./img/young programmer vs nomarl child.jpg" 
							class="img-thumbnail float-right" style="max-height: 200px;"/>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>SP04</td>
					<td>iPhone 6s</td>
					<td>
						<img src="./img/i can not understand it for you.jpg" 
							class="img-thumbnail float-left" style="max-height: 200px;"/>
					</td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>