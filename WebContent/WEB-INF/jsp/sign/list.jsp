<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html dir="ltr" lang="en">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!-- Tell the browser to be responsive to screen width -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>办公自动化系统</title>
		<!-- Custom CSS -->
	    <jsp:include page="../share/resources_css.jsp"></jsp:include>
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
       <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
       <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
   <![endif]-->
	</head>

	<body>

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
							<h4 class="page-title">考勤统计</h4>
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
				<div class="container-fluid">
					<!-- ============================================================== -->
					<!-- Start Page Content -->
					<!-- ============================================================== -->
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								
									<div class="card-body">
									<div    class="form-row"  style="margin: 0.3125rem 0;">
											<form  class="form-inline navbar-form navbar-left" action="sign/list">						   							   		
											
												<!-- 起始时间 -->
											   <span>开始时间</span><div class="input-group" style="margin-right: 0.3125rem;">
												<input type="date" class="form-control" name="begintime" value="${sign.begintime }">
											   </div>
												<!-- 终止时间 -->
											    <span>结束时间</span><div class="input-group" style="margin-right: 0.3125rem;">
												<input type="date" class="form-control" name="endtime" value="${sign.endtime }">									   							   		
											   </div>
												<!-- 下拉列表 -->
									   			<div class="input-group" style="margin-right: 0.3125rem;">
													<select class="form-control" name="departid">									   							   		
														<option value="0">==选择部门==</option>
														<c:forEach items="${listDepart }" var="depart">								   							   		
															<option value="${depart.departId }">${depart.departName }</option>						   							   		
														</c:forEach>	
													</select>
												</div>
												<!-- 终止时间 -->
												<div class="input-group" style="margin-right: 0.3125rem;">
													<input type="text" class="form-control" name="empname" value="${sign.empname }" placeholder="请输入输入姓名查询">									   							   		
												</div>
									   <!-- 按钮和超链接 -->
									   <div class="input-group" style="margin-right: 0.3125rem;">
										   	<span class="input-group-btn">
												<button type="submit" class="btn  btn-success">查询</button>
											</span>									   							   
									   </div>									   							   	
									   </form>
									</div>
									
									<div style="height: 20px"></div>
										<div class="table-responsive">
										<!-- ============================================================== -->
										<!-- end Tables Content -->
										<!-- ============================================================== -->										   							
										   <table id="zero_config" class="table  table-bordered table-hover">
											   <thead class="thead-light">
												   <tr>
													  <th scope="col">编号</th>
													  <th scope="col">员工名称</th>
													  <th scope="col">部门名称</th>
													  <th scope="col">出勤情况</th>
													  <th scope="col">操作</th>
												   </tr>
											   </thead>
											   <tbody class="customtable">
											   	<c:forEach items="${pages.list }" var="sign" varStatus="vs">
													  <tr>
														<td>${vs.count }</td>
														<td>${sign.empname }</td>
														<td>${sign.departname }</td>
														<td>
															<div>出勤率:<span>${dayCount/sub*100}</span>%</div>
															<div>应出勤:${sub }天</div>
															<div>实出勤:${dayCount }天</div>
														</td>
														<td>
															<a href="sign/detail?empid=${sign.empid }">查看详情</a>
														</td>
													  </tr>
												</c:forEach>
											   </tbody>
											   <tfoot>
													<tr>
												   		<td colspan="10">
												   			<div style="float: right;">
												   				<ul class="pagination">
																	<li class="page-item active"><a class="page-link" href="#">当前页/总页数: ${pages.currPage }/${pages.pages }</a></li>
												   					<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/sign/list?currPage=${pages.first }&empname=${sign.empname}&departid=${sign.departid }&begintime=${sign.begintime}&endtime=${sign.endtime}">首页</a></li>
												   					<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/sign/list?currPage=${pages.pre }&empname=${sign.empname}&departid=${sign.departid }&begintime=${sign.begintime}&endtime=${sign.endtime}">上一页</a></li>
												   					<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/sign/list?currPage=${pages.next }&empname=${sign.empname}&departid=${sign.departid }&begintime=${sign.begintime}&endtime=${sign.endtime}">下一页</a></li>
																	<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/sign/list?currPage=${pages.last }&empname=${sign.empname}&departid=${sign.departid }&begintime=${sign.begintime}&endtime=${sign.endtime}">末页</a></li>
												   				</ul>
												   			</div>
												   		</td>
												   	</tr>
											   </tfoot>
										   </table>
										   
								   <!-- ============================================================== -->
									<!-- end Tables Content -->
									<!-- ============================================================== -->										   							
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- ============================================================== -->
				<!-- End PAge Content -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- Right sidebar -->
				<!-- ============================================================== -->
				<!-- .right-sidebar -->
				<!-- ============================================================== -->
				<!-- End Right sidebar -->
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
		<!-- Bootstrap tether Core JavaScript -->
		<jsp:include page="../share/resources_js.jsp"></jsp:include>

		<script>
		
			// 解决文件域不显示上传文件名称的
			function showFilename(file) {
				$("#filename_label").html(file.name);
			}
			
			//下拉列表定值
			$("select[name=departid]").val("${sign.departid}");
			
		</script>
	</body>

</html>
