package com.lujun61.http.request;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DispatcherTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接收到了来自用户手动使用浏览器发送的请求");
        //1、通过【当前请求对象】获取【资源文件申请报告对象】
        RequestDispatcher report = request.getRequestDispatcher("/dispatch02");

        //2、将report对象发送给Tomcat
        report.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
