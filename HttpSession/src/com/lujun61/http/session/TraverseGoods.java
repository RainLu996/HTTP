package com.lujun61.http.session;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class TraverseGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、调用请求对象，向Tomcat索要当前用户的HttpSession
        HttpSession session = request.getSession();

        //2、获取用户选定的商品信息
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String goodsName = attributeNames.nextElement();
            int goodsNum = (int)session.getAttribute(goodsName);//map集合中的value类型是Integer
            System.out.println("商品名称：" + goodsName + "；商品数量：" + goodsNum);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
