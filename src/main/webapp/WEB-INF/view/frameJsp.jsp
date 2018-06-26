<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ustcsoft.framework.vo.UserVO"%>
<%@page import="com.ustcsoft.jt.vo.User"%>
<%@page
	import="org.springframework.security.core.context.SecurityContext"%>
<%
	SecurityContext context = (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
	User user = (User) context.getAuthentication().getPrincipal();
	UserVO userInfo = user.getUserVo();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>安徽省粮食局</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<%@include file="/common/common_easyui.jsp"%>
<script type="text/javascript">
var path="<%= basePath%>";
</script>
</head>
<body class="easyui-layout">
	<div class="head">
		<img class="logo" src="./images/logo.png">
		<div class="head-r">
			<a class="tc" href="j_spring_security_logout.do">退出</a>
		</div>
	</div>
	<div class="main-cont">
	<div  class="main-left">
		<a class="home-page" href="javascript:;"><i></i>系统首页</a>
		<div id="sider-menu" class="easyui-accordion" data-options="border:false">
		</div>
	</div>
	<div class="menu-toggle"></div>
	<div class="main-right">
		<div class="public-tabs">
			<div id="pageIframes" class="easyui-tabs" data-options="border:false" style="height:auto">
			</div>
		</div>
	</div>
	</div>
<script type="text/javascript" src="<%=basePath%>js/public.js"></script>
</body>
</html>
