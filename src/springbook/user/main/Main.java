package springbook.user.main;

import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

/**
 * Created by kjnam on 2016. 4. 18..
 */
public class Main {
    public static void main(String [] args) throws ClassNotFoundException, SQLException {

        UserDao dao = new UserDao();

        User user = new User();
        user.setId("kjnam");
        user.setName("kyukyu");
        user.setPassword("1234");

        dao.add(user);
        System.out.println(user.getId() + " 등록 성공!");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getId() + " 조회 성공!");
    }
}
