<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
    <title>Hibernate Demo</title>
</head>
<body>
<h1>這是一位後端人員作的網頁 QQ</h1>
<h2>訂單系統</h2>
<a href="${pageContext.request.contextPath}/ProductOrderDetail/productOrderDetail.do?action=getAll">查詢所有員工</a>
<br><br>
<h3><b>複合查詢 (使用 Criteria Query)：</b></h3>
<form action="${pageContext.request.contextPath}/ProductOrderDetail/productOrderDetail.do" method="post">
    <p><label>訂單編號查詢：</label></p>
    <input type="text" name="pOrdNo"><br>
    <p><label>員工職位：</label></p>
    <input type="text" name="pNo"><br>
    <p><label>星星範圍</label></p>
    <input type="date" name="startpScore"> ～ <input type="date" name="endpScore"><br>
    <p><label>薪資範圍</label></p>
    <input type="text" name="startsal"> ～ <input type="text" name="endsal"><br>
    <p><input type="submit" value="送出"></p>
    <input type="hidden" name="action" value="compositeQuery">
</form>
</body>
</html>