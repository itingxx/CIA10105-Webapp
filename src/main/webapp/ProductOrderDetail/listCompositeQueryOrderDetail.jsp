<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
    <title>List Emps</title>
</head>
<body>
<h1>員工列表</h1>
<br>
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
<table style="width:50%; text-align:center;">
    <tr>
        <th>商品訂單編號</th>
        <th>商品編號</th>
        <th>商品單價</th>
        <th>購買數量</th>
        <th>訂單實付金額</th>
        <th>評價內容</th>
        <th>評價星等</th>
    </tr>
    <c:forEach var="productOrderDetail" items="${productOrderDetailList}">
        <tr>
            <td>${productOrderDetail.compositeKey.pOrdNo}</td>
            <td>${productOrderDetail.compositeKey.pNo}</td>
            <td>${productOrderDetail.pPrice}</td>
            <td>${productOrderDetail.pOrdQty}</td>
            <td>${productOrderDetail.pRealPrice}</td>
            <td>${productOrderDetail.pComContent}</td>
            <td>${productOrderDetail.pScore}</td>
        </tr>
    </c:forEach>
</table>
<br>
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
<br><br>

<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>
</body>
</html>