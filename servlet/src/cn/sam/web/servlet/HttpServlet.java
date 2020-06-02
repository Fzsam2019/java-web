package cn.sam.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/httpservlet")
//@WebServlet({"/d1","d2","d3"})//多个地址访问
//@WebServlet("/test/dome")//多层路径访问
@WebServlet("/*.do")//只要是访问".do"结尾的都可以调用
public class HttpServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("httpservlet test!");
    }
}
