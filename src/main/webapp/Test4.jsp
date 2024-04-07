<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*" %>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
    ProductPictureDAO dao = new ProductPictureDAO();
    List<ProductPictureVO> list = dao.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
    <title>�Ҧ��Ӥ���� - listAllpic.jsp</title>

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

<h4>�����m��w..�ĥ� EL ���g�k����:</h4>
<table id="table-1">
    <tr><td>
        <h3>�Ҧ����u��� - listAllPic.jsp</h3>
        <h4><a href="index_page.jsp"><img src="image.jpg" width="100" height="32" border="0">�^����</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>�Ӥ��s��</th>
        <th>�ӫ~�s��</th>
        <th>�Ӥ�</th>

    </tr>

    <c:forEach var="picVO" items="${list}">

        <tr>
            <td>${picVO.pPicNo}</td>
            <td>${picVO.pNo}</td>
            <td>

                <c:if test="${picVO.pPic ne null}">
                    <img src="data:image/png;base64,${Base64.getEncoder().encodeToString(picVO.pPic)}" alt="�Ӥ�"  width="100" ;height="32">
                </c:if>
            </td>

        </tr>
    </c:forEach>
</table>


</body>
</html>