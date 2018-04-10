<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<!DOCTYPE html>
<html>
<head>
    <title>用户个人信息</title>
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
</head>
<body>
<div class="container">
    <div class="row">
        <h1 class="text-primary">用 户 信 息</h1>
    </div>
    <div class="row">
        <table class="table table-hover">
            <thead>
                <th>账号</th>
                <td>${User.userid}</td>
            </thead>
             <tbody>
              <tr>
               <th>姓名</th>
               <td>${User.username}</td>
              </tr>
              <tr>
                  <th>性别</th>
                  <td>${User.sex}</td>
              </tr>
              <tr>
                  <th>地址</th>
                  <td>${User.liveplace}</td>
              </tr>
              <tr>
                  <th>注册时间</th>
                  <td><fmt:formatDate value="${User.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate>  </td>
              </tr>
              <tr>
                  <th>账户余额</th>
                  <td>${User.balance}</td>
              </tr>
              <tr>
                  <th>状态</th>
                  <td>${User.status=="Y"?"会员":"普通用户"}</td>
              </tr>
            </tbody>
        </table>
    </div>
    <div class="row">
        <div class="col-md-offset-8">
        <a  class="btn btn-primary" href="${ctx}/portal/user/toEdit">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span><span> 信 息 修 改</span>
        </a>
        <a  class="btn btn-primary" href="${ctx}/portal/user/toEditPassword">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span><span> 密 码 修 改</span>
        </a>
        </div>
    </div>
</div>
</body>
</html>
