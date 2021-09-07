package com.lujun61.listener;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletContextAttributeListenerTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        //新增共享数据
        application.setAttribute("key1", 100);

        //修改共享数据
        application.setAttribute("key1", 666);

        //删除共享数据
        application.removeAttribute("key1");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
