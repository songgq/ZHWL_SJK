<%
	//清空页面缓存  防止用户出现数据没有刷新
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	request.setCharacterEncoding("UTF-8");
	String basePath = request.getContextPath() + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>plugins/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>plugins/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
	<script type="text/javascript" src="<%=basePath%>plugins/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>plugins/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/tree.loadFilter.js"></script>
<script type="text/javascript">
(function($){
	$.ajaxSetup({
		global: true,
		cache: false,
		type: "POST"
	});
    var ajax=$.ajax;
    $.ajax=function(s){
        var old = s.error;
        var errHeader = s.errorHeader || "Error-Json";
        s.error = function(xhr,status,err){
           var errMsg = xhr.getResponseHeader(errHeader);
           if(errMsg != null){
        	   window.top.location.href = "<%=basePath%>login.jsp";
           }
		}
		ajax(s);
	}
})(jQuery);

/**
 * 获取选中的行
 * 单选
 * add by mapp
 */
function getDgChecked(id) {
	var checkedRows = $('#' + id).datagrid('getChecked');
	if (checkedRows && checkedRows != null && checkedRows.length == 1) {
		return checkedRows[0];
	}else {
		$.messager.alert('错误提示','您未选中任何行');
		return;
	}
}

/**
 * doAjax
 * add by mapp
 */
function doAjax(url,id, data) {
	$.ajax({
		url : url,
		dataType: 'json',
		type: 'post',
		data: data == null? "": data,
		success : function(data) {
			if (data.result.success == true) {
				$.messager.show({
					title:'提示',
					showType:'slide',
					msg: data.result.message
				});
			}else {
				$.messager.show({
					title:'提示',
					showType:'slide',
					msg: data.result.message
				});
			}
			// 成功后刷新的dg
			if (!isEmpty(id)) {
				$('#' + id).datagrid('reload');
			}
		},
		error: function() {
			$.messager.show({
				title:'提示',
				showType:'slide',
				msg: '操作失败'
			});
		}
	});
}

function isEmpty(str) {
	if (str && str != null && str.length > 0) {
		return false;
	}
	return true;
}
</script>
