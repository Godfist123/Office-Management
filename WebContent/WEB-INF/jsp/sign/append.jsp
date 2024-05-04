<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> --%>

<!-- 获取系统时间必须导入的  -->
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>


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
                        <h4 class="page-title">用户考勤</h4>
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
                                <form class="form-horizontal" method="post" action="sign/append">
                                
<%--                                 	<jsp:useBean id="now" class="java.util.Date" scope="page"></jsp:useBean> --%>
<%--                                 	<fmt:formatDate value="${now }" pattern="yyyy年MM月dd日  hh:mm:ss"/> --%>
                                	
                                	<!-- 当前时间 -->
                                    <h5 class="card-title" id="clock"></h5>
                                    
                                 	 <!-- 隐藏控件 -->
                                    <input type="hidden" id="signtime" name="signtime">
                                    <input type="hidden" id="signtag" value="${signtag }">
                                    <input type="hidden" id="empid" value="${emp.empId }">
                                    
                                    <div style="height: 30px"></div>
                                    <div class="form-group row">
                                        <label for="fname" class="col-sm-3 text-right control-label col-form-label"></label>
                                        <div class="col-sm-8">
                                          
											<button type="submit" id="signIn" class="btn btn-info btn-lg" style="background-color:#075279;width: 110px;height: 50px;font-size: 20px">签到</button>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<button type="button" id="signout" class="btn btn-info btn-lg" style="background-color:#4d6234;width: 110px;height: 50px;font-size: 20px ">签退</button>
                                        </div>
                                    </div>
                                    <div style="height: 20px"></div>
									<div class="form-group row">
										<label id="signIn" for="cono1" class="col-sm-3 text-right control-label col-form-label">签到备注</label>
										<div class="col-sm-6">
											<textarea class="form-control" rows="6" cols="8" name="signdesc" id="signdesc"  placeholder="输入备注"></textarea>
										</div>
									</div>	
										<h4 class="card-title  border-top">用户信息</h4>
										<div class="form-group row" >
										    <label for="fname" class="col-sm-3 text-right control-label col-form-label"></label>
										    <div class="col-sm-4" id=hide>
												<input type="text" class="form-control" style="border: none;" value="姓名 : ${emp.empName }"> <br>
												<input type="text" class="form-control" style="border: none;" value="性别 :${emp.gender }"><br>
										        <input type="text" class="form-control" style="border: none;" value="电话 : ${emp.tel }">
										</div>
									</div>
								</form>
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
	
			//页面加载事件
			$(function() {
				
				$("#hide").hide();
				
				if($("#signtag").val()==1){
					//当天已经签到时,签到不可按
					$("#signIn").prop("disabled",true);
				}else if($("#signtag").val()==2){
					//当天已经签退时,签到.签退都不可按
					$("#signout").prop("disabled",true);
					$("#signIn").prop("disabled",true);
				}else{
					//当天没签到和签退时,签到可按,签退不可按
					$("#signout").prop("disabled",true);
					$("#signIn").prop("disabled",false);
				}
			})
			
			//签到按钮
			$("#signIn").click(function() {
				
				//签到不可按
				$(this).prop("disabled",true);
				//签退可按
				$("#signout").prop("disabled",false);
				//个人信息显示
				$("#hide").show();
				
				var param={
						
						"signtime":$("#signtime").val(),
						"signdesc":$("#signdesc").val()
				}
				
				$.post("${pageContext.request.contextPath}/sign/signin",param,function(){
					
				},"json")
					
			})
			
			//签退按钮
			$("#signout").click(function() {
				
				$(this).prop("disabled",true);
				$("#signIn").prop("disabled",true);
				
				
				var param={
						
						"signtime":$("#signtime").val(),
						"empid":$("#empid").val(),
						"signdesc":$("#signdesc").val()
				}
				
				$.post("${pageContext.request.contextPath}/sign/signout",param,function(){

				},"json")
			})
			
			//获取系统当前时间
			function systemTime(clock) {
				
				var now=new Date(); //创建Date对象
				var year=now.getFullYear(); //获取年份
				var month=now.getMonth(); //获取月份
				var date=now.getDate(); //获取日期
				var day=now.getDay(); //获取星期
				var hour=now.getHours()<10?'0'+now.getHours():now.getHours(); //获取小时
				var minu=now.getMinutes()<10?'0'+now.getMinutes():now.getMinutes(); //获取分钟
				var sec=now.getSeconds()<10?'0'+now.getSeconds():now.getSeconds(); //获取秒钟
				
				month=month+1;
				
				var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
				var week=arr_week[day]; //获取中文的星期
				
				var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec; //组合系统时间
				clock.innerHTML=time; //显示系统时间
				
				$("#signtime").val(year+"-"+month+"-"+date);//给表示签到时间的隐藏控件赋值
				}
		
			//实时更新时间
			window.onload=function(){
				
				window.setInterval("systemTime(clock)",100); //实时获取并显示系统时间
			}
			
	    </script>
</body>

</html>