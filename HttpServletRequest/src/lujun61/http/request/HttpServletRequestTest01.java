package lujun61.http.request;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 注意：
 *  浏览器以GET方式发送请求时：
 *      请求参数信息保存在【请求头】中；
 *      当Http请求协议包到达Http服务器后，{Http服务器}负责用默认的【utf-8】字符集去解码文件内容--->中文不会出现乱码
 *
 *  浏览器以POST方式发送请求时：
 *      请求参数信息保存在【请求体】中；
 *      当Http请求协议包到达Http服务器后，{当前【请求对象】}负责用默认的【ISO-8859-1】字符集去解码文件内容--->中文会出现乱码
 */
public class HttpServletRequestTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 1、通过请求对象，读取【请求行】中的【URL】信息 */
        String url = request.getRequestURL().toString();
        System.out.println("URL = " + url);  //URL = /myWeb/request01

        /* 2、通过请求对象，读取【请求行】中的【method】信息 */
        String method = request.getMethod();
        System.out.println("method = " + method);  //method = GET

        /* 3、通过请求对象，读取【请求行】中的【URI】信息 */
        String uri = request.getRequestURI();
        System.out.println("URI = " + uri);

        /* 4、通过请求对象，读取【请求头】中的所有【参数信息名】 */
        //将所有的请求参数名称保存到一个枚举对象中进行返回
        Enumeration<String> parameterNames = request.getParameterNames();//看做一个迭代器
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();//获取参数名【name】
            String parameter = request.getParameter(s);//获取参数值【value】
            System.out.println(s + "=" + parameter);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 5、通过请求对象，读取【请求体】中的所有【参数信息名】 */
        /**
         * 注意：
         * 在【post】请求方式下，在【读取请求体】内容之前，应该通知请求对象使用：utf-8字符集，对请求体内容进行解码
         */
        req.setCharacterEncoding("utf-8");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            String parameter = req.getParameter(element);
            System.out.println(element + "=" + parameter);
        }

    }
}
