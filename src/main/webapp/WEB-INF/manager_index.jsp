<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理主页面</title>
<link rel="stylesheet" type="text/css" href="js/jqueryeasyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/jqueryeasyui/themes/icon.css">
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/jqueryeasyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {
		var title = "${title}";
		var url = "${url}";
		if (title!="") {
			indexAddtabs(title,url);
		}
	});

	function indexAddtabs(title, url) {
		if (!$('#indexCenter').tabs('exists',title)) {
			$.get(url, function(data) {
				$('#indexCenter').tabs('add',{    
				    title:title,
				    content:data,
				    closable:true
				});  
			})
		}
	}

</script>
</head>
<body class="easyui-layout">

	<div data-options="region:'north'" style="height:50px"></div>
	<div data-options="region:'south',split:true" style="height:50px;"></div>
	<div data-options="region:'east',split:true" title="East" style="width:180px;">
		<ul class="easyui-tree" ></ul>
	</div>
	<div data-options="region:'west',split:true" title="West" style="width:150px;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="商品发布模块" style="padding:10px;" data-options="selected:true">
				<a href="javascript:indexAddtabs('商品信息分布','to_spu_publish/.htm')" >商品信息发布</a><br/><br/>
				<a href="javascript:indexAddtabs('属性信息发布','to_attr_publish/.htm')">属性信息发布</a><br/><br/>
				<a href="javascript:indexAddtabs('库存信息发布','to_sku_publish/.htm')" >库存信息发布</a><br/><br/>
			</div>
			<div title="订单管理模块" data-options="" style="padding:10px;">
				<a href="javascript:;">订单查询</a><br/><br/>
				<a href="javascript:;">订单修改</a><br/><br/>
				<a href="javascript:;">订单删除</a><br/><br/>
			</div>
			<div title="缓存管理模块" style="padding:10px">
				<a href="javascript:indexAddtabs('分类检索缓存管理','to_search_redis/.htm')">分类检索缓存管理</a><br/><br/>
			</div>
		</div>
	</div>
	<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
		<div id="indexCenter" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
		</div>
	</div>



</body>
</html>