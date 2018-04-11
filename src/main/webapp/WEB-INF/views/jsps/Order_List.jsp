<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>用户信息列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="${ctx}/js/jquery.min.js"></script>
    <link href="${ctx}/css/bootstrap3/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrap-responsive.min.css" rel="stylesheet">
    <script src="${ctx}/js/jquery.toastmessage.js" type="text/javascript"></script>
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
</head>

<body>
<div class="container" >
    <div class="row">
        <table class="table table-bordered">
            <caption>
                <h3>订单信息查询</h3>
            </caption>
            <div class="search">
                <form action="${ctx}/admin/order/getAllOrderInfo" method="get">
                    <div >
                        <label for="orderid">订 单 编 号</label>
                        <input type="text" class="form-control" id="orderid" name="orderid" value="${requestScope.orderid}" >
                        <label for="category">状 态</label>
                        <select class="form-control" id="category" name="status">
                            <option value="">--请选择--</option>
                            <c:forEach items="${requestScope.statusMap}" var="item">
                                <option  value="${item.key}" <c:if test ="${item.key eq requestScope.status}">selected</c:if> >${item.value}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn btn-default">查 询</button>
                    </div>
                </form>
            </div>
            <thead>
            <tr class="info">
                <th>订单编号</th>
                <th>购买者</th>
                <th>书名</th>
                <th>购买数量</th>
                <th>总金额</th>
                <th>收货地址</th>
                <th>购买日期</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${requestScope.pageInfo.list}" var="order">
                <tr>
                    <td>${order.orderid}</td>
                    <td>${order.username}</td>
                    <td>${order.bookname}</td>
                    <td>${order.buynumber}</td>
                    <td>${order.buyprice}</td>
                    <td>${order.buyaddress}</td>
                    <td><fmt:formatDate value="${order.buydata}"
                                        pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td>
                        <c:choose>
                            <c:when test="${order.status eq '0'}">
                                <span>未支付</span>
                            </c:when>
                            <c:when test="${order.status eq '1'}">
                                <span>已支付</span>
                            </c:when>
                            <c:when test="${order.status eq '2'}">
                                <span>已取消</span>
                            </c:when>
                            <c:when test="${order.status eq '3'}">
                                <span>已发货</span>
                            </c:when>
                            <c:when test="${order.status eq '4'}">
                                <span>已收货</span>
                            </c:when>
                        </c:choose>
                    </td>
                    <td>
                        <a  class="btn btn-info" href="${ctx}/admin/order/toEdit?orderid=${order.orderid}">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span><span>修 改</span>
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
                        <a href="${ctx}/admin/order/getAllOrderInfo?pageNum=1">首页</a>
                    </li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${ctx}/admin/order/getAllOrderInfo?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach items="${requestScope.pageInfo.navigatepageNums}" var="page_Num">
                        <c:if test="${page_Num eq pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num != pageInfo.pageNum}">
                            <li ><a href="${ctx}/admin/order/getAllOrderInfo?pageNum=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${ctx}/admin/order/getAllOrderInfo?pageNum=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li>
                        <a href="${ctx}/admin/order/getAllOrderInfo?pageNum=${pageInfo.pages}">末页</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>

