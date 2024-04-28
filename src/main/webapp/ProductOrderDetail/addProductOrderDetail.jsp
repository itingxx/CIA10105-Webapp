<%@ page import="com.iting.productorderdetail.DAO.ProductOrderDetailService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>商品圖片資料新增 - addPic.jsp</title>

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
    <tr><td>
        <h3>商品訂單明細資料新增 - addPic.jsp</h3></td><td>
        <h4><a href="<%=request.getContextPath()%>/ProductOrderDetail/index.jsp"><img src="../images/cat.png" width="100" height="100" border="0">回首頁</a></h4>
    </td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
    <font style="color:red">請修正以下錯誤:</font>
    <ul>
        <c:forEach var="message" items="${errorMsgs}">
            <li style="color:red">${message}</li>
        </c:forEach>
    </ul>
</c:if>
<% ProductOrderDetailService dao0 =new ProductOrderDetailService();%><%pageContext.setAttribute("dao",dao0); %>
<form action="${pageContext.request.contextPath}/ProductOrderDetail/productOrderDetail.do" method="post">

        <label>商品訂單編號：</label>
        <input type="text" id="pOrdNo" name="pOrdNo">
    <label>>商品編號：</label>
        <input type="text" id="pNo" name="pNo">
    <label>>商品價格：</label>
    <input type="text" id="pPrice" name="pPrice">
    <label>購買數量：</label>
    <input type="text" id="pOrdQty" name="pOrdQty">
    <label>訂單實付金額：</label>
    <input type="text" id="pRealPrice" name="pRealPrice">
    <label>評價內容：</label>
    <input type="text" id="pComContent" name="pComContent">
    <label>評價星等：</label>
    <select name="pScore">
        <option value="">選取</option>
        <option value="1">1顆星</option>
        <option value="2">2顆星</option>
        <option value="3">3顆星</option>
        <option value="4">4顆星</option>
        <option value="5">5顆星</option>
    </select>


    <%--        <jsp:useBean id="productPictureSvc" scope="page" class="com.iting.productpicture.DAO.ProductPictureService" />--%>
    <%--        <tr>--%>
    <%--            <td>圖片編號:<font color=red><b>*</b></font></td>--%>
    <%--            <td><select size="1" name="pPicNo">--%>
    <%--                <c:forEach var="deptVO" items="${deptSvc.all}">--%>
    <%--                <option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname}--%>
    <%--                    </c:forEach>--%>
    <%--            </select></td>--%>
    <%--        </tr>--%>

    <%--    </table>--%>
    <%--    <br>--%>
    <input type="hidden" name="action" value="add">
    <input type="submit" value="送出新增">

</FORM>
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
                document.getElementById('preview').innerHTML = '<span class="text" ></span>';
            }
        });
    };
</script>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%--<%--%>
<%--    java.sql.Date hiredate = null;--%>
<%--    try {--%>
<%--        hiredate = empVO.getHiredate();--%>
<%--    } catch (Exception e) {--%>
<%--        hiredate = new java.sql.Date(System.currentTimeMillis());--%>
<%--    }--%>
<%--%>--%>
<%--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />--%>
<%--<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>--%>
<%--<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>--%>

<%--<style>--%>
<%--    .xdsoft_datetimepicker .xdsoft_datepicker {--%>
<%--        width:  300px;   /* width:  300px; */--%>
<%--    }--%>
<%--    .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {--%>
<%--        height: 151px;   /* height:  151px; */--%>
<%--    }--%>
<%--</style>--%>

<%--<script>--%>
<%--    $.datetimepicker.setLocale('zh');--%>
<%--    $('#f_date1').datetimepicker({--%>
<%--        theme: '',              //theme: 'dark',--%>
<%--        timepicker:false,       //timepicker:true,--%>
<%--        step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)--%>
<%--        format:'Y-m-d',         //format:'Y-m-d H:i:s',--%>
<%--        value: '<%=hiredate%>', // value:   new Date(),--%>
<%--        //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含--%>
<%--        //startDate:	            '2017/07/10',  // 起始日--%>
<%--        //minDate:               '-1970-01-01', // 去除今日(不含)之前--%>
<%--        //maxDate:               '+1970-01-01'  // 去除今日(不含)之後--%>
<%--    });--%>



<%--    // ----------------------------------------------------------以下用來排定無法選擇的日期-------------------------------------------------------------%>

<%--    //      1.以下為某一天之前的日期無法選擇--%>
<%--    //      var somedate1 = new Date('2017-06-15');--%>
<%--    //      $('#f_date1').datetimepicker({--%>
<%--    //          beforeShowDay: function(date) {--%>
<%--    //        	  if (  date.getYear() <  somedate1.getYear() ||--%>
<%--    //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) ||--%>
<%--    //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())--%>
<%--    //              ) {--%>
<%--    //                   return [false, ""]--%>
<%--    //              }--%>
<%--    //              return [true, ""];--%>
<%--    //      }});--%>


<%--    //      2.以下為某一天之後的日期無法選擇--%>
<%--    //      var somedate2 = new Date('2017-06-15');--%>
<%--    //      $('#f_date1').datetimepicker({--%>
<%--    //          beforeShowDay: function(date) {--%>
<%--    //        	  if (  date.getYear() >  somedate2.getYear() ||--%>
<%--    //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) ||--%>
<%--    //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())--%>
<%--    //              ) {--%>
<%--    //                   return [false, ""]--%>
<%--    //              }--%>
<%--    //              return [true, ""];--%>
<%--    //      }});--%>


<%--    //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)--%>
<%--    //      var somedate1 = new Date('2017-06-15');--%>
<%--    //      var somedate2 = new Date('2017-06-25');--%>
<%--    //      $('#f_date1').datetimepicker({--%>
<%--    //          beforeShowDay: function(date) {--%>
<%--    //        	  if (  date.getYear() <  somedate1.getYear() ||--%>
<%--    //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) ||--%>
<%--    //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())--%>
<%--    //		             ||--%>
<%--    //		            date.getYear() >  somedate2.getYear() ||--%>
<%--    //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) ||--%>
<%--    //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())--%>
<%--    //              ) {--%>
<%--    //                   return [false, ""]--%>
<%--    //              }--%>
<%--    //              return [true, ""];--%>
<%--    //      }});--%>


</html>