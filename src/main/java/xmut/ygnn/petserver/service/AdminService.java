package xmut.ygnn.petserver.service;


import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.entity.Admin;

@Service
public interface AdminService {

    Admin getUserByAdminName(String username);

}
