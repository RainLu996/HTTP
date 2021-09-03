package com.lujun61.sharing;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletContextTest02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、通过请求对象获取全局作用域对象
        ServletContext application = request.getServletContext();

        //2、从全局作用域对象中通过key值到共享数据
        Object key1 = application.getAttribute("key1");
        if (key1 instanceof Integer) {
            Integer val1 = (Integer) key1;
            System.out.println(val1);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
