package xmut.ygnn.petserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xmut.ygnn.petserver.entity.User;
import xmut.ygnn.petserver.dao.UserDao;
import xmut.ygnn.petserver.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserByUserid(int id) {
        return userDao.getUserByUserid(id);
    }

    @Override
    public User getUserByOpenid(String openid) {
        return userDao.getUserByopenid(openid);
    }

    @Override
    public boolean insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(User user) {
        return userDao.delete(user);
    }
}