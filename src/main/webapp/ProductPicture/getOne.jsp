<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="com.iting.productpicture.DAO.ProductPictureService" %>

<%@ page import="java.util.Base64" %>
<%@ page import="com.iting.productpicture.model.ProductPictureVO" %>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    List<ProductPictureVO> productPictureVOList = (List<ProductPictureVO>) request.getAttribute("productPictureVO");
%>

<html>
<head>


    <style>
        table#table-1 {
            background-color: #CCCCFF;
            border: 2px solid black;
            text-align: center;
        }
        table#table-1 h4 {
            color: red;
            display: block;
            margin-bottom: 1px;
        }
        h4 {
            color: blue;
            display: inline;
        }
    </style>

    <style>
        table {
            width: 800px;
            background-color: white;
            margin-top: 5px;
            margin-bottom: 5px;
        }
        table, th, td {
            border: 1px solid #CCCCFF;
        }
        th, td {
            padding: 5px;
            text-align: center;
        }
    </style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
    <tr>
        <td>
            <h3>所有員工資料 - listAllPic.jsp</h3>
            <h4><a href="SelectPage.jsp"><img src="../images/cat.png" width="100" height="100" border="0" alt="圖片">回首頁</a></h4>
        </td>
    </tr>
</table>

<table>
    <tr>
        <th>照片編號</th>
        <th>商品編號</th>
        <th>照片</th>
        <th colspan="2">操作</th>
    </tr>

    <c:forEach var="productPictureVO" items="${productPictureVOList}" >
        <tr>
            <td>${productPictureVO.pPicNo}</td>
            <td>${productPictureVO.pNo}</td>
            <td>
            <td><img src="data:image/png;base64,${Base64.getEncoder().encodeToString(productPictureVO.pPic)}" alt="照片" width="100" height="100">
                     alt="照片" width="100" height="100">
            </td>
            <td>
                <form method="post" action="<%=request.getContextPath()%>/ProductPicture/productPicture.do" name="form1">
                    <input type="submit" value="修改">
                    <input type="hidden" name="pPicNo" value="${productPictureVO.pPicNo}">
                    <input type="hidden" name="action" value="getOne_For_Update">
                </form>
            </td>
            <td>
                <form method="post" action="<%=request.getContextPath()%>/ProductPicture/productPicture.do" style="margin-bottom: 0px;">
                    <input type="submit" value="刪除">
                    <input type="hidden" name="pPicNo" value="${productPictureVO.pPicNo}">
                    <input type="hidden" name="action" value="delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
