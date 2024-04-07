<%--
  Created by IntelliJ IDEA.
  User: TMP-214
  Date: 2024/4/6
  Time: 下午 03:21
  To change this template use File | Settings | File Templates.
--%>
<%--訪問JSP時不生成session對象--%>
<%--寫了session對象無法使用--%>
<%--<%@page session="false" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登錄失敗</title>
</head>
<body>
登錄失敗請<a href="<%=request.getContextPath()%>/WEB-INF/TEST/example.jspT/example.jsp">重新登錄</a>
</body>
</html>
