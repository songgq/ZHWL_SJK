$(function() {
	$('.sub-menu dd>a').click(
			function() {
				var _this = $(this).parent();
				_this.addClass('on').siblings().removeClass('on');
				$(this).siblings().slideToggle().parent().siblings().find(
						'.three-menu-child').slideUp();
	});

	$('.menu-toggle').click(function() {
		$(this).toggleClass('on');
		if ($(this).hasClass('on')) {
			$('.main-left').animate({
				left : "-200px"
			});
			$('.main-right').animate({
				left : "0"
			});
			$(this).animate({
				left : "0"
			});
		} else {
			$('.main-left').animate({
				left : "0"
			});
			$('.main-right').animate({
				left : "200px"
			});
			$(this).animate({
				left : "200px"
			});
		}
	})

	shouYeInit();
	CreateDiv("shouye", "welcome.do", "首页", "notrefresh");

});

var closeFuncMap = {};
function CreateDiv(tabid, url, name, type, callback)// tabid 用来关闭这个tab
{
	closeFuncMap[tabid] = callback;
	var tablist = $('#pageIframes').tabs('tabs');
	// /如果当前tabid不存在则新建一个tab
	if (!$('#pageIframes').tabs('exists', name)) {
		if (tablist.length > 8) {
			layer.msg('页面打开太多，请关闭后再打开!', {
				shift : 6
			});
			return;
		}
		var iframe = '<div title="'+name+'"><iframe id='+tabid+' src="'+url+'" frameborder="no"  width="100%" scrolling="auto"></iframe></div>';
		var closable = true;
		if (tabid == "shouye") {
			closable = false;
		}
		$('#pageIframes').tabs('add', {
			title : name,
			content : iframe,
			iconCls : '',
			closable : closable,
			tabWidth : (60 + name.length * 15) + "px"
		});
		$("#"+tabid).height($('.main-right').height()-48);
	} else {// /如果当前tabid存在直接显示已经打开的tab
		$('#pageIframes').tabs('select', name);
		if (type == "refresh") {
			$("#"+tabid).attr('src', url);
		}
	}
}
function setacrent(tabname) {// 设置当前高亮的tab是哪一个
	$('#pageIframes').tabs('select', tabname);
}
function CloseDiv(tabname) {
	$('#pageIframes').tabs('close', tabname);
}
var cacheAry = [];
function shouYeInit() {// 首页tab的初始化 包含 快捷菜单 、菜单、通知公告
	$.ajax({
		url : path + 'sysMenu/findSysMenuTreeAll.do',
		data : {
			"node" : "0"
		},
		success : function(data) {
			var nodeMap = {
				"0" : {}
			};
			for (var i = 0; i < data.length; i++) {
				var node = data[i];
				if (node.menuUrl) {
					node.menuUrl = path + node.menuUrl;
				}
				nodeMap[node.menuId] = node;
				if (!nodeMap[node.parentId]) {
					continue;
				}
				if (!nodeMap[node.parentId].children) {
					nodeMap[node.parentId].children = [];
				}
				nodeMap[node.parentId].children.push(node);
			}
			var rootNode = nodeMap["0"];
			createMenuHtml(rootNode);

		}
	});
}

function createMenuHtml(node) {// 创建主菜单的方法
	if (node.children) {
		for (var i = 0; i < node.children.length; i++) {// 当主菜单少于等于13个的时候
			createNodeHtml(node.children[i], i);
		}
	}
}
function createNodeHtml(n, index) {// 创建主菜单的方法的子方法
	var level = n.menuId.replace(/(00)+$/, "").length / 2;
	if (level == 1) {
		cacheAry = [];
		cacheAry.push('<div class="sub-menu"><dl>');
		for (var j = 0; j < n.children.length; j++) {
			createNodeHtml(n.children[j], j);
		}
		cacheAry.push('</dl></div>');
		$('#sider-menu').accordion('add', {
			title: n.menuName,
			content: cacheAry.join(""),
			selected: false,
			iconCls:n.menuIco
		});
	} else if (level == 2) {
		cacheAry.push('<dd class="three-menu">');
		if (n.children) {
			cacheAry.push('<a href="javascript:;"><i class="line"></i>'+n.menuName+'<i class="toggle"></i></a><ul class="three-menu-child">');
			for (var j = 0; j < n.children.length; j++) {
				createNodeHtml(n.children[j], j);
			}
			cacheAry.push('</ul>');
		}else{
			cacheAry.push('<a href="javascript:;" title="' + n.menuName
					+ '" onclick=\"CreateDiv(\'' + n.menuId + '\',\''
					+ n.menuUrl + '\',\'' + n.menuName
					+ '\',\'notrefresh\')\"><i class="line"></i>'+n.menuName+'<i class="toggle"></i></a>');
		}
		cacheAry.push('</dd>');
	} else {
		var sign = '?';
		if (n.menuUrl.indexOf('?') > -1) {
			sign = '&';
		}
		n.menuUrl = n.menuUrl + sign + 'menuId=' + n.menuId + '&timetamp='
				+ new Date().getTime();
		cacheAry.push('<li><a href="javascript:;" title="' + n.menuName
				+ '" onclick=\"CreateDiv(\'' + n.menuId + '\',\''
				+ n.menuUrl + '\',\'' + n.menuName
				+ '\',\'notrefresh\')\">' + n.menuName + '</a></li>');
	}
}
