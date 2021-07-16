package xmut.ygnn.petserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.dao.StoreDao;
import xmut.ygnn.petserver.entity.Store;
import xmut.ygnn.petserver.service.StoreService;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {


    @Autowired
    private StoreDao storeDao;


    @Override
    public List<Store> getAllStore() {
        return storeDao.getAllStore();
    }

    @Override
    public Store getByName(String name) {
        return storeDao.getByName(name);
    }

    @Override
    public boolean insert(Store store) {
        return storeDao.insert(store);
    }

    @Override
    public boolean update(Store store) {
        return storeDao.update(store);
    }

    @Override
    public boolean delete(Store store) {
        return storeDao.delete(store);
    }

}
