package test;
import java.io.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
@WebServlet("/Pic")
public class Pic extends HttpServlet{
    Connection con;

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("image/gif");
        ServletOutputStream out = res.getOutputStream();

        try {
            Statement stmt = con.createStatement();
            String id=req.getParameter("pPicno");
            ResultSet rs = stmt.executeQuery(
                    "select pPic from ProductPicture where pPicNo="+10);

            if (rs.next()) {
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
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei", "root", "850811");
        } catch (ClassNotFoundException e) {
            throw new UnavailableException("Couldn't load JdbcOdbcDriver");
        } catch (SQLException e) {
            throw new UnavailableException("Couldn't get db connection");
        }
    }

    public void destroy() {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    }