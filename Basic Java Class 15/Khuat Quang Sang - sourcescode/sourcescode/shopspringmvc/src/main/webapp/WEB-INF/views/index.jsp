<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@page import="java.util.List"%>
<%@page import="com.niit.java.DAO.danhmucDaoImpl"%>
<%@page import="com.niit.java.Service.danhmucService"%>
<%@page import="com.niit.java.Entity.DanhMuc"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home | E-Shopper</title>
    
    <link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resources/css/prettyPhoto.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resources/css/price-range.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resources/css/animate.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/css/main.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/css/responsive.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/css/all.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/fonts/fontawesome-webfont.woff" rel="stylesheet">
</head>
<body>
   <jsp:include page="header.jsp"/>
   <jsp:include page="slider.jsp"/>
   <section>
		<div class="container">
			<div class="row">
			     <div class="col-sm-3">
		<div class="left-sidebar">
			<h2>DANH MỤC</h2>
			<div class="panel-group category-products" id="accordian">
				<!--category-productsr-->
               <%
                  
                  List<DanhMuc> listdmcha =dmService.getAll();
				  //List<DanhMuc> listdmcha=(List<DanhMuc>)request.getAttribute("listdmcha");
				  
				  for(DanhMuc dmcha : listdmcha){
				%>   
				<div class="panel panel-default">
					<div class="panel-heading">
						
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordian"
								href="#sportswear"> <span class="badge pull-right"><i
									class="fa fa-plus"></i></span> <%= dmcha.getTendanhmuc() %>
							</a>
						</h4>
					</div>

						<div class="panel-body">
							<ul>
							     <% for(DanhMuc dmcon : dmService.listDMByCha(dmcha.getMadanhmuc())){ %> 
								<li><a href="ClickDanhMucServlet?ma_danh_muc=<%=dmcon.getMadanhmuc() %>"><%= dmcon.getTendanhmuc() %></a></li>
								<% } %>
							</ul>
						</div>
					

				</div>
				<%
				  };
				  %>

			</div>
		</div>
	</div>
	<!--/category-products-->
			     <%-- <jsp:include page="category.jsp"/> --%>
                 <jsp:include page="product.jsp"/>
			</div>
		</div>
	</section>		
   <jsp:include page="footer.jsp"/> 
<!--script  -->
 <script src="${pageContext.request.contextPath }/resources/frontend/js/Custom.js"></script>
 <script src="resources/js/jquery.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.scrollUp.min.js"></script>
	<script src="resources/js/price-range.js"></script>
    <script src="resources/js/jquery.prettyPhoto.js"></script>
    <script src="resources/js/main.js"></script>
</body>
</html>