<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!-- 脚本    -->
<!-- All Jquery -->
<!-- ============================================================== -->
 <script src="${pageContext.request.contextPath}/resources/assets/libs/jquery/dist/jquery.min.js"></script>
 <!-- Bootstrap tether Core JavaScript -->
 <script src="${pageContext.request.contextPath}/resources/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
 <!--Wave Effects -->
 <script src="${pageContext.request.contextPath}/resources/dist/js/waves.js"></script>
 <!--Menu sidebar -->
 <script src="${pageContext.request.contextPath}/resources/dist/js/sidebarmenu.js"></script>
 <!--Custom JavaScript -->
 <script src="${pageContext.request.contextPath}/resources/dist/js/custom.min.js"></script>
<!-- editor javascript -->
<script src="${pageContext.request.contextPath}/resources/assets/libs/quill/dist/quill.min.js"></script>

<!-- <script src="${pageContext.request.contextPath}/resources/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script> -->
 <script src="${pageContext.request.contextPath}/resources/assets/extra-libs/sparkline/sparkline.js"></script>
 <!-- datepicker javascript -->
<script src="${pageContext.request.contextPath}/resources/assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

<script>
	$(".pagination li").click(function(){
		$(this).addClass("active").siblings().removeClass("active");
	});
	
</script>