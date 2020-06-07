package cn.sam.web.longing.test;

import cn.sam.web.longing.dao.UserDao;
import cn.sam.web.longing.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){

        User loginuser = new User();
        loginuser.setUsername("SAM");
        loginuser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
