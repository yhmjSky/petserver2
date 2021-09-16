package xmut.ygnn.petserver.dao;


import xmut.ygnn.petserver.entity.Discuss;

import java.util.List;

public interface DiscussDao {

    List<Discuss> getAll();

    boolean insert(Discuss discuss);

    boolean update(Discuss discuss);

    boolean delete(Discuss discuss);

}
