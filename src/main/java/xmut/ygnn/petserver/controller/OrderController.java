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

    @GetMapping("/line1/{orderId}")
    public Result list1(@PathVariable("orderId") Serializable orderId) {
        result.setSuccess("查询成功！", gson.toJson(this.orderService.getOrderByOrderId(Long.parseLong(orderId.toString()))));
        return result;
    }

    @GetMapping("/line2/{storeId}")
    public Result list2(@PathVariable("storeId") Serializable storeId) {
        result.setSuccess("查询成功！", gson.toJson(this.orderService.getOrderByStoreId(Integer.parseInt(storeId.toString()))));
        return result;
    }

    @GetMapping("/state/{state}")
    public Result list3(@PathVariable("state") Serializable state) {
        result.setSuccess("查询成功！", gson.toJson(this.orderService.getOrderByState(Integer.parseInt(state.toString()))));
        return result;
    }

    @PutMapping("/update2")
    public Result update2(@RequestBody String json) {
        System.out.println(json);
        result.setInfo("更改失败！",json);
        Order order=null;
        try{
            order=gson.fromJson(json,Order.class);
            if(this.orderService.update(order)){
                result.setSuccess("更改成功！",gson.toJson(order));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PutMapping("/update")
    public Result update( String json) {
        System.out.println(json);
        result.setInfo("更改失败！",json);
        Order order=null;
        try{
            order=gson.fromJson(json,Order.class);
            if(this.orderService.update(order)){
                result.setSuccess("更改成功！",gson.toJson(order));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("/delete/{goodsId}")
    public Result delete(@PathVariable("goodsId") String goodsId) {

        boolean is=this.orderService.delete(orderService.getOrderByOrderId(Long.parseLong(goodsId)));
        if(is){
            result.setSuccess("删除成功！", null);

        }else{
            result.setInfo("删除失败！",null);
        }
        return result;
    }

}
