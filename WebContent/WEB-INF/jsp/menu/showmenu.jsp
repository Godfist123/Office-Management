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
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
	    <jsp:include page="../share/menu.jsp"></jsp:include>
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
                        <h4 class="page-title">权限分配</h4>
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
                <!-- Sales Cards  -->
                <!-- ============================================================== -->
                

                
                <!-- ============================================================== -->
                <!-- Sales chart -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Recent comment and chats -->
                <!-- ============================================================== -->
                <div class="row">
                    <!-- column -->
                    <div class="col-lg-12">
                        <div class="card">
                        
                            <div class="card-body">
								<div class="col-sm-3 form-inline">
								    <div class="custom-control custom-checkbox mr-sm-2" style="font-size: 18px">
								        <input type="checkbox" class="custom-control-input" id="customControlAutosizing11" name="allCheck">
								        <label class="custom-control-label text-danger" for="customControlAutosizing11">-全选/全不选-</label>
								    </div>
								</div>
                            </div>
                            	                        
 						<!--    begin     -->
							<!-- 上级 -->
							<c:forEach items="${list }" var="menu">							
	                        	<div class="form-group row  border-bottom">

	                                <!-- <label class="col-sm-3  text-lg-right text-danger control-label col-form-label">用户管理</label> -->
									<div class="col-sm-3 form-inline">
									    <div class="custom-control custom-checkbox mr-sm-2" style="margin-left: 30px;">
									    		<!-- checkRow(this)中的this表示当前元素 , 或者传  ${menu.menuid }也行-->
									        <input type="checkbox" class="custom-control-input" onclick="checkRow(this)" value="${menu.menuid }" name="c" id="c${menu.menuid }">
									        <label class="custom-control-label text-danger" for="c${menu.menuid }">-${menu.menuname }-</label>
									    </div>
									</div>
									
							<!-- 下级 -->	
	                                <div class="col-sm-9 form-inline">
									<c:forEach items="${menu.list }" var="son">	                                 
	                                     <div class="custom-control custom-checkbox mr-sm-2">
	                                         <input type="checkbox" class="custom-control-input" onclick="checkParent(this)" value="${son.menuid }" name="c${menu.menuid }" id="c${son.menuid }">
	                                         <label class="custom-control-label" for="c${son.menuid }">${son.menuname }</label>
	                                     </div>
	                                 </c:forEach>
	                                 </div>
	                        	 </div>
	                        </c:forEach>
						<!--   end    -->
									                           
							  <div class="comment-footer">
							      <button type="button" id="save" class="btn btn-success btn-sm">保存</button>
							      <button type="button" id="reset" class="btn btn-primary btn-sm">重置</button>
							      <a href="javascript:;" onclick="history.go(-1)" class="btn btn-danger btn-sm" >返回</a>
							  </div> 

	                   </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- Recent comment and chats -->
                <!-- ============================================================== -->
                <!-- 隐藏控件 -->
                <input type="hidden" id="empid" value="${empid }">
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
	<script type="text/javascript">
	
		//全选全不选
		$("#customControlAutosizing11").click(function() {
			
			$("input[name*=c]").prop("checked",$(this).prop("checked"));
			
		})
		 
		//选中一行
		//obj是传过来的当前input元素- dom对象
		//上级id的值=下级name的值
		function checkRow(obj) {
			
			var ck=$(obj).prop("checked");
			
			$("input[name="+obj.id+"]").prop("checked",ck);
			
			//如果有一个没选中,全选的框也不选中
			//都选中的话,全选框也选上
			if($("input[name^=c]:checked").length<$("input[name^=c]").length){
				
				$("#customControlAutosizing11").prop("checked",false);
			}else{
				$("#customControlAutosizing11").prop("checked",true);
			}
		}	
		
		//选中一行
		//上级id的值=下级name的值
		//function checkRow(menuid) {
					
		//	$("input[name=c"+menuid+"]").prop("checked",$("#c"+menuid+"").prop("checked"));
		//}
		
		//子菜单有一个选中时,父菜单也选中
		//子菜单有两个都取消选中时,父菜单取消选中
		//下级name的值就是上级id的值
		function checkParent(obj) {
			
			//var length=$("input[name="+obj.name+"]:checked").length;
			//$("#"+obj.name+"").prop("checked",length>0?true:false);
			
			if($("input[name="+obj.name+"]:checked").length>0){
				
				$("#"+obj.name+"").prop("checked",true);
			}else{
				
				$("#"+obj.name+"").prop("checked",false);
			}

			//如果有一个没选中,全选的框也不选中
			if($("input[name^=c]:checked").length<$("input[name^=c]").length){
				
				$("#customControlAutosizing11").prop("checked",false);
			}else{
				$("#customControlAutosizing11").prop("checked",true);
			}
		}
		
		//重置按钮
		$("#reset").click(function() {
			
			$("input[name*=c]").prop("checked",false);
		})
	
		//显示当前用户的权限,并选中
		$.get("${pageContext.request.contextPath}/menu/selectbyempid",{"empid":'${empid}'},function(data){
			
			$.each(data,function(index,obj) {
	
				$("input[name*=c]").each(function() {

					if($(this).val()==obj.menuid){
						
						$(this).prop("checked","checked");
					}
				})
			})
		},"json")
		
		//老师的方法
		//显示当前用户的权限,并选中
		//$.get("${pageContext.request.contextPath}/menu/selectbyempid",{"empid":'${empid}'},function(data){
					
		// 	$.each(data,function(index,obj) {
		
				//判断上级是否选中
		// 		$("input[name=c]").each(function() {
							
		// 			if($(this).val()==obj.menuid){
								
		// 				$(this).prop("checked","checked");
		// 			}
							
				//上级value/id=下级name   $(this).val() / $(this).attr("id")
		// 		//判断下级是否选中
		// 		$("input[name=c"+$(this).val()+"]").each(function() {
								
		// 			if($(this).val()==obj.menuid){
									
		// 				$(this).prop("checked","checked");	
		// 				}
		// 			})
		// 		})
		// 	 })
		// },"json")
		
		
		//保存权限
		$("#save").click(function() {
			
			var menuids=new Array();
			
			$("input[name^=c]:checked").each(function() {
				
				menuids.push($(this).val());
			})
			
			if(menuids.length==0){
				
				alert("请选择权限 !")
			}else{
				
				location.href="menu/updateUsersMenu?menuids="+menuids+"&empid="+$("#empid").val();
			}
		})
		
	
	</script>


</body>

</html>