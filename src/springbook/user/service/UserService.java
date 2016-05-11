package springbook.user.service;

import springbook.user.domain.User;

/**
 * Created by kjnam on 2016. 5. 11..
 */
public interface UserService {
    void add(User user);
    void upgradeLevels();
}
