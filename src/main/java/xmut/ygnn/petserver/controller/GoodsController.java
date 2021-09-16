package xmut.ygnn.petserver.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmut.ygnn.petserver.entity.Goods;
import xmut.ygnn.petserver.entity.PlayEntity;
import xmut.ygnn.petserver.entity.Result;
import xmut.ygnn.petserver.service.GoodsService;

import java.io.Serializable;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();

    @GetMapping("/list")
    public Result list() {
        result.setSuccess("查询成功！", gson.toJson(this.goodsService.getAllGoods()));
        return result;
    }


    @PostMapping("/insert")
    public Result insert(String json){
        Goods goods=null;
        try{
            goods=gson.fromJson(json,Goods.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(goodsService.getByName(goods.getName())!=null){//username重复！
            result.setInfo("重名，添加失败",null);
        }else{
            goodsService.insert(goods);
            result.setSuccess("添加成功！",gson.toJson(goods));
        }
        return result;
    }


    @DeleteMapping("/deletename/{name}")
    public Result deletename(@PathVariable("name") String name) {

        boolean is=this.goodsService.delete(goodsService.getByName(name));
        if(is){
            result.setSuccess("删除成功！", null);

        }else{
            result.setInfo("删除失败！",null);
        }
        return result;
    }

    @GetMapping("/line/{style}")
    public Result list(@PathVariable("style") Serializable style) {
        result.setSuccess("查询成功！", gson.toJson(this.goodsService.getByStyle(Integer.parseInt(style.toString()))));
        return result;
    }


    @GetMapping("/line1/{goodsId}")
    public Result list1(@PathVariable("goodsId") Serializable goodsId) {
        result.setSuccess("查询成功！", gson.toJson(this.goodsService.getByGoodsId(Integer.parseInt(goodsId.toString()))));
        return result;
    }

    @GetMapping("/line2/{storeCode}")
    public Result list2(@PathVariable("storeCode") Serializable storeCode) {
        result.setSuccess("查询成功！", gson.toJson(this.goodsService.getByStoreCode(Integer.parseInt(storeCode.toString()))));
        return result;
    }

    @GetMapping("/line/{storeCode}/{style}")
    public Result listStore(@PathVariable("storeCode") Serializable storeCode,
                            @PathVariable("style")  Serializable style) {

        result.setSuccess("查询成功！", gson.toJson(this.goodsService.getByStoreAndType(Integer.parseInt(storeCode.toString()), Integer.parseInt(style.toString()))));
        return result;
    }

    @PutMapping("/update")
    public Result update(String json) {
        System.out.println(json);
        result.setInfo("更改失败！",json);
        Goods goods=null;
        try{
            goods=gson.fromJson(json,Goods.class);
            if(this.goodsService.update(goods)){
//                result.setSuccess("更改成功！",gson.toJson(goodsService.getByName(goods.getName())));
                result.setSuccess("更改成功！",gson.toJson(goods));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PutMapping("/update1")
    public Result update1(@RequestBody String json) {
        System.out.println(json);
        result.setInfo("更改失败！",json);
        Goods goods=null;
        try{
            goods=gson.fromJson(json,Goods.class);
            if(this.goodsService.update(goods)){
//                result.setSuccess("更改成功！",gson.toJson(goodsService.getByName(goods.getName())));
                result.setSuccess("更改成功！",gson.toJson(goods));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id) {

        boolean is=this.goodsService.delete(goodsService.getByGoodsId(Integer.parseInt(id)));
        if(is){
            result.setSuccess("删除成功！", null);

        }else{
            result.setInfo("删除失败！",null);
        }
        return result;
    }

}
