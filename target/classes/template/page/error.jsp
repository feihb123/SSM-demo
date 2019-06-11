<%@ page language="java" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" 
		content="text/html; charset=utf-8">
	<title>Spring MVC</title>
	<style type="text/css">
	* { padding: 0; margin: 0; font-family: '微软雅黑', Segoe UI Symbol; }
	body { background: #ccc; }
	#content-wrapper { text-align: center; }
	#content { background: #fff; width: 860px;
		margin: 0 auto; text-align: left;
		padding: 20px; }
	#content h2 { color: #f00; }
	#content h3 { color: #f00; }
	</style>
</head>
<body>
	<div id="content-wrapper">
	<div id="content">
		<h2>操作失败！</h2>
		<h3>${errorMessage }</h3>
	</div>
	</div>
</body>
</html>