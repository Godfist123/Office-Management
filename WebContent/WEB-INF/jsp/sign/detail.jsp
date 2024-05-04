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
	
		<!-- 地址栏根目录是项目名 -->
		<base href="${pageContext.request.contextPath}/">

		<title>办公自动化系统</title>
		<!-- Custom CSS -->
		<link rel="stylesheet" type="text/css" href="resources/assets/libs/quill/dist/quill.snow.css">
		<link rel="stylesheet" type="text/css" href="resources/assets/libs/bootstrap/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="resources/dist/bootstrap-icons.css" />
		<link rel="stylesheet" type="text/css" href="resources/dist/css/multicheck.css">
		<!-- Custom CSS -->
		<link href="resources/assets/libs/fullcalendar/dist/fullcalendar.min.css" rel="stylesheet" />
		<link href="resources/assets/extra-libs/calendar/calendar.css" rel="stylesheet" />
		<link href="resources/dist/css/style.min.css" rel="stylesheet">
		<style type="text/css">
			.row1{border: 1px blue solid;}
			
		</style>
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
							<h4 class="page-title">日程表</h4>
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
				<input type="hidden" id="empid" value="${param.empid }">
				<input type="hidden" id="empId" value="${emp.empId }">
				
				<!-- ============================================================== -->
				<!-- End Bread crumb and right sidebar toggle -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- Container fluid  -->
				<!-- ============================================================== -->
				<div style="height: 40px">
						<div class="card-body">
				           <!-- <h5 class="card-title m-b-0">Static Table With Checkboxes</h5> -->
							<!-- ==============================================================-->
				    </div>
					   
				   <div class="table-responsive">
					<!-- ============================================================== -->
					<!-- end Tables Content -->
					<!-- ============================================================== -->	
				   </div>
				</div>
				<!-- ============================================================== -->
				<!-- Start Calender  -->
				<!-- ============================================================== -->
				<div class="card-body">
					<div class="row">
						<div class="col-md-12">
							<h5 class="card-title">Calender日历</h5>
							<div class="card">
								<div class="col-md-12">
									<div class="card-body b-l calender-sidebar">
										<div id="calendar">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- ============================================================== -->
					<!-- end Calender -->
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
		<%@include file="../share/resources_js.jsp" %>		
		<!-- this calendar js -->
		<script src="resources/assets/libs/moment/min/moment.min.js"></script>
		<script src="resources/assets/libs/fullcalendar/dist/fullcalendar.min.js"></script>
		<!-- <script src="resources/dist/js/pages/calendar/cal-init.js"></script> -->
		<script src="resources/assets/libs/fullcalendar/dist/locale/zh-cn.js"></script>

		<script type="text/javascript">
		
			//$.ajaxSetup({}): 设置ajax 全局的属性,参数是json格式("{键:值,键:值}")
			//或者用$.ajax({})设置全局属性
			$.ajaxSetup({
				
				//默认是异步:无序执行
				//async:false 设置成同步
				async:false
			})
		
			//页面加载事件:日程表数据初始化
			$(document).ready(function() {
	
				init();
			});
			
			
			function init(){
				
				//重新加载数据显示,刷新
			    $('#calendar').fullCalendar( 'refetchEvents' );
				
					var cal=$('#calendar').fullCalendar({
						//日历头部左边：初始化切换按钮
						header: {
	
							left: '',
							//日历头部中间：显示当前日期信息
							center: 'title',
							//日历头部右边：初始化视图
							right: 'prev,next today'
						},
						editable: true,
						//设置是否可被单击
						selectable: false,
						//设置是否显示周六和周日，设为false则不显示
						weekends:true,
						drop://拖拽
						 function(date) {
							$this.onDrop($(this), date);
							alert("drop")
						},
						dayClick:///点击日历每天时的点击事件
						 function(date, allDay, jsEvent, view) {
							alert(date)
							//var date1=new Date(date)
							//var date2=date1.Format("yyyy-MM-dd");
							//location.href="http://www.baidu.com?id="+date2;
						
						},
						eventClick://当点击日历中的某一日程
						function(date, allDay, jsEvent, view){
							console.log(date);//calEvent是日程（事件）对象
							console.log(view)
// 							console.log(date.title)
// 							console.log(date.id)
						},
						events://日程数据
						function(start, end, timezone, callback) {
							//var events=new Array();
							
						
						var events=[];
						
						var param={
								
								"empid":$("#empid").val()
						}
						
						//ajax方法 
						//function(data)回调函数:初始数据,接值.
						//param:向后台发起请求,传参数
						$.get("/oa/sign/ajaxselect",param,function(data){
							
	
							for(var i=0;i<data.length;i++){
								
								events.push({
									
									signid: data[i].signid,
									empid: data[i].empid,
									signtime: data[i].signtime,  //签到时间
// 									signdesc: data[i].signdesc,  //签到备注
// 									signtag: data[i].signtag,  //签到状态
									color:  data[i].empid==$("#empId").val()?'#649b40':'#fe8101'  //设置event的背景颜色
// 									url:'/oa/schedule/  //点击时跳转的地址
								});
								console.log(data[i].empid);
							}
						},"json")
							
							console.log(events);					
	
						callback(events)  //回调函数
					}
				});
			}
			

		</script>
	</body>

</html>
    