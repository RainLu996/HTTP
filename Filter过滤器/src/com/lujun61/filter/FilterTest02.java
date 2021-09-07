package com.lujun61.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description 使用过滤器（Filter）接口检测用户请求合法性
 * @author Jun Lu
 * @date 2021-09-07 20:29:00
 */
public class FilterTest02 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1、通过拦截请求对象得到请求参数包信息，从而得到来访用户的真实年龄
        servletRequest.setCharacterEncoding("utf-8");
        String age = servletRequest.getParameter("age");

        //2、根据年龄，帮助HTTP服务器判断本次服务合法性
        if (Integer.parseInt(age) < 70) { //合法请求
            //将拦截请求对象和响应对象交还给HTTP服务器，由HTTP服务器继续调用资源文件
            filterChain.doFilter(servletRequest, servletResponse);/* 放行 */
        } else {
            //由过滤器代替HTTP服务器拒绝/处理本次请求
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter out = servletResponse.getWriter();
            out.println("违法请求<br/>请规范行为");
        }
    }
}
