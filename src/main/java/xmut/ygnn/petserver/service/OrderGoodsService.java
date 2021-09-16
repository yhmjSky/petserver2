package xmut.ygnn.petserver.service;

import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.entity.OrderGoods;

import java.util.List;

@Service
public interface OrderGoodsService  {

    List<OrderGoods> getAll();

    List<OrderGoods> getGoodsByOrderId(Long userId);

    boolean insert(OrderGoods orderGoods);

    boolean update(OrderGoods orderGoods);


}
