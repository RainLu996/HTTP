package com.lujun61.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Consume extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //改变浏览器默认字符编码集
        response.setContentType("text/html;charset=utf-8");

        //食物的金额
        float dumplings = 10;
        float bao = 5;
        float noodle = 5;

        //余额
        float balance = 0;

        float purchase = 0;

        //cookie中保存的用户名
        String userName = null;

        //获取请求头中所有的cookie
        Cookie[] cookies = request.getCookies();

        //改变输出流的方向至响应体（将交互信息写入到响应体中反馈给浏览器）
        PrintWriter out = response.getWriter();

        //用于更新卡中存放money的Cookie
        Cookie updateCookie = null;

        //1、获取请求头中的参数信息(食物名称)
        String food = request.getParameter("food");

        //2、读取请求头中cookie参数信息：获取用户信息（姓名and余额）；完成消费，并记录消费信息
        for (Cookie cookie:
             cookies) {
            String key = cookie.getName();
            String value = cookie.getValue();
            if ("userName".equals(key)) {
                userName = value;
            } else if ("money".equals(key)){
                balance = Float.parseFloat(value);
                if ("饺子".equals(food)) {
                    if (balance < dumplings) {
                        out.println("当前用户" + userName + "余额不足，请及时充值。");
                    } else {
                        updateCookie = new Cookie("money", String.valueOf(balance - dumplings));
                        purchase = dumplings;
                        balance = balance - dumplings;
                    }
                } else if ("肉包子".equals(food)) {
                    if (balance < bao) {
                        out.println("当前用户" + userName + "余额不足，请及时充值。");
                    } else {
                        updateCookie = new Cookie("money", String.valueOf(balance - bao));
                        purchase = bao;
                        balance = balance - bao;
                    }
                } else if ("热干面".equals(food)) {
                    if (balance < noodle) {
                        out.println("当前用户" + userName + "余额不足，请及时充值。");
                    } else {
                        updateCookie = new Cookie("money", String.valueOf(balance - noodle));
                        purchase = noodle;
                        balance = balance - noodle;
                    }
                }
            }
        }

        //3、返还给用户餐饮卡
        response.addCookie(updateCookie);

        //4、记录消费记录，写入响应体中
        out.println("用户《" + userName + "》本次消费：" + purchase + "元；" + "余额：" + balance);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
