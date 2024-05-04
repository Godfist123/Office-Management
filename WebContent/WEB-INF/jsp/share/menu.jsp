<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<aside class="left-sidebar" data-sidebarbg="skin5">
	<!-- Sidebar scroll-->
	<div class="scroll-sidebar">
		<!-- Sidebar navigation-->
		<nav class="sidebar-nav">
			<ul id="sidebarnav" class="p-t-30">
				
				<!-- =============================侧边栏权限菜单=============================== -->
				<!-- 父级菜单 -->
				<c:forEach items="${usersMenu }" var="usersMenu">
					<li class="sidebar-item">
						<a class="sidebar-link has-arrow waves-effect waves-light" href="javascript:void(0)" aria-expanded="false">
							<i class="${usersMenu.ico }"></i>
							<span class="hide-menu">${usersMenu.menuname }</span>
						</a>
						
						<!-- 子菜单 -->
						<ul aria-expanded="false" class="collapse  first-level">
						
							<c:forEach items="${usersMenu.list }" var="son">
								<li class="sidebar-item">
									<a href="${son.url }" class="sidebar-link">
										<i class="${son.ico }"></i>
										<span class="hide-menu">${son.menuname }</span>
									</a>
								</li>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>	
			</ul>
		</nav>
		<!-- End Sidebar navigation -->
	</div>
	<!-- End Sidebar scroll-->
</aside>
<!-- ============================================================== -->
