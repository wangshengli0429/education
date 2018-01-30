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
    	<table class="layui-hide" id="dataTable" lay-filter="teacher"></table>
    	<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
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
	    url: '${path}/query/teacher',    //数据接口
	    page: true, //开启分页
	    cols: [[ //表头
	      {field: 'teacherName', title: '教师姓名', align:'center',width:140}
	      ,{field: 'phone', title: '电话', align:'center',width:120}
	      ,{field: 'age', title: '年龄', align:'center',width:50}
	      ,{field: 'nativePlace', title: '籍贯', align:'center',width:140}
	      ,{field: 'province', title: '所在省份', align:'center',width:140}
	      ,{field: 'city', title: '所在城市', align:'center',width:140}
	      ,{field: 'district', title: '所在区县', align:'center',width:140}
	      ,{field: 'address', title: '现在住址', align:'center',width:140}
	      ,{field: 'idNumber', title: '身份证号', align:'center',width:140}
	      ,{field: 'accountName', title: '支付宝账号', align:'center',width:140}
	      ,{field: 'education', title: '最高学历', align:'center',width:140}
	      ,{field: 'major', title: '所学专业', align:'center',width:140}
	      ,{field: 'selfDescr', title: '自我介绍', align:'center',width:140}
	      ,{field: 'remark', title: '备注', align:'center',width:140}
	      ,{field: 'regTime', title: '注册时间', align:'center',width:180,
	    	  templet:function(row){
	    		  return DateFormat(row.regTime,'yyyy-MM-dd HH:mm:ss');
	    	 }  
	      } 
	      ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
	    ]]
  		,id: 'testReload'
	  });
  
  	// 监听操作	
  	table.on('tool(teacher)',function(obj) {
  		var data = obj.data;

  		if(obj.event === 'detail'){
 			 $.ajax({
 	            url: '${path}/query/teacher/'+data.id,
 	            type: 'get',
 	            dataType:'json',
 	            contentType: 'application/json',
 	            async:false,
 	            success: function (data) {
 	            	
 	                if (data.teacher != null &&  data.teacher !== 'undefined') {
						var gender = "-";
 	                    if(data.teacher.gender === 'M'){gender="男"}if(data.teacher.gender === 'W'){gender="女"}
 	                  layer.open({ 
 	  	       			  title: ['教师审核', 'background-color: #00bb9d;text-align:center;font-size:18px;'],
 	  	       			  type: 1,
 	  	       			  shade: false,  
 	  	       		      maxmin: true, 
 	  	       			  skin: 'layui-layer-rim', //加上边框
 	  	       			  area: ['750px', '500px'], //宽高
 	  	       			  content: '<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">'+
 	  	       		  					'<legend>教师审核</legend>'+
 	  	      	  					'</fieldset>'+
 	  	      	  			'<table class="layui-table" lay-size="sm" style="width: 500px;height: 120px;margin-left: 80px;">'+
			  	      		  '<colgroup>'+
			  	      		    '<col width="80" align="right" >'+
			  	      		    '<col width="150" align="center">'+
			  	      		    '<col width="80" align="right">'+
			  	      		    '<col width="150" align="center">'+
			  	      		  '</colgroup>'+
			  	      		  '<tbody>'+
			  	      		    '<tr>'+
			  	      		      '<td>学生姓名：</td>'+
			  	      		      '<td>'+ data.teacher.teacherName +'</td>'+
				  	      		  '<td>性别：</td>'+
			  	      		      '<td>'+ gender +'</td>'+
			  	      		    '</tr>'+
			  	      		    '<tr>'+
			  	      		      '<td>年龄：</td>'+
			  	      		      '<td>'+ data.teacher.age +'</td>'+
				  	      		  '<td>身份证号：</td>'+
			  	      		      '<td>'+ data.teacher.idNumber +'</td>'+
			  	      		    '</tr>'+
				  	      		'<tr>'+
			  	      		      '<td>所在地区：</td>'+
			  	      		      '<td colspan="3">'+ data.teacher.province +'-'+data.teacher.city+'-'+data.teacher.district+'</td>'+
			  	      		    '</tr>'+
				  	      		'<tr>'+
			  	      		      '<td>详细住址：</td>'+
			  	      		      '<td colspan="3">'+ data.teacher.address +'</td>'+
			  	      		    '</tr>'+
				  	      		'<tr>'+
			  	      		      '<td>简介：</td>'+
			  	      		      '<td colspan="3">'+ data.teacher.remark +'</td>'+
			  	      		    '</tr>'+
				  	      		'<tr>'+
			  	      		      '<td>头像：</td>'+
			  	      		      '<td colspan="3">'+ data.teacher.photo +'</td>'+
			  	      		    '</tr>'+
			  	      		  '</tbody>'+
			  	      		'</table>'
			  	      		
				  	      	,btn: ['审核通过', '审核未通过'] //只是为了演示
		  	                ,btn1:function(index){
		  	                	var teacher = data.teacher;
		  	                	//审核状态
		  	                	 $.ajax({
		  	         	            url: '${path}/teacher/examine',
		  	         	            type: 'post',
			  	         	        dataType:'json',
		  	         	            data:teacher,
		  	         	            async:false,
		  	         	            success: function (data) {
		  	         	            	if(data.code === 5){
	  	         	            			layer.msg(data.msg+":审核通过");
	  	         	            			layer.close(index);
	  	         	            		}else if(data.code === 8){
	  	         	            			layer.msg("异常:没查到关联用户");
	  	         	            		}else{
	  	         	            			layer.alert(data.msg);
	  	         	            		}
			  	         	         },
			  	     	            error: function (data) {
			  	     	            	alert("请求异常")
			  	     	            }
		  	     	        	});
		  	                	layer.close(index);
		  	     	            	
		  	                }
		  	                ,btn2: function(index){
		  	                	var teacher = data.teacher;
		  	              	//审核状态
		  	                	 $.ajax({
		  	         	            url: '${path}/teacher/unaudited',
		  	         	            type: 'post',
			  	         	        dataType:'json',
		  	         	            data:teacher,
		  	         	            async:false,
		  	         	            success: function (data) {
		  	         	            	if(data.code === 5){
	  	         	            			layer.alert(data.msg+":审核未通过");
	  	         	            		}else if(data.code === 8){
	  	         	            			layer.alert("异常:没查到关联用户");
	  	         	            		}else{
	  	         	            			layer.alert(data.msg);
	  	         	            		}
			  	         	         },
			  	     	            error: function (data) {
			  	     	            	layer.alert("请求异常");
			  	     	            }
		  	     	        	});
		  	                	layer.close(index);
		  	                }
		  	                
 	  	       			});
 	                } else {
 	                	layer.alert('提示','请求出错');
 	                }
 	            	

 	            },
 	            error: function (data) {
 	                 layer.msg('请求异常')
 	            }
 	        });
 			
 		}
  		if(obj.event === 'del'){
  			layer.confirm('真的删除吗？', function(index){
  				  $.ajax({
                    url: "<%=path%>/teacher/del",
                    type: "POST",
                    data:{"id":data.userId},
                    dataType: "json",
                    success: function(data){
                        if(data.code==7){
                            obj.del();
                            layer.close(index);
                            layer.msg("删除成功", {icon: 6});
                        }else{
                            layer.msg("删除失败", {icon: 5});
                        }
                    },
                    error:function(){
                    	layer.msg('删除教师异常')
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
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_30088308'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "w.cnzz.com/c.php%3Fid%3D30088308' type='text/javascript'%3E%3C/script%3E"));</script>
</body>
</html>