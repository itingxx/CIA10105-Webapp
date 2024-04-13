<!DOCTYPE html>
<html>
<head>
    <title>Example Form</title>
</head>

<body>
<%--<form action="ExampleServlet" method="get">--%>
<%--    <label for="ne">Name:</label>--%>
<%--    <input type="text" id="ne" name="nae">--%>
<%--    <br>--%>
<%--    <label for="ae">Age:</label>--%>
<%--    <input type="text" id="ae" name="age">--%>
<%--    <br>--%>
<%--    <input type="submit" value="Submit">--%>
<%--</form>--%>

<form action=<%=request.getContextPath()%>/user/login method="post">
    <label for="user">username:</label>
    <input type="text" id="user" name="username" value="egr">
    <br>
    <label for="pass">password:</label>
    <input type="text" id="pass" name="password">
    <br>
    <input type="submit" value="login">
</form>
</body>
</html>

