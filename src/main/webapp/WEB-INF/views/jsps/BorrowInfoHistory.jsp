<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="ctx" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${ctx}/js/jquery.min.js"></script>
<link href="${ctx}/css/bootstrap3/bootstrap.min.css" rel="stylesheet">
<script src="${ctx}/css/bootstrap3/bootstrap.min.js"></script>
<style type="text/css">
body {
	background: url(${ctx}/images/8.jpg) no-repeat top left;
	background-size: 100%;
}

.blue {
	background-color: #0094ff;
}

.text-center {
	text-align: center;
}

#loginModal {
	width: 300px;
}
</style>

<title>用户历史借阅信息</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<table class="table table-hover">
				<caption>
					<h3 class="text-center">历史借阅信息</h3>
				</caption>
				<thead>
					<tr class="info">
						<th>借阅编号</th>
						<th>用户名</th>
						<th>图书名</th>
						<th>借阅时间</th>
					</tr>
				</thead>

				<tbody>
				<c:if test="${empty requestScope.pageInfo.list}">
					您 还 没 有 借 过 书...
				</c:if>
				<c:if test="${!empty requestScope.pageInfo.list}">
					<c:forEach items="${requestScope.pageInfo.list}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.username}</td>
							<td>${item.bookname}</td>
							<td><fmt:formatDate value="${item.borrowTime}"
												pattern="yyyy-MM-dd"></fmt:formatDate></td>
						</tr>
					</c:forEach>
				</c:if>
				</tbody>
			</table>
		</div>
		<div id="links" class="row">
			<div class="col-md-6">
				当前第${requestScope.pageInfo.pageNum}页,总共${requestScope.pageInfo.pages}页,总共${pageInfo.total}条记录
			</div>
			<div class="col-md-6">
				<nav aria-label="Page navigation">
					<ul class="pagination pagination-lg">
						<li>
							<a href="${ctx}/portal/borrowInfo/borrowInfoHS?pageNum=1">首页</a>
						</li>
						<c:if test="${pageInfo.hasPreviousPage}">
							<li>
								<a href="${ctx}/portal/borrowInfo/borrowInfoHS?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
						</c:if>
						<c:forEach items="${requestScope.pageInfo.navigatepageNums}" var="page_Num">
							<c:if test="${page_Num eq pageInfo.pageNum}">
								<li class="active"><a href="#">${page_Num}</a></li>
							</c:if>
							<c:if test="${page_Num != pageInfo.pageNum}">
								<li ><a href="${ctx}/portal/borrowInfo/borrowInfoHS?pageNum=${page_Num}">${page_Num}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${pageInfo.hasNextPage}">
							<li>
								<a href="${ctx}/portal/borrowInfo/borrowInfoHS?pageNum=${pageInfo.pageNum+1}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</c:if>
						<li>
							<a href="${ctx}/portal/borrowInfo/borrowInfoHS?pageNum=${pageInfo.pages}">末页</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	</div>
</body>
</html>