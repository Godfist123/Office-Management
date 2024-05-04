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
						
						<!-- 未提交才能修改 -->
							<c:if test="${expense.state eq 1 }">
								<h4 class="page-title">报销单详情-修改</h4>
							</c:if>
							<c:if test="${expense.state ne 1 }">
								<h4 class="page-title">报销单详情</h4>
							</c:if>
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
									<form class="form-horizontal" method="post" action="expense/modify" onsubmit="return check()">
										<table id="master" class="table">
											<thead class="thead-light">
												<tr>
													<th>填报人</th>
													<th>填报时间</th>
													<th>事由</th>
													<th>总金额</th>
													<th>状态</th>
													<th>审批人</th>
												</tr>
											</thead>
											<tbody class="customtable" id="tbody">
												<tr>
													<td>${expense.empname }</td>
													<td>
														<input id="addtime" name="addtime" value="${datetime }" style="border: none" readonly="readonly">
													</td>
													<td>
														<input id="reason" name="reason" value="${expense.reason }" class="form-control col-md-8">
													</td>
													<td>
														<input name="total" readonly="readonly" value="${expense.total }" style="border: none">
														<!-- 隐藏控件 -->
														<input type="hidden" name="expenseid" value="${expense.expenseid}">
														<input type="hidden" id="confirmperson" value="${expense.confirmperson}">
														<input type="hidden" name="state" value="${expense.state}">
													</td>
													<td>${expense.state==1?'未提交':expense.state==2?'已提交':'已审批'}</td>
													<td>
														<select class="form-control col-md-8" name='confirmperson'>
															<option value='0'>==请选择==</option>
															<c:forEach items='${listEmployee}' var='leader'>
																<option value='${leader.empId}'>${leader.empName}</option>
															</c:forEach>			
														</select>
													</td>
												</tr>
										
											</tbody>
											
											<tfoot>
												<tr>
													<!-- 未提交才能修改 -->
													<c:if test="${expense.state eq 1 }">
														<td colspan="6">
															<button type="button" id="row"  class="btn btn-danger" style="background-color: #ca6307;border: none">新增一项</button>
														</td>
													</c:if>
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
													<th scope="col"></th>
													
												<!-- 隐藏控件 -->
													<c:forEach items="${listdetail}" var="exid" varStatus="vs">
														<input type="hidden" id="exid${vs.count }" value="${exid.extypeid}">
													</c:forEach>													
												</tr>
												
											</thead>
											
											<tbody>
												<c:forEach items="${listdetail}" var="detail" varStatus="vs">
													<tr id="row${vs.count }" detailid=${detail.id }>
															<td>${vs.count }</td>
														<td>
															<div id="select${vs.count }">
																<select class="form-control col-md-8" name="extypeid">
																	<option value='0'>==请选择==</option>
																	<c:forEach items="${listExType}" var="extype">
																		<option value="${extype.extypeid}">${extype.extypename}</option>
																	</c:forEach>			
																</select>
															</div>
															
<%-- 															<input type="hidden" name="extypeid" value="${detail.extypeid}"> --%>
															<input type="hidden" name="id" id="id" value="${detail.id}">
															
														</td>
														<td>
															<div class="row">
																<input type="text" onchange="moneys()" id="money" name="money" value="${detail.money }" class="form-control col-md-6">
															</div>
														</td>
														<td>
															<div class="row">
																<input type="text" id="costdesc" name="costdesc" value="${detail.costdesc}" class="form-control col-md-6">
															</div>
														</td>
														<td>
															<!-- 未提交才能删除 -->
															<c:if test="${expense.state eq 1 }">
																<div class="row">
																	<button type="button" class="btn btn-danger"  id="delete" onclick='deleteRow(${vs.count})'>删除</button>
																</div>
															</c:if>
														</td>
													</tr>		
												</c:forEach>
												
											</tbody>
											
											<tfoot>
											</tfoot>
										
										</table>
								<div class="card-body">
									<c:if test="${expense.state eq 1 }">
							      	   <button type="submit" id="modify" class="btn btn-success" style="background-color: #609e9b">保存</button>
							      	</c:if>
							       <a href="javascript:;" onclick="history.go(-1)" class="btn btn-success" style="background-color: #355a6d">返回</a>
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
			$("#tbody td:nth-child(1),#tbody td:nth-child(2),#tbody td:nth-child(4),#tbody td:nth-child(5)").css("padding-top", "25px");
			
			//审批人下拉列表定值
			$("select[name=confirmperson]").val($("#confirmperson").val());  
			//报销类型下拉列表定值
			for(var i=1;i<=$("select[name=extypeid]").length;i++){
				var exid=$("#exid"+i).val();
				$("#select"+i+" select[name=extypeid]").val(exid);
			}
			
			//已提交的文本框,下拉列表属性为不能更改
			if($("input[name=state]").val()!=1){
				
				$("#addtime,#confirmperson").attr("disabled","disabled");
				$("input[name=extypeid]").each(function() {
					$(this).attr("disabled","disabled")
				})
				$("#reason,#money,#costdesc").attr("readonly","readonly");
			}
			
			
			//计算总金额
			function moneys() {
				
				var cash=0;
				$("input[name=money]").each(function() {
					cash+=parseInt($(this).val());
				})
				
				$("input[name=total]").val(cash);
			}
			
			//删除一行
			function deleteRow(num){
				
				var id=$("#row"+num).attr("detailid");
				if(confirm("确定删除吗")){
					
					//界面上移除一条
					$("#row"+num).remove();
					//删除数据
					$.get("/oa/expense/removedetail/"+id,function(data){});
				}
				//计算总金额
				moneys();
			}
			
	
			//提交验证
			function check() {
				
				for(var i=0;i<=$("input[name=money]").length;i++ ){
					
					if($("select[name=confirmperson]").val()=="0"){
						
						alert("请选择审批人!");
						return false;
					}
					
					if($("#select"+(i+1)+" select").val()=="0"){
						
						alert("请选择序号"+(i+1)+"的费用类别!");
						return false;
					}
						
					if($("input[name=money]").eq(i).val()=="0"||$("input[name=money]").eq(i).val()==""){
						
						alert("请填写序号"+(i+1)+"的费用金额!");
						return false;
					}
					
					if($("input[name=costdesc]")[i].value==""){
									
						alert("请填写序号"+(i+1)+"的费用说明!");
						return false;
					}
	
					//报销详情条数
					var number=$("input[name=money]").length;
					//报销详情至少有一条
					if(number=="0"){
						alert("请添加报销详情!");
						return false;
					}
				}
			}
			
			//添加一行
			$("#row").click(function(){
				
				//原有的记录数量
				var id=$("select[name=extypeid]").length;
				//记录数量自增
				id=id+1;
				
				var tr="<tr id='row"+id+"'>";
					tr+="<td>"+id+"</td>";
					tr+="<td>";
					tr+="<div class=\"row\" id='select"+id+"'>";
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
					// console.log(tr)
					$("#detail tbody").append(tr);
					
					//计算总金额
					moneys();
			});
		
		</script>

	</body>

</html>
