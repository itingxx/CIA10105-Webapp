<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--private Integer pPicNo;--%>
<%--private Integer pNo;--%>
<%--private byte[] pPic;--%>
<form action="#" method="get" id="the_form">
<label for="pPicNo">商品照片編號:</label><br>
<input id="pPicNo" type="text" name="pPicNo"><br>
<label for="pNo">商品編號:</label><br>
<input id="pNo" type="text" name="pNo"><br>
<label>商品圖片：</label>
<input type="file" id="pPic" name="pPic">

<div id="preview">
    <span class="text" >預覽圖</span>
</div>
    <input type="submit" value="新增">
</form>

    <table>
    <tr>
        <th>
            商品照片編號
        </th>
        <th>
            商品編號
        </th>
        <th>
            商品圖片
        </th>

    </tr>
</table>

<script>
    function previewImg(file) {
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
            var imgStr = '<img src="' + reader.result + '" class="preview_img">';
            document.getElementById('preview').innerHTML = imgStr;
        };
    }

    window.onload = function () {
        document.getElementById('pPic').addEventListener('change', function (e) {
            if (this.files.length > 0) {
                previewImg(this.files[0]);
            } else {
                document.getElementById('preview').innerHTML = '<span class="text">預覽圖</span>';
            }
        });
    };
</script>
</body>
</html>
