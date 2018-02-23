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

<title>好学习-学生管理</title>
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
  
		 <div class="layui-tab">
		  <ul class="layui-tab-title">
		    <li class="layui-this" id="s_examine">审核通过</li>
		    <li id="s_unaudited" >审核未通过</li>
		    
		  </ul>
		  <div class="layui-tab-content">
		  	<input type="hidden" value="Y" id="cerStatus"/>
		    <div class="layui-tab-item layui-show">  
		    	<!-- 内容主体区域 -->
				<div style="padding: 15px;">
				  <div class="demoTable">
				  <div class="layui-inline">
				    <input class="layui-input" name="keyword" id="demoReload_Y" autocomplete="off">
				  </div>
				  <button class="layui-btn" data-type="reload">搜索</button>
				</div>
		    	<table class="layui-hide" id="dataTable_Y" lay-filter="student"></table>
		    	<script type="text/html" id="barDemo_Y">
			 		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  					<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
				</script>
		    	</div>
    		</div>
		    <div class="layui-tab-item">
		    	<!-- 内容主体区域 -->
		    	<div style="padding: 15px;">
				  <div class="demoTable">
				  <div class="layui-inline">
				    <input class="layui-input" name="keyword" id="demoReload_N" autocomplete="off">
				  </div>
				  <button class="layui-btn" data-type="reload">搜索</button>
				</div>
		    	<table class="layui-hide" id="dataTable_N" lay-filter="student"></table>
		    	<script type="text/html" id="barDemo_N">
			 		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  					<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
				</script>
		    	</div>
		    </div>
		   
		  </div>
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
layui.use(['layer', 'table','laypage', 'element'], function(){
  var layer = layui.layer
  ,table = layui.table
  ,laypage = layui.laypage //分页
  ,element = layui.element;
  // 获取dataTable 
  // alert($("input[name='keyword']").val());
  var cerStatus = 'Y';
  var $ = layui.$,active = {
	        reload: function(){
	        	cerStatus = $('#cerStatus').val();
	            var demoReload = $('#demoReload_'+cerStatus);
	            table.reload('testReload_'+cerStatus, {
	                where: {
	                	keyword: demoReload.val(),
	                	"cerStatus":cerStatus
	                }
	            });
	        }
	    }; 
  
  // 加载表格数据
  function loadDataTable(cerStatus){	  
	  table.render({
		    elem: '#dataTable_'+cerStatus,
		    where:{"cerStatus":cerStatus,keyword:$("input[name='keyword']").val()},
		    height: 450,
		    url: '${path}/query/student',    //数据接口
		    page: true, //开启分页
		    cols: [[ //表头
		      {field: 'id', title: 'ID', align:'center',width:30}
		      ,{field: 'student', title: '学生姓名', align:'center',width:80}
		      ,{field: 'gender', title: '性别', align:'center',width:50,
		    	  templet:function(row){
		    		  if(row.gender === 'M'){
		    			  return "男";
		    		  }
		    		  if(row.gender === 'W'){
		    			  return "女";
		    		  }
		    	  }
		      }
		      ,{field: 'age', title: '年龄', align:'center',width:50}
		      ,{field: 'nativePlace', title: '籍贯', align:'center',width:120}
		      ,{field: 'province', title: '所在省份', align:'center',width:120}
		      ,{field: 'city', title: '所在城市', align:'center',width:120}
		      ,{field: 'district', title: '所在区县', align:'center',width:140}
		      ,{field: 'address', title: '现在住址', align:'center',width:140}
		      ,{field: 'idNumber', title: '身份证号', align:'center',width:140}
		      ,{field: 'selfDescr', title: '自我介绍', align:'center',width:140}
		      ,{field: 'remark', title: '备注', align:'center',width:140}
	// 	      ,{field: 'regTime', title: '注册时间', align:'center',width:180,
	// 	    	  templet:function(row){
	// 	    		  return DateFormat(row.commentTime,'yyyy-MM-dd HH:mm:ss');
	// 	    	 }  
	// 	      } 
		      ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo_'+cerStatus}
		    ]]
	  		,id: 'testReload_'+cerStatus
		  });
  	}
  
	  $(function(){
		  cerStatus = $('#cerStatus').val();
		  loadDataTable(cerStatus);
	  });  
	  
	  $(document).on("click","#s_examine",function(){
		  var cerStatus = $('#cerStatus').val('Y');
		  loadDataTable(cerStatus.val());
	  });	  
	  
	  $(document).on("click","#s_unaudited",function(){  
		    var cerStatus = $('#cerStatus').val('N');
			loadDataTable(cerStatus.val());
	  });	  
	   
	  
  	// 监听操作
  	table.on('tool(student)',function(obj) {
  		var data = obj.data;
  		if(obj.event === 'detail'){
  			
  			 $.ajax({
  	            url: '${path}/query/student/'+data.id,
  	            type: 'get',
  	            dataType:'json',
  	            contentType: 'application/json',
  	            async:false,
  	            success: function (data) {
  	            	
  	                if (data.student != null &&  data.student !== 'undefined') {
						var gender = "-";
  	                    if(data.student.gender === 'M'){gender="男"}if(data.student.gender === 'W'){gender="女"}
  	                  layer.open({ 
  	  	       			  title: ['学生审核', 'background-color: #00bb9d;text-align:center;font-size:18px;'],
  	  	       			  type: 1,
  	  	       			  shade: false,  
  	  	       		      maxmin: true, 
  	  	       			  skin: 'layui-layer-rim', //加上边框
  	  	       			  area: ['750px', '500px'], //宽高
  	  	       			  content: '<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">'+
  	  	       		  					'<legend>学生审核</legend>'+
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
			  	      		      '<td>'+ data.student.student +'</td>'+
				  	      		  '<td>性别：</td>'+
			  	      		      '<td>'+ gender +'</td>'+
			  	      		    '</tr>'+
			  	      		    '<tr>'+
			  	      		      '<td>年龄：</td>'+
			  	      		      '<td>'+ data.student.age +'</td>'+
				  	      		  '<td>身份证号：</td>'+
			  	      		      '<td>'+ data.student.idNumber +'</td>'+
			  	      		    '</tr>'+
				  	      		'<tr>'+
			  	      		      '<td>所在地区：</td>'+
			  	      		      '<td colspan="3">'+ data.student.province +'-'+data.student.city+'-'+data.student.district+'</td>'+
			  	      		    '</tr>'+
				  	      		'<tr>'+
			  	      		      '<td>详细住址：</td>'+
			  	      		      '<td colspan="3">'+ data.student.address +'</td>'+
			  	      		    '</tr>'+
				  	      		'<tr>'+
			  	      		      '<td>简介：</td>'+
			  	      		      '<td colspan="3">'+ data.student.remark +'</td>'+
			  	      		    '</tr>'+
				  	      		'<tr>'+
			  	      		      '<td>头像：</td>'+
			  	      		      '<td colspan="3">'+ data.student.photo +'</td>'+
			  	      		    '</tr>'+
			  	      		  '</tbody>'+
			  	      		'</table>'
			  	      		
				  	      	,btn: ['审核通过', '审核未通过'] //只是为了演示
		  	                ,btn1:function(index){
		  	                	var student = data.student;
		  	                	//审核状态
		  	                	 $.ajax({
		  	         	            url: '${path}/student/examine',
		  	         	            type: 'post',
			  	         	        dataType:'json',
		  	         	            data:student,
		  	         	            async:false,
		  	         	            success: function (data) {
		  	         	            	if(data != null && data!='undefined'){
		  	         	            		if(data.code === 5){
		  	         	            			if($("#cerStatus").val() === 'N'){
		  	         	            				obj.del();
		  	         	            			}
		  	         	            			layer.alert(data.msg+":审核通过");
		  	         	            		}else{
		  	         	            			layer.alert(data.msg);
		  	         	            		}
		  	         	            	}
			  	         	         },
			  	     	             error: function (data) {
			  	     	            	layer.alert("请求异常");
			  	     	             }
		  	     	        	  });
		  	                	layer.close(index);
		  	                	
		  	                }
		  	                ,btn2: function(){
		  	                	var student = data.student;
		  	                //审核状态
		  	                	 $.ajax({
		  	         	            url: '${path}/student/unaudited',
		  	         	            type: 'post',
			  	         	        dataType:'json',
		  	         	            data:student,
		  	         	            async:false,
		  	         	            success: function (data) {
		  	         	            	if(data != null && data!='undefined'){
		  	         	            		if(data.code === 5){
		  	         	            			if($("#cerStatus").val() === 'Y'){
		  	         	            				obj.del();
		  	         	            			}
		  	         	            			layer.alert(data.msg+":审核未通过");
		  	         	            		}else{
		  	         	            			layer.alert(data.msg);
		  	         	            		}
		  	         	            	}
			  	         	         },
			  	     	             error: function (data) {
			  	     	            	layer.alert("请求异常");
			  	     	             }
		  	     	        	  });
		  	                  layer.close();
		  	                }
		  	                
  	  	       			});
  	                } else {
  	                	layer.alert('请求出错');
  	                }
  	            	

  	            },
  	            error: function (data) {
  	                if (data.responseJSON === 'undefined' || data.responseJSON.msg === 'undefined') {
  	                	layer.alert('请求出错');
  	                } else {
  	                	layer.alert(data.responseJSON.msg);
  	                }
  	            }
  	        });
  			
  		}
  		if(obj.event === 'del'){
  			layer.confirm('真的删除吗？', function(index){
  				   $.ajax({
                    url: "<%=path%>/student/del",
                    type: "post",
                    data:{"id":data.userId},
                    dataType: "json",
                    async:false,
                    success: function(data){
                        if(data.code==7){
                            obj.del();
                            layer.close(index);
                            layer.msg("删除成功", {icon: 6});
                        }else{
                            layer.msg("删除失败", {icon: 5});
                        }
                    },
                    error:function(data){
                    	 layer.msg("删除异常");
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