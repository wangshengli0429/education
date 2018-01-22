<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.education.framework.authority.login.model.LoginUser" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	LoginUser user = (LoginUser)session.getAttribute("user");
%>
<c:set value="<%=path %>" var="path"></c:set>
<c:set value="<%=user %>" var="user"></c:set>
<!-- _meta 作为公共模版分离出去-->
<%@ include file="../../../../layui-inc/_meta.jsp" %>
<!-- _meta 作为公共模版分离出去-->

<title>好学习-欢迎您</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <!-- _header 作为公共模版分离出去-->
	<%@ include file="../../../../layui-inc/_header.jsp" %>
	<!-- _header 作为公共模版分离出去-->
  	
 	<!-- _menu 作为公共模版分离出去-->
	<%@ include file="../../../../layui-inc/_menu.jsp" %>
	<!-- _menu 作为公共模版分离出去-->
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
	<div style="padding:15px;" align="center">
		  <h1>阿忠，周林抓紧写代码，少看黄色图片</h1>
		  <img style="height:450px;width:500px;" src="<%=path%>/static/img/index.jpg"></img>
    </div>
  </div>
  
  <div class="layui-footer">
    	好学习 © layui.com - 底部固定区域
  </div>
</div>

<!-- 公共JS -->
<!-- _footer 作为公共模版分离出去-->
<%@ include file="../../../../layui-inc/_footer.jsp" %>
<!-- _footer 作为公共模版分离出去-->
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});

var menuList = '${menuList}';
//	menuList = eval("(" + menuList + ")");
$(function(){
	// alert(menuList)
});
</script>

</body>
</html>