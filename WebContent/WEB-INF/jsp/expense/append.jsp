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

		<!-- ============================================================== -->
		<!-- Main wrapper - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<div id="main-wrapper">
			<!-- ============================================================== -->
			<!-- Topbar header - style you can find in pages.scss -->
			<!-- ============================================================== -->
          	<jsp:include page="../share/head.jsp"></jsp:include>
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
							<h4 class="page-title">报销单填写</h4>
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


								<div class="table-responsive">
									<!-- ============================================================== -->
									<!-- end Tables Content -->
									<!-- ============================================================== -->
									<form class="form-horizontal" method="post" action="expense/append" onsubmit="return check()">
										<table id="master" class="table">
											<thead class="thead-light">
												<tr>
													<th>填报人</th>
													<th>填报时间</th>
													<th>总金额</th>
													<th>状态</th>
													<th>审批人</th>
												</tr>
											</thead>
											<tbody class="customtable" id="tbody">
												<tr>
													<td>${emp.empName }</td>
													<td id="clock">
														<input name="addtime" type="text" readonly="readonly" style="border: none" value="${datetime }">
													</td>
													<td>
														<input name="total" type="text" readonly="readonly" style="border: none" value="0">
													</td>
													<td>新创建</td>
													<td>
													<div class="row">
														<select class="form-control col-md-8" id="selectManager" name="confirmperson">
															<option value="0">==选择审批人==</option>
															<c:forEach items="${listEmployee }" var="employee">
																<option value="${employee.empId }">${employee.empName }</option>
															</c:forEach>
														</select>
													</div>
													</td>
												</tr>
										
											</tbody>
											<tfoot>
												<tr>
													<td colspan="5">
														<button type="button" id="row"  class="btn btn-danger" style="background-color: #ca6307;border: none">新增一项</button>
													</td>
												</tr>
											</tfoot>
										</table>

										<table id="detail" class="table">
											<thead class="thead-light">
												<tr>
													<th>序号</th>
													<th scope="col">费用类别</th>
													<th scope="col">费用金额</th>
													<th scope="col">费用说明</th>
													<th scope="col">操作</th>
												</tr>
											</thead>
											
											<tbody>
											
											</tbody>
										
										</table>
							<div class="border-top">
								<label for="cono1" class="col-sm-3 text-left control-label col-form-label">事由</label>
								<div class="col-sm-12">
									<textarea class="form-control" name="reason" style="height: 100px;" placeholder="输入内容"></textarea>
								</div>
							</div>
							<!-- 隐藏控件 -->
								<input type="hidden" id="start" value="1">
							    <div class="card-body">
							       <button type="submit" class="btn btn-secondary" style="background-color: #609e9b;border: none">保存</button>
							       <button type="reset" class="btn btn-info" style="background-color: #355a6d;border: none">重置</button>
							    </div>
							
							

							</form>
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
		<!-- All Jquery -->
		<!-- ============================================================== -->
		<jsp:include page="../share/resources_js.jsp"></jsp:include>
	
		<script>
		
			//td和input对齐
			$("#tbody td:not(:last-child)").css("padding-top", "25px");
		
			//添加一行
			//给id=row注册点击事件
			$("#row").click(function(){
				//
				//得到id=start 的value属性的值
				var id=$("#start").val();
				//给id=start的value重新赋值
				$("#start").val(parseInt(id)+1)
				var tr="<tr id='row"+id+"'>";
					tr+="<td>"+id+"</td>";
					tr+="<td>";
					tr+="<div class=\"row\">";
					tr+="		<select class=\"form-control col-md-8\" name='extypeid'>";
					tr+="			<option value='0'>==请选择==</option>";
					tr+="			<c:forEach items='${listExType}' var='extype'>";
					tr+="				<option value='${extype.extypeid}'>${extype.extypename}</option>";
					tr+="			</c:forEach>";				
					tr+="		</select>";
					tr+="	</div>";
					tr+="</td>";
					tr+="<td>";
					tr+="	<div class='row'>";
					tr+="		<input name='money' onchange='moneys()' value='0' type=\"text\" class=\"form-control col-md-6\" placeholder=\"请输入金额...\">";
					tr+="	</div>";
					tr+="</td>";
					tr+="<td>";
					tr+="	<div class=\"row\">";
					tr+="		<input name='costdesc' type=\"text\" class=\"form-control col-md-6\" placeholder=\"请输入说明...\">";
					tr+="	</div>";
					tr+="</td>";
					tr+="<td>";
					tr+="	<div class=\"row\">";
					tr+="		<button type=\"button\" class=\"btn btn-danger\" id='delete' onclick='deleteRow("+id+")'>删除</button>";
					tr+="	</div>";
					tr+="</td>";
					tr+="</tr>";
					//把tr添加到id=detail表格中
					//console.log(tr)
					$("#detail tbody").append(tr);
			});
			
			//删除一行
			function deleteRow(id){
				
				if(confirm("确定删除吗")){
					
					$("#row"+id).remove();
				}
				moneys();
			}
			
			//计算总金额
			function moneys() {
				
				var cash=0;
				$("input[name=money]").each(function() {
					cash+=parseInt($(this).val());
				})
				
				$("input[name=total]").val(cash);
			}
			
			
			//提交验证
			function check() {
				
				if($("#selectManager").val()=="0"){
					
					alert("请选择审批人!");
					return false;
				}
				
				for (var i = 0; i < $("select[name=extypeid]").length; i++) {
					
					if($("select[name=extypeid]")[i].value=="0"){
						
						alert("请选择序号"+(i+1)+"的费用类别!");
						return false;
					}
					
					if($("input[name=costdesc]")[i].value==""){
						
						alert("请填写序号"+(i+1)+"的费用说明!");
						return false;
					}
					
					if($("input[name=money]").eq(i).val()=="0"||$("input[name=money]").eq(i).val()==""){
						
						alert("请填写序号"+(i+1)+"的费用金额!");
						return false;
					}
				}
				
				//报销详情条数
				var number=$("input[name=money]").length;
				//报销详情至少有一条
				if(number=="0"){
					alert("请添加报销详情!");
					return false;
				}
			}
			
		</script>

	</body>

</html>
