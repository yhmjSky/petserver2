package xmut.ygnn.petserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.dao.DiscussDao;
import xmut.ygnn.petserver.entity.Discuss;
import xmut.ygnn.petserver.service.DiscussService;

import java.util.List;


@Service
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private DiscussDao discussDao;

    @Override
    public List<Discuss> getAll() {
        return discussDao.getAll();
    }

    @Override
    public boolean insert(Discuss discuss) {
        return discussDao.insert(discuss);
    }

    @Override
    public boolean update(Discuss discuss) {
        return discussDao.update(discuss);
    }

    @Override
    public boolean delete(Discuss discuss) {
        return discussDao.delete(discuss);
    }
}
