<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<!DOCTYPE html>
<html>
<head>
    <title>库存信息</title>
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
<body>
<div class="container">
    <div class="row">
        <h1 class="text-primary">库 存 信 息</h1>
    </div>
    <div class="row">
        <table class="table table-hover">
            <thead>
                <th>馆藏量</th>
                <td>${stock.stocknum}</td>
            </thead>
             <tbody>
              <tr>
               <th>图书总类</th>
               <td>${stock.totalcategory}</td>
              </tr>
            </tbody>
        </table>
    </div>
    <div class="row">
        <div class="col-md-offset-8">
        <a  class="btn btn-primary" href="${ctx}/admin/book/books">
            <span class="glyphicon glyphicon-search" aria-hidden="true"></span><span>详细信息</span>
        </a>
        </div>
    </div>
</div>
</body>
</html>
