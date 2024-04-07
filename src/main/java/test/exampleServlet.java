package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExampleServlet")
public class exampleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 獲取名為 "name" 和 "age" 的參數值
        String name = request.getParameter("nae");
        String age = request.getParameter("age");

        // 輸出參數值到控制台
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        // 在響應中回傳參數值
        response.setContentType("text/html");
        response.getWriter().println("Name: " + name + "<br>");
        response.getWriter().println("Age: " + age + "<br>");
    }
}

