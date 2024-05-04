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
	
	    <title>办公自动化系统</title>
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
						<h4 class="page-title">权限管理</h4>
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
										<form class="form-inline navbar-form navbar-left" method="get" action="${pageContext.request.contextPath}/employee/list">						   							   		
											<!-- 搜索框 -->
											<div class="input-group" style="margin-right: 0.3125rem;">
												<input type="text" name="empName" value="${employee.empName }" class="form-control" placeholder="请输入员工姓名查询" >
											</div>
											<!-- 搜索框 -->
											<div class="input-group" style="margin-right: 0.3125rem;">
												<input type="text" name="loginName" value="${employee.loginName }" class="form-control" placeholder="输入登录名查询" >
											</div>
											<!-- 下拉列表搜索 -->
											<div class="input-group" style="margin-right: 0.3125rem;">
												<select class="form-control"  name="departId" >
													<option value="0">==选择部门==</option>
													<c:forEach items="${departInfo }" var="departInfo">
														<option value="${departInfo.departId}">${departInfo.departName}</option>
													</c:forEach>
												</select>
											</div>
											<!-- 隐藏控件 -->
											<input type="hidden" id="departId" value="${employee.departId }">
											<input type="hidden" id="position" value="${employee.position }">
											<input type="hidden" id="state" value="${employee.state }">
											
											<div class="input-group" style="margin-right: 0.3125rem;">
												<select class="form-control"  name="position" >
													<option value="">==选择职位==</option>
													<c:forEach items="${employee2 }" var="employee2">
														<option value="${employee2.position}">${employee2.position}</option>
													</c:forEach>
												</select>
											</div>
											<div class="input-group" style="margin-right: 0.3125rem;">
												<select class="form-control"  name="state" >
													<option selected="selected" value="0">==选择状态==</option>
													<option value="1">正常</option>
													<option value="2">加锁</option>
												</select>
											</div>											
								   <!-- 按钮和超链接 -->
								   <div class="input-group" style="margin-right: 0.3125rem;">
								   	<span class="input-group-btn">
										<button type="submit" class="btn  btn-success">查询</button>
									</span>									   							   
								   	<span class="input-group-btn">
										<a href="employee/append" class="btn btn-primary" style="margin-left: 5px;">添加</a>
									</span>
								   	<span class="input-group-btn">
										<a href="javascript:;" id="deleteAll" class="btn btn-danger" style="margin-left: 5px;" >批量删除</a>
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
										  <th scope="col">照片</th>
										  <th scope="col">员工姓名</th>
										  <th scope="col">入职日期</th>
										  <th scope="col">个人信息</th>
										  <th scope="col">职务信息</th>
										  <th scope="col">操作</th>
									   </tr>
								   </thead>
								   <tbody class="customtable">
										<c:forEach items="${pages.list }" var="employee" varStatus="vs">
								   		  <tr>
											<th>	
												<label class="customcheckbox">
													<input type="checkbox" class="listCheckbox" value="${employee.empId }"/>
													<span class="checkmark"></span>
												</label>
											</th>
											<td>${vs.count+(pages.currPage-1)*pages.pageSize  }</td>
											<td>
												<img src="upload/${employee.picture }" style="width: 110px;height: 110px">
											
											</td>											
											<td>${employee.empName }</td>
											<td>${employee.hireDate }</td>
											<td>
												<div>性别 : ${employee.gender }</div>
												<div>生日 : ${employee.birthday }</div>
												<div>移动电话 : ${employee.mobile }</div>
												<div>家庭电话 : ${employee.familyTel }</div>
												<div>住址 : ${employee.address }</div>
												<div>备注:${employee.remark }</div>
											</td>
											<td>
												<div>登录名 : ${employee.loginName }</div>
												<div>密码: :${employee.password }</div>
												<div>部门 :${employee.departName }</div>
												<div>职位 :${employee.position }</div>
												<div>办公电话 : ${employee.tel }</div>
												<div>状态:<span style="color: red;font-weight: bold">${employee.state==1?'正常':'加锁' }</span></div>
											</td>
											<td>
												<a href="menu/showmenu?empid=${employee.empId }" style="font-size: 15px">分配权限</a>
											</td>
										  </tr>
									   </c:forEach>
								   </tbody>
								   <tfoot>
								   	<tr>
								   		<td colspan="8">
								   			<div style="float: right;">
								   				<ul class="pagination">
													<li class="page-item active"><a class="page-link" href="#">当前页/总页数: ${pages.currPage }/${pages.pages }</a></li>
								   					<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/menu/list?currPage=${pages.first }&empName=${employee.empName }&loginName=${employee.loginName }&position=${employee.position }&departId=${employee.departId }&state=${employee.state}">首页</a></li>
								   					<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/menu/list?currPage=${pages.pre }&empName=${employee.empName }&loginName=${employee.loginName }&position=${employee.position }&departId=${employee.departId }&state=${employee.state}">上一页</a></li>
								   					<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/menu/list?currPage=${pages.next }&empName=${employee.empName }&loginName=${employee.loginName }&position=${employee.position }&departId=${employee.departId }&state=${employee.state}">下一页</a></li>
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/menu/list?currPage=${pages.last }&empName=${employee.empName }&loginName=${employee.loginName }&position=${employee.position }&departId=${employee.departId }&state=${employee.state}">末页</a></li>
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
	<script src="resources/dist/js/menu_list_js.js"></script>
	
	
</body>

</html>
    