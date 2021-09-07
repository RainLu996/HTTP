package com.lujun61.http.session;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ShoppingCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取浏览器中参数信息：goodsName
        String goodsName = request.getParameter("goodsName");

        //2、调用请求对象，向Tomcat索要当前用户的HttpSession
        HttpSession session = request.getSession();

        //3、将用户选购的商品添加至当前的HttpSession中
        /* key————>商品名称；value————>商品个数 */
        Integer goodsNum = (Integer) session.getAttribute(goodsName);
        if (goodsNum == null) {
            session.setAttribute(goodsName, 1);
        } else {
            session.setAttribute(goodsName, goodsNum + 1);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
