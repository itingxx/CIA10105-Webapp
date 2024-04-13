<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="dao.*"%>
<%@ page import="java.util.Base64" %>
<%@ page import="ProductPicture.ProductPictureVO" %>
<%@ page import="ProductPicture.ProductPictureService" %>

<%-- productPictureVO --%>
<%
    ProductPictureService productPictureService = new ProductPictureService();
    ProductPictureVO productPictureVO = null;
    byte[] pPic = null;

    if (request.getParameter("pPicNo") != null) {
        // 如果请求参数中包含 pPicNo，则使用请求参数
        productPictureVO = productPictureService.getOneProductPicture(Integer.parseInt(request.getParameter("pPicNo")));
        pPic = productPictureVO.getpPic();
    } else {
        // 如果请求参数中不包含 pPicNo，则尝试使用请求属性
        Object pPicNoAttribute = request.getAttribute("pPicNo");
        if (pPicNoAttribute != null) {
            productPictureVO = productPictureService.getOneProductPicture((Integer) pPicNoAttribute);
            pPic = productPictureVO.getpPic();
        }
    }
%>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>商品資料修改 - update_productpicture.jsp</title>

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
            width: 450px;
            background-color: white;
            margin-top: 1px;
            margin-bottom: 1px;
        }
        table, th, td {
            border: 0px solid #CCCCFF;
        }
        th, td {
            padding: 1px;
        }
    </style>

</head>
<body bgcolor='white'>

<c:if test="${not empty errorMsgs}">
    <font style="color:red">請修正以下錯誤:</font>
    <ul>
        <c:forEach var="message" items="${errorMsgs}">
            <li style="color:red">${message.value}</li>
        </c:forEach>
    </ul>
</c:if>


<table id="table-1">
    <tr><td>
        <h3>商品資料修改 - update_productpicture.jsp</h3>
        <h4><a href="SelectPage.jsp"><img src="images/cat.png" width="100" height="32" border="0">回首頁</a></h4>
    </td></tr>
</table>

<h3>資料修改:</h3>

<form method="post" action="productPicture.do" name="form1" enctype="multipart/form-data">
    <table>
        <tr>
            <td>照片編號:<font color=red><b>*</b></font></td>
            <td>${productPictureVO.pPicNo}</td>
        </tr>
        <tr>
            <td>商品編號:</td>
            <td><input type="text" name="pNo" value="${productPictureVO.pNo}" size="45"/></td>
        </tr>
        <tr>
            <td>圖片:</td>
            <td>
                <input type="file" id="pPic" name="pPic" >

                <div id="preview"  width="32" ;height="32">
                    <span class="text" >預覽圖</span>
                    <img src="data:image/jpeg;base64, <%= new String(Base64.getEncoder().encode(pPic)) %>" width="200" height="200" />
                </div>
            </td>
        </tr>
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="pPicNo" value="${productPictureVO.pPicNo}">
    <input type="submit" value="送出修改">
</form>

<script>
    function previewImg(file) {
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
            var imgStr = '<img src="' + reader.result + '" class="preview_img" style="width:200; height: 200;">';
            document.getElementById('preview').innerHTML = imgStr;
        };
    }

    window.onload = function () {
        document.getElementById('pPic').addEventListener('change', function (e) {
            if (this.files.length > 0) {
                previewImg(this.files[0]);
            } else {
                document.getElementById('previewImg').style.display = 'none';
                document.getElementById('preview').innerHTML = '<span class="text">預覽圖</span>';
            }
        });
    };
</script>

</body>
</html>
