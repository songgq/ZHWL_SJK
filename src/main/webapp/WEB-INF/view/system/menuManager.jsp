<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
	<!DOCTYPE html>
	<html xmlns="http://www.w3.org/1999/xhtml">
		<head>
			<title>
				交通运输综合执法系统
			</title>
			<%@include file="/common/common_easyui.jsp" %>
			<script type="text/javascript" src="<%=basePath%>scripts/py.js"></script>
				<script type="text/javascript">
					$(function() {
						//拼音
						// TODO 实现方式后面调查
						$("input",$("#menuName").next("span")).blur(function(){  
							$("#busiCode").textbox("setValue", makePy($("#menuName").textbox("getValue")));
						})  
						$("#add").click(function(){
							$("#type").val("add");
							$('#form1').form('clear');
						})
						
						//点击保存
						$("#save").click(function() {
							if($("#type").val()=="add"){
								var menuId=$("#menuId").val();
								//新增
								if($("#form1").form('validate')){
									$.ajax({
										type: 'POST',
										url: "<%=basePath%>sysMenu/insertSysMenu.do?menuId="+menuId ,
										data: $('#form1').serialize(),
										dataType: 'text',
										success: function(data){
											if(data==0){
												$.messager.show({
													title:'提示',
													msg:'新增成功',
													timeout:3000,
													showType:'slide'
												});
												$("#zTreeMenu").tree("reload");
												$("#type").val("");
											}else if(data==1){
												$.messager.alert('错误提示','菜单名重复');
											}
										} ,
										error: function(){
											$.messager.alert('错误提示','失败');
										}
									});
								}else{
									$.messager.alert('错误提示','请完善红色必填项');
								}
							}else{
								//更新
								var menuId = $("#menuId").val();
								if (menuId == null || menuId == "") {
									return false;
								} else {
									if($("#form1").form('validate')){
										$.ajax({
											type: 'POST',
											url: "<%=basePath%>sysMenu/updateSysMenu.do?menuId="+menuId ,
											data: $('#form1').serialize(),
											dataType: 'text',
											success: function(data){
												
												if(data==0){
													$.messager.show({
														title:'提示',
														msg:'更新成功',
														timeout:3000,
														showType:'slide'
													});
													$("#zTreeMenu").tree("reload");
												}else if(data==1){
													$.messager.alert('错误提示','菜单名重复');
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
							}
							
						});
							
						//删除 
						$("#del").click(function() {
							var node = $("#menuId").val();
							if (node == null || node == "") {
								$.messager.alert('错误提示','请选择功能|对象节点或点击新增功能|');
							} else {
								$.messager.confirm('提示框', '你确定要删除吗?',function(r){
									if(r){
										$.ajax({
											url: '<%=basePath%>sysMenu/deleteSysMenu.do?node=' + node,
													success:function(){
														$.messager.show({
															title:'提示',
															msg:'删除成功',
															timeout:3000,
															showType:'slide'
														});
														$("#zTreeMenu").tree("reload");
													}
										});
									}
								})
							}
						});
					});
				$(function() {  
					$('#zTreeMenu').tree({
						url: '<%=basePath%>sysMenu/findAllSysMenuTree.do',
						parentField:"parentId",
						textFiled:"menuName",
						idFiled:"menuId",
						onClick: function(node){
							$('#form1').form('load', '<%=basePath%>sysMenu/findUserMenuByMENU_ID.do?node=' + node.menuId);
							$("#menuId").val(node.menuId);
							$('#save').linkbutton('enable');
							$('#del').linkbutton('enable');
							return false;
					    }
					});
				});
				</script>
		</head>
		<body>
			<div class="easyui-layout" style="width:100%;height:450px;" fit="true">
				<div data-options="region:'north'" style="height:30px;">
					<a href="javascript:void(0)" id="add" class="easyui-linkbutton" style="width:80px" data-options="iconCls:'icon-add'">新增</a>
					<a href="javascript:void(0)" id="save" class="easyui-linkbutton" style="width:80px" data-options="iconCls:'icon-save',disabled:true" >保存</a>
					<a href="javascript:void(0)" id="del" class="easyui-linkbutton" style="width:80px"  disabled:true data-options="iconCls:'icon-remove',disabled:true">删除</a>
				</div>
				<div data-options="region:'west'" title="功能菜单" style="width:200px">
					<ul id="zTreeMenu" class="easyui-tree">
					</ul>
				</div>
				<div data-options="region:'center',title:'功能',iconCls:'icon-ok'" >
						 <input type="hidden" name="menuId" id="menuId" />
						<input type="hidden" name="type" id="type" />
						<form action="" name="form1" id="form1" data-options="novalidate:true" method="post">
							
							<div style="margin-bottom:20px">
								<input class="easyui-textbox"  style="width:300px" type="text" name="menuName" id="menuName" data-options="label:'功能名称：',required:true" />
							</div>
							<div style="margin-bottom:20px">
								<input class="easyui-textbox" style="width:300px" type="text" name="busiCode" id="busiCode" data-options="label:'业务编码：',required:true" />
							</div>
							<div style="margin-bottom:20px">
								<select class="easyui-combobox" data-options="required:true,editable:false" label="状态：" name="delFlg" id="delFlg" style="width:300px;">
									<option value="0" selected="selected">启用</option>
									<option value="1">停用</option>
								</select>
							</div>
							<div style="margin-bottom:20px">
								打开方式：
							<input type="radio" name="isPop" id="isPop1" value="N" checked="checked"/>
								跟框架一致
							<input type="radio" name="isPop" id="isPop2" value="Y" />
								window形式弹出
							<input type="radio" name="isPop" id="isPop3" value="O" />
								浏览器形式弹出
							</div>
							<div style="margin-bottom:20px">
								<input class="easyui-textbox"  style="width:300px" type="text" name="menuUrl" id="menuUrl" data-options="label:'功能连接：',required:true"/>
							</div>
							<div style="margin-bottom:20px">
								<input class="easyui-textbox"  style="width:300px" type="text" name="helpUrl" id="helpUrl" data-options="label:'帮助链接：'"/>
							</div>
						</form>
				</div>
			</div>
		</body>
	
	</html>