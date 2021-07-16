package xmut.ygnn.petserver.dao;

import xmut.ygnn.petserver.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();

//    User huaweiLogin(String huaweiId);

    User getUserByUsername(String username);

    User getUserByUserid(int id);

    User getUserByopenid(String openid);

    boolean insert(User user);

    boolean update(User user);

    boolean delete(User user);
}
