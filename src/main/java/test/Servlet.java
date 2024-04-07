//package test;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.*;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
////@WebServlet({"/dept/list","/dept/save","/dept/edit","/dept/detail"})
//@WebServlet("/dept/*")
//public class Servlet extends HttpServlet {
//    String driver = "com.mysql.cj.jdbc.Driver";
//    String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Taipei";
//    String userid = "root";
//    String passwd = "850811";
//
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         //獲取session,這個session不需要興建
//        //或取不到則返回null
//        //如果已經登入過才能繼續
//         HttpSession session= request.getSession(false);
////        已經登錄過
//       if(session !=null&&session.getAttribute("username")!=null){
//
//
//        String servletPath=request.getServletPath();
//        if("/dept/list".equals(servletPath)){
//            dolist(request,response);
//
//        }else if("/dept/save".equals(servletPath)){
//            dosave(request,response);
//        }
//        else if("/dept/edit".equals(servletPath)){
//            doedit(request,response);
//        }
//        else if("/dept/detail".equals(servletPath)){
//            dodetail(request,response);
//
//
//
//        }else{
//            //跳轉到登錄頁面
//
//             //response.sendRedirect("/oa/index.jsp");
//            response.sendRedirect(request.getContextPath());
//        }
//    }
//
//    private void dolist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//
//    }
//    private void dosave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//
//    }
//    private void doedit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//
//    }
//    private void dodetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out=response.getWriter();
//
//        String deptno=request.getParameter("adad");
//
//        Connection con=null;
//        PreparedStatement ps=null;
//        ResultSet rs=null;
//            try {
//                try {
//                    con = DriverManager.getConnection(url, userid, passwd);
//                    String sql = "select dname,loc from dept where deptno=?";
//                    ps = con.prepareStatement(sql);
//                    ps.setString(1; deptno);
//                    rs = ps.executeQuery();
//                    if (rs.next() {
//                        String dname = rs.getString(dname);
//                        String loc = rs.getString(loc);
//                        out.print("部們編號" + deptno + "<br>");
//                        out.print("部們名稱" + dname + "<br>");
//                        out.print("部們位置" + loc + "<br>");
//                    }
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//
//            } finally {
//
//            }
//
//
//
//    }
//}
//
