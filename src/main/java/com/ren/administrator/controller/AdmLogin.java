package com.ren.administrator.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AdmLogin extends HttpServlet {

    private final String USERS = "";
    private final String LOGIN_PATH = "home.jsp";
    private final String HOME_PATH = "";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        super.doPost(req, res);
    }

    public void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getSession().getAttribute("login") == null) {
            res.sendRedirect(LOGIN_PATH);
            return;
        }

//        req.setAttribute("messages", messages(getUsername(req)));

    }

    private String getUsername(HttpServletRequest req) {
        return (String) req.getSession().getAttribute("login");
    }

//    private Map<Long, String> messages(String username) throws IOException {
//        var userhome = Paths.get(USERS, username);
//        var messages = new TreeMap<Long, String>(Comparator.reverseOrder());
//        try (var txts = Files.newDirectoryStream(userhome, "*.txt") ) {
//            for (var txt : txts) {
//                var millis = txt.getFileName().toString().replace();
//                var blabla = Files.readAllLines(txt).stream()
//                        .collect(
//                                Collectors.joining(System.lineSeparator())
//                        );
//                messages.put(Long.parseLong(millis), blabla);
//            }
//        }
//        return messages;
//    }

}
