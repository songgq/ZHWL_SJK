<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>打印页面_DEMO</title>
<%@include file="/common/common_easyui.jsp" %>
<script type="text/javascript" src="<%=basePath%>scripts/localprint.js"></script>
<script type="text/javascript">
$(function(){
	$('#btnPrint').bind('click', function(){
		PRINTA("sample_print_wycxkz.do?id=1", $("#printer_printa").combobox('getValue'), function(){
			alert("hello 1");
		});
    });
	$('#btnPreview').bind('click', function(){
		PREVIEW("sample_print_wycxkz.do?id=1",800,500, function(){
			alert("hello 2");
		});
    });
	$('#btnDesign').bind('click', function(){
		PRINT_DESIGN("sample_print_wycxkz.do?id=1",800,500);
    });
	
	INIT_PRINTERLIST($("#printer_printa"), "wycxkz");
});
</script>
</head>
<body>
<a id="btnPrint" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print'">打印</a>
<input id="printer_printa" class="easyui-combobox" style="width:200px" />
<br/>
<br/>
<br/>
<a id="btnPreview" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print'">打印预览</a>
<br/>
<br/>
<br/>
<a id="btnDesign" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">打印设计(暂时由程序员代码实现)</a>
</body>
</html>