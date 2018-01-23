<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.education.framework.authority.login.model.LoginUser" %>
<%@ page import="com.education.framework.model.student.Student" %>
<%@ page import="java.util.Map" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	LoginUser user = (LoginUser)session.getAttribute("user");
	Map<String, Object> map = new HashMap<String, Object>();
	Student student = (Student)map.get("student"); 
%>
<c:set value="<%=path %>" var="path"></c:set>
<c:set value="<%=user %>" var="user"></c:set>
<c:set value="<%=student %>" var="student"></c:set>

<!-- _meta 作为公共模版分离出去-->
<%@ include file="../../../../layui-inc/_meta.jsp" %>
<!-- _meta 作为公共模版分离出去-->
<!-- 下面写业务相关的JS脚本 -->

<title>好学习-学生管理</title>
</head>
<body class="layui-layout-body">
  
	<form class="layui-form" action="">
	<div class="layui-form-item">
	  <label class="layui-form-label">学生ID:${id }</label>
	  <div class="layui-input-block">
			  
	  </div>
	  <label class="layui-form-label">学生姓名:</label>
	  <div class="layui-input-block">
			   ${studentName }
	  </div>
	</div>
	
	<div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-submit lay-filter="formSubmit">审核通过</button>
	      <button type="layui-btn" class="layui-btn layui-btn-primary" lay-filter="formNo">审核未通过</button>
	    </div>
     </div>
	
	</form>
<script type type="text/javascript">
var student = '${student}';
$(function(){
alert(student)
})
// //JavaScript代码区域
// layui.use('form', function(){
//   var form = layui.form;
//   layer.msg(student)
//   //监听提交
//   form.on('submit(formSubmit)', function(data){
//     layer.msg(JSON.stringify(data.field));
//     return false;
//   });
// });


</script>
</body>
</html>