<%@ page contentType="text/html;charset=UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>学海无涯</title>
    <link rel="icon" href="static/image/logo.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="static/image/logo.ico" type="image/x-icon" />
</head>
<body>
<%
    response.sendRedirect(basePath + "computer/run");
%>
</body>
</html>