package springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

/**
 * Created by kjnam on 2016. 4. 18..
 */
public class UserDaoTest {
    public static void main(String [] args) throws ClassNotFoundException, SQLException {

        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("kjnam");
        user.setName("kyukyu");
        user.setPassword("1234");

        dao.add(user);
        System.out.println(user.getId() + " 등록 성공!");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공!");
    }
}
