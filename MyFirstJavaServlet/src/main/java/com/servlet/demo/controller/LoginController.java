package com.servlet.demo.controller;

import com.servlet.demo.manager.DBConnectionManager;
import com.servlet.demo.service.LoginService;
import com.servlet.demo.vo.UserVO;

import java.io.*;
import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "MyFirstServlet", value = "/hello" ,loadOnStartup = 1,initParams = {@WebInitParam(name = "charset",value = "UTF-8")})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = -1915463532411657451L;

    private String message;
    private LoginService loginService;

    public void init() {
        message = "Hello World!";
        loginService = new LoginService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        //set session
        HttpSession session = request.getSession();
        session.setAttribute("name",name);
        session.setAttribute("age",age);

        //get value from servletContext
        ServletContext context = request.getServletContext();
        //set value in servletContext
        context.setAttribute("name", name);
        DBConnectionManager dbManager = (DBConnectionManager)context.getAttribute("DBManager");
        UserVO userVO = loginService.login(name, dbManager);
        boolean exist = userVO != null;

        //parse request
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.getWriter().write("你好:"+name+",登录:"+exist);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
        //TODO save some data when stop server

    }
}