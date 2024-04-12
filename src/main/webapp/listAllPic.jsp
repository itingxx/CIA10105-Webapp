<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*" %>
<%@ page import="ProductPicture.ProductPictureService" %>
<%@ page import="ProductPicture.ProductPictureVO" %>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%

    ProductPictureService productPicture = new ProductPictureService();
    List<ProductPictureVO> list = productPicture.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
    <title>所有照片資料 - listAllpic.jsp</title>

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

<h4>此頁練習w..採用 EL 的寫法取值:</h4>
<table id="table-1">
    <tr><td>
        <h3>所有員工資料 - listAllPic.jsp</h3>
        <h4><a href="SelectPage.jsp"><img src="images/cat.png" width="100" height="32" border="0">回首頁</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>照片編號</th>
        <th>商品編號</th>
        <th>照片</th>

    </tr>

    <c:forEach var="productPictureVO" items="${list}">
        <tr>
            <td>${productPictureVO.pPicNo}</td>
            <td>${productPictureVO.pNo}</td>
            <td><img src="data:image/png;base64,${Base64.getEncoder().encodeToString(productPictureVO.pPic)}" alt="照片" width="100" height="100">
            </td>
            <td>
                <form method="post" action="<%=request.getContextPath()%>/productPicture.do" name="form1">
                    <input type="submit" value="修改">
                    <input type="hidden" name="pPicNo" value="${productPictureVO.pPicNo}">
                    <input type="hidden" name="action" value="getOne_For_Update">
                </form>
            <td>
                <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/productPicture.do" style="margin-bottom: 0px;">
                    <input type="submit" value="刪除">
                    <input type="hidden" name="pPicNo"  value="${productPictureVO.pPicNo}">
                    <input type="hidden" name="action" value="delete"></FORM>
            </td>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>