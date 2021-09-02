package com.lujun61.ServletLifeCircle;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest02 extends HttpServlet {
    public ServletTest02() {
        System.out.println("ServletTest02类被创建实例对象");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletTest02 doGet方法调用了！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
