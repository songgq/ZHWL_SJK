<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>交通运输综合执法系统</title>
<%@include file="/common/common_easyui.jsp"%>
<script type="text/javascript">

$(function(){
	var datagrid = $("#dg").datagrid({  
	      url:"<%=basePath%>sysUser/findUserList.do",
	      pagination:true,//显示分页  
	      rownumbers:true,//显示行号
	      pageSize:20,//分页大小  
	      pageList:[20,40,60,80],//每页的个数  
	      //fit:true,//自动补全  
	      fitColumns:true, 
	      			loadFilter : function(data){
	      				 //过滤数据
	      				if(data.items==null || data.items==""){
	       					return {total:0,rows:[]}; 
	       				}else{
	      				 var value={
	      				 total:data.recordCount,
	      				 rows:[]
	      				 };
	      				 var x=0;
	      				 for (var i = 0; i < data.items.length; i++) {  
	      					 value.rows[x]=data.items[i];
	      					 x++;
	      				 }
	      				 return value;
	       				}
	      			},
	       toolbar: [{
	      	   text: '角色',  
	           iconCls: 'icon-add',  
	           handler: function() {  
	        	  role();  
	           }  
	       }
	      ],
	      columns:[[      //每个列具体内容  
	               { field:'ck',checkbox:true },
	               {field:'userId',title:'userId',width:100,hidden:true},
	               {field:'orgId',title:'orgId',width:100,hidden:true},
	               {field:'userName',title:'用户名',width:140},
	               {field:'name',title:'姓名',width:140},
	               {field:'sex',title:'性别',width:50,formatter:function(value,row,index){
	                   if(value=='M'){
	                       return "男";
	                   }else if(value=='F'){
	                       return "女";
	                   }
	                 }
	               },     
	               {field:'tel',title:'联系电话',width:140},
	               {field:'idNo',title:'身份证号',width:140},
	               {field:'orgName',title:'所属机构',width:140},
	            ]],
	            singleSelect: false,
	 	         selectOnCheck: true,
	 	         checkOnSelect: true,
	  	         height:300
	      
	});
	  
	  var p = $('#dg').datagrid('getPager');  
	  $(p).pagination({  
	      pageSize: 20,//每页显示的记录条数，默认为10  
	      pageList: [20,40,60,80],//可以设置每页记录条数的列表  
	      beforePageText: '第',//页数文本框前显示的汉字  
	      afterPageText: '页    共 {pages} 页',  
	      displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',  
	     
	  }); 
	    $('#jigou').combotree({
	    	url: '<%=basePath%>deptorg/searchOrgTree.do?node=3400000000000000',
		    idFiled:"orgId",
		    textFiled:"orgName",
			parentField:"parentId"
	    });
	  
	 //查询
	  $("#doSearch").click(function(){
			 $('#dg').datagrid({  
				    url:'<%=basePath%>sysUser/findUserList.do',  
				    queryParams:{  
				    	orgId:$("#jigou").combobox("getValue"),
				    	userName:$("#s_userName").val(), 
				    	IdNo:$("#s_IdNo").val(),
				    	chaXunFangShi:$("#chaXunFangShi").combobox("getValue"),
				    	name:$("#s_name").val(),
				    	tel:$("#s_tel").val()
				    }  
				});  
		  }); 
	  
	//所属机构
		$('#orgId').combotree({
		    url: '<%=basePath%>deptorg/searchOrgTree.do?node=3400000000000000',
		    idFiled:"orgId",
		    textFiled:"orgName",
			parentField:"parentId",
		    required: true
		});
		
		$("#dgRole").datagrid({  
		       url:"<%=basePath%>sysRole/findRoleList.do",
		       pagination:true,//显示分页  
			      rownumbers:true,//显示行号
			      pageSize:20,//分页大小  
			      pageList:[20,40,60,80],//每页的个数  
			      fit:true,//自动补全  
		       fitColumns:true, 
		       			loadFilter : function(data){
		       				 //过滤数据
		       				 var value={
		       				 total:data.recordCount,
		       				 rows:[]
		       				 };
		       				 var x=0;
		       				 for (var i = 0; i < data.items.length; i++) {  
		       					 value.rows[x]=data.items[i];
		       					 x++;
		       				 }
		       				 return value;
		       			},
		       columns:[[      //每个列具体内容  
		                { field:'ck',checkbox:true },
		                {field:'roleId',title:'roleId',width:100,hidden:true},
		                {field:'roleName',title:'角色名称',width:50},
		                {field:'roleType',title:'所属类别',width:50,formatter:function(value,row,index){
		                    if(value==0){
		                        return "系统管理";
		                    }else if(value==1){
		                        return "许可业务";
		                    }else if(value==2){
		                        return "处罚业务";
		                    }else if(value==3){
		                        return "领导审批";
		                    }else if(value==4){
		                        return "特殊角色";
		                    }
		                  }
		                },     
		                {field:'roleHy',title:'所属行业',width:50,formatter:function(value,row,index){
		                    if(value==00){
		                        return "交通主管部门";
		                    }else if(value==01){
		                        return "公路";
		                    }else if(value==02){
		                        return "运管";
		                    }else if(value==03){
		                        return "海事";
		                    }else if(value==04){
		                        return "质监";
		                    }else if(value==05){
		                        return "港航";
		                    }else if(value==06){
		                        return "通用";
		                    }
		                  }
		                		
		                },    
		                {field:'remark',title:'说明',width:50},    
		                {field:'isSysRole',title:'角色级别',width:50},
		                {field:'createrOrgName',title:'创建人单位',width:50},
		                {field:'ceraterUserName',title:'创建人',width:50}
		                 
		             ]],
		             singleSelect: false,
		  	         selectOnCheck: true,
		  	         checkOnSelect: true,
		  	         height:300,
		       
		});
		var p_dgrole = $('#dgRole').datagrid('getPager');  
		  $(p_dgrole).pagination({  
		      pageSize: 20,//每页显示的记录条数，默认为10  
		      pageList: [20,40,60,80],//可以设置每页记录条数的列表  
		      beforePageText: '第',//页数文本框前显示的汉字  
		      afterPageText: '页    共 {pages} 页',  
		      displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		  }); 
});

