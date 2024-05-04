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
                        <h4 class="page-title">通讯录管理 - 添加 </h4>
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
                            <form class="form-horizontal" method="post" action="address/append">
                                <div class="card-body">
                                    <!-- <h4 class="card-title">通讯录信息</h4> -->
                                    <div class="form-group row">
									<label for="addressparentid" class="col-sm-3 text-right control-label col-form-label">公司</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="companyname" placeholder="companyname Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">部门</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="departname"  placeholder="departname Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="position" class="col-sm-3 text-right control-label col-form-label">职位</label>
                                        <div class="col-sm-4">
                                        	<select name="position" class="form-control">
                                        		<option>请选择</option>
                                        		<option>职员</option>
                                        		<option>经理</option>
                                        	</select>
                                        </div>
                                    </div>
<!--                                     <div class="form-group row"> -->
<!--                                         <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">职位</label> -->
<!--                                         <div class="col-sm-4"> -->
<!--                                             <input type="text" class="form-control" name="position"  placeholder="position Here"> -->
<!--                                         </div> -->
<!--                                     </div> -->
                                    <!-- 下拉列表-->
                                    <div class="form-group row">                                  
                                        <label for="addressparentid" class="col-sm-3 text-right control-label col-form-label">通讯组</label>
                                        <div class="col-sm-4">
                                            <select class="form-control"  name="groupid" >
												<option selected="selected" value="">请选择</option>
												<c:forEach items="${addrGroup.list }" var="addrGroup">
													<option value="${addrGroup.groupid }">${addrGroup.groupname}</option>
												</c:forEach>
											</select>
                                        </div>
                                    </div>
                                    <!-- 下拉列表-->
                                    <div class="form-group row">                                  
                                        <label for="addressparentid" class="col-sm-3 text-right control-label col-form-label">姓名</label>
                                        <div class="col-sm-4">
                                            <select class="form-control"  name="empid" >
												<option selected="selected" value="">请选择</option>
												<c:forEach items="${employee.list }" var="employee">
													<option value="${employee.empId }">${employee.empName}</option>
												</c:forEach>
											</select>
                                        </div>
                                    </div>                                        
                                    <div class="form-group row">                                  
                                        <label for="addressparentid" class="col-sm-3 text-right control-label col-form-label">昵称</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="name" placeholder="name Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">性别</label>
                                        <div class="col-sm-4">
                                        	<input type="radio" name="gender" value="女" style="margin-top: 12px" >女 
                                        	<input type="radio" name="gender" value="男" >男
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="addresscontent" class="col-sm-3 text-right control-label col-form-label">生日</label>
                                        <div class="col-sm-4">
                                            <input type="date" class="form-control" name="birthday"  placeholder="birthday Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
									<label for="addressparentid" class="col-sm-3 text-right control-label col-form-label">移动电话</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="mobile" placeholder="mobile Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">家庭电话</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="familytel"  placeholder="familytel Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">办公电话</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="tel"  placeholder="tel Here">
                                        </div>
                                    </div>   
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">邮箱</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="email"  placeholder="email Here">
                                        </div>
                                    </div>   
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">地址</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="homeaddress"  placeholder="homeaddress Here">
                                        </div>
                                    </div>                                                                                                       
                                </div>
                                <div class="border-top">
                                    <div class="card-body">
										<button type="submit" class="btn btn-success">保存</button>
										<button type="reset" class="btn btn-primary">重置</button>
										<a href="javascript:;" onclick="history.go(-1)" class="btn btn-danger">返回</a>
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