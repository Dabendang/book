<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${ctx}/js/jquery.min.js"></script>
<link href="${ctx}/css/bootstrap3/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${ctx}/css/bootstrap3/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css">
<script src="${ctx}/js/bootstrap3/bootstrap.min.js" type="text/javascript"></script>
<style type="text/css">
body {
	background: url(${ctx}images/8.jpg) repeat top left;
}
	form label{
		font-weight: bold;
	}
	form select{
		width:125px;
		height:28px;
	}
</style>

<title>用户信息编辑</title>
</head>
<body>
	<div class="container">
		<br> <br>

		<form class="form-horizontal"  action="${ctx}/portal/user/update" method="post">
			<h3>用户信息编辑</h3>
			<input type="hidden" name="userid" value="${User.userid}">
			<div class="control-group">
				<label class="control-label" >用户名: </label>
				<input type="text"  name="username" value="${User.username}">
			</div>
			<div class="control-group">
				<label class="control-label" >地址: </label>
				<input type="text"  name="liveplace" value="${User.liveplace}">
			</div>
			<div class="control-group">
				<label class="control-label" >性别：</label>
 					<select name="sex" value="${User.sex}">
						<option value="男" <c:if test="${'男' eq User.sex}">selected</c:if>>男</option>
						<option value="女"<c:if test="${'女' eq User.sex}">selected</c:if>>女</option>
					</select>
			</div>
			<div class="control-group">
				<div class="controls">
					<input type="submit" class="btn" value="修改"/>
				</div>
			</div>
		</form>
	</div>
</body>
</html>