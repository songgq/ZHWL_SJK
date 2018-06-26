<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>打印页面</title>
<%@include file="/common/common_easyui.jsp" %>
<script type="text/javascript" src="<%=basePath%>scripts/printDesign.js"></script>
<script type="text/javascript" src="<%=basePath%>scripts/qrcode.min.js"></script>
<style>
body{background:#EEE;margin:0;}
#page{background-image: url(images/basemap.jpg); background-color: #FFF;}
#page span{position:absolute;background:none;word-break:normal; width:auto; display:block; white-space:pre-wrap;word-wrap : break-word ;overflow: hidden ;}
</style>
<script type="text/javascript">
$(function(){
	// 票据大小，位置，默认字体
	INIT_PAGE_SIZE(100,50,227,333,"wycxkz","images/basemap.jpg","宋体");
	// 字串 最后一位参数还可以添加字体，字段可选,中间不要有空格
	ADD_PRINT_TEXT(137,58,9,"${wycxkzVo.xkzh}");
	ADD_PRINT_TEXT(74,80,7,"${wycxkzVo.clsyr1}","仿宋");
	ADD_PRINT_TEXT(74,96,7,"${wycxkzVo.clsyr2}");
	ADD_PRINT_TEXT(74,111,7,"${wycxkzVo.dz1}");
	ADD_PRINT_TEXT(74,126,7,"${wycxkzVo.dz2}");
	ADD_PRINT_TEXT(74,143,7,"${wycxkzVo.clhp}");
	ADD_PRINT_TEXT(74,159,7,"${wycxkzVo.cllx}");
	ADD_PRINT_TEXT(74,175,7,"${wycxkzVo.zw}");
	ADD_PRINT_TEXT(88,194,7,"${wycxkzVo.chang}");
	ADD_PRINT_TEXT(88,208,7,"${wycxkzVo.kuang}");
	ADD_PRINT_TEXT(88,224,7,"${wycxkzVo.gao}");
	ADD_PRINT_TEXT(82,244,7,"${wycxkzVo.jyfw1}");
	ADD_PRINT_TEXT(23,264,7,"${wycxkzVo.jyfw2}");
	ADD_PRINT_TEXT(89,307,9,"${wycxkzVo.nian}");
	ADD_PRINT_TEXT(133,307,9,"${wycxkzVo.yue}");
	ADD_PRINT_TEXT(171,307,9,"${wycxkzVo.ri}");
	// 二维码
	ADD_PRINT_QRCODE("qrcode1",74,80,150,150,"hello world!!!");
});
</script>
</head>
<body>
</body>
</html>