//角色
function role(){
		var rows = $('#dg').datagrid('getSelections');
		if(rows.length==1){
			   $("#dlg_role").dialog("open");
		}else if(rows.length>1){
			$.messager.alert("操作提示", "只能选择一行！");
		}else{
			$.messager.alert("操作提示", "请选择！");
		}
		
}


function showSubmitRole(){
	var rowsUser = $('#dg').datagrid('getSelections');
	var rows = $('#dgRole').datagrid('getSelections');
	if(rows.length>=1){
		var roleId = '';
        for (var i = 0; i < rows.length; i++) {
            if (roleId != '') 
            	roleId += ',';
            roleId += rows[i].roleId;
        }
        $.ajax({
				url: '<%=basePath%>sysUserRole/setUserRole.do?roleId='
						+ roleId + '&userId=' + rowsUser[0].userId,
				success : function() {
					$('#dgRole').datagrid('reload')
					$.messager.show({
						title : '提示',
						msg : '角色设置成功',
						timeout : 3000,
						showType : 'slide'
					});
				}
			});

		} else {
			$.messager.alert("操作提示", "请选择！");
		}
	}
</script>
</head>
<body class="sub_body_pad">
<div class="query_criteria">
	<div class="query_tit"><em></em>查询条件</div>
	<div class="query_cont">
		<form class="form-inline">
				  <div class="form-group">
				    <label>执法机构:</label>
				    <input id="jigou" name="jigou" class="easyui-combotree"	style="width: 147px" /> 
				  </div>
				  <div class="form-group">
				    <label>用户名:</label>
				    <input id="s_userName" name="s_userName" class="easyui-textbox" style="width: 147px" /> 
				  </div>
				  <div class="form-group">
				    <label>身份证号:</label>
				    <input id="s_IdNo" name="s_IdNo" class="easyui-textbox"	style="width: 147px" /><br /> 
				  </div>
				  <div class="form-group">
				    <label>查询范围:</label>
				    <select	class="easyui-combobox" data-options="editable:false" id="chaXunFangShi" name="chaXunFangShi"	style="width: 147px">
					<option value="">--请选择--</option>
					<option value="01">本单位</option>
					<option value="02">下级单位</option>
				</select> 
				  </div>
				  <div class="form-group">
				    <label>姓名:</label>
				    <input id="s_name" name="s_name" class="easyui-textbox" style="width: 147px" /> 
				  </div>
				  <div class="form-group">
				    <label>电话号码:</label>
				    <input id="s_tel" name="s_tel" class="easyui-textbox" style="width: 147px" /> 
				  </div>
				  <div class="form-group">
					<a href="javascript:;" name="doSearch" id="doSearch" class="easyui-linkbutton btn-default">查询</a>
				  </div>
				</form>
	</div>
</div>
			<table id="dg" style="display: block;"></table>
	<div id="dlg_role" class="easyui-dialog" closed="true" title="用户角色设置窗口" style="width: 1000px; height: 460px; top: 20px; padding: 10px"	data-options="modal:true,buttons: '#dlg-buttonsRole'">
			<table id="dgRole" style="display: block;"></table>
		</div>
	<div id="dlg-buttonsRole">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="showSubmitRole()">提交</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg_role').dialog('close')">关闭</a>
	</div>
</body>
</html>
