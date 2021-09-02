package com.lujun61.http;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpServletResponseTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 针对于 3、4 的解决方案
         */
        response.setContentType("text/html;charset=utf-8");

        /* 1、通过响应对象，向HTTP服务器（Tomcat）索要输出流 */
        PrintWriter out = response.getWriter();

        /**
         * 让浏览器正常编译阿拉伯数字
         *
         * 解决方法：忘掉write方法；一律使用print/println方法
         */
        int num = 50;
        /* 2、通过输出流，将执行结果（整型数据）以二进制的形式写入到响应体中 */
        out.write(num); //浏览器的编译结果竟然是：2----->也就是阿拉伯数字50的ASCII码值
        /* 针对于2的解决方案 */
        out.print(num);
        out.println(num);//浏览器的结果正常：50


        /**
         * 让浏览器正常编译中文
         *
         *  原因：
         *      浏览器默认编码方式为：ISO-8859-1（东欧地区字符编码）
         *
         *  解决方案：
         *      改变浏览器默认字符编码集
         */
        String s = "向Http响应协议包中写入数据";
        /* 3、通过输出流，将执行结果（字符型【中文】数据）以二进制的形式写入到响应体中 */
        out.println(s); //浏览器的结果竟然是：?Http??????????------>


        /**
         * 让浏览器正常执行文本中混有html命令的html命令
         *
         * 原因：
         *      在默认的情况下，【content-type】属性的值为：“text”，
         *      此时浏览器会采用【文本编译器】对响应体中的二进制数据进行编译解析
         *
         * 解决方案：
         *      在得到输出流之前，通过响应对象，对响应头中的【content-type】属性进行重新赋值，
         *      目的就是指定浏览器采用正确的编译器去编译响应头中的二进制数据
         */
        String html = "br是换行<br/>br是html标签命令<br/>让浏览器区别出br是html命令，而不是以文本形式打印";
        /* 4、通过输出流，将执行结果（文本中混有html命令）以二进制的形式写入到响应体中 */
        out.println(html);


        /**
         * 通过响应对象，将地址赋值给响应头中的【location】属性
         *
         * 说明：
         *      浏览器在接收到Http响应协议包之后，如果发现响应头中存在【location】属性，
         *      会自动的通过地址栏向【location】属性中指定的地址发送请求
         *      【以GET方式发送请求】
         */
        String urlString = "https://www.baidu.com";
        urlString = "https://www.baidu.com?userName=LuJun";//带点参数
        response.sendRedirect(urlString);//对应在响应头中：【location="http://www.baidu.com"】

    }//doGet执行完毕：  Tomcat将Http响应协议包推送给浏览器

}
