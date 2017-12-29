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
        var msg = '';
        //alert('没有权限');
    })
</script>
</head>
<body>
<span style="font-size: 50px;margin-left: 40%;">没有权限</span>
</body>
</html>