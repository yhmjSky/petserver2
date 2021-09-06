package xmut.ygnn.petserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmut.ygnn.petserver.entity.Goods;
import xmut.ygnn.petserver.entity.Order;
import xmut.ygnn.petserver.entity.Result;
import xmut.ygnn.petserver.service.OrderService;

import java.io.Serializable;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();

    @GetMapping("/list")
    public Result list() {
        result.setSuccess("查询成功！", gson.toJson(this.orderService.getAllOrder()));
        return result;
    }

    @PostMapping("/insert")
    public Result insert(String json){
        Order order=null;
        try{
            order=gson.fromJson(json,Order.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        orderService.insert(order);
        result.setSuccess("添加成功！",gson.toJson(order));

        return result;
    }


    @GetMapping("/line/{userId}")
    public Result list(@PathVariable("userId") Serializable userId) {
        result.setSuccess("查询成功！", gson.toJson(this.orderService.getOrderByUserId(Integer.parseInt(userId.toString()))));
        return result;
    }



    @GetMapping("/line2/{storeId}")
    public Result list2(@PathVariable("storeId") Serializable storeId) {
        result.setSuccess("查询成功！", gson.toJson(this.orderService.getOrderByStoreId(Integer.parseInt(storeId.toString()))));
        return result;
    }
}
