<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sku属性内嵌页</title>
<script type="text/javascript">
	function sku_innerShowAttrvalue(checked, attrid) {
		if (checked) {
			$("#sku_inner_div_"+attrid).show();
		} else {
			$("#sku_inner_div_"+attrid).hide();
		}
	}
</script>
</head>
<body>
	<c:forEach items="${attrList}" var="attr" varStatus="attrIndex" >
		<input type="checkbox" value="${attr.id}" name="sku_attr_values[${attrIndex.index}].shxm_id" onclick="sku_innerShowAttrvalue(this.checked,${attr.id})" />${attr.shxm_mch}
	</c:forEach>
	<br/>
	<br/>
	<c:forEach items="${attrList}" var="attr" varStatus="attrIndex">
		<div id="sku_inner_div_${attr.id}" style="display:none">
			<c:forEach items="${attr.valueList}" var="attrvalue">
				<input type="radio" name="sku_attr_values[${attrIndex.index}].shxzh_id" value="${attrvalue.id}" />${attrvalue.shxzh}${attrvalue.shxzh_mch}
			</c:forEach>
		</div>
		<br/>
	</c:forEach>
	库存：<input type="text" name="kc"/><br>
	价格：<input type="text" name="jg"/><br>
	名称：<input type="text" name="sku_mch"/><br>
	地址：<input type="text" name="kcdz"/><br>
	<input type="submit" value="发布库存信息"/>
</body>
</html>