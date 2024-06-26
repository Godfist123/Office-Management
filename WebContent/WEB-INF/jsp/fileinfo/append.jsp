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
                        <h4 class="page-title">文件管理-文件上传</h4>
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
                            <form class="form-horizontal" method="post" action="fileinfo/append" enctype="multipart/form-data">
                                <div class="card-body">
                                    <!-- <h4 class="card-title">文件上传信息</h4> -->
                                    <div class="form-group row">
									<label for="fileinfoparentid" class="col-sm-3 text-right control-label col-form-label">文件名称</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="filename" placeholder="输入名称">
                                        </div>
                                    </div>
                                    <div class="form-group row">
										<label for="cono1" class="col-sm-3 text-right control-label col-form-label">文件类型</label>
										<div class="col-md-9">
											<div class="custom-control custom-radio float-left">
												<input type="radio" checked="checked" class="custom-control-input" id="customControlValidation1" name="radio-stacked" required>
												<label class="custom-control-label" for="customControlValidation1">文本文件</label>
											</div>
											 <div class="custom-control custom-radio float-left">
												<input type="radio" class="custom-control-input" id="customControlValidation2" name="radio-stacked" required>
												<label class="custom-control-label" for="customControlValidation2">压缩文件</label>
											</div>
										 </div>
									</div>                                   
                                    <div class="form-group row">
                                        <label for="fileinfotitle" class="col-sm-3 text-right control-label col-form-label">上传文件</label>
                                        <div class="col-sm-4">
                                            <div class="custom-file">
									            <input type="file" onchange="showFilename(this.files[0])" name="file" class="custom-file-input" id="validatedCustomFile" required>
									            <label id="filename_label" class="custom-file-label" for="validatedCustomFile">选择文件</label>
									        </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="fileinfotitle" class="col-sm-3 text-right control-label col-form-label">文件介绍</label>
                                        <div class="col-sm-7">
                                            <textarea cols="30" rows="5" class="form-control" name="filedesc"  placeholder="输入文件介绍说明..."></textarea>
                                        </div>
                                    </div>
                                </div>
                          		<div class="border-top">
                                    <div class="card-body text-center">
										<button type="submit" class="btn btn-success">上传文件</button>
										<button type="submit" class="btn btn-facebook">文件重置</button>
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
		
		//重置文件按钮
		$("#reset").click(function() {
			
			 $("#filename_label").html("选择文件");
		})
		
	
    </script>
</body>

</html>