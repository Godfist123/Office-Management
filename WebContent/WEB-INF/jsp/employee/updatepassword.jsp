<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	
      
<!-- 样式表 -->
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
                        <h4 class="page-title">修改用户密码</h4>
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
                            <form class="form-horizontal" onsubmit="return check()" method="post" action="employee/toUpdatePassword">
                                <div class="card-body">
                                    <!-- <h4 class="card-title">用户信息</h4> -->
                                    <div class="form-group row">
                                        <label for="oldpwd" class="col-sm-3 text-right control-label col-form-label">原密码</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="oldpwd" name="oldpwd"  placeholder="OldPassword Here">
                                            <br>
                                            <input type="text" id="msg" value="" readonly="readonly" style="border: none;color: red;width: 300px;font-weight: 600;font-size: 17px">
											<!-- 隐藏控件 -->
											<input type="hidden" id="judgeOldpwd" value="${emp.password }" >
                                        </div>
                                    </div>
                                    <div class="form-group row"> 
                                        <label for="newpwd" class="col-sm-3 text-right control-label col-form-label">新密码</label>
                                        <div class="col-sm-4">
                                            <input type="password" class="form-control" id="newpwd" name="newpwd"  placeholder="NewPassword Here">
                                            <br>
                                            <!-- 隐藏控件 -->
											<input type="text" id="msg2" readonly="readonly" style="border: none;color: red;width: 300px;font-weight: 600;font-size: 17px">
                                        </div>
                                    </div>
                                    <div style="margin-left:300px;font-size: 20px;color: red;"></div>
                                </div>
                                <div class="border-top">
                                    <div class="card-body">
										<button type="submit" class="btn btn-success" >保存</button>
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
	<jsp:include page="../share/footer.jsp"></jsp:include>
<!-- 脚本    -->
<!-- All Jquery -->
<!-- ============================================================== -->
<jsp:include page="../share/resources_js.jsp"></jsp:include>
<script>
	$(".pagination li").click(function(){
		$(this).addClass("active").siblings().removeClass("active");
	});
	

     var quill = new Quill('#editor', {
         theme: 'snow'
     });

	// 解决文件域不显示上传文件名称的
	function showFilename(file){
	    $("#filename_label").html(file.name);
	}
	
	//验证旧密码
	$("#oldpwd").blur(function() {
		

		if($("#oldpwd").val()==""){
			
			$("#msg").val("请输入原密码!");
			
		}else if($("#oldpwd").val()!=$("#judgeOldpwd").val()){
			
			$("#msg").val("原密码输入错误,请重新输入!");
		}
	})
	
	//验证新密码是否为空
	$("#newpwd").blur(function() {
		
		if($("#newpwd").val()==""){
			
			$("#msg2").val("请输入新密码!");
		}
	})

	
	//原密码获取焦点事件
	$("#oldpwd").focus(function() {
		
		$("#msg").val("");
	})
	
	//新密码获取焦点事件
	$("#newpwd").focus(function() {
		
		$("#msg2").val("");
	})
	
	//表单提交事件
	function check() {
		
		if($("#oldpwd").val()!=$("#judgeOldpwd").val()){

			return false;
		}else{

			if($("#newpwd").val()==null){
				return false;
			}else{
				alert("修改成功,请重新登陆!");
				return true;
			}
		}
		
	}
    </script>
</body>

</html>