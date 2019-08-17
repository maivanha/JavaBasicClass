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

<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../bootstrap/popper.min.js"></script>
	<script type="text/javascript" src="../bootstrap/bootstrap.min.js"></script>
	
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
				$("#popupContent").load("./userform.jsp");
			});
			
			$("#closePopup").click(function(){
				$("#popupWindow").hide(1500);
				//$("#popupWindow").removeClass("showPopup");
			});
		});
	</script>
</head>
<body>
	<button style="margin: 5px;" id="openPopup"> Thêm mới</button>
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
		out.append("<hr/>");
		%>
	</table>
	
	<div id="popupWindow" 
		style="min-width: 300px; display: none;">
		<div style="width: 100%; float: left;">
			<div id="popupTitle" 
				style="width: 85%; float:left;padding: 5px; ">
					Tiêu đề của popup
			</div>
			<div id="closePopup" 
				style="width: 5%; text-align: center; padding: 5px; 
						float:left; cursor: pointer;"> X </div>
		</div>
		
		<div style="clear: left; border: 0px;"></div>
		
		<div id="popupContent" 
			style="width: 100%; min-height: 50px; margin-top: 5px;">
			Nội dung của popup
		</div>
	</div>
</body>
</html>