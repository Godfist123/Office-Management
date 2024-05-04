<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- 新增通用界面 -->
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
   <meta charset="utf-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <!-- Tell the browser to be responsive to screen width -->
       <meta name="viewport" content="width=device-width, initial-scale=1">
       <meta name="description" content="">
       <meta name="author" content="">
   
       <title>用户新增界面</title>
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
                        <h4 class="page-title">新增用户</h4>
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
                            <form class="form-horizontal">
                                <div class="card-body">
                                    <!-- <h4 class="card-title">用户信息</h4> -->
                                    <div class="form-group row">
                                        <label for="uname" class="col-sm-3 text-right control-label col-form-label">用户名称</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" placeholder="Name Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="uname" class="col-sm-3 text-right control-label col-form-label">用户密码</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" placeholder="Password Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="prompt" class="col-sm-3 text-right control-label col-form-label">密保问题</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" placeholder="Question Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="answer" class="col-sm-3 text-right control-label col-form-label">答案</label>
                                        <div class="col-sm-5">
                                            <input type="text" class="form-control" placeholder="Answer Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="answer" class="col-sm-3 text-right control-label col-form-label">所属酒店</label>
                                        <div class="col-sm-5">
                                            <input type="text" class="form-control" placeholder="hotelid Here">
                                        </div>
                                    </div>
                                </div>
                                <div class="border-top">
                                    <div class="card-body">
										<button type="submit" class="btn btn-success">保存</button>
										<button type="reset" class="btn btn-primary">重置</button>
                                    </div>
                                </div>
                            </form>
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