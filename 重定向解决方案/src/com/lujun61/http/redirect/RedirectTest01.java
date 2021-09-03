package com.lujun61.http.redirect;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RedirectTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RedirectTest01被手动调用了！");
//        response.sendRedirect("/myWeb/redirect02");//当前网站内部的资源文件地址
        response.sendRedirect("https://www.baidu.com");//其它网站的资源文件地址
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
