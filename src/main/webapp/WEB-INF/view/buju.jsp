<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>easyUpload.js</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/upload/easy-upload.css">
	<style>
		html{
			/* background: #f5f5f5; */
			background: #fff;
		}
	</style>
</head>
<body>
<div id="easyContainer"></div>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<!-- 视实际需要决定是否引入jquery.cookie-1.4.1.min.js-->
<script src="<%=request.getContextPath()%>/plugins/upload/vendor/jquery.cookie-1.4.1.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/upload/easyUpload.js"></script>
<script>
	$('#easyContainer').easyUpload({
		allowFileTypes: '*.jpg;*.doc;*.pdf;*.xlsx;',//允许上传文件类型，格式';*.doc;*.pdf'
		allowFileSize: 100000,//允许上传文件大小(KB)
		selectText: '选择文件',//选择文件按钮文案
		multi: true,//是否允许多文件上传
		multiNum: 5,//多文件上传时允许的文件数
		showNote: true,//是否展示文件上传说明
		note: '提示：最多上传5个文件，支持格式为doc、pdf、jpg',//文件上传说明
		showPreview: true,//是否显示文件预览
		url: '<%=request.getContextPath()%>/common/fileUpload.do',//上传文件地址
		fileName: 'file',//文件filename配置参数
		formParam: {
			token: $.cookie('token_cookie')//不需要验证token时可以去掉
		},//文件filename以外的配置参数，格式：{key1:value1,key2:value2}
		timeout: 30000,//请求超时时间
		okCode: 200,//与后端返回数据code值一致时执行成功回调，不配置默认200
		successFunc: function(res) {
			console.log('成功回调', res);
		},//上传成功回调函数
		errorFunc: function(res) {
			console.log('失败回调', res);
		},//上传失败回调函数
		deleteFunc: function(res) {
			console.log('删除回调', res);
		}//删除文件回调函数
	});
</script>
</body>
</html>
