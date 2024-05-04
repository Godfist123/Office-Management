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
                        <h4 class="page-title">员工管理 - 修改</h4>
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
                            <form class="form-horizontal" method="post" action="employee/modify"  enctype="multipart/form-data">
                                <div class="card-body">
                                    <!-- <h4 class="card-title">员工信息</h4> -->
                                    <div class="form-group row">
                                        <label for="loginName" class="col-sm-3 text-right control-label col-form-label">登录名</label>
                                        <div class="col-sm-4">
                                            <input type="text" name="loginName" value="${employee.loginName  }" class="form-control" placeholder="loginName Here">
                                        </div>
                                    </div>
                                     <div class="form-group row">
                                        <label for="password" class="col-sm-3 text-right control-label col-form-label">密码</label>
                                        <div class="col-sm-4">
                                            <input type="text" name="password" value="${employee.password  }" class="form-control" placeholder="password Here">
                                        </div>
                                    </div>                                    
                                    <div class="form-group row">
                                        <label for="empName" class="col-sm-3 text-right control-label col-form-label">姓名</label>
                                        <div class="col-sm-4">
                                            <input type="text" name="empName" value="${employee.empName  }" class="form-control" placeholder="empName Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="gender" class="col-sm-3 text-right control-label col-form-label">性别</label>
                                        <div class="col-sm-4">
                                        	<input type="radio" name="gender" id="woman"  value="女" style="margin-top: 12px" >女 
                                        	<input type="radio" name="gender" id="man" value="男" >男
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="position" class="col-sm-3 text-right control-label col-form-label">职位</label>
                                        <div class="col-sm-4">
                                        	<select name="position" id="position" class="form-control" >
                                        		<option>职员</option>
                                        		<option>经理</option>
                                        	</select>
                                        </div>
                                    </div>
<!--                                     <div class="form-group row"> -->
<!--                                         <label for="position" class="col-sm-3 text-right control-label col-form-label">职位</label> -->
<!--                                         <div class="col-sm-4"> -->
<%--                                             <input type="text" name="position" value="${employee.position  }" class="form-control" placeholder="position Here"> --%>
<!--                                         </div> -->
<!--                                     </div> -->
                                     <div class="form-group row">
                                        <label for="departName" class="col-sm-3 text-right control-label col-form-label">所属部门</label>
                                        <div class="col-sm-4" >
                                            <select  class="form-control" name="departId">
	                                            <c:forEach items="${departInfo }" var="departInfo">
	                                            	<option value="${departInfo.departId }">${departInfo.departName }</option>
                                            	</c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="hireDate" class="col-sm-3 text-right control-label col-form-label">入职日期</label>
                                        <div class="col-sm-4">
                                            <input type="date" name="hireDate" value="${employee.hireDate  }" class="form-control" placeholder="hireDate Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="birthday" class="col-sm-3 text-right control-label col-form-label">生日</label>
                                        <div class="col-sm-4">
                                            <input type="date" name="birthday" value="${employee.birthday  }" class="form-control" placeholder="birthday Here">
                                        </div>
                                     </div>
                                    <div class="form-group row">
                                        <label for="address" class="col-sm-3 text-right control-label col-form-label">地址</label>
                                        <div class="col-sm-4">
                                            <input type="text" name="address" value="${employee.address  }" class="form-control" placeholder="address Here">
                                        </div>
                                     </div>                                     
                                    <div class="form-group row">
                                        <label for="mobile" class="col-sm-3 text-right control-label col-form-label">移动电话</label>
                                        <div class="col-sm-4">
                                            <input type="text" name="mobile" value="${employee.mobile  }" class="form-control" placeholder="mobile Here">
                                        </div>
                                     </div>
                                    <div class="form-group row">
                                        <label for="tel" class="col-sm-3 text-right control-label col-form-label">办公电话</label>
                                        <div class="col-sm-4">
                                            <input type="text" name="tel" value="${employee.tel  }" class="form-control" placeholder="tel Here">
                                        </div>
                                     </div>
                                    <div class="form-group row">
                                        <label for="familyTel" class="col-sm-3 text-right control-label col-form-label">家庭电话</label>
                                        <div class="col-sm-4">
                                            <input type="text" name="familyTel" value="${employee.familyTel }" class="form-control" placeholder="familyTel Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="remark" class="col-sm-3 text-right control-label col-form-label">备注</label>
                                        <div class="col-sm-4">
                                            <input type="text" name="remark" value="${employee.remark  }" class="form-control" placeholder="remark Here">
                                        </div>
                                    </div>
									<div class="form-group row">
									    <label class="col-sm-3 text-right control-label col-form-label">上传照片</label>
									    <div class="col-sm-4">
									        <div class="custom-file">
									            <input type="file" name="files" onchange="showFilename(this.files[0])" class="custom-file-input" id="validatedCustomFile" required>
									            <label id="filename_label" onchange="lookImg(this,'img1')" class="custom-file-label" for="validatedCustomFile">选择照片</label>
									            <!-- 预览照片 -->
<!-- 												<div class="col-md-4"> -->
<!-- 												    <img src="" width="200" height="200"  id="img1"> -->
<!-- 												</div>		 -->
									            <div class="invalid-feedback">Example invalid custom file feedback</div>
									        </div>
									    </div>
									</div>   
									
                                    <!-- 隐藏控件 -->
                                    <input type="hidden" name="empId" value="${employee.empId  }" class="form-control">
                                    <input type="hidden" id="selectPosition" value="${employee.position }" class="form-control">
	                               
	                                <div class="border-top">
	                                    <div class="card-body">
											<button type="submit" class="btn btn-success">保存</button>
											<button type="reset" class="btn btn-primary">重置</button>
											<a href="javascript:;" onclick="history.go(-1)" class="btn btn-danger" >返回</a>
	                                    </div>
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
		
		//下拉列表赋值
		$("select[name=departId]").val("${employee.departId  }")
		$("#position").val($("#selectPosition").val());
		
		//性别选中显示
		if("${employee.gender}"=="女"){
			
			$("#woman").attr("checked","checked");
		}else{
			
			$("#man").attr("checked","checked");
		}
		
		
// //		预览图片
// 		//图片预览
// 		function lookImg(ele,imgId){
// 			//获取input file的files文件数组;
// 			//$('#filed')获取的是jQuery对象，.get(0)转为原生对象;
// 			//这边默认只能选一个，但是存放形式仍然是数组，所以取第一个元素使用[0];
// 			var file = ele.files[0];
// 			//创建用来读取此文件的对象
// 			var reader = new FileReader();
// 			//使用该对象读取file文件
// 			reader.readAsDataURL(file);
// 			//读取文件成功后执行的方法函数
// 			reader.onload=function(e){
// 			//读取成功后返回的一个参数e，整个的一个进度事件
// 			console.log(e);
// 			//选择所要显示图片的img，要赋值给img的src就是e中target下result里面
// 			//的base64编码格式的地址
// 			//alert(e.target.result);
// 			document.getElementById(imgId).src = e.target.result;
// 			}
// 		}
			
			
		
    </script>
</body>

</html>