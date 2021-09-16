package xmut.ygnn.petserver.dao;

import xmut.ygnn.petserver.entity.Admin;
import xmut.ygnn.petserver.entity.User;

public interface AdminDao {

    Admin getUserByAdminName(String username);


}
