package xmut.ygnn.petserver.service;


import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.entity.Discuss;

import java.util.List;

@Service
public interface DiscussService {

    List<Discuss> getAll();

    boolean insert(Discuss discuss);

    boolean update(Discuss discuss);

    boolean delete(Discuss discuss);

}
