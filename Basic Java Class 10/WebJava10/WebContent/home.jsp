<%@page import="java.util.ArrayList"%>
<%@page import="model.NhanVien"%>
<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/MultipleLanguageTag.tld" prefix="ml" %>
<%@ page import="model.SanPham"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.DAOSanPham" %>
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
					<a class="nav-link" href="#">
						<ml:multipleLanguage>home.title</ml:multipleLanguage>
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">
						<ml:multipleLanguage>home.products</ml:multipleLanguage>
					</a>
				</li>
				
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="adminFunctions" 
						data-toggle="dropdown" href="#">
							<ml:multipleLanguage>home.manage</ml:multipleLanguage>
						</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="./manage/productAction">Danh mục sản phẩm</a>
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
				String userName = null;
				if(session.getAttribute("user") instanceof KhachHang) 
					userName = ((KhachHang) session.getAttribute("user")).getTenDangNhap();
				else if(session.getAttribute("user") instanceof NhanVien)
					userName = ((NhanVien) session.getAttribute("user")).getTenDangNhap();
			%>
				<ul class="navbar-nav">
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" id="orders"
							data-toggle="dropdown" href="#">
							Xin chào <%=userName %>
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
		
		<div>
			
				<%
				DAOSanPham daoSP = new DAOSanPham();
				List<SanPham> splist = new ArrayList<SanPham>();
				splist = daoSP.getAllSanPham();
				if(splist != null && splist.size() > 0){
					SanPham sp = null;
					for(Object obj : splist){
						sp = (SanPham) obj;
				%>
				
				
				<div style="float: left; margin: 10px; border: 1px solid gray;">
					<div><img src="./img/young programmer vs nomarl child.jpg" 
								class="rounded" style="max-height: 200px;"/></div>
					<div style="text-align: center;"><%=sp.getTen()%></div>
					<div style="text-align: center;">Gia ban: <%=sp.getGiabanra()%>
						<button type="button" name="mua">Mua</button></div>
				</div>
				
				<%}
				}%>
			
		</div>
	</div>
</body>
</html>