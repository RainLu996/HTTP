package com.lujun61.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description 过滤器（Filter）对拦截用户的请求进行增强操作
 * @author Jun Lu
 * @date 2021-09-07 20:48:43
 */
public class FilterTest03 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        servletRequest.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
