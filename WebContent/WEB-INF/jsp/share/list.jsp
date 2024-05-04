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
	
	    <title>酒店系统</title>
	    <jsp:include page="../share/resources_css.jsp"></jsp:include>
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
	        <jsp:include page="../share/head.jsp"></jsp:include>
	        <!-- ============================================================== -->
	        <!-- End Topbar header -->
	        <!-- ============================================================== -->
	        <!-- ============================================================== -->
	        <!-- Left Sidebar - style you can find in sidebar.scss  -->
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
						<h4 class="page-title">就得信息</h4>
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
				<div class="row">
				    <div class="col-12">        
							<div class="card">
								<div class="card-body">
						           <!-- <h5 class="card-title m-b-0">Static Table With Checkboxes</h5> -->
									<!-- ==============================================================-->
									<!-- Start Search Content -->
									<!-- ==============================================================-->						   
									<div    class="form-row"  style="margin: 0.3125rem 0;">							   							   
										<form class="form-inline navbar-form navbar-left">						   							   		
											<!-- 搜索框 -->
											<div class="input-group" style="margin-right: 0.3125rem;">
												<input type="text" class="form-control" placeholder="输入用户名查询" >
											</div>
								   <!-- 按钮和超链接 -->
								   <div class="input-group" style="margin-right: 0.3125rem;">
								   	<span class="input-group-btn">
										<button type="submit" class="btn  btn-success">查询</button>
									</span>									   							   
								   	<span class="input-group-btn">
										<a href="/hotel/users/append.jsp"  class="btn btn-primary" style="margin-left: 5px;">添加</a>
									</span>
								   	<span class="input-group-btn">
										<a href="#" class="btn btn-danger" style="margin-left: 5px;" onclick="deleteAll()">批量删除</a>
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
							   <table id="zero_config" class="table  table-bordered table-hover">
								   <thead class="thead-light">
									   <tr>
										   <th>
											   <label class="customcheckbox m-b-20">
												   <input type="checkbox" id="mainCheckbox" />
												   <span class="checkmark"></span>
											   </label>
										   </th>
										  <th scope="col">编号</th>
										  <th scope="col">添加时间</th>
										  <th scope="col">用户名称</th>
										  <th scope="col">用户密码</th>
										  <th scope="col">用户状态</th>
										  <th scope="col">密保问题</th>
										  <th scope="col">答案</th>
										  <th scope="col">操作</th>
									   </tr>
								   </thead>
								   <tbody class="customtable">

								   		  <tr>
											<th>	
												<label class="customcheckbox">
													<input type="checkbox" class="listCheckbox"/>
													<span class="checkmark"></span>
												</label>
											</th>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>
												<a href="#">删除</a>
												<a href="#">修改</a>
											</td>
										  </tr>
	
								   </tbody>
								   <tfoot>
								   	<tr>
								   		<td colspan="9">
								   			<div style="float: right;" >
								   				<ul class="pagination">
													<li class="page-item active"><a class="page-link" href="#">当前页/总页数: ${pages.currPage }/${pages.pages }</a></li>
								   					<li class="page-item"><a class="page-link" href="/hotel/users/list?currPage=${pages.first }">首页</a></li>
								   					<li class="page-item"><a class="page-link" href="/hotel/users/list?currPage=${pages.pre }">上一页</a></li>
								   					<li class="page-item"><a class="page-link" href="/hotel/users/list?currPage=${pages.next }">下一页</a></li>
													<li class="page-item"><a class="page-link" href="/hotel/users/list?currPage=${pages.last }">末页</a></li>
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
	<jsp:include page="../share/resources_js.jsp"></jsp:include>
	
</body>

</html>
    