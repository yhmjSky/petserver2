package xmut.ygnn.petserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.dao.AdminDao;
import xmut.ygnn.petserver.entity.Admin;
import xmut.ygnn.petserver.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin getUserByAdminName(String username) {
        return adminDao.getUserByAdminName(username);
    }
}
