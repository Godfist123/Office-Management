<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
    
<!DOCTYPE html>
<html dir="ltr" lang="en">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!-- Tell the browser to be responsive to screen width -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
	
		<!-- 地址栏根目录是项目名 -->
		<base href="${pageContext.request.contextPath}/">
	
		<title>办公自动化系统</title>
		<!-- Custom CSS -->
		<link rel="stylesheet" type="text/css" href="resources/assets/libs/quill/dist/quill.snow.css">
		<link rel="stylesheet" type="text/css" href="resources/assets/libs/bootstrap/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="resources/dist/bootstrap-icons.css" />
		<link rel="stylesheet" type="text/css" href="resources/dist/css/multicheck.css">
		<!-- Custom CSS -->
		<link href="resources/assets/libs/fullcalendar/dist/fullcalendar.min.css" rel="stylesheet" />
		<link href="resources/assets/extra-libs/calendar/calendar.css" rel="stylesheet" />
		<link href="resources/dist/css/style.min.css" rel="stylesheet">
		
		<style type="text/css">
			.row1{border: 1px blue solid;}
			
		</style>
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
	</head>

	<body>

		<!-- ============================================================== -->
		<!-- Main wrapper - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<div id="main-wrapper">
			<!-- ============================================================== -->
			<!-- Topbar header - style you can find in pages.scss -->
			<!-- ============================================================== -->
			<jsp:include page="../share/head.jsp"></jsp:include>
			<!-- ============================================================== -->
			<!-- End Topbar header -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Left Sidebar - style you can find in sidebar.scss  -->
			<!-- ============================================================== -->
			<jsp:include page="../share/menu.jsp"></jsp:include>
			<!-- ============================================================== -->
			<!-- End Left Sidebar - style you can find in sidebar.scss  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Page wrapper  -->
			<!-- ============================================================== -->
			<div class="page-wrapper">
				<!-- ============================================================== -->
				<!-- Bread crumb and right sidebar toggle -->
				<!-- ============================================================== -->
				<div class="page-breadcrumb">
					<div class="row">
						<div class="col-12 d-flex no-block align-items-center">
							<h4 class="page-title">日程表</h4>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<span style="display: block;width: 50px;height: 20px;background-color:#649b40;color: white;text-align: center;font-weight: 600px ">本人</span>
							<span style="display: block;width: 50px;height: 20px;background-color:#fe8101;color: white;text-align: center;font-weight: 600px  ">他人</span>
							<div class="ml-auto text-right">
								<nav aria-label="breadcrumb">
									<ol class="breadcrumb">
										<li class="breadcrumb-item"><a href="#">Home</a></li>
										<li class="breadcrumb-item active" aria-current="page">Library</li>
									</ol>
								</nav>
							</div>
						</div>
					</div>
				</div>
				<!-- ============================================================== -->
				<!-- End Bread crumb and right sidebar toggle -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- Container fluid  -->
				<!-- ============================================================== -->
				<div style="height: 80px">
						<div class="card-body">
				           <!-- <h5 class="card-title m-b-0">Static Table With Checkboxes</h5> -->
							<!-- ==============================================================-->
							<!-- Start Search Content -->
							<!-- ==============================================================-->						   
							<div    class="form-row"  style="margin: 0.3125rem 0;">							   							   
								<form class="form-inline navbar-form navbar-left" method="post" action="schedule/list">						   							   		
									<!-- 搜索框 -->
									<div class="input-group" style="margin-right: 0.3125rem;">
										<input type="text" id="title" name="title" class="form-control" placeholder="请输入标题查询" >
									</div>
									<!-- 下拉列表搜索 -->
									<div class="input-group" style="margin-right: 0.3125rem;">
										<select class="form-control" id="state"  name="state" >
											<option value="0">==选择状态==</option>
											<option value="1">未完成</option>
											<option value="2">完成</option>
											<option value="3">进行中</option>
										</select>
									</div>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<!-- 搜索框 -->
									<div class="input-group" style="margin-right: 0.3125rem;">
										<span style="margin-top: 10px">日程时间 : </span>&nbsp;
										<input type="date" id="begintime" name="begintime"  class="form-control" >
									</div>
									<div class="input-group" style="margin-right: 0.3125rem;">
										<span style="margin-top: 10px"> 至 </span>&nbsp;
										<input type="date" id="endtime" name="endtime"  class="form-control" >
									</div>
									&nbsp;&nbsp;
									<input id="empid" type="hidden" value="${emp.empId }">
			<!-- 隐藏控件存放项目名 -->
			<input type="hidden" value="oa" id="projectName">
						   <!-- 按钮和超链接 -->
						   <div class="input-group" style="margin-right: 0.3125rem;">
						   	<span class="input-group-btn">
								<button type="button" onclick="init()" class="btn btn-success">查询</button>
							</span>	
						   	<span class="input-group-btn">
								<a href="schedule/append" class="btn btn-primary" style="margin-left: 5px;">添加</a>
							</span>
						   </div>	
						   </form>
						</div>
						<!-- ==============================================================-->
						<!-- end Search Content -->
						<!-- ==============================================================-->						   
				    </div>
					   
				   <div class="table-responsive">
					<!-- ============================================================== -->
					<!-- end Tables Content -->
					<!-- ============================================================== -->	
				   </div>
				</div>
				<!-- ============================================================== -->
				<!-- Start Calender  -->
				<!-- ============================================================== -->
				<div class="card-body">
					<div class="row">
						<div class="col-md-12">
							<h5 class="card-title">Calender日历</h5>
							<div class="card">
								<div class="col-md-12">
									<div class="card-body b-l calender-sidebar">
										<div id="calendar"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- ============================================================== -->
					<!-- end Calender -->
					<!-- ============================================================== -->
				</div>
				<!-- ============================================================== -->
				<!-- End Container fluid  -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- footer -->
				<!-- ============================================================== -->
				<jsp:include page="../share/footer.jsp"></jsp:include>
				<!-- ============================================================== -->
				<!-- End footer -->
				<!-- ============================================================== -->
			</div>
			<!-- ============================================================== -->
			<!-- End Page wrapper  -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Wrapper -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- All Jquery -->
		<!-- ============================================================== -->
		<%@include file="../share/resources_js.jsp" %>		
		<!-- this calendar js -->
		<script src="resources/assets/libs/moment/min/moment.min.js"></script>
		<script src="resources/assets/libs/fullcalendar/dist/fullcalendar.min.js"></script>
		<!-- <script src="resources/dist/js/pages/calendar/cal-init.js"></script> -->
		<script src="resources/assets/libs/fullcalendar/dist/locale/zh-cn.js"></script>
		<script src="resources/dist/js/schedule_js.js"></script>

	</body>

</html>
    