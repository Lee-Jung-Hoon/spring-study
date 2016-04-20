package springbook.user.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kjnam on 2016. 4. 18..
 */
public class UserDaoTest {

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {

        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user1 = new User("Gildong","Nam","1234");
        User user2 = new User("Chulsu","Kim","4567");

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));


        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        User userget1 = dao.get(user1.getId());
        assertThat(userget1.getName(), is(user1.getName()));
        assertThat(userget1.getPassword(), is(user1.getPassword()));

        User userget2 = dao.get(user2.getId());
        assertThat(userget2.getName(), is(user2.getName()));
        assertThat(userget2.getPassword(), is(user2.getPassword()));
    }


    @Test
    public void count() throws SQLException, ClassNotFoundException {

        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user1 = new User("Gildong","Nam","1234");
        User user2 = new User("Chulsu","Kim","4567");
        User user3 = new User("Gibum","Park","8912");

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        assertThat(dao.getCount(), is(1));

        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        dao.add(user3);
        assertThat(dao.getCount(), is(3));
    }


    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException, ClassNotFoundException {

        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.get("unknown_id");
    }


}
