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
                        <h4 class="page-title">个人中心</h4>
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
            <!-- Start Page Content -->
            <!-- ============================================================== -->
                <div class="row">
                    <!-- column -->
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="comment-widgets scrollable">
                                <!-- Comment Row -->
                                <div class="d-flex flex-row comment-row m-t-0">
                                    <div class="p-2"><img src="resources/assets/images/users/d3.jpg" alt="user" width="70" class="rounded-circle"></div>
                                    <div class="comment-text w-100">
                                    <table id="zero_config"  style="width: 220px;height: 250px;font-size: 20px;margin-left: 10px;margin-top: 40px;">
										  <tr>
									  	   	  <td>用户名称：</td>
										   	  <td>${emp.loginName }</td>
										  </tr>
										  <tr>
									  		  <td>用户密码：</td>
										   	  <td>${emp.password }</td>
										  </tr>
										  <tr>
									  		  <td>用户状态：</td>
										   	  <td>${emp.state==1?'正常':'加锁' }</td>
										  </tr>
									</table>
<%-- 									<c:if test="${emp.state==1 }"> --%>
<!-- 										<a href="employee/updateState"  class="btn btn-info"  style="margin-left: 6px;background-color:#609e9b;border: none">加锁</a> -->
<%-- 									</c:if> --%>
<%-- 									<c:if test="${emp.state==2 }"> --%>
<!-- 										<a href="employee/updateState"  class="btn btn-info"  style="margin-left: 6px;background-color:#609e9b;border: none">启用</a> -->
<%-- 									</c:if> --%>
									
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
             <!-- ============================================================== -->
             <!-- End PAge Content -->
             <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
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
		<jsp:include page="../share/resources_js.jsp"></jsp:include>
    <script>

        var quill = new Quill('#editor', {
            theme: 'snow'
        });
		
		// 解决文件域不显示上传文件名称的
		function showFilename(file){
		    $("#filename_label").html(file.name);
		}
	
    </script>
</body>

</html>