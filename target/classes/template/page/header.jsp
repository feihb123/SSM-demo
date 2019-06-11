<%@ page language="java" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
	
	<style type="text/css">
	* { padding: 0; margin: 0; font-family: '微软雅黑', Segoe UI Symbol; }
	body { background: #ccc; }
	
	li { list-style: none; }
	#header-wrapper { text-align: center;
		border-bottom: 3px solid #787878; }
	#header { background: #fff;
		width: 900px; margin: 0 auto; }
	#nav { height: 70px; overflow: auto; }
	#nav li { float: left; }
	#nav li a { line-height: 70px;
		color: #333; text-decoration: none;
		font-size: 18px; display: block;
		padding: 0 16px; }
	#nav li a:hover { font-weight: bold;
		background: #d8d8d8; }
	#nav li a.current { font-weight: bold;
		background: #d8d8d8; }
	</style>

	<div id="header-wrapper">
		<div id="header">
			<ul id="nav">
				<li><a href="###">首页</a></li>
				<li><a href="###"
				<c:if test="${'user_register_form' eq pageName }">
				 class="current"
				</c:if>>注册</a></li>
				<li><a href="###"
				<c:if test="${'user_login_form' eq pageName }">
				 class="current"
				</c:if>>登录</a></li>
			</ul>
		</div>
	</div>
