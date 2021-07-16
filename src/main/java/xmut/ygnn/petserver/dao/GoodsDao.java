package xmut.ygnn.petserver.dao;

import xmut.ygnn.petserver.entity.Goods;
import xmut.ygnn.petserver.entity.User;

import java.util.List;


public interface GoodsDao {
    List<Goods> getAllGoods();

    Goods getByName(String name);

    List<Goods> getByStoreCode(Integer storeCode);

    List<Goods> getByStyle(Integer style);

    List<Goods> getByStoreAndType(Integer storeCode, Integer style);

    boolean insert(Goods goods);

    boolean update(Goods goods);

    boolean delete(Goods goods);
}