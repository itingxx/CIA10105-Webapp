<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Home</title>

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

<table id="table-1">
    <tr><td><h3>Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for productPicture: Home</p>

<h3>資料查詢:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
    <font style="color:red">請修正以下錯誤:</font>
    <ul>
        <c:forEach var="message" items="${errorMsgs}">
            <li style="color:red">${message}</li>
        </c:forEach>
    </ul>
</c:if>

<ul>
    <li><a href='listAllPic.jsp'>List</a> all ProductPicture </li>
<%--    <li><a href='productPicture.do?action=getAll'> List</a> all productPicture  <h4>(getFromSession).</h4> </li>--%>
    <li><a href='addPic.jsp'>插入資料</a></li>
    <br><br><br>
    <li>
        <FORM METHOD="post" ACTION="productPicture.do" >
            <b>輸入照片編號 (如7001):</b>
            <input type="text" name="pPicNo">
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">                   <h4>(資料格式驗證  by Controller ).</h4>
        </FORM>
    </li>

    <li>
        <FORM METHOD="post" ACTION="productPicture.do" name="form1">
            <b>輸入照片編號 (如7001):</b>
            <input type="text" name="pPicNo">
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="button" value="送出" onclick="fun1()">  <h4>(資料格式驗證  by Java Script).</h4>
        </FORM>
    </li>

    <%--   <jsp:useBean id="dao" scope="page" class="com.emp.model.EmpDAO" /> --%>
    <% dao.ProductPictureDAO dao0 =new dao.ProductPictureDAO();%><%pageContext.setAttribute("dao",dao0); %>
    <!-- pageContext 204.337 -->
    <li>
        <FORM METHOD="post" ACTION="productPicture.do" >
            <b>選擇照片編號:</b>
            <select size="1" name="pPicNo">
                <c:forEach var="productPictureVO" items="${dao.all}" >   <!-- pageScope :p236 -->
                <option value="${productPictureVO.pPicNo}">${productPictureVO.pPicNo}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>


</ul>

<script>
    function fun1(){
        with(document.form1){
            if (pPicNo.value=="")
                alert("請輸入照片編號!");
            else if (isNaN(pPicNo.value))
                alert("照片編號格式不正確!");
            else if ((pPicNo.value > 3000) || (pPicNo.value < 1))
                alert("請填寫介於3000和1之間的數字!");
            else
                submit();
        }
    }
</script>

</body>
</html>