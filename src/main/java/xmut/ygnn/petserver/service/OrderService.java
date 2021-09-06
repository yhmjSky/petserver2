package xmut.ygnn.petserver.service;

import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.entity.Order;

import java.util.List;

@Service
public interface OrderService {

    List<Order> getAllOrder();

    List<Order> getOrderByUserId(Integer userId);

    List<Order> getOrderByStoreId(Integer storeId);

    boolean insert(Order order);

//    boolean update(Order order);
//
//    boolean delete(Order order);

}
