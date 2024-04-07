package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

//Servlet負責業務處理
//JSP負責頁面展示

@WebServlet({"/user/login","/user/exit"})
public class examplelogin extends HttpServlet {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "850811";


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath=request.getServletPath();
        if("/user/login".equals(servletPath)){
            dologin(request,response);
        }else if("/user/exit".equals(servletPath)){
            doexit(request,response);
        }
    }
    protected void doexit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //獲取session,銷毀session
        HttpSession session =request.getSession(false);
        if (session!=null){
            //手動銷毀session對象
            session.invalidate();
            response.sendRedirect(request.getContextPath());
        }
    }


    protected void dologin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     boolean success=false;
      //驗證用戶是否正確
        //獲取用戶明及密碼
        // 前端username=5&password=5
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        //連接數據庫驗證用戶及密碼
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;


            try {
                Class.forName(driver);
                con=DriverManager.getConnection(url, userid, passwd);
                String sql="select * from t_user where username=? and password=?";
                //編譯SQL
                ps=con.prepareStatement(sql);
                //給?傳值
                ps.setString(1,username);
                ps.setString(2,password
                );
                //執行SQL語句,返回結果集
                rs= ps.executeQuery();
                //這個結果集只有0條或1條
                if(rs.next()){
                    //登錄成功
                    success=true;
                }

            } catch (ClassNotFoundException e) {
        throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
        // Handle any SQL errors
    } catch (SQLException se) {
        throw new RuntimeException("A database error occured. " + se.getMessage());
            }finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException se) {
                        se.printStackTrace(System.err);
                    }
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace(System.err);
                    }
                }
            }
            if (success){
                //獲取session對象
                Cookie cookie=new Cookie("gerge","3425511");
                HttpSession session=request.getSession();
                session.setAttribute("username", username);
                //成功,跳轉到用戶表頁面
                response.sendRedirect(request.getContextPath()+"/example.jsp");
                response.addCookie(cookie);
            }else{
                //失敗,跳轉到失敗頁面
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        }
        //登陸成功或失敗

    }

