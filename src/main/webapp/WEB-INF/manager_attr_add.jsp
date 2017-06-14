<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	var attr = 0;
	function attr_table_add() {
		attr++;
		var content = '';
		content+='<table id="attr_table_'+attr+'" border="1">';
		content+='	<tr>';
		content+='		<td>属性名:<input type="text" name="attrList['+attr+'].shxm_mch" /></td><td></td><td><a href="javascript:attr_tr_add('+attr+');">添加值</a></td>';
		content+='	</tr>';
		content+='	<tr>';
		content+='		<td>属性值:<input type="text" name="attrList['+attr+'].valueList[0].shxzh" /></td><td>属性值名:<input type="text" name="attrList['+attr+'].valueList[0].shxzh_mch" /></td><td>删除</td>';
		content+='	</tr>';
		content+='	<tr>';
		content+='		<td>属性值:<input type="text" name="attrList['+attr+'].valueList[1].shxzh" /></td><td>属性值名:<input type="text" name="attrList['+attr+'].valueList[1].shxzh_mch" /></td><td>删除</td>';
		content+='	</tr>';
		content+='</table><hr/>';
		$("#attr_table_div").append(content);
	}
	
	function attr_tr_add(attr) {
		var trIndex = $("#attr_table_"+attr+" tr").length-1;
		var content = '';
		content+='<tr>';
		content+='	<td>属性值:<input type="text" name="attrList['+attr+'].valueList['+trIndex+'].shxzh" /></td><td>属性值名:<input type="text" name="attrList['+attr+'].valueList['+trIndex+'].shxzh_mch" /></td><td>删除</td>';
		content+='</tr>';
		$("#attr_table_"+attr).append(content);
	}
</script>
<title>添加属性信息</title>
</head>
<body>
	${success}
	<h3>添加======${class2name}======属性</h3>
	<form action="add_attr.do" method="post">
		<input type="hidden" name="class2id" value="${class2id}"/>
		<input type="hidden" name="class2name" value="${class2name}"/>
		<div id="attr_table_div">
			<a href="javascript:attr_table_add();">添加属性</a>
			<table id="attr_table_0" border="1">
				<tr>
					<td>属性名:<input type="text" name="attrList[0].shxm_mch" /></td><td></td><td><a href="javascript:attr_tr_add(0);">添加值</a></td>
				</tr>
				<tr>
					<td>属性值:<input type="text" name="attrList[0].valueList[0].shxzh" /></td><td>属性值名:<input type="text" name="attrList[0].valueList[0].shxzh_mch" /></td><td>删除</td>
				</tr>
				<tr>
					<td>属性值:<input type="text" name="attrList[0].valueList[1].shxzh" /></td><td>属性值名:<input type="text" name="attrList[0].valueList[1].shxzh_mch" /></td><td>删除</td>
				</tr>
			</table>
			<hr/>
		</div>
		<br/>
		<input type="submit" value="发布属性信息" />
	</form>
</body>
</html>