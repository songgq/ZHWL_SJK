x<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<div class="query_criteria">
	<div class="query_tit"><em></em>查询条件</div>
	<div class="query_cont">
		<form class="form-inline" id="ser">
			<div class="form-group">
				<label>模板名称：</label>
				<input class="easyui-textbox" type="text" name="mb_Mc" id="mb_Mc" />
			</div>
			<div class="form-group">
				<label>状态：</label>
				<select	class="easyui-combobox" data-options="editable:false" id="status" name="status" style="width: 147px;">
					<option value=""></option>
					<option value="1">已发布</option>
					<option value="0">未发布</option>
				</select>
			</div>
			<div class="form-group">
				<a href="javascript:;" name="search" id="search"  class="easyui-linkbutton btn-default">查询</a>
			</div>
		</form>
	</div>
</div>
	<!--模板管理表格-->
	<table id="dg" style="display: block;">
	</table>
	<!--新增模板弹窗-->
	<div id="addMuBanDlg" class="easyui-dialog" closed="true" title="新增模板" style="width: 400px; height: 300px; padding: 10px; top:20px"
		data-options="modal:true,buttons: '#dlg-buttons'">
		<div id="p" class="easyui-panel" style="width: 350px; height: 200px; padding: 10px;">
			<form action="" id="addForm">
				<input type="text" name="mbmc" id="mbmc" class="easyui-textbox" data-options="label:'模板名称：',required:true" style="width: 300px" /><br />
				<br />
				<input type="text" name="" id="xuanzezhibiao" class="easyui-textbox" data-options="label:'选择指标：'" style="width: 300px" readonly /><br />
				<input type="hidden" name="checkZhiBiao" value="" />
				<input type="hidden" name="id" value="" />
			</form>
		</div>
	</div>

	<!--指标弹窗-->
	<div id="zhibiaoDlg" class="easyui-dialog" closed="true" title="选择指标" style="width: 800px; height: 550px; padding: 10px; top:20px"
		 data-options="modal:true">
		<table id="zhibiaoDg" style="display: block;">
		</table>
	</div>

	<!--查看模板-->
	<div id="viewMuBanDlg">

	</div>

	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveMuBan()">提交</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#addMuBanDlg').dialog('close')">关闭</a>
	</div>
