package xmut.ygnn.petserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.dao.PlayDao;
import xmut.ygnn.petserver.entity.PlayEntity;
import xmut.ygnn.petserver.service.PlayService;

import java.util.List;

@Service
public class PlayServiceImpl implements PlayService {


    @Autowired
    private PlayDao playDao;

    @Override
    public List<PlayEntity> getAllVideo() {
        return playDao.getAllVideo();
    }

    @Override
    public PlayEntity getVideoByName(String name) {
        return playDao.getVideoByName(name);
    }

    @Override
    public boolean insert(PlayEntity playEntity) {
        return playDao.insert(playEntity);
    }

    @Override
    public boolean update(PlayEntity playEntity) {
        return playDao.update(playEntity);
    }

    @Override
    public boolean delete(PlayEntity playEntity) {
        return playDao.delete(playEntity);
    }
}
