<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="ctx" />
<!DOCTYPE html>
<html>
<head>
	<title>欢迎登入悦心网上书店系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="福建工程学院,图书馆,福建工程学院图书馆" />
	<link rel="icon" href="${ctx}/images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="${ctx}/css/style.css" type="text/css">
	<link href="${ctx}/css/popup-box.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="${ctx}/css/jquery.toastmessage.css" type="text/css">
	<style type="text/css">
		.error{
			color: #FF0000;
		}
	</style>
<%--
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
--%>
	<script src="${ctx}/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery.toastmessage.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery.validate.js" type="text/javascript"></script>
	<script src="${ctx}/js/messages_zh.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery-form.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery.magnific-popup.js" type="text/javascript"></script>
	<script src="${ctx}/js/modernizr.custom.53451.js" type="text/javascript" ></script>
 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
							});

                            $("#login_form").ajaxForm(function(result){
                                if(result.code==0){
                                    window.location.href="${ctx}/portal/user/index"
                                }else {
                                    alert(result.msg);
                                }
                            });



                           /*  jquery 校验*/
                      /*      $.validator.addMethod("checkUsername", function(value, element,params) {
                                var result=false;
                               $.ajax({
                                   url:"portal/user/checkUsername",
                                   type:"post",
								   data:{
                                       username:value
								   },
                                   dataType:"json",
                                   async:false,
								   success:function(data){
                                       result=data.isSuccess;
								   },
								   error:function(XMLHttpRequest, textStatus, errorThrown){
                                       console.log(errorThrown)
                                   }
							   });
                               return result;
                            }, "用 户 名 已 存 在!");*/

                            $("#register_form").validate({
                                rules:{
                                    "username":{
                                        required:true,
                                        rangelength:[2,10],
                                        remote:{
                                            url:"/portal/user/checkUsername",
                                            type:"post"
                                        }
                                       /* checkUsername:true*/
                                    },
                                    "logpassword": {
                                        required: true,
                                        rangelength:[6,16]
                                    },
                                    "paypassword": {
                                        required: true,
                                        rangelength:[6,16]
                                    },
                                    "confimLogPwd":{
                                        equalTo:"#logPassword" //配对的元素一定要有id #ID
                                    },
                                    "confimPayPwd":{
                                        equalTo:"#payPassword" //配对的元素一定要有id #ID
                                    },
                                    "liveplace":{
                                        required:true
									}
                                },
                                messages:{
                                    "username": {
                                        required: "请 输 入 用 户 名",
                                        rangelength: "用 户 名 的 长 度 须 在 {0} 到 {1}位 之 间!",
                                        remote:"用 户 名 已 存 在!"
                                    },
                                    "logpassword": {
                                        required: "请 输 入 登 陆 密 码",
                                        rangelength: "密 码 的 长 度 须 在 {0} 到 {1} 位 之 间!"
                                    },
                                    "paypassword": {
                                        required: "请 输 入 支 付 密 码",
                                        rangelength: "密 码 的 长 度 须 在 {0} 到 {1} 位 之 间!"
                                    },
                                    "confimLogPwd":{
                                        equalTo:"两 次 输 入 的 密 码 不 一 致!"
                                    },
                                    "confimPayPwd":{
                                        equalTo:"两 次 输 入 的 密 码 不 一 致!"
                                    },
                                    "liveplace":{
                                        required:"请 输 入 地 址!"
                                    }
                                },
                                errorClass:"error"
                            });


                            $("#register_form").ajaxForm(function(result){
                                if(result.code==0){
                                    $().toastmessage('showToast', {
                                        text     : result.msg,
                                        sticky   : false,
                                        position : 'top-right',
                                        type     : 'success',
                                    });
                                    $("button[class=mfp-close]").click();
                                }
                                if(result.code==1){
                                    $().toastmessage('showToast', {
                                        text     : result.msg,
                                        sticky   : false,
                                        position : 'top-right',
                                        type     : 'error',
                                    });

                                }
                                if(result.code==3){
                                    if(undefined !=result.data.username){
                                        $().toastmessage('showToast', {
                                            text     : result.data.username,
                                            sticky   : false,
                                            position : 'top-right',
                                            type     : 'error',
                                        });
                                    }
                                    if(undefined !=result.data.logpassword){
                                        $().toastmessage('showToast', {
                                            text     : result.data.logpassword,
                                            sticky   : false,
                                            position : 'top-right',
                                            type     : 'error',
                                        });
                                    };

                                    if(undefined !=result.data.paypassword){
                                        $().toastmessage('showToast', {
                                            text     : result.data.paypassword,
                                            sticky   : false,
                                            position : 'top-right',
                                            type     : 'error',
                                        });
                                    }
                                    if(undefined !=result.data.liveplace){
                                        $().toastmessage('showToast', {
                                            text     : result.data.liveplace,
                                            sticky   : false,
                                            position : 'top-right',
                                            type     : 'error',
                                        });
                                    }

                                }
                            });

                        });






