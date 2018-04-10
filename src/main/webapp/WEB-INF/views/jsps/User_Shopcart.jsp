<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>我的购物车列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="${ctx}/js/jquery.min.js"></script>
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrap-responsive.min.css" rel="stylesheet">
    <script src="${ctx}/js/jquery.toastmessage.js" type="text/javascript"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
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
        .col-md-offset-8{
            float: right;
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
    <script>
        function toSbmitOrder(scid,booknum) {

            $.ajax({
                url:"${ctx}/portal/shopcart/toSettle",
                data:{
                    "scid":scid,
                    "booknum":booknum,
                },
                dataType:"json",
                success: function(result){
                    if(result.code==0){

                        alert(result.msg);

                        window.location.href="${ctx}/backend/admin/getAllUserInfo";
                    }
                    if(result.code==1){

                        alert(result.msg);
                        window.location.href="${ctx}/backend/admin/getAllUserInfo";
                    }
                    if(result.code==3){
                        alert(result.msg);
                        window.location.href="${ctx}/backend/admin/getAllUserInfo";
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
                <h3>我的购物车</h3>
            </caption>
            <thead>
            <tr class="info">
                <th>购买者</th>
                <th>图书名</th>
                <th>购买数量</th>
                <th>图书单价</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${requestScope.pageInfo.list}" var="shopcart">
                <tr>
                    <td>${shopcart.username}</td>
                    <td>${shopcart.bookname}</td>
                    <td>
                        <div class="input-group" >
                            <input type="number" min="1" step="1" max="9999999" required  value="${shopcart.booknum}"  class="form-control" id="InputPrice" placeholder="金钱数额" name="booknum">
                        </div>
                    </td>
                    <td>${shopcart.bookprice}</td>
                    <td>
                        <a  class="btn btn-primary" href="${ctx}/portal/shopcart/deleteShopcartInfo?scid=${shopcart.scid}">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span><span>删 除</span>
                        </a>
                        <a  class="btn btn-primary" onclick="toSbmitOrder(${shopcart.scid},$('#InputPrice').val())">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span><span>结 算</span>
                        </a>
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
                        <a href="${ctx}/portal/shopcart/getUserShopcartInfo?pageNum=1">首页</a>
                    </li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${ctx}/portal/shopcart/getUserShopcartInfo?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach items="${requestScope.pageInfo.navigatepageNums}" var="page_Num">
                        <c:if test="${page_Num eq pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num != pageInfo.pageNum}">
                            <li ><a href="${ctx}/portal/shopcart/getUserShopcartInfo?pageNum=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${ctx}/portal/shopcart/getUserShopcartInfo?pageNum=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li>
                        <a href="${ctx}/portal/shopcart/getUserShopcartInfo?pageNum=${pageInfo.pages}">末页</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>

