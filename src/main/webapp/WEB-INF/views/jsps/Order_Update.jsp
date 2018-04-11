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

    <title>订单信息编辑</title>
</head>
<body>
<div class="container">
    <br> <br>

    <form class="form-horizontal"  action="${ctx}/admin/order/update" method="post">
        <h3>订单信息编辑</h3>
        <input type="hidden" name="orderid" value="${Order.orderid}">
        <div class="control-group">
            <label class="control-label" >用户名: </label>
            <input type="text"  name="username" value="${Order.username}">
        </div>
        <div class="control-group">
            <label class="control-label" >图书名: </label>
            <input type="text"  name="bookname" value="${Order.bookname}">
        </div>
        <div class="control-group">
            <label class="control-label" >订单状态：</label>
            <select name="status">
                <option value="0">未支付</option>
                <option value="1">已支付</option>
                <option value="0">已取消</option>
                <option value="1">已发货</option>
                <option value="0">已收货</option>
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