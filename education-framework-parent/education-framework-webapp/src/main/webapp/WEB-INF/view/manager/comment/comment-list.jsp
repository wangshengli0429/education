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

<title>好学习-评论管理</title>
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
		<div style="padding: 15px;">
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
  
  <div class="layui-footer">
    	好学习 © layui.com - 底部固定区域
  </div>
</div>

<!-- 公共JS -->
<!-- _footer 作为公共模版分离出去-->
<%@ include file="../../../../layui-inc/_footer.jsp" %>
<!-- _footer 作为公共模版分离出去-->

<!-- 下面写业务相关的JS脚本 -->
<script type type="text/javascript">
//JavaScript代码区域
layui.use('table', function(){
  var table = layui.table;
  // 获取dataTable 
  // alert($("input[name='keyword']").val());
  
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
	    url: '${path}/comment/getAllComment',    //数据接口
	    page: true, //开启分页
	    cols: [[ //表头
	       {field: 'content', title: '评论内容', width:500, sort: true,align:'center', fixed: 'left'}
	      ,{field: 'studentName', title: '评论人', align:'center',width:140}
	      ,{field: 'teacherName', title: '被评论人', align:'center',width:140}
	      ,{field: 'commentTime', title: '评论时间', align:'center',width:180,
	    	  templet:function(row){
	    		  return DateFormat(row.commentTime,'yyyy-MM-dd HH:mm:ss');
	    	 }  
	      } 
	      ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
	    ]]
  		,id: 'testReload'
	  });
  
  	// 监听操作	
  	table.on('tool(comment)',function(obj) {
  		var data = obj.data;
  		alert(data.content);
  		if(obj.event === 'del'){
  			layer.confirm('真的删除吗？', function(index){
  				<%--  $.ajax({
                    url: "<%=path%>/comment/",
                    type: "POST",
                    data:{"uvid":data.id,"memthodname":"deleteuv","aid":data.aid},
                    dataType: "json",
                    success: function(data){
                        if(data.state==1){
                            obj.del();
                            layer.close(index);
                            layer.msg("删除成功", {icon: 6});
                        }else{
                            layer.msg("删除失败", {icon: 5});
                        }
                    }

                });  --%>
  			})
  		}
  	});
  	
  	$('.demoTable .layui-btn').on('click', function(){
  	    var type = $(this).data('type');
  	    active[type] ? active[type].call(this) : '';
  	});
});
</script>
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_30088308'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "w.cnzz.com/c.php%3Fid%3D30088308' type='text/javascript'%3E%3C/script%3E"));</script>
</body>
</html>