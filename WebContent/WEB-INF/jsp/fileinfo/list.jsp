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
						<h4 class="page-title">文件管理</h4>
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
										<form class="form-inline navbar-form navbar-left" method="post" action="fileinfo/list">						   							   		
											<!-- 搜索框 -->
											<div class="input-group" style="margin-right: 0.3125rem;">
												<input type="text" name="filename" value="${fileinfo.filename }" class="form-control" placeholder="请输入文件名查询" >
											</div>
											<!-- 下拉列表搜索 -->
											<div class="input-group" style="margin-right: 0.3125rem;">
												<select class="form-control"  name="departname" >
													<option selected="selected" value="">==选择上传部门==</option>
													<c:forEach items="${departInfo.list }" var="departinfo">
														<option >${departinfo.departName}</option>
													</c:forEach>
												</select>
											</div>
											<!-- 搜索框 -->
											<div class="input-group" style="margin-right: 0.3125rem;">
												<input type="text" name="empname" value="${fileinfo.empname }" class="form-control" placeholder="请输入上传员工姓名查询" >
											</div>
								   <!-- 按钮和超链接 -->
								   <div class="input-group" style="margin-right: 0.3125rem;">
								   	<span class="input-group-btn">
										<button type="submit" class="btn  btn-success">查询</button>
									</span>									   							   
								   	<span class="input-group-btn">
										<a href="fileinfo/append" class="btn btn-primary" style="margin-left: 5px;">添加</a>
									</span>
								   	<span class="input-group-btn">
										<a href="javascript:;" class="btn btn-danger" id="deleteAll" style="margin-left: 5px;">批量删除</a>
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
										  <th scope="col">上传时间</th>
										  <th scope="col">文件信息</th>
										  <th scope="col">文件大小</th>
										  <th scope="col">下载次数</th>
										  <th scope="col">操作</th>
									   </tr>
								   </thead>
								   <tbody class="customtable">
										<c:forEach items="${pages.list }" var="fileinfo" varStatus="vs">
								   		  <tr>
											<th>	
												<label class="customcheckbox">
													<input type="checkbox" class="listCheckbox" value="${fileinfo.fileid }"/>
													<span class="checkmark"></span>
												</label>
											</th>
											<td>${vs.count+(pages.currPage-1)*pages.pageSize  }</td>
											<td>${fileinfo.posttime }</td>
											<td>
												<div>文件名称：${fileinfo.filename }</div>
												<div>文件介绍：${fileinfo.filedesc }</div>
												<div>上传员工：${fileinfo.departname }  [ ${fileinfo.empname } ]</div>
											</td>
											<td>${fileinfo.filesize<1?1.0:fileinfo.filesize }k</td>
											<td id="count">${fileinfo.count }</td>
											<td>
												<a href="javascript:;" onclick="deleteRow(${fileinfo.fileid })">删除</a>
												
										   <%-- <a href="upload/${fileinfo.fileurl }">下载1</a>&nbsp;&nbsp;&nbsp;&nbsp; --%>
												<a href="fileinfo/detail?fileid=${fileinfo.fileid }"  style="font-size: 17px;margin-left: 20px">下载</a>
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
								   					<li class="page-item"><a class="page-link" href="fileinfo/list?currPage=${pages.first }&filename=${fileinfo.filename }&empname=${fileinfo.empname}&departname=${fileinfo.departname}">首页</a></li>
								   					<li class="page-item"><a class="page-link" href="fileinfo/list?currPage=${pages.pre }&filename=${fileinfo.filename }&empname=${fileinfo.empname}&departname=${fileinfo.departname}">上一页</a></li>
								   					<li class="page-item"><a class="page-link" href="fileinfo/list?currPage=${pages.next }&filename=${fileinfo.filename }&empname=${fileinfo.empname}&departname=${fileinfo.departname}">下一页</a></li>
													<li class="page-item"><a class="page-link" href="fileinfo/list?currPage=${pages.last }&filename=${fileinfo.filename }&empname=${fileinfo.empname}&departname=${fileinfo.departname}">末页</a></li>
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
	<script>
	
		//定住搜索下拉列表的值
		$("select[name=departname]").val("${fileinfo.departname}");
		
		//下载次数增加
		function appendCount(fileid,count) {
			
			location.href="fileinfo/modify?fileid="+fileid+"&count="+count;
		}
	
		//删除一条记录
		function deleteRow(fileid) {
			
			if(confirm("确定删除吗")){
				
				location.href="fileinfo/remove?fileid="+fileid;
				
			}
		}
	
		//全选全不选
		$("#mainCheckbox").click(function() {
			
			$(".listCheckbox").prop("checked",$(this).prop("checked"))
			
		})
		
		//批量删除
		$("#deleteAll").click(function() {
			
			var fileids=new Array();
			
			$(".listCheckbox:checked").each(function() {
				
				fileids.push($(this).val());
			})
			
			if(fileids.length!=0){
				
				if(confirm("确认删除吗？")){
					location.href="fileinfo/removes?fileids="+fileids;
				}
			}else
				alert("请先选择要删除的信息！")
		})
		
	</script>
	
	
</body>

</html>
    