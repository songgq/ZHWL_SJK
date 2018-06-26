<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>粮食局</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<%@include file="/common/common_easyui.jsp"%>
</head>
<body class="sub_body_pad">
	<form id="" action="" method="POST">
		<table style="width: 100%;border: 1px solid black">
			<thead>
				<th style="text-align: center;">指标名称</th>
				<th style="text-align: center;">行次</th>
				<th style="text-align: center;">购销企业</th>
				<th style="text-align: center;">其他企业</th>
			</thead>
			<tbody>
			<c:forEach items="${muBan.zhiBiaos}" var="zhiBiao">
				<tr>
					<c:if test="${zhiBiao.jibie == '1'}">
						<td class="hide">${zhiBiao.id}</td>
						<td>${zhiBiao.value}</td>
						<td>${zhiBiao.hangci}</td>
						<td><input type="text" class="easyui-textbox" readonly style="width: 150px" /></td>
						<td><input type="text" class="easyui-textbox" readonly style="width: 150px" /></td>
					</c:if>
					<c:if test="${zhiBiao.jibie == '2'}">
						<td class="hide">${zhiBiao.id}</td>
						<td style="padding-left: 40px">${zhiBiao.value}</td>
						<td >${zhiBiao.hangci}</td>
						<td><input type="text" class="easyui-textbox" readonly style="width: 150px" /></td>
						<td><input type="text" class="easyui-textbox" readonly style="width: 150px" /></td>
					</c:if>
					<c:if test="${zhiBiao.jibie == '3'}">
						<td class="hide">${zhiBiao.id}</td>
						<td style="padding-left: 80px">${zhiBiao.value}</td>
						<td >${zhiBiao.hangci}</td>
						<td><input type="text" class="easyui-textbox" readonly style="width: 150px" /></td>
						<td><input type="text" class="easyui-textbox" readonly  style="width: 150px" /></td>
					</c:if>
					<c:if test="${zhiBiao.jibie == '4'}">
						<td class="hide">${zhiBiao.id}</td>
						<td style="padding-left: 120px">${zhiBiao.value}</td>
						<td >${zhiBiao.hangci}</td>
						<td><input type="text" class="easyui-textbox" readonly style="width: 150px" /></td>
						<td><input type="text" class="easyui-textbox" readonly  style="width: 150px" /></td>
					</c:if>
					<c:if test="${zhiBiao.jibie == '5'}">
						<td class="hide">${zhiBiao.id}</td>
						<td style="padding-left: 160px">${zhiBiao.value}</td>
						<td >${zhiBiao.hangci}</td>
						<td><input type="text" class="easyui-textbox" readonly style="width: 150px" /></td>
						<td><input type="text" class="easyui-textbox" readonly  style="width: 150px" /></td>
					</c:if>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</form>
</body>
<script type="text/javascript" src="<%=basePath%>scripts/py.js"></script>
</html>
