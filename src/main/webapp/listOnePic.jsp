<%@ page import="dao.*" %>
<%@ page import="java.util.Base64" %>
<%@ page import="ProductPicture.ProductPictureVO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
    ProductPictureVO productPictureVO = (ProductPictureVO) request.getAttribute("productPictureVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
    <title>���u��� - listOnePic.jsp</title>

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
            width: 600px;
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

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
    <tr><td>
        <h3>���u��� - listOnePic.jsp</h3>
        <h4><a href="SelectPage.jsp"><img src="images/cat.png" width="100" height="32" border="0">�^����</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>�Ӥ��s��</th>
        <th>�ӫ~�s��</th>
        <th>�Ӥ�</th>
    </tr>
    <tr>
        <td><%=productPictureVO.getpPicNo()%></td>
        <td><%=productPictureVO.getpNo()%></td>
        <td> <img src="data:image/png;base64,${Base64.getEncoder().encodeToString(productPictureVO.pPic)}" alt="�Ӥ�" width="100" height="100"></td>

        <td>
            <form method="post" action="<%=request.getContextPath()%>/productPicture.do" name="form1">
                <input type="submit" value="�ק�">
                <input type="hidden" name="pPicNo" value="${productPictureVO.pPicNo}">
                <input type="hidden" name="action" value="getOne_For_Update">
            </form>
        <td>
            <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/productPicture.do" style="margin-bottom: 0px;">
                <input type="submit" value="�R��">
                <input type="hidden" name="pPicNo"  value="${productPictureVO.pPicNo}">
                <input type="hidden" name="action" value="delete"></FORM>
        </td>
    </tr>
</table>

</body>
</html>
