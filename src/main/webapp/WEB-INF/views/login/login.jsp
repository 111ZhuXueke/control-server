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
    <link href="${basePath}static/h-ui/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}static/h-ui/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}static/h-ui/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}static/h-ui/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
    <title>后台登录 - 智能助手 - 本地版本</title>
    <link rel="icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
<%--<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">--%>
<%--<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">--%>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input  id="name" type="text" placeholder="账户" class="input-text size-L" value="${uname}">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input  id="pwd" type="password" placeholder="密码" class="input-text size-L" value="${upwd}">
        </div>
      </div>
        <div class="row cl">
            <label class="form-label col-xs-3"></label>
            <div class="formControls col-xs-8">
                <label class="form-label col-xs-3 back-msg"></label>
            </div>
        </div>
      <%--<div class="row cl">--%>
        <%--<div class="formControls col-xs-8 col-xs-offset-3">--%>
          <%--<input class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">--%>
          <%--<img src=""> <a id="kanbuq" href="javascript:;">看不清，换一张</a> </div>--%>
      <%--</div>--%>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="">
            使我保持登录状态</label>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright fzet by 2018-01-23</div>
<script type="text/javascript" src="${basePath}static/h-ui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}static/h-ui/h-ui/js/H-ui.min.js"></script>
<script>
    $(function(){
        $(".sub").click(function(){
            $.post("${basePath}computer/login",{"pwd":$("#pwd").val(),"name":$("#name").val()},function(result){
                var obj = eval("("+result+")");
                $(".msage").css("display","block");
                var message = obj.message;
                if(obj.ok != null){
                    $(".back-msg").css("color","green");
                    $(".back-msg").html(message);
                    setTimeout(function(){
                        window.location.href = "${basePath}computer/openApplication";
                    },1000);
                }else{
                    $(".back-msg").html(message);
                    $(".back-msg").css("color","red");
                }
            });
        });
    })
</script>
</body>
</html>