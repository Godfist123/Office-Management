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
                        <h4 class="page-title">通讯录管理 - 修改</h4>
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
                            <form class="form-horizontal" method="post" action="address/modify">
                                <div class="card-body">
                                    <!-- <h4 class="card-title">通讯录信息</h4> -->
                                    <div class="form-group row">
									<label for="addressparentid" class="col-sm-3 text-right control-label col-form-label">公司</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" value="${address.companyname }" name="companyname" >
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">部门</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" value="${address.departname }" name="departname" >
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="position" class="col-sm-3 text-right control-label col-form-label">职位</label>
                                        <div class="col-sm-4">
                                        	<select name="position" class="form-control" id="selectPosition">
                                        		<option>请选择</option>
                                        		<option>职员</option>
                                        		<option>经理</option>
                                        	</select>
                                        </div>
                                    </div>
                                    <!-- 隐藏控件 -->
                                    <input type="hidden" id="position" value="${address.position }">
                                    <input type="hidden" name="addressid" value="${address.addressid }">
                                    <input type="hidden" id="groupid" value="${address.groupid }">
                                    <input type="hidden" id="empid" value="${address.empid }">
                                    <!-- 下拉列表-->
                                    <div class="form-group row">                                  
                                        <label for="addressparentid" class="col-sm-3 text-right control-label col-form-label">通讯组</label>
                                        <div class="col-sm-4">
                                            <select class="form-control" name="groupid" >
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
                                            <select class="form-control" name="empid" >
											<c:forEach items="${employee.list }" var="employee">
												<option value="${employee.empId }">${employee.empName}</option>
											</c:forEach>
											</select>
                                        </div>
                                    </div>                                        
                                    <div class="form-group row">                                  
                                        <label for="addressparentid" class="col-sm-3 text-right control-label col-form-label">昵称</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" value="${address.name }" name="name" >
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">性别</label>
                                        <div class="col-sm-4" style="margin-top: 12px">
                                        	<input type="radio" name="gender" id="woman"  value="女" >女 
                                        	<input type="radio" name="gender" id="man" value="男" >男
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="addresscontent" class="col-sm-3 text-right control-label col-form-label">生日</label>
                                        <div class="col-sm-4">
                                            <input type="date" class="form-control" value="${address.birthday }" name="birthday" >
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="addresscontent" class="col-sm-3 text-right control-label col-form-label">婚否</label>
                                        <div class="col-sm-4" style="margin-top: 9px">
                                        	<input type="radio" id="noMarry" name="marry" value="0">未婚
                                        	<input type="radio" id="isMarry" name="marry" value="1">已婚
                                        </div>
                                    </div>                                    
                                    <div class="form-group row">
									<label for="addressparentid" class="col-sm-3 text-right control-label col-form-label">移动电话</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" value="${address.mobile }" name="mobile">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">家庭电话</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" value="${address.familytel }" name="familytel">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">办公电话</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" value="${address.tel }" name="tel">
                                        </div>
                                    </div>   
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">邮箱</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" value="${address.email }" name="email">
                                        </div>
                                    </div>   
                                    <div class="form-group row">
                                        <label for="addresstitle" class="col-sm-3 text-right control-label col-form-label">地址</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" value="${address.homeaddress }" name="homeaddress" >
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
		
		
		//下拉框赋值
		$("select[name=groupid]").val($("#groupid").val());
		$("select[name=empid]").val($("#empid").val());
		$("#selectPosition").val($("#position").val());

		//婚否按钮选中
		if("${address.marry  }"=="0"){
			$("#noMarry").prop("checked",true);
		}else{
			$("#isMarry").prop("checked",true);
		}
		//性别按钮选中
		if("${address.gender}"=="女"){
			
			$("#woman").prop("checked","checked");
		}else{
			
			$("#man").prop("checked","checked");
		}
		
		
	
    </script>
</body>

</html>