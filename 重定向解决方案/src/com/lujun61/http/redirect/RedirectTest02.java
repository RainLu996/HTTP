package com.lujun61.http.redirect;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RedirectTest02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("浏览器根据响应头中的location属性自动访问网站！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
