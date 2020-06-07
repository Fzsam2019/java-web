package cn.sam.web.longing.web.servlet;

import cn.sam.web.longing.dao.UserDao;
import cn.sam.web.longing.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

//        //获取请求参数
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        //封装user对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);

        //获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        //创建User对象
        User loginUser = new User();
        //使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        if (user == null){
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else {
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
