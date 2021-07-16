package xmut.ygnn.petserver.service;

import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.entity.User;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUser();

    User getUserByUsername(String username);

    User getUserByUserid (int id);

    User getUserByOpenid (String openid);

    boolean insert(User user);

    boolean update(User user);

    boolean delete(User user);


}
