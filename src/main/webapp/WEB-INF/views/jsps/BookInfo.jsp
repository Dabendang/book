<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<!DOCTYPE html>
<html>
<head>
    <title>图书详细信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="${ctx}/js/jquery.min.js"></script>
    <link href="${ctx}/css/bootstrap3/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/css/bootstrap3/bootstrap.min.js"></script>
    <style>
        body{
            /* background: url(${ctx}/images/8.jpg) repeat top left;*/
        }
        table{
            margin: 0 auto;
            width: 600px !important;
        }
        table th{
            width: 400px !important;
            text-align: center;
        }
        h1{
            text-align: center;
        }

    </style>
    <script>
        function addShopcart(bookname) {
            console.log(111);
            $.ajax({
                url:"/portal/shopcart/addShopcart",
                data:{
                    "bookname":bookname
                },
                dataType:"json",
                success: function(result){
                    if(result.code==0){
                        alert(result.msg);
                    }
                    if(result.code==1){
                        alert(result.msg);
                        window.location.href="redirect:index";
                    }
                }
            });
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <h1 class="text-primary">图书详细信息</h1>
    </div>
    <div class="row">
        <table class="table table-hover">
            <thead>
            <th>图书名</th>
            <td>${Book.bookname}</td>
            </thead>
            <tbody>
            <tr>
                <th>作者</th>
                <td>${Book.author}</td>
            </tr>
            <tr>
                <th>出版商</th>
                <td>${Book.publisher}</td>
            </tr>
            <tr>
                <th>出版日期</th>
                <td><fmt:formatDate value="${Book.pubilshdata}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <th>单价</th>
                <td>${Book.price}</td>
            </tr>
            <tr>
                <th>描述</th>
                <td>${Book.description}</td>
            </tr>
            <tr>
                <th>库存数量</th>
                <td>${Book.stocknum}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="row">
        <div class="col-md-offset-8">
            <a  class="btn btn-primary" onclick="addShopcart('${Book.bookname}')">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span><span> 加 入 购 物 车</span>
            </a>
            <a  class="btn btn-primary" href="${ctx}/portal/user/toEditPassword">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span><span> 立 即 购 买</span>
            </a>
        </div>
    </div>
</div>
</body>
</html>
