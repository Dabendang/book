<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>用户查询图书</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${ctx}/js/jquery.min.js"></script>
	<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/css/bootstrap-responsive.min.css" rel="stylesheet">
	<script src="${ctx}/js/bootstrap.min.js"></script>
<style type="text/css">
	body {
		margin: 0px;
		padding: 0px;
		/*background: url(${ctx}/images/8.jpg) no-repeat top left;*/
		background-size: 100%;
	}
	.search{
		line-height: 50px;
		padding-left: 200px;
	}
	.search label{
		padding-top: 5px;
	}
	.search label,input{
		float:left;
	}
	.search select{
		float: left;
		margin-bottom: 30px;
	}
	.search button{
		margin-bottom: 30px;
	}
	.form-control{
		width:120px;
	}
	/*.search*/
	#links {text-align:center;}
	#links ul li{
	display:inline;
	}
	.pagination{font-size:20px;	list-style-type:none;}
</style>
	<script type="text/javascript">
        function buyBook(bookisbn) {
            if(confirm('尊敬的用户${currentUser.username},您确认要购买这本书籍吗？')){
                $.ajax({
                    url:"${ctx}/portal/user/borrow",
                    data:{
                        "bookisbn":bookisbn
                    },
                    dataType:"json",
                    success: function(result){
                        if(result.code==0){
                            alert(result.msg);
                            window.location.href="${ctx}/portal/user/getBookInfo"
                        } else{
                            alert(result.msg);
                        }
                    }
                })
            }else{

            }
        };

	</script>

</head>
<body>
	<div class="container" >
		<div class="row">
			<table class="table table-bordered">
				<h3 class="text-center">图书信息查询</h3>
			<div class="search">
				<form action="${ctx}/portal/user/getBookInfo" method="get">
					<div >
						<label for="bookName">书 名</label>
						<input type="text"  class="form-control" id="bookName" name="bookName" value="${requestScope.bookName}" >
						<label for="author">作 者</label>
						<input type="text"  class="form-control" id="author" name="author" value="${requestScope.author}" >
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
					<th>图书名</th>
					<th>作者</th>
					<th>单价</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${requestScope.pageInfo.list}" var="book">
					<tr>
						<td><a href="${ctx}/user/book/showBookInfo?bookisbn=${book.bookisbn}">${book.bookname}</a></td>
						<td>${book.author}</td>
						<td>${book.price}</td>
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

