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
<script type="text/javascript" src="<%=basePath%>scripts/py.js"></script>
<script type="text/javascript">
$(function(){
	//拼音
	   $("input",$("#roleName").next("span")).blur(function(){  
			$("#roleCode").textbox("setValue", makePy($("#roleName").textbox("getValue")));
		})  
	
	
	     var datagrid = $("#dg").datagrid({  
	       url:"<%=basePath%>sysRole/findRoleList.do",
	       pagination:true,//显示分页  
	       rownumbers:true,//显示行号
	       pageSize:20,//分页大小  
	      
	       pageList:[20,40,60,80],//每页的个数  
	       //fit:true,//自动补全  
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
	        toolbar: [{  
	           text: '新增角色',  
	           iconCls: 'icon-add',  
	           handler: function() {  
	        	   add();  
	           },
	       },"-",{
	    	   text: '修改',  
	           iconCls: 'icon-reload',  
	           handler: function() {  
	        	   update();  
	           },  
	       },"-",{
	    	   text: '删除',  
	           iconCls: 'icon-remove',  
	           handler: function() {  
	        	   del();  
	           }  
	       },"-",{
	    	   text: '设置页面权限',  
	           iconCls: 'icon-add',  
	           handler: function() {  
	        	   page_right();  
	           }  
	       }
	       ],
	       columns:[[      //每个列具体内容  
	                { field:'ck',checkbox:true },
	                {field:'roleId',title:'roleId',width:100,hidden:true},
	                {field:'roleName',title:'角色名称',width:50},
	                {field:'roleCode',title:'角色编码',width:50},     
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
	  	         height:360
	});
	   
	   var p = $('#dg').datagrid('getPager');  
	   $(p).pagination({  
	       pageSize: 20,//每页显示的记录条数，默认为10  
	       pageList: [20,40,60,80],//可以设置每页记录条数的列表  
	       beforePageText: '第',//页数文本框前显示的汉字  
	       afterPageText: '页    共 {pages} 页',  
	       displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',  
	      
	   });  
		
	   
		function add(){
			$('#dlg').form('clear');
			$('#dlg').dialog('open');
		}
		
		//更新
		
		
		function update(){
			var rows = $('#dg').datagrid('getSelections');
			if(rows.length==1){
				$('#addForm').form('load',{
					roleId:rows[0].roleId,
					roleName:rows[0].roleName,
					roleCode:rows[0].roleCode,
					remark:rows[0].remark,
					roleType:rows[0].roleType,
					roleHy:rows[0].roleHy,
					isSysRole:rows[0].isSysRole
				});
				$('#dlg').dialog('open');
			}else if(rows.length>1){
				$.messager.alert("操作提示", "只能选择一行！");
			}else{
				$.messager.alert("操作提示", "请选择！");
			}
			
		}
		function del(){
			var rows = $('#dg').datagrid('getSelections');
		    var roleId="";
            for(var i=0;i<rows.length;i++){
            	roleId +=rows[i].roleId + ",";
             //获取选中节点的值
            }
			if(rows.length>0){
				$.messager.confirm('提示框', '你确定要删除吗?',function(r){
					if(r){
						$.ajax({
							url: '<%=basePath%>sysRole/deleteRole.do?roleId=' + roleId,
									success:function(){
										$.messager.show({
											title:'提示',
											msg:'删除成功',
											timeout:3000,
											showType:'slide'
										});
										$('#dg').datagrid('reload')
									}
						});
					}
				})
			}else{
				$.messager.alert("操作提示", "请选择！");
			}
		}
		
		//设置页面权限
		function page_right(){
			//页面权限的树
			var rows = $('#dg').datagrid('getSelections');
			if(rows.length==1){
				var roleId=rows[0].roleId;
				$('#zTreeMenu').tree({
					url: '<%=basePath%>sysRole/findSysMenuOrObjectTreeAll4Role.do?roleId='+roleId,
					checkbox:true,
					parentField:"parentId",
					textFiled:"menuName",
					idFiled:"menuId",
				});
				$('#dlg_pageRight').dialog('open');
			}else if(rows.length>1){
				$.messager.alert("操作提示", "只能选择一行！");
			}else{
				$.messager.alert("操作提示", "请选择！");
			}
		}
		 //重置
		  $("#reset").click(function(){
			  $("#ser").form('clear');
		  });
		//搜索功能
		   $("#search").click(function(){
			    var roleName=$("input",$("#role_Name").next("span")).val();
				var roleType=$("#roleType").combobox("getValue");
				var roleHy=$("#roleHy").combobox("getValue");
			   $('#dg').datagrid({  
				    url:'<%=basePath%>sysRole/findRoleList.do',  
				    queryParams:{  
				    	roleName:roleName,  
				    	roleType:roleType,
				    	roleHy:roleHy
				    }  
				});  
			});
	   });
	   
	function showSubmit(){
		if($("#addForm").form('validate')){
			$.ajax({
				type: 'POST',
				url: "<%=basePath%>sysRole/edit.do" ,
				data: $('#addForm').serialize(),
				dataType: 'text',
				success: function(data){
					
					if(data==0){
						$.messager.show({
							title:'提示',
							msg:'操作成功',
							timeout:3000,
							showType:'slide'
						});
						$('#dg').datagrid('reload')
					}else if(data==1){
						$.messager.alert('错误提示','角色名重复');
					}
				} ,
				error: function(){
					$.messager.alert('错误提示','失败');
				}
			});
		}else{
			$.messager.alert('错误提示','请完善红色必填项');
		}
		
	}
  //设置页面提交
  function showSubmitPage(){
	 	  var rows = $('#dg').datagrid('getSelections');
          var nodes = $('#zTreeMenu').tree('getChecked');
          var menuIds = '';
          for (var i = 0; i < nodes.length; i++) {
              if (menuIds != '') 
            	  menuIds += ',';
              menuIds += nodes[i].menuId;
          }
          $.ajax({
				url: '<%=basePath%>sysRole/setRole.do?roleId=' + rows[0].roleId
					+ '&menuIds=' + menuIds,
			success : function() {
				$("#zTreeMenu").tree("reload");
			}
		});
	}
</script>
</head>
<body class="sub_body_pad">
<div class="query_criteria">
	<div class="query_tit"><em></em>查询条件</div>
	<div class="query_cont">
		<form class="form-inline">
				  <div class="form-group">
				    <label>角色名称：</label>
				    <input class="easyui-textbox" type="text" name="role_Name" id="role_Name" />
				  </div>
				  <div class="form-group">
				    <label>所属类别：</label>
				    <select	class="easyui-combobox" data-options="editable:false" id="roleType" name="roleType" style="width: 147px;">
					<option></option>
					<option value="0">系统管理</option>
					<option value="1">许可业务</option>
					<option value="2">处罚业务</option>
					<option value="3">领导审批</option>
					<option value="4">特殊角色</option>
					</select>
				  </div>
				  <div class="form-group">
				    <label>所属行业:</label>
				    <select class="easyui-combobox" data-options="editable:false" id="roleHy" name="roleHy" style="width: 147px;">
					<option></option>
					<option value="00">交通主管部门</option>
					<option value="01">公路</option>
					<option value="02">运管</option>
					<option value="03">海事</option>
					<option value="04">质监</option>
					<option value="05">港航</option>
					<option value="06">通用</option>
				</select>
				  </div>
				  <div class="form-group">
					<a href="javascript:;" name="search" id="search"  class="easyui-linkbutton btn-default">查询</a>
				  </div>
				</form>
	</div>
</div>
	<table id="dg" style="display: block;">
	</table>
	<div id="dlg" class="easyui-dialog" closed="true" title="角色窗口" style="width: 400px; height: 360px; padding: 10px; top:20px"
		data-options="modal:true,buttons: '#dlg-buttons'">
		<div id="p" class="easyui-panel" style="width: 350px; height: 260px; padding: 10px;">
			<form action="" id="addForm">
				<input type="hidden" name="roleId" id="roleId" /> 
				<input type="text" name="roleName" id="roleName" class="easyui-textbox" data-options="label:'角色名称：',required:true" style="width: 230px" /><br />
				<br /> 
				<input type="text" name="roleCode" id="roleCode" class="easyui-textbox" data-options="label:'角色编码：',required:true" style="width: 230px" /><br />
				<br /> 
				<input type="text" name="remark" id="remark" class="easyui-textbox" data-options="label:'角色说明：'" style="width: 230px" /><br />
				<br /> 
				<select class="easyui-combobox" id="roleType" name="roleType" data-options="label:'所属类别:',labelPosition:'right',editable:false" style="width: 250px;">
					<option></option>
					<option value="0">系统管理</option>
					<option value="1">许可业务</option>
					<option value="2">处罚业务</option>
					<option value="3">领导审批</option>
					<option value="4">特殊角色</option>
				</select><br />
				<br /> 
				<select class="easyui-combobox" id="roleHy" name="roleHy" data-options="label:'所属行业:',labelPosition:'right',editable:false" style="width: 250px;">
					<option></option>
					<option value="00">交通主管部门</option>
					<option value="01">公路</option>
					<option value="02">运管</option>
					<option value="03">海事</option>
					<option value="04">质监</option>
					<option value="05">港航</option>
					<option value="06">通用</option>
				</select><br />
				<br /> 
				<select class="easyui-combobox" id="isSysRole" name="isSysRole" data-options="label:'角色级别:',labelPosition:'right',editable:false" style="width: 250px;">
					<option></option>
					<option value="0">0级</option>
					<option value="1">1级</option>
					<option value="2">2级</option>
				</select><br />
			</form>
		</div>
	</div>

	<div id="dlg_pageRight" class="easyui-dialog" closed="true" title="角色设置窗口" style="width: 400px; height: 360px; padding: 10px; top:20px"
		data-options="modal:true,buttons: '#dlgPage-buttons'">
		<div id="pan" class="easyui-panel" style="width: 350px; height: 260px; padding: 10px;">
			<div style="width: 200px">
				<ul id="zTreeMenu" class="easyui-tree"
					data-options="cascadeCheck :false">
				</ul>
			</div>
		</div>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="showSubmit()">提交</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
	</div>
	<div id="dlgPage-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="showSubmitPage()">提交</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg_pageRight').dialog('close')">关闭</a>
	</div>
</body>
</html>