</script>
		
</head>
<body>
	<h1>悦心网上书店系统</h1>
	<div class="w3layouts">
		<div class="signin-agile">
			<h2  style="margin-left:30%;color: #081148;">用 户 登 录</h2>

			<form  id="login_form" action="${ctx}/portal/user/login" method="post" >
				<input type="text" id="logUsername" name="logUsername" class="name" autofocus="autofocus" placeholder="用户名" required oninvalid="setCustomValidity('请 输 入 用 户 名！');" oninput="setCustomValidity('');"  >
				<input type="password" name="userPassword"  placeholder="密码" required oninvalid="setCustomValidity('请 输 入 密 码！');" oninput="setCustomValidity('');">
				<ul>
					<li>
						<input type="checkbox" id="brand1" value="Y">
						<label for="brand1"><span></span>记住密码</label>
					</li>
				</ul>
				<a href="#">忘记密码?</a><br>
			<div class="clear"></div>
				<input type="submit" value="登录">
			</form>
		</div>
		<div class="signup-agileinfo">
			<p>&nbsp;学习改变命运,知识成就未来.</p>
			<p>&nbsp;取你最少的,给你最好的.</p>
			<p>&nbsp;你的世界书的天地,你的精彩我来做主,带你进入精彩的世界！</p>
			<p>&nbsp;小说、历史、经济、文学、恐怖等等大量图书等你来！</p>
			<p> </p>
			<div class="more" background="red;">
				<a id="reg" class="book popup-with-zoom-anim button-isi zoomIn animated" data-wow-delay=".5s" href="#small-dialog" onclick="resetRegForm()">点击注册</a>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	
	<div class="footer-w3l">
		<p class="agileinfo"> 悦心网上书店系统
 </p>
	</div>
	<div class="pop-up"> 
	<div id="small-dialog" class="mfp-hide book-form">
		<h3>用 户 注 册</h3>
			<form  id="register_form" action="${ctx}/portal/user/register" method="post" >
				<input type="text"  id="rusername" name="username" placeholder="用户名" autofocus="autofocus"/>
				<input type="password" id="logPassword" name="logpassword"  placeholder="登陆密码" />
				<input type="password" id="confimLogPwd"  name="confimLogPwd" placeholder="确认登陆密码" />
				<input type="password" id="payPassword" name="paypassword"  placeholder="支付密码" />
				<input type="password" id="confimPayPwd"  name="confimPayPwd"  placeholder="确认支付密码" />
				<input type="text"  id="livePlace" name="liveplace" placeholder="地址" />
				 &nbsp;&nbsp;&nbsp;&nbsp;
				性别：<select id="sex" name="sex">
					<option value="-1">--请选择--</option>
				<option value="男">男</option>
				<option value="女">女</option>
				</select>			
				<input type="submit" value="点击注册">
			</form>
	</div>
		<script type="text/javascript">
            function resetRegForm() {
                document.getElementById("register_form").reset();
                $("#register_form label").hide();
            }


		</script>
</div>	
</body>
</html>