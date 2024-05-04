/**
 * 
 * 2021-11-24
 * 日历相关的js
 * 
 */
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
							console.log(date.title)
							console.log(date.id)
						},
						events://日程数据
						function(start, end, timezone, callback) {
							//var events=new Array();
							
						
						var events=[];
						
						var param={
								
								"title":$("#title").val(),
								"begintime":$("#begintime").val(),
								"endtime":$("#endtime").val(),
								"state":$("#state").val(),
						}
						
						//ajax方法 
						//function(data)回调函数:初始数据,接值.
						//param:向后台发起请求,传参数
						var projectName=$("#projectName").val() //项目名list.jsp的隐藏控件
						$.get("/"+projectName+"/schedule/ajaxselect",param,function(data){
							
	
							for(var i=0;i<data.length;i++){
								
								events.push({
									
									id: data[i].scheduleid,
									title: data[i].title,  //标题
									start: data[i].begintime,  //表示开始时间
									end: data[i].endtime,  //表示结束时间  
									color:  data[i].empid==$("#empid").val()?'#649b40':'#fe8101',  //设置event的背景颜色
									url:'/'+projectName+'/schedule/detail?scheduleid='+data[i].scheduleid  //点击时跳转的地址
								});
								console.log(data[i].empId);
							}
						},"json")
							
 						console.log(events);					
	
						callback(events)  //回调函数
					}
				});
			}