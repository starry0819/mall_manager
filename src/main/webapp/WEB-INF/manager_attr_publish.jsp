<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>属性信息发布</title>
<script type="text/javascript">
	$(function() {
		// 获取一级分类的json数据并遍历添加到一级分类的select中
		$.getJSON("js/json/class_1.js", function(data) {
			$.each(data, function(i, item) {
				var option = "<option value="+item.id+">"+item.flmch1+"</option>";
				$("#attr_class1_select").append(option);
			});
		});
	});
	
	function attr_class2OptionByclass1(class1id) {
		// 当一级分类选择变化时，清空二级分类和品牌的下拉列表内容，并新增请选择的下拉
		$("#attr_class2_select").empty().append("<option value='0'>请选择</option>");
		$("#attr_trademark_select").empty().append("<option value='0'>请选择</option>");
		
		// 根据一级分类的id获取二级分类的json数据并遍历添加至二级分类的select中
		$.getJSON("js/json/class_2_"+class1id+".js", function(data) {
			$.each(data, function(i, item) {
				$("#attr_class2_select").append("<option value="+item.id+">"+item.flmch2+"</option>");
			});
		});
	}
	
	function attr_attrQueryByclass2(class2id) {
		$("#attr_show_div").datagrid({
			url:'get_attrlistByclass2.do',
			queryParams:{
				class2id:class2id
			},
			columns:[[
				{field:'shxm_mch',title:'属性名',width:100},  
	            {field:'chjshj',title:'创建时间',width:200,
	            	formatter: function(value,row,index){
	            		var d = new Date(value);
	            		return d.toLocaleString();
	            	}
	            },
	            {field:'list_value',title:'属性值',width:300,
	            	formatter: function(value,row,index){
	            		var v ="属性值";
	            		$(value).each(function(i,json){
	            			v +=" "+json.shxzh + json.shxzh_mch;
	            		});
	            		return v;
	            	}
	            }
			]]
		});
		
	}
	
	function to_attr_add() {
		var class2id = $("#attr_class2_select").val();
		var class2name = $("#attr_class2_select option:selected").html();
		if (class2id != 0) {
			window.open("to_attr_add/"+class2id+"/"+class2name+"/.htm");
			// 此处还可以使用window.open();
		}
	}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<h3>${result}</h3><br/>
		<div data-options="region:'west',split:true" style="height:50px">
			一级分类<br/>
			<select name="flbh1" id="attr_class1_select" style="width:80px" onchange="attr_class2OptionByclass1(this.value)">
				<option>请选择</option>
			</select><br/><br/>
			二级分类<br/>
			<select name="flbh2" id="attr_class2_select" style="width:80px" onchange="attr_attrQueryByclass2(this.value)">
				<option value="0">请选择</option>
			</select><br/><br/>
			<div id="attr_show_div" class="easyui-datagrid">
			</div>
			<a href="javascript:to_attr_add();" target="_blank">添加属性</a>
		</div>
	</div>
</body>
</html>