<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="${ctx}/js/jquery.min.js"></script>
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/css/jquery.toastmessage.css" type="text/css">
    <script src="${ctx}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/datepicker/WdatePicker.js"></script>
    <script src="${ctx}/js/jquery-form.js" type="text/javascript"></script>
    <script src="${ctx}/js/jquery.bootstrap.min.js"></script>
    <style type="text/css">
        body {
            /*background: url(${ctx}/images/8.jpg) repeat top left;*/
        }
        label{
            font-weight: bold;
        }
    </style>



    <title>订单生成</title>
</head>
<body>
<div class="container">
    <br> <br>
    <form id="book_editForm" class="form-horizontal"  action="${ctx}/admin/book/book" method="post">
        <input type="hidden" name="bookisbn" value="${Book.bookisbn}">
        <div class="control-group">
            <label class="control-label" >图书名: </label>
            <input type="text" placeholder="" required oninvalid="setCustomValidity('请 输 入 图 书 名！');" oninput="setCustomValidity('');"  name="bookname"  value="${Book.bookname}">
        </div>

        <div class="control-group">
            <label class="control-label" >作者：</label>
            <input type="text"  required name="author" oninvalid="setCustomValidity('请 输 入 作 者 ！');" oninput="setCustomValidity('');" value="${Book.author}">
        </div>
        <div class="control-group">
            <label class="control-label" >出版商：</label>
            <input type="text" required name="publisher" oninvalid="setCustomValidity('请 输 入 出 版 商 ！');" oninput="setCustomValidity('');" value="${Book.publisher}">
        </div>
        <div class="control-group">
            <label class="control-label">出版日期:</label>
            <div class="form-control" id="datetimepicker"  >
                <input type="date" required  name="pubilshdata" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" >价格：</label>
            <input type="number" min="0.0" step="0.1" max="200" required  oninvalid="setCustomValidity('请 输 入 正 确 的 价 格！');" oninput="setCustomValidity('');" name="price" value="${Book.price}">
        </div>
        <c:if test="${empty Book.bookisbn}">
            <div class="control-group">
                <label class="control-label" >数量：</label>
                <input type="number" min="1" required required  oninvalid="setCustomValidity('请 输 入 正 确 的 数 量,最 少 为 1！');" oninput="setCustomValidity('');" name="stocknum">
            </div>
        </c:if>
        <div class="control-group">
            <label class="control-label">所属类型：</label>
            <select class="form-control" id="category" name="categoryid" required  oninvalid="setCustomValidity('请 选 择 分 类！');" oninput="setCustomValidity('');">
                <option value="-1">--请选择--</option>
                <c:forEach items="${requestScope.cateGories}" var="category">
                    <option  value="${category.categoryid}" <c:if test ="${category.categoryid eq requestScope.Book.categoryid}">selected</c:if> >${category.categoryname}</option>
                </c:forEach>
            </select>
        </div>

        <div class="control-group">
            <label class="control-label" >描述：</label>
            <textarea rows="3" name="description" >${Book.description}
            </textarea>
        </div>
        <div class="control-group">
            <div class="controls">
                <input type="submit" class="btn" value="确认提交"/>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $("#book_editForm").ajaxForm(function(result){
            if(result.code==0){
                alert(result.msg);
                window.location.href="${ctx}/admin/book/books";
            }
            if(result.code==1){
                alert(result.msg);
                return false;
            }
        });
    })
</script>
</body>
</html>