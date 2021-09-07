package com.lujun61.filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class FilterTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("你符合条件，可以访问此网站！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
