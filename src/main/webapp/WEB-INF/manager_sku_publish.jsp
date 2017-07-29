<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存信息发布</title>
<script type="text/javascript">
	$(function() {
		$.getJSON("js/json/class_1.js", function(data) {
			$.each(data, function(i, item) {
				var option = "<option value="+item.id+">"+item.flmch1+"</option>";
				$("#sku_class1_select").append(option);
			});
		});
	});
	
	function sku_class2OptionByclass1(class1id) {
		// 当一级分类选择变化时，清空二级分类和品牌的下拉列表内容，并新增请选择的下拉
		$("#sku_class2_select").empty().append("<option value='0'>请选择</option>");
		$("#sku_trademark_select").empty().append("<option value='0'>请选择</option>");
		
		// 根据一级分类的id获取二级分类的json数据并遍历添加至二级分类的select中
		$.getJSON("js/json/class_2_"+class1id+".js", function(data) {
			$.each(data, function(i, item) {
				$("#sku_class2_select").append("<option value="+item.id+">"+item.flmch2+"</option>");
			});
		});
		
		// 根据一级分类的id获取品牌的json数据并遍历添加至二级分类的select中
		$.getJSON("js/json/trademark_"+class1id+".js", function(data) {
			$.each(data, function(i, item) {
				$("#sku_trademark_select").append("<option value="+item.id+">"+item.ppmch+"</option>");
			});
		});
	}
	
	function sku_spuQueryByppid_class2id_class1id() {
		var pp_id = $("#sku_trademark_select").val();
		var class1id = $("#sku_class1_select").val();
		var class2id = $("#sku_class2_select").val();
		$("#sku_spu_select").empty().append("<option value='0'>请选择</option>");
		$.post("get_spuByppid_class2id_class1id.do",{"flbh2":class2id,"flbh1":class1id,"pp_id":pp_id},function(data){
			$.each(data, function(i, item) {
				$("#sku_spu_select").append("<option value="+item.id+">"+item.shp_mch+"</option>");
			});
		});
	}
	
	function sku_attrQueryByclass2(class2id) {
		$.post("get_skuAttrlistByclass2.do",{"class2id":class2id},function(data){
			$("#sku_showAttr_div").html(data);
		});
	}
</script>
</head>
<body>
	<h3>库存信息发布</h3>
	${result}
	<form action="addSku.do" method="post">
		一级分类<br/>
		<select id="sku_class1_select" style="width:80px" onchange="sku_class2OptionByclass1(this.value)">
			<option value="0">请选择</option>
		</select><br/><br/>
		二级分类<br/>
		<select id="sku_class2_select" style="width:80px" onchange="sku_attrQueryByclass2(this.value)">
			<option value="0">请选择</option>
		</select><br/><br/>
		品牌<br/>
		<select id="sku_trademark_select" style="width:80px" onchange="sku_spuQueryByppid_class2id_class1id()">
			<option>请选择</option>
		</select><br/><br/>
		商品信息<br/>
		<select name="shp_id" id="sku_spu_select" >
			<option value="0">请选择</option>
		</select><br/><br/>
		<div id="sku_showAttr_div"></div>
	</form>
</body>
</html>