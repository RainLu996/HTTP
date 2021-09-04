package com.lujun61.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OpenAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、将参数信息（用户个人信息）通过请求对象获取到
        String userName = request.getParameter("userName");
        String money = request.getParameter("money");

        //2、开卡
        Cookie card_1 = new Cookie("userName", userName);
        Cookie card_2 = new Cookie("money", money);

        //3、发卡：将Cookie写入到响应头交给浏览器
        response.addCookie(card_1);
        response.addCookie(card_2);

        //4、通知浏览器将 点餐页面 内容写入到响应体，并推送给浏览器（请求转发解决方案）
        request.getRequestDispatcher("menu.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
