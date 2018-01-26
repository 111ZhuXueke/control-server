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
    <title>我的桌面</title>
    <link rel="icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
</head>
<body>
<div class="page-container">
	<p class="f-20 text-success">欢迎使用 智能助手 <span class="f-14"></span>window版本！</p>
	<p>上次登录IP：${welcome.lastIp}  上次登录时间：${welcome.updateTime}</p>
	<table class="table table-border table-bordered table-bg mt-20">
		<thead>
			<tr>
				<th colspan="2" scope="col">服务器信息</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th width="30%">计算机名称</th>
				<td><span id="lbServerName">${info.computerName}</span></td>
			</tr>
			<tr>
				<td>当前IPv4地址</td>
				<td>${info.ipv4}</td>
			</tr>
			<tr>
				<td>占用的端口 </td>
				<td>${welcome.port}</td>
			</tr>
            <tr>
                <td>计算机域名 </td>
                <td>${info.computerDomain}</td>
            </tr>
			<tr>
				<td>操作系统以及版本 </td>
				<td>${info.operationSystem}</td>
			</tr>
			<tr>
				<td>本次登录过期时间 </td>
				<td>${info.signOutTime}分钟</td>
			</tr>
			<tr>
				<td>服务器的语言种类 </td>
				<td>Chinese (People's Republic of China)</td>
			</tr>
			<tr>
				<td>服务器当前时间 </td>
				<td>${info.nowTime}</td>
			</tr>
			<tr>
				<td>逻辑驱动器 </td>
				<td>${info.letters}</td>
			</tr>
			<tr>
				<td>CPU 总数 </td>
				<td>${info.cpuCount}</td>
			</tr>
			<tr>
				<td>当前SessionID </td>
				<td>${info.sessionId}</td>
			</tr>
			<tr>
				<td>当前系统用户名 </td>
				<td>${welcome.name}</td>
			</tr>
		</tbody>
	</table>
</div>
<footer class="footer mt-20">
	<div class="container">
		<p>本后台系统由 <a href="#" target="_blank" title="智行助手">FZET 锐进科技有限公司</a> 提供技术支持</p>
	</div>
</footer>
<script type="text/javascript" src="${basePath}static/h-ui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui//h-ui/js/H-ui.min.js"></script>
<script>

</script>
</body>
</html>