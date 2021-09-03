package com.lujun61.http.request;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DispatcherTest02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求对象代替用户操作浏览器向Tomcat发送请求！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
