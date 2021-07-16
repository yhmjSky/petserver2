package xmut.ygnn.petserver.dao;

import xmut.ygnn.petserver.entity.PlayEntity;

import java.util.List;

public interface PlayDao {

    List<PlayEntity> getAllVideo();

//    User huaweiLogin(String huaweiId);

    PlayEntity getVideoByName(String name);

    boolean insert(PlayEntity playEntity);

    boolean update(PlayEntity playEntity);

    boolean delete(PlayEntity playEntity);
}
