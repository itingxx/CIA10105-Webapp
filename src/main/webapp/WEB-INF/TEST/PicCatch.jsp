<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Image</title>
</head>
<body>
<h1>圖片顯示</h1>

<%
    Connection conn = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fallelove", "root", "850811");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT pPic FROM ProductPicture "); // Assuming pPicNo is 1

        while (rs.next()) {
            Blob blob = rs.getBlob("pPic");
            byte[] imageBytes = blob.getBytes(1, (int) blob.length());
            String base64Image = java.util.Base64.getEncoder().encodeToString(imageBytes);
            String imageData = "data:image/png;base64," + base64Image;

%>
<img src="<%= imageData %>" alt="Product Image">
<%
}
} catch (Exception e) {
        out.println("Error: " + e.getMessage());
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
%>
</body>
</html>