</body>
<script type="text/javascript">
	var type = "";
	$(function(){
		$("#xuanzezhibiao").textbox('textbox').bind("click", function () { openZhiBiao(type)})

		var datagrid = $("#dg").datagrid({
			url:"<%=basePath%>muBan/muBanPage.do",
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
				if (data.items) {
					for (var i = 0; i < data.items.length; i++) {
						value.rows[x]=data.items[i];
						x++;
					}
				}
				return value;
			},
			toolbar: [{
				id:'add',
				text: '新增',
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
				text: '查看',
				iconCls: 'icon-reload',
				handler: function() {
					view();
				},
			},"-",{
				text: '发布',
				iconCls: 'icon-remove',
				handler: function() {
					release();
				}
			},"-",{
				text: '删除',
				iconCls: 'icon-remove',
				handler: function() {
					deleteMuBan();
				}
			}
			],
			columns:[[      //每个列具体内容
				{ field:'ck',checkbox:true,width:10, align: 'center'},
				{field:'id',title:'roleId',width: 10,hidden:true},
				{field:'mbmc',title:'模板名称',width:400,align: 'left', halign: 'center', formatter: function(value,row,index) {
					return '<a href="javascript:void(0)" onclick="view(\''+row.id+'\',\''+value+'\')">'+value+'</a>';
				}},
				{field:'status',title:'状态',width:100,align: 'center', halign: 'center', formatter: function(value) {
					if (value == "0") {
						return "未发布";
					}else if(value == "1") {
						return "已发布"
					}
				}},
				{field: 'createTime', title: '创建时间', width: 300,align: 'center', halign: 'center'},
				{field: 'creater', title: '创建人', width: 300,align: 'center', halign: 'center'}
			]],
			singleSelect: true,
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



		//重置
		$("#reset").click(function(){
			$("#ser").form('clear');
		});
		//搜索功能
		$("#search").click(function(){debugger;
			var mbmc = $("input",$("#mb_Mc").next("span")).val();
			var status = $("#status").combobox("getValue");
			$('#dg').datagrid('reload',{"mbmc":mbmc, "status":status});
		});
	});


	function add(){
		type = 'add';
		$('#addMuBanDlg').form('clear');
		$('#addMuBanDlg').dialog('open');
	}

	/**
	 * 打开指标选择窗口
	 * @param obj
	 */
	function openZhiBiao(type) {
		$('#zhibiaoDlg').dialog('open');
		var datagrid = $("#zhibiaoDg").datagrid({
			url:"<%=basePath%>zhiBiaoPage.do?limit=999",
			fitColumns:true,
			fit:true,//自动补全
			loadFilter : function(data){
				//过滤数据
				var value={
					total:data.recordCount,
					rows:[]
				};
				var x=0;
				if (data.items) {
					for (var i = 0; i < data.items.length; i++) {
						value.rows[x]=data.items[i];
						x++;
					}
				}
				return value;
			},
			toolbar: [{
				text: '保存',
				iconCls: 'icon-add',
				handler: function() {
					saveZhiBiao();
				},
			}
			],
			columns:[[      //每个列具体内容
				{ field:'ck',checkbox:true,width:'5%', align: 'center'},
				{field:'id',title:'指标id',width:'10%',hidden:true},
				{field:'value',title:'指标名称',width:'30', formatter: function(value,row,index) {
					if (row.jibie == '1') {
						return '<span>'+value+'</span>';
					}
					if (row.jibie == '2') {
						return '<span style="margin-left: 40px">'+value+'</span>';
					}
					if (row.jibie == '3') {
						return '<span style="margin-left: 80px">'+value+'</span>';
					}
					if (row.jibie == '4') {
						return '<span style="margin-left: 120px">'+value+'</span>';
					}
					if (row.jibie == '5') {
						return '<span style="margin-left: 160px">'+value+'</span>';
					}
				}},
				{field: 'createtime', title: '创建日期', width: '30%',align: 'center'},
				{field:'hangci',title:'行次',width:'10%',align: 'center'}]],
			singleSelect: false,
			selectOnCheck: true,
			checkOnSelect: true,
			onLoadSuccess: function() {
				// 修改的时候才查询关联的指标
				var checkRows = $('#dg').datagrid('getChecked');
				var id = checkRows[0].id;
				if (type == 'update') {
					$.ajax({
						url: '<%=basePath%>muBan/getCheckedZhiBiaos.do?id='+id,
						dataType: 'json',
						success: function(data) {
							var rows = $('#zhibiaoDg').datagrid('getRows');
							if (data && data.zhiBiaos && data.zhiBiaos.length > 0) {
								for (var i = 0; i < data.zhiBiaos.length; i++) {
									for (var j = 0; j < rows.length; j++) {
										if (data.zhiBiaos[i].id == rows[j].id) {
											$('#zhibiaoDg').datagrid('checkRow', j);
										}
									}
								}
							}
						}
					});
				}
			},
			height:360
		});
	}

	/**
	 * 保存选中的指标
	 */
	function saveZhiBiao() {
		var checkRows = $('#zhibiaoDg').datagrid('getChecked');
		var length = checkRows.length;
		var s = '';
		if (length == 0) {
			$.messager.alert('错误提示','您未选中任何指标');
			return;
		}
		for (var i = 0; i < length; i++) {
			s += checkRows[i].id + ',';
		}
		$("input[name='checkZhiBiao']").val(s);
		$('#zhibiaoDlg').dialog('close');
	}

	/**
	 * 保存模板
	 */
	function saveMuBan() {
		doAjax('<%=basePath%>muBan/saveMuBan.do', 'dg', $("#addForm").serialize());
		$('#addMuBanDlg').dialog('close');
	}

	/**
	 * 查看模板
	 */
	function view(muBanId, mb_mc) {
		var id = '';
		var mbmc = '';
		if (arguments.length > 0) {
			id = muBanId;
			mbmc = mb_mc;
		}else{
			var checkedRows = $('#dg').datagrid('getChecked');
			id = checkedRows[0].id;
			mbmc = checkedRows[0].mbmc;
		}

		$('#viewMuBanDlg').dialog({
			title: '模板指标',
			width: 800,
			height: 550,
			closed: false,
			cache: false,
			href: '<%=basePath%>/muBan/viewMuBan.do?id='+id+'&mbmc='+mbmc,
			modal: true

		});
	}

	/**
	 * 删除 0: 未发布 1：已发布 2:已删除
	 */
	function deleteMuBan() {
		var checkedRows = getDgChecked("dg");
		if (checkedRows.status == '1') {
			$.messager.alert('提示','已发布模板不能删除');
			return;
		}
		var id = checkedRows.id;
		$.messager.confirm('确认','您确认想要删除模板吗？',function(r){
			if (r){
				doAjax('<%=basePath%>muBan/deleteMuBan.do?muBanId=' + id, 'dg', null);
			}
		});
	}

	/**
	 * 获取模板的指标  字符串形式
	 */
	function getCheckedZhiBiaos(id) {debugger;
		var zhiBiaoId = '';
		$.ajax({
			url: '<%=basePath%>muBan/getCheckedZhiBiaos.do?id='+id,
			dataType: 'json',
			success: function(data) {
				if (data && data.zhiBiaos && data.zhiBiaos.length > 0) {
					for (var i = 0; i < data.zhiBiaos.length; i++) {
						zhiBiaoId += data.zhiBiaos[i].id + ',';
					}
				}
				$("input[name='checkZhiBiao']").val(zhiBiaoId);
			}
		});
	}

	/**
	 * 修改
	 */
	function update() {
		$('#addMuBanDlg').form('clear');
		type = 'update';
		var rows = getDgChecked("dg");
		if (rows.status == '1') {
			$.messager.alert('提示','已发布模板不能修改');
			return;
		}
		getCheckedZhiBiaos(rows.id);
		$('#addMuBanDlg').form('load',{
			mbmc:rows.mbmc,
			id: rows.id
		});
		$('#addMuBanDlg').dialog('open');
	}

	/**
	 *  发布
	 */
	function release() {
		var checkedRows = getDgChecked("dg");
		var id = checkedRows.id;
		$.messager.confirm('确认','您确认想要发布选中的模板吗？',function(r){
			if (r){
				doAjax('<%=basePath%>muBan/releaseMuBan.do?muBanId=' + id, 'dg', null);
			}
		});

	}

</script>
</html>