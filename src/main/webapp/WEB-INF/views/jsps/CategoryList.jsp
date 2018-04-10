<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="ctx" />
<!DOCTYPE html>
<html>
  <head>
    <title>图书类型列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<script src="${ctx}/js/jquery.min.js"></script>
    <link href="${ctx}/css/bootstrap3/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/css/bootstrap3/bootstrap.min.js"></script>
	<style type="text/css">
		body{
			font-size: 12px;
		}
	table th,td {
		text-align: center;
	}
	.container{
		position: relative;
	}
	.row{
		width:100%;
		padding-left:400px;
	}
	.btn-primary:hover{
		align:right !important:
	}
	.add{
		float:left;
		padding-left:235px;
	}
	</style>
	<script type="text/javascript">
        function deleteCategory(categoryid) {
            $.ajax({
                url:"${ctx}/admin/category/toDelete",
                data:{
                    "categoryid":categoryid
                },
                dataType:"json",
                success: function(result){
                    if(result.code==0){
                        alert(result.msg);
                        window.location.href="${ctx}/admin/category/categories";
                    }
                  if(result.code==1){
                        alert(result.msg);
                    }
                }
            });
        }

        function updateCategory(categoryid,text) {
            $('#editModal').modal('toggle');
          $("#CID").val(categoryid);
          $("#categoryName").val(text);
        }
        function addCategory() {
            document.getElementById("editForm").reset();
            $('#editModal').modal('toggle');
        }
        function submitForm() {
            var categoryid=$("#CID").val();
            if(undefined==categoryid){
                categoryid=null;
			}
           var name= $("#categoryName").val();
            $.ajax({
                url:"${ctx}/admin/category/category",
                data:{
                    "categoryid": categoryid,
					"categoryname":name
                },
				method:"post",
                dataType:"json",
                success: function(result){
                    if(result.code==0){
                        alert(result.msg);
                        window.location.href="${ctx}/admin/category/categories";
                    }
                    if(result.code==1){
                        alert(result.msg);
                    }
                }
            });
            $('#editModal').modal('toggle');
        }
	</script>

  </head>
  
  <body>
    <div class="container" >
		<table class="table table-hover">
			<thead>
				<tr class="info">
					<th>类型编号</th>
					<th>类型名</th>
					<th>库存数量</th>
					<th>销售数量</th>
					<th>操作</th>
				</tr>
			</thead>

			<tbody>
			<c:forEach items="${requestScope.pageInfo.list}" var="category">
				<tr>
					<td>${category.categoryid}</td>
					<td>${category.categoryname}</td>
					<td>${category.inventory}</td>
					<td>${category.salesvolume}</td>
					<td>
						<button class="btn btn-info" type="button" onclick="updateCategory(${category.categoryid},'${category.categoryname}');">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>修改</button>
						<button class="btn btn-info" type="button" onclick="deleteCategory(${category.categoryid});">
							<span class="glyphicon glyphicon-trash" aria-hidden="true"> </span>删除</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="row">
		<div class="col-md-4" style="align:center !important;">
			<div style="text-align:center !important;">
				当前第${requestScope.pageInfo.pageNum}页,总共${requestScope.pageInfo.pages}页,总共${pageInfo.total}条记录
			</div>
			<div  style="text-align:center !important;">
				<nav aria-label="Page navigation" style="text-align:center !important;">
					<ul class="pagination pagination-lg">
						<li>
							<a href="${ctx}/admin/category/categories?pageNum=1">首页</a>
						</li>
						<c:if test="${pageInfo.hasPreviousPage}">
							<li>
								<a href="${ctx}/admin/category/categories?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
						</c:if>
						<c:forEach items="${requestScope.pageInfo.navigatepageNums}" var="page_Num">
							<c:if test="${page_Num eq pageInfo.pageNum}">
								<li class="active"><a href="#">${page_Num}</a></li>
							</c:if>
							<c:if test="${page_Num != pageInfo.pageNum}">
								<li ><a href="${ctx}/admin/category/categories?pageNum=${page_Num}">${page_Num}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${pageInfo.hasNextPage}">
							<li>
								<a href="${ctx}/admin/category/categories?pageNum=${pageInfo.pageNum+1}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</c:if>
						<li>
							<a href="${ctx}/admin/category/categories?pageNum=${pageInfo.pages}">末页</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
		<div class="add" style="algin:right;">
				<button type="button" class="btn btn-primary" onclick="addCategory()">添加新类型</button>
		</div>
	</div>
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="exampleModalLabel">请输入需要编辑的类型名字</h4>
				</div>
				<div class="modal-body">
					<form   id="editForm" action="${ctx}/admin/category/category" method="post">
						<input type="hidden" name="categoryid" id="CID">
						<div class="form-group">
							<label for="categoryName" class="control-label">Name:</label>
							<textarea class="form-control" id="categoryName" name="categoryname" ></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取 消</button>
					<button type="button" class="btn btn-primary" onclick="submitForm()">确 认</button>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
