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

<title>角色管理</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	<!-- _header 引入 -->
	<%@ include file="../../../../layui-inc/_header.jsp" %>
	<!-- _header 引入 -->
	<!-- _menu 引入 -->
	<%@ include file="../../../../layui-inc/_menu.jsp" %>
	<!-- _menu 引入 -->
	
	<div class="layui-body">
	<!-- 内容主体 -->
		<div style="padding:15px;">
			<div class="demoTable">
				<div class="layui-inline">
				    <input class="layui-input" name="keyword" id="demoReload" autocomplete="off">
				</div>
				<button class="layui-btn" data-type="reload">搜索</button>
			</div>
			<table class="layui-hide" id="dataTable" lay-filter="comment"></table>
			<script type="text/html" id="barDemo">
  				<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
			</script>
		</div>
	</div>
	<!-- 脚 -->
	 <div class="layui-footer">
    	好学习 © layui.com - 底部固定区域
   </div>
</div>
<!-- _footer 作为公共模版分离出去-->
<%@ include file="../../../../layui-inc/_footer.jsp" %>
<!-- _footer 作为公共模版分离出去-->
<script type="text/javascript">
	//javascript 代码区域
	layui.use("table",function(){
		  var table = layui.table;
		  var $ = layui.$, active = {
			        reload: function(){
			            var demoReload = $('#demoReload');
			            table.reload('testReload', {
			                where: {
			                	keyword: demoReload.val()
			                }
			            });
			        }
			    }; 
		  // 加载表格数据
		  table.render({
			    elem: '#dataTable',
			    /* params:{keyword:$("input[name='keyword']").val()}, */
			    height: 450,
			    url: '${path}/role/getAllRole',    //数据接口
			    page: true, //开启分页
			    cols: [[ //表头
			       {field: 'roleCode', title: '角色代码', width:500, sort: true,align:'center', fixed: 'left'}
			      ,{field: 'roleDescr', title: '角色', align:'center',width:140}
			      ,{field: 'remark', title: '备注', align:'center',width:140}
			      ,{field: 'createTime', title: '创建时间', align:'center',width:180,
			    	  templet:function(row){
			    		  return DateFormat(row.createTime,'yyyy-MM-dd HH:mm:ss');
			    	 }  
			      } 
			      ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
			    ]]
		  		,id: 'testReload'
			  });
		// 监听操作	
		  	table.on('tool(comment)',function(obj) {
		  		var data = obj.data;
		  		alert(data.id);
		  		if(obj.event === 'del'){
		  			layer.confirm('真的删除吗？', function(index){
		  				 $.ajax({
		                    url: "<%=path%>/comment/updateCommentStatusById",
		                    type: "POST",
		                    data:{"id":data.id},
		                    dataType: "json",
		                    success: function(data){
		                        if(data.code == 7){
		                            obj.del();
		                            layer.close(index);
		                            layer.msg("删除成功", {icon: 6});
		                        }else{
		                            layer.msg("删除失败", {icon: 5});
		                        }
		                    }

		                });
		  			})
		  		}
		  	});
		
		  	$('.demoTable .layui-btn').on('click', function(){
		  	    var type = $(this).data('type');
		  	    active[type] ? active[type].call(this) : '';
		  	});
	});
	
</script>

</body>
</html>