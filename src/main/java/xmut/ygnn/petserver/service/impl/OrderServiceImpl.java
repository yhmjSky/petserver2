package xmut.ygnn.petserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.dao.OrderDao;
import xmut.ygnn.petserver.entity.Order;
import xmut.ygnn.petserver.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> getAllOrder() {
        return orderDao.getAllOrder();
    }

    @Override
    public Order getOrderByOrderId(Long orderId) {
        return orderDao.getOrderByOrderId(orderId);
    }

    @Override
    public List<Order> getOrderByUserId(Integer userId) {
        return orderDao.getOrderByUserId(userId);
    }

    @Override
    public List<Order> getOrderByState(Integer state) {
        return orderDao.getOrderByState(state);
    }

    @Override
    public List<Order> getOrderByStoreId(Integer storeId) {
        return orderDao.getOrderByStoreId(storeId);
    }


    @Override
    public boolean insert(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public boolean update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public boolean delete(Order order) {
        return orderDao.delete(order);
    }

//    @Override
//    public boolean update(Order order) {
//        return orderDao.update(order);
//    }
//
//    @Override
//    public boolean delete(Order order) {
//        return orderDao.delete(order);
//    }
}
