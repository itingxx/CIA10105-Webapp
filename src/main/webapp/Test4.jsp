<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*" %>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    ProductPictureDAO dao = new ProductPictureDAO();
    List<ProductPictureVO> list = dao.getAll();
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
        <h4><a href="index_page.jsp"><img src="image.jpg" width="100" height="32" border="0">回首頁</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>照片編號</th>
        <th>商品編號</th>
        <th>照片</th>

    </tr>

    <c:forEach var="picVO" items="${list}">

        <tr>
            <td>${picVO.pPicNo}</td>
            <td>${picVO.pNo}</td>
            <td>

                <c:if test="${picVO.pPic ne null}">
                    <img src="data:image/png;base64,${Base64.getEncoder().encodeToString(picVO.pPic)}" alt="照片"  width="100" ;height="32">
                </c:if>
            </td>

        </tr>
    </c:forEach>
</table>


</body>
</html>