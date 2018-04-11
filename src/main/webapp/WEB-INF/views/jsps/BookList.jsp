<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>管理员查询图书</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${ctx}/js/jquery.min.js"></script>
	<link href="${ctx}/css/bootstrap3/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/css/bootstrap-responsive.min.css" rel="stylesheet">
	<script src="${ctx}/js/bootstrap3/bootstrap.min.js"></script>
<style type="text/css">
	body {
		margin: 0px;
		padding: 0px;
		font-size: 12px;
		/*background: url(${ctx}/images/8.jpg) no-repeat top left;*/
		background-size: 100%;
	}
	.search{
		width: 43%;
		height: 60px;
		position: absolute;
		line-height: 50px;
		right:0;
	}
	.search label{
		padding-top: 5px;
	}
	.search label,input{
		float:left;
	}
	.search select{
		margin-bottom: 30px;
	}
	.search button{
		margin-bottom: 30px;
	}
	/*.search*/
	#links {text-align:center;}
	#links ul li{
	display:inline;
	}
	.form-control{
		width:120px;
	}
	.pagination{font-size:20px;	list-style-type:none;}
</style>
	<script type="text/javascript">
        function deleteBook(bookisbn) {
            console.log(111);
			$.ajax({
              url:"/admin/book/toDelete",
			  data:{
                  "bookisbn":bookisbn
			  },
			  dataType:"json",
				success: function(result){
                    if(result.code==0){
                        alert(result.msg);
                        window.location.href="${ctx}/admin/book/books";
                    }
                    if(result.code==1){
                        alert(result.msg);
                        window.location.href="${ctx}/admin/book/books";
                    }
				}
			});
        }
	</script>

</head>
<body>
	<div class="container" >
		<div class="row">
			<table class="table table-bordered">
			<caption>
				<h3>图书信息查询</h3>
			</caption>
			<div class="search">
				<form action="${ctx}/admin/book/books" method="get">
					<div >
						<label for="bookName">书 名</label>
						<input type="text" class="form-control" id="bookName" name="bookName" value="${requestScope.bookName}" >
						<label for="category">类 别</label>
						<select class="form-control" id="category" name="categoryid">
							<option value="">--请选择--</option>
							<c:forEach items="${requestScope.cateGories}" var="category">
								<option  value="${category.categoryid}" <c:if test ="${category.categoryid eq requestScope.category_id}">selected</c:if> >${category.categoryname}</option>
							</c:forEach>
						</select>
						<button type="submit" class="btn btn-default">查 询</button>
					</div>
				</form>
			</div>
				<thead>
				<tr class="info">
					<th>图书图片</th>
					<th>图书编号</th>
					<th>图书名</th>
					<th>作者</th>
					<th>出版商</th>
					<th>出版日期</th>
					<th>单价</th>
					<th>描述</th>
					<th>库存数量</th>
					<th>操作</th>
				</tr>
				</thead>

				<tbody>
				<c:forEach items="${requestScope.pageInfo.list}" var="book">
					<tr>
						<td><img src="${book.img}"></td>
						<td>${book.bookisbn}</td>
						<td>${book.bookname}</td>
						<td>${book.author}</td>
						<td>${book.publisher}</td>
						<td><fmt:formatDate value="${book.pubilshdata}"
											pattern="yyyy-MM-dd"></fmt:formatDate></td>
						<td>${book.price}</td>
						<td>${book.description}</td>
						<td>${book.stocknum}</td>
						<td>
							<a class="btn btn-info"  href="${ctx}/admin/book/toEdit/${book.bookisbn}">
								<span >修改</span>
							</a>
							<button class="btn btn-info"  id="deleteBtn" onclick="deleteBook(${book.bookisbn})">
								<span>删除</span>
							</button>
						</td>
					</tr>
				</c:forEach>
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
							<a href="${ctx}/admin/book/books?pageNum=1">首页</a>
						</li>
						<c:if test="${pageInfo.hasPreviousPage}">
							<li>
								<a href="${ctx}/admin/book/books?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
						</c:if>
						<c:forEach items="${requestScope.pageInfo.navigatepageNums}" var="page_Num">
							<c:if test="${page_Num eq pageInfo.pageNum}">
							<li class="active"><a href="#">${page_Num}</a></li>
							</c:if>
							<c:if test="${page_Num != pageInfo.pageNum}">
								<li ><a href="${ctx}/admin/book/books?pageNum=${page_Num}">${page_Num}</a></li>
							</c:if>
						</c:forEach>
                       <c:if test="${pageInfo.hasNextPage}">
						<li>
							<a href="${ctx}/admin/book/books?pageNum=${pageInfo.pageNum+1}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					   </c:if>
						<li>
							<a href="${ctx}/admin/book/books?pageNum=${pageInfo.pages}">末页</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>

