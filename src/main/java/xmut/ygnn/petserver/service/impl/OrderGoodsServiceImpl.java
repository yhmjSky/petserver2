package xmut.ygnn.petserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.dao.OrderGoodsDao;
import xmut.ygnn.petserver.entity.OrderGoods;
import xmut.ygnn.petserver.service.OrderGoodsService;

import java.util.List;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {

    @Autowired
    OrderGoodsDao dao;


    @Override
    public List<OrderGoods> getAll() {
        return dao.getAll();
    }

    @Override
    public List<OrderGoods> getGoodsByOrderId(Long orderId) {
        return dao.getGoodsByOrderId(orderId);
    }

    @Override
    public boolean insert(OrderGoods orderGoods) {
        return dao.insert(orderGoods);
    }

    @Override
    public boolean update(OrderGoods orderGoods) {
        return dao.update(orderGoods);
    }
}
