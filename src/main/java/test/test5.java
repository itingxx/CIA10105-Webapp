package test;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class test5 {




    @WebServlet("/Readpic")
    public class Readpic extends HttpServlet {
        private static final long serialVersionUID = 1L;

        // MySQL database connection details
        private static final String url = "jdbc:mysql://localhost:3306/cinema?serverTimezone=Asia/Taipei";
        private static final String userid = "root";
        private static final String password = "168168";

        protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            req.setCharacterEncoding("Big5");
            res.setContentType("image/jpeg"); // Set the content type to image/jpeg
            try {
                // Retrieve movieId parameter from the request
                String movieId = req.getParameter("movieId");

                // Establish a connection to the MySQL database
                String url = "jdbc:mysql://localhost:3306/cinema?serverTimezone=Asia/Taipei";
                String userid = "root";
                String password = "168168";
                Connection connection = DriverManager.getConnection(url, userid, password);


                String sql = "SELECT pic FROM movie WHERE movieId = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, movieId);  //取得網址列上的參數  上面string


                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    InputStream inputStream = rs.getBinaryStream("pic");  //取得二元資料流


                    int bytesRead;
                    byte[] buffer = new byte[4096];
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        res.getOutputStream().write(buffer, 0, bytesRead);  // 用RESPONSE 取得輸出資料流然後寫入網頁
                    }
                    inputStream.close();
                } else {

                    InputStream in=getServletContext().getResourceAsStream("/images/null.jpg");   //如果無參數送出要得到的回應照片
                    byte[]b =new byte[in.available()];
                    in.read(b);
                    res.getOutputStream().write(b);
                    in.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                res.getWriter().write("錯誤發生");
            }
        }

    }
}
