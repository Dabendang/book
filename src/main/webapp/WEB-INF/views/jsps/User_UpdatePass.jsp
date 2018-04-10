<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${ctx}/css/bootstrap3/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrap3/bootstrap-theme.min.css" rel="stylesheet"
          type="text/css">
    <script src="${ctx}/js/bootstrap3/bootstrap.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/jquery-3.1.1.js" type="text/javascript"></script>
    <script src="${ctx}/js/jquery.toastmessage.js" type="text/javascript"></script>
    <script src="${ctx}/js/jquery.validate.js" type="text/javascript"></script>
    <script src="${ctx}/js/messages_zh.js" type="text/javascript"></script>
    <script src="${ctx}/js/jquery-form.js" type="text/javascript"></script>
    <%-- <script src="${ctx}/js/jquery.magnific-popup.js" type="text/javascript"></script>
    <script src="${ctx}/js/modernizr.custom.53451.js" type="text/javascript" ></script> --%>
    <script>
        $(function() {
            $("#updatePass_form").validate({
                rules:{
                    "logpassword": {
                        required: true,
                        rangelength:[6,16]
                    },
                    "paypassword": {
                        required: true,
                        rangelength:[6,16]
                    },
                    "confimLogPwd":{
                        equalTo:"#logpassword" //配对的元素一定要有id #ID
                    },
                    "confimPayPwd":{
                        equalTo:"#paypassword" //配对的元素一定要有id #ID
                    }
                },
                message:{
                    "logpassword": {
                        required: "请 输 入 登 陆 密 码",
                        rangelength: "密 码 的 长 度 须 在 {0} 到 {1} 位 之 间!"
                    },
                    "paypassword": {
                        required: "请 输 入 支 付 密 码",
                        rangelength: "密 码 的 长 度 须 在 {0} 到 {1} 位 之 间!"
                    },
                    "confimLogPwd":{
                        equalTo:"两 次 输 入 的 密 码 不 一 致!"
                    },
                    "confimPayPwd":{
                        equalTo:"两 次 输 入 的 密 码 不 一 致!"
                    }
                },
                errorClass:"text-danger"
            });
        })
    </script>
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
        div{
            height: 20px;
        }
        .text-danger{
            color: #FF0000;
        }
    </style>

    <title>用户密码编辑</title>
</head>
<body>
<div class="container">
    <br> <br>

    <form id="updatePass_form" class="form-horizontal"  action="${ctx}/portal/user/updatePass" method="post">
        <h3>用户密码编辑</h3>
        <input type="hidden" name="userid" value="${User.userid}">
        <div class="control-group">
            <label class="control-label" >登陆密码: </label>
            <input type="password" id="logpassword" name="logpassword">
        </div>
        <div></div>
        <div>
            <label class="control-label" >确认登录密码: </label>
            <input type="password" id="confimLogPwd"  name="confimLogPwd"  />
        </div>
        <div></div>
        <div class="control-group">
            <label class="control-label" >支付密码: </label>
            <input type="password" id="paypassword" name="paypassword">
        </div><div></div>
        <div>
            <label class="control-label" >确认支付密码: </label>
            <input type="password" id="confimPayPwd"  name="confimPayPwd"/>
        </div>
        <div></div>
        <div></div>
        <div></div>
        <div class="control-group" >
            <div class="controls">
                <input type="submit" class="btn" value="修改"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>