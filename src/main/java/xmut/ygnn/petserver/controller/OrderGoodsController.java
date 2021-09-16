package xmut.ygnn.petserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmut.ygnn.petserver.entity.Order;
import xmut.ygnn.petserver.entity.OrderGoods;
import xmut.ygnn.petserver.entity.Result;
import xmut.ygnn.petserver.service.OrderGoodsService;

import java.io.Serializable;

@RestController
@RequestMapping("/orderGoods")
public class OrderGoodsController {


    @Autowired
    OrderGoodsService orderGoodsService;

    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();

    @GetMapping("/list")
    public Result list() {
        result.setSuccess("查询成功！", gson.toJson(this.orderGoodsService.getAll()));
        return result;
    }

    @PostMapping("/insert")
    public Result insert(String json){
        OrderGoods og=null;
        try{
            og=gson.fromJson(json,OrderGoods.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        orderGoodsService.insert(og);
        result.setSuccess("添加成功！",gson.toJson(og));

        return result;
    }

    @GetMapping("/line/{orderId}")
    public Result list(@PathVariable("orderId") Serializable orderId) {
        result.setSuccess("查询成功！", gson.toJson(this.orderGoodsService.getGoodsByOrderId(Long.parseLong(orderId.toString()))));
        return result;
    }



}
