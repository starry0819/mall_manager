<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<title>商品信息发布</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		$("#spu_class1_select").combobox({
			url:'js/json/class_1.js',
			valueField:'id',
			textField:'flmch1',
			width:100,
			onSelect: function spu_class2AndTrademarkOptionByclass1(){
				var class1id = $(this).combobox('getValue');
				$("#spu_class2_select").combobox({
					url:'js/json/class_2_'+class1id+'.js',
					valueField:'id',
					textField:'flmch2'
				});
				$("#spu_trademark_select").combobox({
					url:'js/json/trademark_'+class1id+'.js',
					valueField:'id',
					textField:'ppmch'
				});
			}
		});
		
	});
	
	function spu_img_click(index) {
		$("#spu_img_file_"+index).click();
	}
	
	function spu_img_file_change(index) {
		var image = $("#spu_img_file_"+index)[0].files[0];
		var url = window.URL.createObjectURL(image);
		$("#spu_img_"+index).attr("src", url);
		
		if ((index == ($("#spu_shp_tp_div :file").length-1)) && index < 4) {
			var img = '<img id="spu_img_'+(index+1)+'" width="100px" src="img/upload_hover.png" onclick="spu_img_click('+(index+1)+')" style="cursor:pointer" />';
			$("#spu_shp_tp_div").append(img);
			var inputfile = '<input id="spu_img_file_'+(index+1)+'" name="files" style="display:none" type="file" onchange="spu_img_file_change('+(index+1)+')" />';
			$("#spu_shp_tp_div").append(inputfile);
		}
	}
	
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="spu_publish.do" method="post" enctype="multipart/form-data">
			<div data-options="region:'west',split:true" style="width:300px">
				<h3>${result}</h3><br/>
					一级分类<br/>
					<select name="flbh1" id="spu_class1_select" style="width:80px" onchange="spu_class2OptionByclass1(this.value)">
						<option>请选择</option>
					</select><br/><br/>
					二级分类<br/>
					<select class="easyui-combobox" id="spu_class2_select" data-options="width:100" name="flbh2">
						<option>请选择</option>
					</select><br/><br/>
					品牌<br/>
					<select class="easyui-combobox" id="spu_trademark_select" data-options="width:100" name="pp_id">
						<option>请选择</option>
					</select><br/><br/>
			</div>
			<div data-options="region:'center'">
				商品spu名称：<input class="easyui-textbox" data-options="required:true" type="text" name="shp_mch" /><br/>
				商品spu描述：<input type="text" name="shp_msh" /><br/>
				商品图片组：
				<div id="spu_shp_tp_div">
					<img id="spu_img_0" height="80px" width="80px" src="img/upload_hover.png" onclick="spu_img_click(0)" style="cursor:pointer"/>
					<input id="spu_img_file_0" name="files" style="display:none" type="file" onchange="spu_img_file_change(0)" />
				</div>
				<input type="submit" value="发布spu信息" />
			</div>
		</form>
	</div>
</body>
</html>