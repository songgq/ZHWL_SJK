<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 获取文件类型
String fileType=request.getParameter("fileType");
if(null == fileType || "".equals(fileType)){
	// 没有限制则默认全类型可选
	fileType = "*";
}
String display= (null==request.getParameter("display")?"":request.getParameter("display"));
String override = (null==request.getParameter("override")?"fileUpload_Click":request.getParameter("override"));

String basePath = request.getContextPath() + "/";
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="<%=basePath%>scripts/jquery.form.min.js"></script>
<script type="text/javascript">

function fileUploadFunc(func){
	if(func){
/* 		$("#fileUpload").change(function(){
			func();
		}); */
		$("#fileUpload").attr('onchange',func);
		$("#fileUpload").click(); 
	}
}

function fileUpload_Click()
{
    var path;
    path=$("#fileUpload").val();      
    var aa;
    aa=path.split('.');
    $("#fileNamePatten").val(aa[aa.length-1]);

    var name;
    name=path.split('\\'); 
    var bb=name[name.length-1];             
    var timestamp = Date.parse(new Date());
    $("#fileName").val(bb.substr(0,bb.indexOf('.'))+'_'+timestamp); 

    $("#jspUploadHide").ajaxSubmit({
		type: "POST",
		url:"<%=basePath%>common/fileUpload.do",
		dataType: "json",
	    success: function(data){
	    	if(data.msg=='SUCCESS'){
	    		// 上传成功，进行转换
	    		top.xzzfAlert("提示","上传成功");
	    		if(fileUpload_Callback){
	    			fileUpload_Callback();
	    		}
	    	}
		}
	});
}
</script>
<form name="jspUploadHide" id="jspUploadHide" action="<%=basePath%>common/fileUpload.do" enctype="multipart/form-data" method="post">  
	<div style="display:<%=display%>">
	<p>指定文件名： <input type="text" name="fileName" id="fileName" value= ""/></p>
	<p>指定文件后缀名： <input type="text" name="fileNamePatten" id="fileNamePatten" value= ""/></p>
	<p>上传文件： <input type="file" name="file" id="fileUpload" <%-- onchange="return <%=override%>()" --%> accept="<%=fileType%>"/></p>
	</div>
</form> 