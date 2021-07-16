package xmut.ygnn.petserver.service;

import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.entity.Store;

import java.util.List;

@Service
public interface StoreService {

    List<Store> getAllStore();

    Store getByName(String name);

    boolean insert(Store store);

    boolean update(Store store);

    boolean delete(Store store);

}
