package xmut.ygnn.petserver.dao;

import xmut.ygnn.petserver.entity.Article;
import xmut.ygnn.petserver.entity.Order;
import xmut.ygnn.petserver.entity.PlayEntity;

import java.util.List;

public interface OrderDao {

    List<Order> getAllOrder();

    List<Order> getOrderByUserId(Integer userId);

    Order getOrderByOrderId(Long orderId);

    List<Order> getOrderByState(Integer state);

    List<Order> getOrderByStoreId(Integer storeId);

    boolean insert(Order order);

    boolean update(Order order);
//
    boolean delete(Order order);
}
