package xmut.ygnn.petserver.service;

import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.entity.PlayEntity;

import java.util.List;

@Service
public interface PlayService {

    List<PlayEntity> getAllVideo();

    PlayEntity getVideoByName(String name);

    boolean insert(PlayEntity playEntity);

    boolean update(PlayEntity playEntity);

    boolean delete(PlayEntity playEntity);
}
