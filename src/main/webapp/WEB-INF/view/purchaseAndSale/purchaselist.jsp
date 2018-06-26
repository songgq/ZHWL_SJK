<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>"一卡通"系统购销数据列表</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <style>
    .td2 {
      padding-left: 40px;
    }
    .td3 {
      padding-left: 30px;
    }
    .max{width:100%;height:auto;}
    .min{width:270px;height:330px;}
  </style>
  <%@include file="/common/common_easyui.jsp"%>
  <script type="text/javascript" src="<%=basePath%>scripts/py.js"></script>
  <script type="text/javascript">
    $(function(){
      //拼音
      /*$("input",$("#roleName").next("span")).blur(function(){
        $("#roleCode").textbox("setValue", makePy($("#roleName").textbox("getValue")));
      })*/

        $(".list_img").click(function(){
            var _this = $(this);//将当前的pimg元素作为_this传入函数
            imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
        });

        var datagrid = $("#dg").datagrid({
        url:"<%=basePath%>purchaseAndSale/search.do",
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
        toolbar: [
          {
            text: '查看',
            iconCls: 'icon-ok',
            handler: function() {
              lookInfo();
            }}
        ],
        columns:[[      //每个列具体内容
          { field:'ck',checkbox:true },
          {field:'uuid',title:'uuid',width:100,hidden:true},
          {field:'djbh',title:'单据编号',width:50},
          {field:'kdmc',title:'库点名称',width:80},
          {field:'pinzhong',title:'品种',width:50},
          /*{field:'roleHy',title:'业务名称',width:50,formatter:function(value,row,index){
          }
          },*/
          {field:'ywrq',title:'业务日期',width:50},
          {field:'khmc',title:'客户名称',width:50},
          {field:'ywlx',title:'类型',width:50},
          {field:'khlxdh',title:'客户联系电话',width:50},
          {field:'xzsj',title:'新增时间',width:50}

        ]],
        singleSelect: false,
        selectOnCheck: true,
        checkOnSelect: true,
        height:460
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


      function lookInfo(){
        var rows = $('#dg').datagrid('getSelections');
        if(rows.length==1){
          $('#addForm').form('load',{
            djczlx:rows[0].djczlx
          });
        }else if(rows.length>1){
          $.messager.alert("操作提示", "只能选择一行！");
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
        var cx_djbh=$("#cx_djbh").val();
        var cx_kdmc=$("#cx_kdmc").val();
        var cx_startDate=$("#cx_startDate").val();
        var cx_endDate=$("#cx_endDate").val();
        $('#dg').datagrid({
          url:'<%=basePath%>purchaseAndSale/search.do',
          queryParams:{
            cx_djbh:cx_djbh,
            cx_kdmc:cx_kdmc,
            cx_startDate:cx_startDate,
            cx_endDate:cx_endDate
          }
        });
      });
    });

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

    function imgShow(outerdiv, innerdiv, bigimg, _this){
        var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
        $(bigimg).attr("src", src);//设置#bigimg元素的src属性

        /*获取当前点击图片的真实大小，并显示弹出层及大图*/
        $("<img/>").attr("src", src).load(function(){
            var windowW = $(window).width();//获取当前窗口宽度
            var windowH = $(window).height();//获取当前窗口高度
            var realWidth = this.width;//获取图片真实宽度
            var realHeight = this.height;//获取图片真实高度
            /*var imgWidth, imgHeight;
            var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

            if(realHeight>windowH*scale) {//判断图片高度
                imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
                imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
                if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
                    imgWidth = windowW*scale;//再对宽度进行缩放
                }
            } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
                imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
                imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
            } else {//如果图片真实高度和宽度都符合要求，高宽不变
                imgWidth = realWidth;
                imgHeight = realHeight;
            }*/
            //$(innerdiv).css({"width":1000,"height":550});
            $(bigimg).css("width",realWidth);//以最终的宽度对图片缩放

            var w = windowW*0.1;//计算图片与窗口左边距
            var h = windowH*0.1;//计算图片与窗口上边距
            $(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性
            $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg
        });

        $(outerdiv).click(function(){//再次点击淡出消失弹出层
            $(this).fadeOut("fast");
        });
    }
  </script>
</head>
<body class="sub_body_pad">
<div class="query_criteria">
  <div class="query_tit"><em></em>"一卡通"系统购销数据列表</div>
  <div class="query_cont">
    <form class="form-inline">
      <div class="form-group">
        <label>单据编号：</label>
        <input class="easyui-textbox" type="text" name="cx_djbh" id="cx_djbh" />
      </div>
      <div class="form-group">
        <label>库点名称：</label>
        <input class="easyui-textbox" type="text" name="cx_kdmc" id="cx_kdmc" />
      </div>
      <div class="form-group">
        <a href="javascript:;" name="search" id="search"  class="easyui-linkbutton btn-default">查询</a>
      </div>
    </form>
  </div>
</div>
<table id="dg" style="display: block;">
</table>
<div id="dlg" class="easyui-dialog" closed="true" title="数据详细" style="width: 1000px; height: 580px; padding: 10px; top:20px;"
     data-options="modal:true,buttons: '#dlg-buttons'">
  <div id="p" class="easyui-panel" style="width: 950px; height: 480px; padding: 10px;">
    <form action="" id="addForm">
      <table style="border-collapse: separate; border-spacing: 25px;">
        <tr><td colspan="3" style="font-size: large;"> 入库单据详细 <hr/></td></tr><tr>
          <td  title="单据操作类型"><input type="text" name="djczlx" id="djczlx" class="easyui-textbox" data-options="label:'单据操作类型：'" style="width: 270px" readonly/></td>
          <td title="单据编号"><input type="text" name="djbh" id="djbh" class="easyui-textbox" data-options="label:'单据编号：'" style="width: 270px" readonly/></td>
          <td title="库点名称"><input type="text" name="kdmc" id="kdmc" class="easyui-textbox" data-options="label:'库点名称：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="品种"><input type="text" name="pinzhong" id="pinzhong" class="easyui-textbox" data-options="label:'品种：'" style="width: 270px" readonly/></td>
          <td title="等级"><input type="text" name="dj" id="dj" class="easyui-textbox" data-options="label:'等级：'" style="width: 270px" readonly/></td>
          <td title="客户名称"><input type="text" name="khmc" id="khmc" class="easyui-textbox" data-options="label:'客户名称：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="客户身份证号"><input type="text" name="khsfzh" id="khsfzh" class="easyui-textbox" data-options="label:'客户身份证号：'" style="width: 270px" readonly/></td>
          <td title="客户地址"><input type="text" name="khdz" id="khdz" class="easyui-textbox" data-options="label:'客户地址：'" style="width: 270px" readonly/></td>
          <td title="承运人姓名"><input type="text" name="cyrxm" id="cyrxm" class="easyui-textbox" data-options="label:'承运人姓名：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="承运人身份证号"><input type="text" name="cyrsfzh" id="cyrsfzh" class="easyui-textbox" data-options="label:'承运人身份证号：'" style="width: 270px" readonly/></td>
          <td title="客户联系电话"><input type="text" name="khlxdh" id="khlxdh" class="easyui-textbox" data-options="label:'客户联系电话：'" style="width: 270px" readonly/></td>
          <td title="入粮仓房编号"><input type="text" name="rlcfbh" id="rlcfbh" class="easyui-textbox" data-options="label:'入粮仓房编号：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="入粮货位编号"><input type="text" name="rlhwbh" id="rlhwbh" class="easyui-textbox" data-options="label:'入粮货位编号：'" style="width: 270px" readonly/></td>
          <td title="收获年度"><input type="text" name="shnd" id="shnd" class="easyui-textbox" data-options="label:'收获年度：'" style="width: 270px" readonly/></td>
          <td title="库存性质"><input type="text" name="kcxz" id="kcxz" class="easyui-textbox" data-options="label:'库存性质：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="业务日期"><input type="text" name="ywrq" id="ywrq" class="easyui-textbox" data-options="label:'业务日期：'" style="width: 270px" readonly/></td>
          <td title="新增时间"><input type="text" name="xzsj" id="xzsj" class="easyui-textbox" data-options="label:'新增时间：'" style="width: 270px" readonly/></td>
          <td title="变更时间"><input type="text" name="bgsj" id="bgsj" class="easyui-textbox" data-options="label:'变更时间：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="国别"><input type="text" name="gb" id="gb" class="easyui-textbox" data-options="label:'国别：'" style="width: 270px" readonly/></td>
          <td title="产地"><input type="text" name="cd" id="cd" class="easyui-textbox" data-options="label:'产地：'" style="width: 270px" readonly/></td>
          <td title="车船号"><input type="text" name="cch" id="cch" class="easyui-textbox" data-options="label:'车船号：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="毛重"><input type="text" name="mz" id="mz" class="easyui-textbox" data-options="label:'毛重：'" style="width: 270px" readonly/></td>
          <td title="皮重"><input type="text" name="pz" id="pz" class="easyui-textbox" data-options="label:'皮重：'" style="width: 270px" readonly/></td>
          <td title="其它扣量"><input type="text" name="qtkl" id="qtkl" class="easyui-textbox" data-options="label:'其它扣量：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="结算数量"><input type="text" name="jssl" id="jssl" class="easyui-textbox" data-options="label:'结算数量：'" style="width: 270px" readonly/></td>
          <td title="入门登记员"><input type="text" name="rmdjy" id="rmdjy" class="easyui-textbox" data-options="label:'入门登记员：'" style="width: 270px" readonly/></td>
          <td title="出门登记员"><input type="text" name="cmdjy" id="cmdjy" class="easyui-textbox" data-options="label:'出门登记员：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="毛重检斤员"><input type="text" name="mzjjy" id="mzjjy" class="easyui-textbox" data-options="label:'毛重检斤员：'" style="width: 270px" readonly/></td>
          <td title="皮重检斤员"><input type="text" name="pzjjy" id="pzjjy" class="easyui-textbox" data-options="label:'皮重检斤员：'" style="width: 270px" readonly/></td>
          <td title="保管员"><input type="text" name="bgy" id="bgy" class="easyui-textbox" data-options="label:'保管员：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="扦样员"><input type="text" name="qyy" id="qyy" class="easyui-textbox" data-options="label:'扦样员：'" style="width: 270px" readonly/></td>
          <td title="检验员"><input type="text" name="jyy" id="jyy" class="easyui-textbox" data-options="label:'检验员：'" style="width: 270px" readonly/></td>
          <td title="水分"><input type="text" name="sf" id="sf" class="easyui-textbox" data-options="label:'水分：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="扣水分比例"><input type="text" name="ksfbl" id="ksfbl" class="easyui-textbox" data-options="label:'扣水分比例：'" style="width: 270px" readonly/></td>
          <td title="扣水分数量"><input type="text" name="ksfsl" id="ksfsl" class="easyui-textbox" data-options="label:'扣水分数量：'" style="width: 270px" readonly/></td>
          <td title="杂质"><input type="text" name="zz" id="zz" class="easyui-textbox" data-options="label:'杂质：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="扣杂质比例"><input type="text" name="kzzbl" id="kzzbl" class="easyui-textbox" data-options="label:'扣杂质比例：'" style="width: 270px" readonly/></td>
          <td title="扣杂质数量"><input type="text" name="kzzsl" id="kzzsl" class="easyui-textbox" data-options="label:'扣杂质数量：'" style="width: 270px" readonly/></td>
          <td title="不完善粒"><input type="text" name="bwsl" id="bwsl" class="easyui-textbox" data-options="label:'不完善粒：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="扣不完善粒比例"><input type="text" name="kbwslbl" id="kbwslbl" class="easyui-textbox" data-options="label:'扣不完善粒比例：'" style="width: 270px" readonly/></td>
          <td title="扣不完善粒数量"><input type="text" name="kbwslsl" id="kbwslsl" class="easyui-textbox" data-options="label:'扣不完善粒数量：'" style="width: 270px" readonly/></td>
          <td title="容重"><input type="text" name="rz" id="rz" class="easyui-textbox" data-options="label:'容重：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="出糙率"><input type="text" name="ccl" id="ccl" class="easyui-textbox" data-options="label:'出糙率：'" style="width: 270px" readonly/></td>
          <td title="整精米率"><input type="text" name="zjml" id="zjml" class="easyui-textbox" data-options="label:'整精米率：'" style="width: 270px" readonly/></td>
          <td title="扣整精米率比例"><input type="text" name="kzjmlbl" id="kzjmlbl" class="easyui-textbox" data-options="label:'扣整精米率比例：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="扣整精米率数量"><input type="text" name="kzjmlsl" id="kzjmlsl" class="easyui-textbox" data-options="label:'扣整精米率数量：'" style="width: 270px" readonly/></td>
          <td title="黄粒米"><input type="text" name="hlm" id="hlm" class="easyui-textbox" data-options="label:'黄粒米：'" style="width: 270px" readonly/></td>
          <td title="黄粒米扣量比例"><input type="text" name="hlmklbl" id="hlmklbl" class="easyui-textbox" data-options="label:'黄粒米扣量比例：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="扣黄粒米数量"><input type="text" name="khlmsl" id="khlmsl" class="easyui-textbox" data-options="label:'扣黄粒米数量：'" style="width: 270px" readonly/></td>
          <td title="谷外糙米"><input type="text" name="gwcm" id="gwcm" class="easyui-textbox" data-options="label:'谷外糙米：'" style="width: 270px" readonly/></td>
          <td title="谷外糙米扣量比例"><input type="text" name="gwcmklbl" id="gwcmklbl" class="easyui-textbox" data-options="label:'谷外糙米扣量比例：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="扣谷外糙米数量"><input type="text" name="kgwcmsl" id="kgwcmsl" class="easyui-textbox" data-options="label:'扣谷外糙米数量：'" style="width: 270px" readonly/></td>
          <td title="其中矿物质"><input type="text" name="qzkwz" id="qzkwz" class="easyui-textbox" data-options="label:'其中矿物质：'" style="width: 270px" readonly/></td>
          <td title="其中矿物质扣量比例"><input type="text" name="qzkwzklbl" id="qzkwzklbl" class="easyui-textbox" data-options="label:'其中矿物质扣量比例：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="扣其中矿物质数量"><input type="text" name="kqzkwzsl" id="kqzkwzsl" class="easyui-textbox" data-options="label:'扣其中矿物质数量：'" style="width: 270px" readonly/></td>
          <td title="硬度"><input type="text" name="yd" id="yd" class="easyui-textbox" data-options="label:'硬度：'" style="width: 270px" readonly/></td>
          <td title="互混率"><input type="text" name="hhl" id="hhl" class="easyui-textbox" data-options="label:'互混率：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="互混率扣量比例"><input type="text" name="hhlklbl" id="hhlklbl" class="easyui-textbox" data-options="label:'互混率扣量比例：'" style="width: 270px" readonly/></td>
          <td title="扣互混率数量"><input type="text" name="khhlsl" id="khhlsl" class="easyui-textbox" data-options="label:'扣互混率数量：'" style="width: 270px" readonly/></td>
          <td title="生霉粒"><input type="text" name="sml" id="sml" class="easyui-textbox" data-options="label:'生霉粒：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="生霉粒扣量比例"><input type="text" name="smlklbl" id="smlklbl" class="easyui-textbox" data-options="label:'生霉粒扣量比例：'" style="width: 270px" readonly/></td>
          <td title="扣生霉粒数量"><input type="text" name="ksmlsl" id="ksmlsl" class="easyui-textbox" data-options="label:'扣生霉粒数量：'" style="width: 270px" readonly/></td>
          <td title="色泽气味"><input type="text" name="szqw" id="szqw" class="easyui-textbox" data-options="label:'色泽气味：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="单据状态"><input type="text" name="djzt" id="djzt" class="easyui-textbox" data-options="label:'单据状态：'" style="width: 270px" readonly/></td>
          <td title="备注"><input type="text" name="bz" id="bz" class="easyui-textbox" data-options="label:'备注：'" style="width: 270px" readonly/></td>
          <td title="保管员扣水"><input type="text" name="bgyks" id="bgyks" class="easyui-textbox" data-options="label:'保管员扣水：'" style="width: 270px" readonly/></td>
      </tr><tr>
          <td title="保管员扣杂"><input type="text" name="bgykz" id="bgykz" class="easyui-textbox" data-options="label:'保管员扣杂：'" style="width: 270px" readonly/></td>
          <td title="校验码"><input type="text" name="xym" id="xym" class="easyui-textbox" data-options="label:'校验码：'" style="width: 270px" readonly/></td>
          <td title="业务类型"><input type="text" name="ywlx" id="ywlx" class="easyui-textbox" data-options="label:'业务类型：'" style="width: 270px" readonly/></td>
        </tr>
        <tr><td colspan="3"></td></tr>
      </table><table style="border-collapse: separate; border-spacing: 25px;" id="jsForm">
        <tr><td colspan="3" style="font-size: large;"> 结算单据详细 <hr/></td></tr>
        <tr>
        <td title="单据编号"><input type="text" name="jsdjbh" id="jsdjbh" class="easyui-textbox" data-options="label:'单据编号：'" style="width: 270px" readonly/></td>
        <td title="品种"><input type="text" name="jspinzhong" id="jspinzhong" class="easyui-textbox" data-options="label:'品种：'" style="width: 270px" readonly/></td>
        <td title="等级"><input type="text" name="js_dj" id="js_dj" class="easyui-textbox" data-options="label:'等级：'" style="width: 270px" readonly/></td>
        </tr><tr>
        <td title="结算数量"><input type="text" name="jsjssl" id="jsjssl" class="easyui-textbox" data-options="label:'结算数量：'" style="width: 270px" readonly/></td>
        <td title="结算单价"><input type="text" name="jsdj" id="jsdj" class="easyui-textbox" data-options="label:'结算单价：'" style="width: 270px" readonly/></td>
        <td title="结算价款"><input type="text" name="jsjk" id="jsjk" class="easyui-textbox" data-options="label:'结算价款：'" style="width: 270px" readonly/></td>
      </tr><tr>
        <td title="结算员姓名"><input type="text" name="jsyxm" id="jsyxm" class="easyui-textbox" data-options="label:'结算员姓名：'" style="width: 270px" readonly/></td>
        <td title="结算时间"><input type="text" name="jssj" id="jssj" class="easyui-textbox" data-options="label:'结算时间：'" style="width: 270px" readonly/></td>
        <td title="客户名称"><input type="text" name="jskhmc" id="jskhmc" class="easyui-textbox" data-options="label:'客户名称：'" style="width: 270px" readonly/></td>
      </tr><tr>
        <td title="对应入库单编号"><input type="text" name="dyrkdbh" id="dyrkdbh" class="easyui-textbox" data-options="label:'对应入库单编号：'" style="width: 270px" readonly/></td>
        <td title="校验码"><input type="text" name="jsxym" id="jsxym" class="easyui-textbox" data-options="label:'校验码：'" style="width: 270px" readonly/></td>
      </tr>
        <tr><td colspan="3"></td></tr>
    </table><table style="border-collapse: separate; border-spacing: 25px;">
        <tr><td colspan="3" style="font-size: large;"> 图片信息 <hr/></td></tr>
        <tr>
          <td title="承运人身份证照片">承运人身份证照片<img id="img_1"  class="list_img" src="" style="width: 270px;height: 330px"></td>
          <td title="客户身份证照片">客户身份证照片<img id="img_2" class="list_img" src="" style="width: 270px;height: 330px"></td>
          <td title="结算环节照片">结算环节照片<img id="img_3" class="list_img" src="" style="width: 270px;height: 330px"></td>
        </tr><tr>
        <td title="称毛重时前摄像头拍摄的照片">称毛重时前摄像头拍摄的照片<img id="img_4" class="list_img" src="" style="width: 270px;height: 330px"></td>
        <td title="称毛重时后摄像头拍摄的照片">称毛重时后摄像头拍摄的照片<img id="img_5" class="list_img" src="" style="width: 270px;height: 330px"></td>
        <td title="称皮重时前摄像头拍摄的照片">称皮重时前摄像头拍摄的照片<img id="img_6" class="list_img" src="" style="width: 270px;height: 330px"></td>
      </tr><tr>
        <td title="称皮重时后摄像头拍摄的照片">称皮重时后摄像头拍摄的照片<img id="img_7" class="list_img" src="" style="width: 270px;height: 330px"></td>
        </tr>
      </table>
    </form>
  </div>
</div>

<div id="dlg-buttons">
  <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
</div>
<div></div>
<div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:10000;width:100%;height:100%;display:none;">
    <div id="innerdiv" style="position:absolute;overflow: scroll;width: 80%;height: 80%">
        <img id="bigimg" <%--style="border:5px solid #fff;"--%> src="" />
    </div>
</div>
<%--<img src="img.do"/>--%>
</body>
</html>