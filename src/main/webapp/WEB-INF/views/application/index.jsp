﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<title>应用程序列表</title>
	<link rel="icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 应用程序管理 <span class="c-gray en">&gt;</span> 应用程序列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
		<div class="text-c">
			日期范围：
			<input type="text" placeholder="开始日期" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'beginTime\')||\'%y-%M-%d\'}' })" id="beginTime" class="input-text Wdate" style="width:120px;">
			-
			<input type="text" placeholder="结束日期" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'endTime\')}',maxDate:'%y-%M-%d' })" id="endTime" class="input-text Wdate" style="width:120px;">
			<input type="text" name="applicationName" id="applicationName" placeholder="应用程序名称" style="width:250px" class="input-text">
			<button name="" id="on-search" class="btn btn-success" type="button"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
            <span class="l">
                <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
                <a class="btn btn-primary radius" data-title="新增应用" onclick="article_add('新增应用','${basePath}application/add',300,500)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 新增应用</a>
            </span>
            <span class="r">共有数据：<strong>54</strong> 条</span>
        </div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="80">ID</th>
						<th width="100">应用程序名称</th>
						<th width="200">应用程序路径</th>
						<th width="80">创建时间</th>
						<th width="80">类别</th>
						<th width="120">操作</th>
					</tr>
				</thead>
			</table>
		</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${basePath}static/h-ui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}static/h-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $('.table-sort').dataTable({
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "bStateSave": true,//状态保存
        "pading":false,
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable":false,"aTargets":[0,8]}// 不参与排序的列
        ]
    });
    /*应用程序-添加*/
	function article_add(title,url,w,h){
		var index = layer.open({
			type: 2,
			title: title,
			content: url
		});
		layer.full(index);
	}
/*资讯-编辑*/
function article_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*资讯-删除*/
function article_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*资讯-下架*/
function article_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

/*资讯-发布*/
function article_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}
/*资讯-申请上线*/
function article_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}

</script> 
</body>
</html>