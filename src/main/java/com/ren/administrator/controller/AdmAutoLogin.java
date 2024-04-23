package com.ren.administrator.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AdmAutoLogin extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

//    @Override
//    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        super.doPost(req, res);
//        if ("login".equals(action)) {
//
//            List<String> errorMsgs = new LinkedList<>();
//            // Store this set in the request scope, in case we need to
//            // send the ErrorPage view.
//            req.setAttribute("errorMsgs", errorMsgs);
//
//            String admName = req.getParameter("admName").trim();
//            if (admName == null || admName.trim().length() == 0) {
//                errorMsgs.add("管理員名稱請勿空白");
//            }
//
//            String admPwd = req.getParameter("admPwd");
//            String admPwdReg = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{6,12}$";
//            if (admPwd == null || admPwd.trim().length() == 0) {
//                errorMsgs.add("管理員密碼: 請勿空白!");
//            } else if (!admPwd.trim().matches(admPwdReg)) { // 以下練習正則(規)表示式(regular-expression)
//                errorMsgs.add("管理員密碼: 只能是中、英文字母、數字和_ , 且長度必需在6到12之間");
//            }
//
//            var encrypt = Integer.parseInt(data[1]);
//            var salt = Integer.parseInt(data[2]);
//            (admPwd.hashCode() + salt) == encrypt;
//        }
//
//        if ("autoLogin".equals(action)) {
//            Optional<Cookie> userCookie = Optional.ofNullable(req.getCookies())
//                    .flatMap(this::userCookie);
//        }
//    }
//
//    private Optional<Cookie> userCookie(Cookie[] cookies) {
//        return Stream
//    }

}
