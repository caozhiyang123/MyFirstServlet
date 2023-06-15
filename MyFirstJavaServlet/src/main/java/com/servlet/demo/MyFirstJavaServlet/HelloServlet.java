package com.servlet.demo.MyFirstJavaServlet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "MyFirstServlet", value = "/hello" ,loadOnStartup = 1,initParams = {@WebInitParam(name = "charset",value = "UTF-8")})
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = -1915463532411657451L;

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //parse request
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.getWriter().write("你好:"+name);
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