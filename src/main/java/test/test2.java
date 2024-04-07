package test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class test2 extends HttpServlet {
    Connection con;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("image/gif");
        ServletOutputStream out = res.getOutputStream();

        try {
            // 建立資料庫連接
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei", "root", "850811");

            // 從資料庫中查詢圖片資料，這裡需要根據你的需求來填寫 SQL 查詢語句
            PreparedStatement pstmt = con.prepareStatement("SELECT pPic FROM ProductPicture WHERE pPicNo = ?");
            pstmt.setInt(1, Integer.parseInt(req.getParameter("pPicNo")));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // 從 ResultSet 中讀取圖片資料
                BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("pPic"));
                byte[] buf = new byte[4 * 1024]; // 4K buffer
                int len;
                while ((len = in.read(buf)) != -1) {
                    out.write(buf, 0, len);
                }
                in.close();
            } else {
                res.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei", "root", "850811");
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }

    public void destroy() {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

