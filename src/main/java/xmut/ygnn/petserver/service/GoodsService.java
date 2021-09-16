package xmut.ygnn.petserver.service;

import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.entity.Goods;

import java.util.List;


@Service
public interface GoodsService {

    List<Goods> getAllGoods();

    Goods getByName(String name);

    Goods getByGoodsId(Integer goodsId);

    List<Goods> getByStoreCode(Integer storeCode);

    List<Goods> getByStyle(Integer style);

    List<Goods> getByStoreAndType(Integer storeCode, Integer style);

    boolean insert(Goods goods);

    boolean update(Goods goods);

    boolean delete(Goods goods);
}
