<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="ctx" />
<!DOCTYPE html>
<html>
<head>
<title>充值界面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<script src="${ctx}/js/jquery.min.js"></script>
<link href="${ctx}/css/bootstrap3/bootstrap.min.css" rel="stylesheet">
<script src="${ctx}/css/bootstrap3/bootstrap.min.js"></script>
	<script src="${ctx}/js/jquery-form.js"></script>
	<style type="text/css">
	.form-group{
		width:30% !important;
		align:center
	}
	.input-group{
	
		width:20% !important;
		align:center
	}
</style>

	<script type="text/javascript">
		$(function () {
            $("#recharge_Form").ajaxForm(function(result){
                if(result.code==0){
                    window.location.href="${ctx}/backend/admin/getAllUserInfo"
                }else {
                    alert(result.msg);
                }
            });
        })


	</script>
</head>

<body>
	<div class="container">
		<h3>用户充值</h3>
		<form id="recharge_Form" action="${ctx}/backend/admin/recharge" method="get">
			<div class="form-group">
				<label for="InputUsername">用户名:</label>
				<input type="text" class="form-control" id="InputUsername"   required oninvalid="setCustomValidity('请 输 入 用 户 名！');" oninput="setCustomValidity('');" name="username">
			</div>
			<div class="form-group">
				<label for="InputPassword">支付密码:</label>
				<input type="password" class="form-control" id="InputPassword"  required oninvalid="setCustomValidity('请 输 入 支 付 密 码！');" oninput="setCustomValidity('');"  name="payPassword">
			</div>
			
			<label for="InputPrice">充值金额:</label>
		 	<div class="input-group">
		      <div class="input-group-addon">￥</div>
		      <input type="number" min="0.0" step="0.1"  required  oninvalid="setCustomValidity('请 输 入 充 值 的 金 额！');" oninput="setCustomValidity('');"  class="form-control" id="InputPrice" placeholder="金钱数额" name="money">
		      <div class="input-group-addon">.0</div>
		    </div>
			<br><br>
			<input type="submit" class="btn" value="确认充值"/>
		</form>
	</div>
</body>
</html>
