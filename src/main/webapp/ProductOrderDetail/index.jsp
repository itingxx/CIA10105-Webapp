<%@ page import="com.iting.productorderdetail.DAO.ProductOrderDetailService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<a href="${pageContext.request.contextPath}/ProductOrderDetail/addProductOrderDetail.jsp">新增員工</a>
<a href="${pageContext.request.contextPath}/ProductOrderDetail/productOrderDetail.do?action=getAll">查詢所有員工</a>
<% ProductOrderDetailService dao0 =new ProductOrderDetailService();%><%pageContext.setAttribute("dao",dao0); %>
<br><br>
<h3><b>複合查詢 (使用 Criteria Query)：</b></h3>
<form action="${pageContext.request.contextPath}/ProductOrderDetail/productOrderDetail.do" method="post">
    <label >商品訂單編號:</label>
    <select size="1" name="pOrdNo">
        <option value="">選取</option>
        <c:forEach var="productOrderDetail" items="${dao.getAllProductOrderDetailVO()}">   <!-- pageScope :p236 -->
        <option value="${productOrderDetail.compositeKey.pOrdNo}">${productOrderDetail.compositeKey.pOrdNo}
            </c:forEach>
    </select><br>

    <label >商品編號:</label>
    <select size="1" name="pNo">
        <option value="">選取</option>
        <c:forEach var="productOrderDetail" items="${dao.getAllProductOrderDetailVO()}">   <!-- pageScope :p236 -->
        <option value="${productOrderDetail.compositeKey.pNo}">${productOrderDetail.compositeKey.pNo}
            </c:forEach>
    </select>
    <p><label>星星範圍</label></p>

    <select name="startpScore">
        <option value="">選取</option>
        <option value="1">1顆星</option>
        <option value="2">2顆星</option>
        <option value="3">3顆星</option>
        <option value="4">4顆星</option>
        <option value="5">5顆星</option>
    </select> ～
    <select name="endpScore">
        <option value="">選取</option>
        <option value="1">1顆星</option>
        <option value="2">2顆星</option>
        <option value="3">3顆星</option>
        <option value="4">4顆星</option>
        <option value="5">5顆星</option>
    </select>
    <p><input type="submit" value="送出"></p>
    <input type="hidden" name="action" value="compositeQuery">
</form>
</body>
</html>