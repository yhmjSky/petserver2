package xmut.ygnn.petserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.dao.GoodsDao;
import xmut.ygnn.petserver.entity.Goods;
import xmut.ygnn.petserver.service.GoodsService;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }

    @Override
    public Goods getByName(String name) {
        return goodsDao.getByName(name);
    }

    @Override
    public List<Goods> getByStoreCode(Integer storeCode) {
        return goodsDao.getByStoreCode(storeCode);
    }

    @Override
    public List<Goods> getByStyle(Integer style) {
        return goodsDao.getByStyle(style);
    }

    @Override
    public List<Goods> getByStoreAndType(Integer storeCode, Integer style) {
        return goodsDao.getByStoreAndType(storeCode, style);
    }

    @Override
    public boolean insert(Goods goods) {
        return goodsDao.insert(goods);
    }

    @Override
    public boolean update(Goods goods) {
        return goodsDao.update(goods);
    }

    @Override
    public boolean delete(Goods goods) {
        return goodsDao.delete(goods);
    }
}
