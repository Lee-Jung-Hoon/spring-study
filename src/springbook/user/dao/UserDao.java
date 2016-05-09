package springbook.user.dao;

import springbook.user.domain.User;

import java.util.List;

public interface UserDao {

    public abstract void add(User user);

    public abstract User get(String id);

    public abstract void deleteAll();

    public abstract int getCount();

    public abstract List<User> getAll();

    public void update(User user);

}