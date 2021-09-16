package xmut.ygnn.petserver.dao;

import xmut.ygnn.petserver.entity.Order;
import xmut.ygnn.petserver.entity.OrderGoods;

import java.util.List;

public interface OrderGoodsDao {

    List<OrderGoods> getAll();

    List<OrderGoods> getGoodsByOrderId(Long userId);

    boolean insert(OrderGoods orderGoods);

    boolean update(OrderGoods orderGoods);


}
