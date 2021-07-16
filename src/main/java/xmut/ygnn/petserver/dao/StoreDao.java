package xmut.ygnn.petserver.dao;

import xmut.ygnn.petserver.entity.Goods;
import xmut.ygnn.petserver.entity.Store;

import java.util.List;

public interface StoreDao {

    List<Store> getAllStore();

    Store getByName(String name);

    boolean insert(Store store);

    boolean update(Store store);

    boolean delete(Store store);

}
