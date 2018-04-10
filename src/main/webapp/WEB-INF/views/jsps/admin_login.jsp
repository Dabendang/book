<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="ctx" />
<!DOCTYPE html>
<html>
<head>
	<title>悦心网上书店系统后台</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="悦心网上书店系统后台" />
	<link rel="icon" href="${ctx}images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="${ctx}css/style.css" type="text/css">
	<link href="${ctx}css/popup-box.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="${ctx}css/jquery.toastmessage.css" type="text/css">
	<style type="text/css">
		.error{
			color: #FF0000;
		}
	</style>

	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<script src="${ctx}js/jquery.min.js" type="text/javascript"></script>
	<script src="${ctx}js/jquery.toastmessage.js" type="text/javascript"></script>
	<script src="${ctx}js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctx}js/messages_cn.js" type="text/javascript"></script>
	<script src="${ctx}js/jquery-form.js" type="text/javascript"></script>
	<script src="${ctx}js/jquery.magnific-popup.js" type="text/javascript"></script>
	<script src="${ctx}js/modernizr.custom.53451.js" type="text/javascript" ></script>
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
                                    window.location.href="${ctx}/backend/admin/index";
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
                                        $().toastmessage('showToast', {
                                            text     : result.msg,
                                            sticky   : false,
                                            position : 'top-right',
                                            type     : 'error',
                                        });
								}
                            });
                        });

</script>
		
</head>
<body>
	<h1>悦心网上书店系统</h1>
	<div class="w3layouts">
		<div class="signin-agile">
			<h2 style="margin-left:30%; color:#081148">管理员登录</h2>

			<form  id="login_form" action="${ctx}/backend/admin/login" method="post" >
				<input type="text" name="username" class="name" autofocus="autofocus" placeholder="用户名" required oninvalid="setCustomValidity('请 输 入 用 户 名！');" oninput="setCustomValidity('');"  >
				<input type="password" name="password" class="password" placeholder="密码" required oninvalid="setCustomValidity('请 输 入 密 码！');" oninput="setCustomValidity('');">
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
		</div>
		<div class="clear"></div>
	</div>
	
	<div class="footer-w3l">
		<p class="agileinfo"> 悦心网上书店系统后台</p>
	</div>
<body>
</html>