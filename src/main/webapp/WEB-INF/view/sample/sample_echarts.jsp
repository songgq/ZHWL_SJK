<%@page import="com.ustcsoft.jt.util.PropertyUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>交通运输综合执法系统</title>
<%@include file="/common/common_easyui.jsp" %>
<script type="text/javascript" src="<%=basePath%>scripts/echarts/<%=PropertyUtil.getProperty("echars_url") %>"></script>
<script type="text/javascript">
$(function() {
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    myChart.setOption({
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: []
        }]
    });

 // 异步加载数据
 	$.ajax({
		type: 'get',
		url: "<%=basePath%>getDataOfEcharts.do",
		dataType: 'json',
		success: function(data){
        	// 填入数据
        	myChart.setOption({
            	xAxis: {
            	    data: data.categories
            	},
            	series: [{
            	    // 根据名字对应到相应的系列
                	name: '销量',
                	data: data.data
           		}]
        	});
    	}
	});
});
</script>
</head>

<body>
<div id="main" style="width: 600px;height:400px;"></div>
</body>
</html>
