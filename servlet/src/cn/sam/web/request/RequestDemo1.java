package cn.sam.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/demo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //预防post出现中文乱码的情况，输入下面代码
        request.setCharacterEncoding("utf-8");//参数是根据前端页面的编码方式

        String username1 = request.getParameter("username");//获取某个参数值
        System.out.println(username1);
        System.out.println("====================");
        String[] hobbies = request.getParameterValues("hobby");//获取某个参数多个值
        for (String hobby: hobbies){
            System.out.println(hobby);
        }
        System.out.println("====================");
        Enumeration<String> parameterNames = request.getParameterNames();//获取一个参数名一个值
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("------------------------------------");
        }
        System.out.println("====================");
        Map<String, String[]> parameterMap = request.getParameterMap();//获取一个参数名多个值
        Set<String> keySet = parameterMap.keySet();
        for(String name : keySet){
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values){
                System.out.println(value);
            }
            System.out.println("-------------------------------------");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();//获取虚拟目录
        System.out.println(contextPath);
        System.out.println("------------------");
        String queryString = request.getQueryString();//
        System.out.println(queryString);
        System.out.println("------------------");
        String requestURI = request.getRequestURI();//获取请求URI，简短：/servlet_war_exploded/demo1
        StringBuffer requestURL = request.getRequestURL();//获取请求URI，长：http://localhost:8080/servlet_war_exploded/demo1
        System.out.println(requestURI);
        System.out.println(requestURL);
        System.out.println("-------------------");
//      获取浏览器版本
        String agent = request.getHeader("user-agent");
        if (agent.contains("Chrome")){
            System.out.println("谷歌浏览器");
        }else if (agent.contains("360")){
            System.out.println("360浏览器");
        }
        System.out.println(agent);
        //获取从哪里点开连接的地址
        String referer = request.getHeader("referer");
        System.out.println(referer);
        System.out.println("-------------------");

    }
}
