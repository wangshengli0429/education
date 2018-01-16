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
 	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0"> 
	<title>登录界面</title>
 	
 	<link href="<%=path %>/static/layui_login/css/default.css" rel="stylesheet" type="text/css" />
	<!--必要样式-->
    <link href="<%=path %>/static/layui_login/css/styles.css" rel="stylesheet" type="text/css" />
    <link href="<%=path %>/static/layui_login/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="<%=path %>/static/layui_login/css/loaders.css" rel="stylesheet" type="text/css" />
    
   
</head>
<body>
   <div class='login'>
	  <div class='login_title'>
	    <span>管理员登录</span>
	  </div>
	  <div class='login_fields'>
	    <div class='login_fields__user'>
	      <div class='icon'>
	        <img alt="" src='<%=path %>/static/layui_login/img/user_icon_copy.png'>
	      </div>
	      <input name="manageCode" placeholder='用户名' maxlength="16" type='text' autocomplete="off" value=""/>
	        <div class='validation'>
	          <img alt="" src='<%=path %>/static/layui_login/img/tick.png'>
	        </div>
	    </div>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='<%=path %>/static/layui_login/img/lock_icon_copy.png'>
	      </div>
	      <input name=managePwd placeholder='密码' maxlength="16" type='text' autocomplete="off">
	      <div class='validation'>
	        <img alt="" src='<%=path %>/static/layui_login/img/tick.png'>
	      </div>
	    </div>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='<%=path %>/static/layui_login/img/key.png'>
	      </div>
	      <input name="code" placeholder='验证码' maxlength="4" type='text' name="ValidateNum" autocomplete="off">
	      <div class='validation' style="opacity: 1; right: -5px;top: -3px;">
          <canvas class="J_codeimg" id="myCanvas" onclick="Code();">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
	      </div>
	    </div>
	    <div class='login_fields__submit'>
	      <input type='button' value='登录'>
	    </div>
	  </div>
	  <div class='success'>
	  </div>
	  <div class='disclaimer'>
	    <p>欢迎登录后台管理系统 </p>
	  </div>
	</div>
	<div class='authent'>
	  <div class="loader" style="height: 44px;width: 44px;margin-left: 28px;">
        <div class="loader-inner ball-clip-rotate-multiple">
            <div></div>
            <div></div>
            <div></div>
        </div>
        </div>
	  <p>认证中...</p>
	</div>
	<div class="OverWindows"></div>
	
     <link href="<%=path %>/static/layui_login/layui/css/layui.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="<%=path %>/static/layui_login/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/static/layui_login/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src='<%=path %>/static/layui_login/js/stopExecutionOnTimeout.js?t=1'></script>
    <script type="text/javascript" src="<%=path %>/static/layui_login/layui/layui.js"></script>
    <script type="text/javascript" src="<%=path %>/static/layui_login/js/Particleground.js"></script>
    <script type="text/javascript" src="<%=path %>/static/layui_login/js/Treatment.js"></script>
    <script type="text/javascript" src="<%=path %>/static/layui_login/js/jquery.mockjax.js"></script>
	<script type="text/javascript">
		var canGetCookie = 0;//是否支持存储Cookie 0 不支持 1 支持
		var ajaxmockjax = 0;//是否启用虚拟Ajax的请求响 0 不启用  1 启用
		//默认账号密码
		
		var truelogin = "123456";
		var truepwd = "123456";
		
		var CodeVal = 0;
	    Code();
	    function Code() {
			if(canGetCookie == 1){
				createCode("AdminCode");
				var AdminCode = getCookieValue("AdminCode");
				showCheck(AdminCode);
			}else{
				showCheck(createCode(""));
			}
	    }
	    function showCheck(a) {
			CodeVal = a;
	        var c = document.getElementById("myCanvas");
	        var ctx = c.getContext("2d");
	        ctx.clearRect(0, 0, 1000, 1000);
	        ctx.font = "80px 'Hiragino Sans GB'";
	        ctx.fillStyle = "#E8DFE8";
	        ctx.fillText(a, 0, 100);
	    }
	    $(document).keypress(function (e) {
	        // 回车键事件  
	        if (e.which == 13) {
	            $('input[type="button"]').click();
	        }
	    });
	    //粒子背景特效
	    $('body').particleground({
	        dotColor: '#E8DFE8',
	        lineColor: '#133b88'
	    });
	    $('input[name="managePwd"]').focus(function () {
	        $(this).attr('type', 'password');
	    });
	    $('input[type="text"]').focus(function () {
	        $(this).prev().animate({ 'opacity': '1' }, 200);
	    });
	    $('input[type="text"],input[type="password"]').blur(function () {
	        $(this).prev().animate({ 'opacity': '.5' }, 200);
	    });
	    $('input[name="manageCode"],input[name="managePwd"]').keyup(function () {
	        var Len = $(this).val().length;
	        if (!$(this).val() == '' && Len >= 5) {
	            $(this).next().animate({
	                'opacity': '1',
	                'right': '30'
	            }, 200);
	        } else {
	            $(this).next().animate({
	                'opacity': '0',
	                'right': '20'
	            }, 200);
	        }
	    });
	    var open = 0;
	    layui.use('layer', function () {
			var msgalert = '默认账号:' + truelogin + '<br/> 默认密码:' + truepwd;
//     		var index = layer.alert(msgalert, { icon: 6, time: 4000, offset: 't', closeBtn: 0, title: '友情提示', btn: [], anim: 2, shade: 0 });  
// 			layer.style(index, {
// 				color: '#777'
// 			}); 
	        //非空验证
	        $('input[type="button"]').click(function () {
	            var manageCode = $('input[name="manageCode"]').val();
	            var managePwd = $('input[name="managePwd"]').val();
	            var code = $('input[name="code"]').val();
	            if (manageCode == '') {
	                ErroAlert('请输入您的账号');
	            } else if (managePwd == '') {
	                ErroAlert('请输入密码');
	            } else if (code == '' || code.length != 4) {
	                ErroAlert('输入验证码');
	            } else {
	                //认证中..
	                fullscreen();
	                $('.login').addClass('test'); //倾斜特效
	                setTimeout(function () {
	                    $('.login').addClass('testtwo'); //平移特效
	                }, 300);
	                setTimeout(function () {
	                    $('.authent').show().animate({ right: -320 }, {
	                        easing: 'easeOutQuint',
	                        duration: 600,
	                        queue: false
	                    });
	                    $('.authent').animate({ opacity: 1 }, {
	                        duration: 200,
	                        queue: false
	                    }).addClass('visible');
	                }, 500);
					//******************* 认证中... ************************/
	                //登录验证...
	                var LoginUser = { manageCode: manageCode, managePwd: managePwd, code: code };
					//此处做为ajax内部判断
					var url = "";
// 					if(LoginUser.manageCode == truelogin && LoginUser.managePwd == truepwd && LoginUser.code.toUpperCase() == CodeVal.toUpperCase()){
					if(LoginUser.code.toUpperCase() == CodeVal.toUpperCase()){
						url = "<%=path %>/login/doLogin";
					}else{
						url = "Ajax/LoginFalse";
					}
					
					
	                AjaxPost(url, LoginUser,
	                                function () {
	                                    //ajax加载中
	                                	 $.ajax({
	                                          type: "GET",
	                                          url: url,
	                                          data: {manageCode:LoginUser.manageCode, managePwd:LoginUser.managePwd},
	                                          dataType: "json",
	                                          success: function(data){
//	                                                      $('#resText').empty();   //清空resText里面的所有内容
	                                                      var html = ''; 
	                                                      alert(data);
//	                                                      $.each(data, function(commentIndex, comment){
//	                                                            html += '<div class="comment"><h6>' + comment['username']
//	                                                                      + ':</h6><p class="para"' + comment['content']
//	                                                                      + '</p></div>';
//	                                                      });
//	                                                      $('#resText').html(html);
	                                                   },
	                                          error:function(msg){
	                                        	  alert(msg);
	                                          }
	                                      });
	                                },
	                                function (data) {
	                                	 
	                                    //ajax返回 
	                                    //认证完成
	                                    setTimeout(function () {
	                                        $('.authent').show().animate({ right: 90 }, {
	                                            easing: 'easeOutQuint',
	                                            duration: 600,
	                                            queue: false
	                                        });
	                                        $('.authent').animate({ opacity: 0 }, {
	                                            duration: 200,
	                                            queue: false
	                                        }).addClass('visible');
	                                        $('.login').removeClass('testtwo'); //平移特效
	                                    }, 2000);
	                                    ErroAlert(data.Status);
	                                    setTimeout(function () {
	                                        $('.authent').hide();
	                                        $('.login').removeClass('test');
	                                       
	                                        if (data.Status == 'ok') {
	                                            //登录成功
	                                            $('.login div').fadeOut(100);
	                                            $('.success').fadeIn(1000);
	                                            $('.success').html(data.Text);
												//跳转操作
												
	                                        } else {
	                                        	
	                                        alert('<%=path %>')
	                                            layer.open({
	                                            	  type: 2, 
	                                            	  content: '<%=path %>' 
	                                            	  //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	                                            	}); 
	                                        }
	                                    }, 2400);
	                                })
	            }
	        })
	    })
	    var fullscreen = function () {
	        elem = document.body;
	        if (elem.webkitRequestFullScreen) {
	            elem.webkitRequestFullScreen();
	        } else if (elem.mozRequestFullScreen) {
	            elem.mozRequestFullScreen();
	        } else if (elem.requestFullScreen) {
	            elem.requestFullscreen();
	        } else {
	            //浏览器不支持全屏API或已被禁用  
	        }
	    }  
		if(ajaxmockjax == 1){
			
			$.mockjax({  
				url: '<%=path %>/login/doLogin',  
				status: 200,  
				responseTime: 500,          
				responseText: {"Status":"ok","Text":"登录成功<br /><br /><br /><a href=\"http://www.baidu.com\">去主页面</a>"} ,
				
			}); 
			$.mockjax({ 
				url: 'Ajax/LoginFalse',  
				status: 200,  
				responseTime: 50,          
				responseText: {"Status":"Erro","Erro":"账号名或密码或验证码有误"}
			});   
		}
    </script>
</body>
</html>