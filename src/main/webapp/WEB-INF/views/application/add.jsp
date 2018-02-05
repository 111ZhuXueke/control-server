<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="stylesheet" type="text/css" href="${basePath}static/h-ui/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}static/h-ui/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}static/h-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}static/h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="${basePath}static/h-ui/h-ui.admin/css/style.css" />

	<title>新增应用</title>
	<link rel="icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add" action="${basePath}application/add">
		<input type="hidden" class="input-text" name="computerId" value="${computerId}" >
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>应用名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="applicationName" value="" placeholder="" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">路径：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="file" name="applicationUrl" class="btn btn-primary radius" value="" placeholder="" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>类别：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="type" class="select">
					<option value="">---请选择---</option>
					<option value="0">音乐</option>
					<option value="1">视频</option>
					<option value="2">其他</option>
				</select>
				</span> </div>
		</div>

	</form>
</article>

<script type="text/javascript" src="${basePath}static/h-ui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}static/h-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/lib/jquery.validation/1.14.0/messages_zh.js"></script>

<script type="text/javascript">
$(function(){
	//表单验证
	$("#form-article-add").validate({
		rules:{
            applicationName:{
				required:true,
			},
            applicationUrl:{
				required:true,
			},
            type:{
				required:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit(function(data){
			    alert(data);
			});
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
	
	$list = $("#fileList"),
	$btn = $("#btn-star"),
	state = "pending",
	uploader;

});
</script>
</body>
</html>