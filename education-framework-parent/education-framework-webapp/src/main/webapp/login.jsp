<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<c:set value="<%=path %>" var="path"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/static/jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/static/jquery-easyui-1.5.3/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/static/jquery-easyui-1.5.3/demo/demo.css">
<script type="text/javascript" src="<%=path %>/static/jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>

</head>
<body>
	 
	<div id="dlg" class="easyui-dialog" title="User for Login" style="width:400px;height:200px;padding:10px">
		 <form id="loginform" method="post" action="<%=path %>/login/doLogin">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>Name:</td>
	    			<td><input class="easyui-textbox" type="text" name="userName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Password:</td>
	    			<td><input class="easyui-textbox" type="password" name="passWord" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<input type="submit" value="登录"/>
	    			<input type="button" value="注册" onclick="alert('注册')"/>
	    		</tr>
	    	</table>
	    </form>
	     
	</div>
	 
</body>
</html>