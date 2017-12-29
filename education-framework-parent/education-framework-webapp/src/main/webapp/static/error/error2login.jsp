<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常告警</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/static/css/default.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/static/easyUi/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/static/easyUi/themes/icon.css" />
<script type="text/javascript" src="<%=path %>/static/js/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/easyUi/jquery.easyui.min.js"></script>
<script type="text/javascript">
    $(function(){
        setTimeout(function(){
            window.top.location="<%=path %>/login.jsp";
               },2000);
        $("#toLogin").click(function(){
            window.top.location="<%=path %>/login.jsp";
        });
    })
</script>
</head>
<body>
<p style="font-size: 12px; color:red;">用户登录异常或session已失效，请重新登录！！！！页面2秒后自动跳转至登录页面，如未自动跳转，请点击下面登录
    <a href="javascript:void(0)" id="toLogin">登录</a>
</p>
</body>
</html>