<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.education.framework.authority.login.model.LoginUser"  %>
<%@ page import="com.education.framework.authority.login.model.LoginUser" %>
<%taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path=request.getContextPath();
	LoginUser user=session.getAttribute("user")
%>
<c:set value="<%=path %>" var="path"></c:set>
<c:set value="<%=user %>" var="user"></c:set>
<!-- 引用 meta 公共模板 -->
<%@ include file="../../../../layui-inc/_meta.jsp" %>

<title>角色管理</title>
</head>
<body class="layui-layout-body">
<div></div>

</body>
</html>